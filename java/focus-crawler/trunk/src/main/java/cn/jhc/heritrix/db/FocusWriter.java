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
		
		long brandId = checkBrand(itemPage);
		Commodity commodity = createCommodity(itemPage, brandId);
		long commodityId = checkCommodity(commodity);
		writeGathering(itemPage,commodityId);
	}

	/**
	 * 将采集数据写入数据库Gathering表和GatherMeta表。
	 * @param itemPage
	 * @param commodityId
	 */
	private static void writeGathering(ItemPage itemPage, long commodityId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 如果商品在数据库中还没有，则写入数据库，若已经存在，则判断是否名字相同，名字不同的话，就添加CommodityAlias
	 * @param commodity
	 * @return
	 * 		该商品的ID。
	 */
	private static long checkCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static Commodity createCommodity(ItemPage itemPage, long brandId) {
		Commodity commodity = new Commodity();
		commodity.setName(itemPage.getName());
		commodity.setBrandId(brandId);
		//TODO unique,instance_id
		return commodity;
	}

	/**
	 * 根据shopId查询相应的ContextID，如果该Context记录还没有，那就添加该Context记录。
	 * @param shopId
	 * @return
	 * 		contex记录的ID。
	 */
	private static long getShopContextId(long shopId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 检查Shop表中是否已经有该shop，没有的话，将当前shop保存到Shop表。
	 * @param shop
	 * @return
	 * 		shop在表中的ID。
	 */
	private static long checkShop(Shop shop) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 检查提取出来的商品信息中有没有品牌信息，如果有，再检查Brand表是否已经有了该Brand，则写入Brand表，并返回该Brand的ID。
	 * @param itemPage
	 * @return
	 * 		返回该品牌的ID，如果没有品牌，返回0。
	 */
	private static long checkBrand(ItemPage itemPage) {
		// TODO Auto-generated method stub
		return 0;
	}
}
