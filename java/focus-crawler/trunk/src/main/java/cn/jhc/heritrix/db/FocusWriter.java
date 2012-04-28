package cn.jhc.heritrix.db;

import cn.jhc.heritrix.bean.Commodity;
import cn.jhc.heritrix.bean.ItemPage;
import cn.jhc.heritrix.bean.Shop;

public class FocusWriter {

	public static void writeAll(ItemPage itemPage, Shop shop) {
		//如果shop对象非空，则更新itemPage中的contextId
		if(null != shop) {
			long shopId = checkShop(shop);
			long contextId = getShopContextId(shopId);
			//更新contextId
			itemPage.setContextId(contextId);
		}
		
		Commodity commodity = createCommodity(itemPage);
		long commodityId = checkCommodity(commodity);
		writeGathering(itemPage,commodityId);
	}

	/**
	 * 将采集数据写入数据库Gathering表和GatherMeta表。
	 * @param itemPage
	 * @param commodityId
	 */
	protected static void writeGathering(ItemPage itemPage, long commodityId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 如果商品在数据库中还没有，则写入数据库，若已经存在，则判断是否名字相同，名字不同的话，就添加CommodityAlias
	 * @param commodity
	 * @return
	 * 		该商品的ID。
	 */
	protected static long checkCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected static Commodity createCommodity(ItemPage itemPage) {
		Commodity commodity = new Commodity();
		commodity.setName(itemPage.getName());
		commodity.setInstanceId(itemPage.getInstanceId());
		return commodity;
	}

	/**
	 * 根据shopId查询相应的ContextID，如果该Context记录还没有，那就添加该Context记录。
	 * @param shopId
	 * @return
	 * 		contex记录的ID。
	 */
	protected static long getShopContextId(long shopId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 检查Shop表中是否已经有该shop，没有的话，将当前shop保存到Shop表。
	 * @param shop
	 * @return
	 * 		shop在表中的ID。
	 */
	protected static long checkShop(Shop shop) {
		// TODO Auto-generated method stub
		return 0;
	}

}
