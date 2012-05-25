package cn.jhc.heritrix.writer.extractor;

import cn.jhc.heritrix.bean.ItemPage;
import cn.jhc.heritrix.bean.Shop;

public interface Extractor {

	/**
	 * 从网页中抽取商品信息。
	 * @return
	 * 		返回商品信息的封装对象。
	 */
	public abstract ItemPage extractItem();

	/**
	 * 提取店铺的信息。
	 * @return
	 * 		Shop对象
	 */
	public abstract Shop extractShop();

}