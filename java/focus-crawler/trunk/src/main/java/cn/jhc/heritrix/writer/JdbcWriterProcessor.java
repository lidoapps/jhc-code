package cn.jhc.heritrix.writer;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.archive.crawler.datamodel.CoreAttributeConstants;
import org.archive.crawler.datamodel.CrawlURI;
import org.archive.crawler.framework.Processor;
import org.archive.io.RecordingInputStream;
import org.archive.net.UURI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cn.jhc.heritrix.bean.ItemPage;
import cn.jhc.heritrix.writer.extractor.ItemExtractor;
import cn.jhc.heritrix.writer.extractor.ShopExtractor;

public abstract class JdbcWriterProcessor extends Processor implements
		CoreAttributeConstants {

	private static final long serialVersionUID = -5415095894885011067L;
	private static final Logger logger = Logger
			.getLogger(JdbcWriterProcessor.class.getName());

	public JdbcWriterProcessor(String name) {
		super(name, "A JDBC Writer Processor");

	}

	@Override
	protected void initialTasks() {

	}

	@Override
	protected void innerProcess(CrawlURI curi) throws InterruptedException {
		if (!curi.isSuccess())
			return;
		UURI uuri = curi.getUURI(); // Current URI.
		// Only http and https schemes are supported.
		String scheme = uuri.getScheme();
		if (!"http".equalsIgnoreCase(scheme)
				&& !"https".equalsIgnoreCase(scheme)) {
			return;
		}

		String uri = uuri.toString();
		logger.finest("UURI.toString() output is: " + uri);
		// 用子类的方法再次确认URI符合提取要求。
		if (!validateUri(uuri.toString())) {
			logger.fine("validateUri returns false. This should not be happen. Please check Heritrix configuration. "
					+ uri);
			return;
		}

		// Only text/html file will be parsed and store in database
		String contenttype = curi.getContentType();
		if (null == contenttype || !"text/html".equalsIgnoreCase(contenttype)) {
			return;
		}

		RecordingInputStream recis = curi.getHttpRecorder().getRecordedInput();
		if (0L == recis.getResponseContentLength()) {
			return;
		}

		try {
			InputStream input = (InputStream) recis.getContentReplayInputStream();
			Document doc = Jsoup.parse(input, null, curi.getBaseURI().toString());
			ItemPage page = extract(doc);
			//当前网页的URL直接在这里设定，并不需要传递到extract方法中去。
			page.setUrl(uri);
	
		} catch (IOException e) {
			curi.addLocalizedError(this.getName(), e,
					"IO Exception in JdbcWriterProcessor innerprocess.");
		}
	}

	/**
	 * 每个子类都必须实现此方法，实现对需要分析的URI地址的再次确认。
	 * 
	 * @param uri
	 *            当前URI地址字符串。
	 * @return 如果符合抽取条件，则返回true，否则返回false。
	 */
	public abstract boolean validateUri(String uri);
	/**
	 * 每个子类都必须实现此方法，返回在该网站下的商品的默认的Context ID。
	 * 在Heritirx中选择不同的JdbcWriterProcessor，相应的默认Context ID也就随之确定。
	 * @return
	 * 		该网站商品的默认Context ID。
	 */
	public abstract long getDefaultContextId();
	/**
	 * 从网页中抽取商品信息。
	 * @param doc
	 * 		网页内容经jsoup处理后的Document对象。
	 * @return
	 * 		返回商品信息的封装对象。
	 */
	public ItemPage extract(Document doc) {
		ItemPage itemPage = new ItemPage();
		ItemExtractor extractor = createItemExtractor(doc);
		itemPage.setName(extractor.extractCommodityName());
		
		return itemPage;
	}

	/**
	 * 每个子类都需实现此方法，提供具体的抽取商品信息的Extractor。
	 * @param doc
	 * 		网页内容经jsoup处理后的Document对象。
	 * @return
	 * 		实现了ItemExtractor接口的具体实例。
	 */
	public abstract ItemExtractor createItemExtractor(Document doc);
	/**
	 * 每个子类都需实现此方法，提供具体的抽取店铺信息的Extractor。
	 * @param doc
	 * 		网页内容经jsoup处理后的Document对象。
	 * @return
	 * 		实现了ShopExtractor接口的具体实例。
	 */
	public abstract ShopExtractor createShoptExtractor(Document doc);
}
