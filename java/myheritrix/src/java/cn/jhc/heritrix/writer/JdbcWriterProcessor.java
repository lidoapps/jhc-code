package cn.jhc.heritrix.writer;

import org.archive.crawler.datamodel.CoreAttributeConstants;
import org.archive.crawler.datamodel.CrawlURI;
import org.archive.crawler.framework.Processor;

public class JdbcWriterProcessor extends Processor implements
		CoreAttributeConstants {

	private static final long serialVersionUID = -5415095894885011067L;
	
	public JdbcWriterProcessor(String name) {
		super(name,"A JDBC Writer Processor");

	}
	
	@Override
	protected void initialTasks() {
		
	}

	@Override
	protected void innerProcess(CrawlURI curi) throws InterruptedException {

	}
}
