/*
 * cn.jhc.ch09.IProcessCredit.java
 * 2007-6-16
 * 第9章的Java示例，演示Web服务
 */
package cn.jhc.ch09;

public interface IProcessCredit {
	int creditProcess(String creditCard, double total);
}