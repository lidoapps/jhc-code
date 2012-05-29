package cn.jhc.heritrix.frontier;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.httpclient.URIException;
import org.archive.crawler.datamodel.CandidateURI;
import org.archive.crawler.frontier.HostnameQueueAssignmentPolicy;
import org.archive.net.UURIFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class HostnameQueueAssignmentPolicyTest {
	
	private HostnameQueueAssignmentPolicy policy;
	private CandidateURI curi;
	private String hostname;

	@Parameters
	public static Collection<String[]> getParameters() {
		return Arrays.asList(new String[][] {
				{"http://tq.taobao.com/", "tq.taobao.com"},
				{"http://item.taobao.com/item.htm?id=9505588655", "item.taobao.com"},
				{"http://service.taobao.com/support/knowledge-847753.htm", "service.taobao.com"},
				{"http://info.jhc.cn:8080/index.jsp", "info.jhc.cn#8080"}
		});
	}
	
	public HostnameQueueAssignmentPolicyTest(String uri, String hostname) throws URIException {
		this.curi = new CandidateURI(UURIFactory.getInstance(uri));
		this.hostname = hostname;
	}
	
	@Before
	public void setUp() throws Exception {
		policy = new HostnameQueueAssignmentPolicy();
	}

	@Test
	public void testGetClassKey() {
		assertEquals(hostname, policy.getClassKey(null, curi));
	}

}
