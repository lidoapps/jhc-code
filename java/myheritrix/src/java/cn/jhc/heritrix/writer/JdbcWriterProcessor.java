package cn.jhc.heritrix.writer;

import java.io.IOException;
import java.util.logging.Logger;

import org.archive.crawler.datamodel.CoreAttributeConstants;
import org.archive.crawler.datamodel.CrawlURI;
import org.archive.crawler.framework.Processor;
import org.archive.io.RecordingInputStream;
import org.archive.io.ReplayInputStream;
import org.archive.net.UURI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class JdbcWriterProcessor extends Processor implements
		CoreAttributeConstants {

	private static final long serialVersionUID = -5415095894885011067L;
	private static final Logger logger = Logger.getLogger(JdbcWriterProcessor.class.getName());
	
	public JdbcWriterProcessor(String name) {
		super(name,"A JDBC Writer Processor");

	}
	
	@Override
	protected void initialTasks() {
		
	}

	@Override
	protected void innerProcess(CrawlURI curi) throws InterruptedException {
		if(!curi.isSuccess())
			return;
        UURI uuri = curi.getUURI(); // Current URI.
        // Only http and https schemes are supported.
        String scheme = uuri.getScheme();
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            return;
        }

        //Only text/html file will be parsed and store in database
        String contenttype = curi.getContentType();
        if (null == contenttype || !"text/html".equalsIgnoreCase(contenttype)) {
            return;
        }

        RecordingInputStream recis = curi.getHttpRecorder().getRecordedInput();
        if (0L == recis.getResponseContentLength()) {
            return;
        }
        
        try {
			ReplayInputStream replay = recis.getContentReplayInputStream();
			Document doc = Jsoup.parse(replay, null, curi.getBaseURI().toString());
			Element e = doc.select("#abroad").first();
			if(null == e) {
				logger.info("没有属性被记录下来。");
			}else {
			logger.info(e.text());
			}
		} catch (IOException e) {
			curi.addLocalizedError(this.getName(), e, "IO Exception in JdbcWriterProcessor innerprocess.");
		}
	}
}
