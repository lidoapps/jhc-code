package cn.jhc.heritrix.frontier;

import java.util.concurrent.PriorityBlockingQueue;

import org.archive.crawler.frontier.BdbFrontier;

public class TaobaoBdbFrontier extends BdbFrontier {

	private static final long serialVersionUID = 8992838772881590331L;

	public TaobaoBdbFrontier(String name) {
		super(name);
	}

	@Override
	protected void initQueuesOfQueues() {
		super.initQueuesOfQueues();
		//此处将原来的BlockingQueue替换成PriorityBlockingQueue
		readyClassQueues = new PriorityBlockingQueue<String>();
	}
}
