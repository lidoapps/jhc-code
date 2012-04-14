package cn.jhc.heritrix.writer;

import static org.junit.Assert.*;

import java.io.IOException;

import org.archive.crawler.datamodel.CandidateURI;
import org.archive.crawler.datamodel.CrawlURI;
import org.archive.crawler.fetcher.FetchHTTP;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JdbcWriterProcessorTest {
	private final static String TEST_URL= "http://item.taobao.com/item.htm?id=14760159056";
	private CrawlURI curi;

	@Before
	public void setUp() throws Exception {
		CandidateURI candidate = CandidateURI.fromString(TEST_URL);
		curi = new CrawlURI(candidate,1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInnerProcess() {
		try {
			System.out.println(curi.getHttpRecorder().getReplayCharSequence().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
