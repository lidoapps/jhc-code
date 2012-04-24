package cn.jhc.heritrix.writer.extractor;

import cn.jhc.heritrix.bean.ItemPage;
import cn.jhc.heritrix.bean.Shop;

public class ExtractorFacade implements Extractor {

	private ItemExtractor itemExtractor;
	private ShopExtractor shopExtractor;
	
	public ExtractorFacade(ItemExtractor itemExtractor,
			ShopExtractor shopExtractor) {
		this.itemExtractor = itemExtractor;
		this.shopExtractor = shopExtractor;
	}

	public ItemPage extractItem() {
		ItemPage itemPage = new ItemPage();
		itemPage.setName(itemExtractor.extractCommodityName());
		itemPage.setMarketPrice(itemExtractor.extractMarketPrice());
		itemPage.setMarketPrice(itemExtractor.extractMaxPrice());
		itemPage.setPromotionPrice(itemExtractor.extractPromotionPrice());
		itemPage.setPromotionNote(itemExtractor.extractPromotionNote());
		itemPage.setSaledDesc(itemExtractor.extractSaledDesc());
		itemPage.setAssessment(itemExtractor.extractAssessment());
		itemPage.setCategory(itemExtractor.extractCategory());
		itemPage.setAttributes(itemExtractor.extractAttributes());
		return itemPage;
	}

	public Shop extractShop() {
		Shop shop = new Shop();
		shop.setName(shopExtractor.extractName());
		shop.setUrl(shopExtractor.extractUrl());
		shop.setAmount(shopExtractor.extractAmount());
		shop.setAssessment(shopExtractor.extractAssessment());
		shop.setCreateDate(shopExtractor.extractCreateDate());
		return shop;
	}

}
