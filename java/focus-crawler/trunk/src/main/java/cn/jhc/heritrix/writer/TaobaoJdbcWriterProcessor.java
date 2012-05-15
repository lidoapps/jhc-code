package cn.jhc.heritrix.writer;

import java.util.regex.Pattern;

import org.jsoup.nodes.Document;

import cn.jhc.heritrix.db.dao.DAOFactory;
import cn.jhc.heritrix.writer.extractor.Extractor;
import cn.jhc.heritrix.writer.extractor.ExtractorFacade;
import cn.jhc.heritrix.writer.extractor.ShopExtractor;
import cn.jhc.heritrix.writer.extractor.TaobaoItemExtractor;
import cn.jhc.heritrix.writer.extractor.TaobaoShopExtractor;

public class TaobaoJdbcWriterProcessor extends JdbcWriterProcessor {

	private static final long serialVersionUID = 3567651846232196014L;
	//提供商品信息的网页的URL模式
	private static final String URL_PATTERN = "^http://item\\.taobao\\.com/item\\.htm\\?id=\\d+";
	private static final Pattern PATTERN = Pattern.compile(URL_PATTERN);
	
	public TaobaoJdbcWriterProcessor(String name) {
		super(name);
	}

	@Override
	public boolean validateUri(String uri) {
		return PATTERN.matcher(uri).matches();
	}

	@Override
	public Extractor createExtractor(Document doc) {
		return new ExtractorFacade(new TaobaoItemExtractor(doc), new TaobaoShopExtractor(doc));
	}

}
