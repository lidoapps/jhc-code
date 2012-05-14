use focus;

-- 添加网站信息
insert into site(name,fullname,url,datetime)
values('天猫网','天猫网','http://www.tmall.com/',now()),
('当当网','当当网','http://www.dangdang.com/',now()),
('淘宝网','淘宝网','http://www.taobao.com/',now()),
('太平洋电脑网','太平洋电脑网','http://www.pconline.com.cn/',now());

-- 保存网站变量
select id from site where name='天猫网' into @tmall_id;
select id from site where name='当当网' into @dangdang_id;
select id from site where name='淘宝网' into @taobao_id;
select id from site where name='太平洋电脑网' into @pconline_id;

-- 添加各个网站的context
insert into context(path,instance_id,context_level,datetime)
values(@tmall_id,@tmall_id,10,now()),
(@dangdang_id,@dangdang_id,10,now()),
(@taobao_id,@taobao_id,10,now()),
(@pconline_id,@pconline_id,10,now());

-- 保存各网站context id
select id from context where instance_id=@tmall_id into @tmall_ctx_id;
select id from context where instance_id=@dangdang_id into @dangdang_ctx_id;
select id from context where instance_id=@taobao_id into @taobao_ctx_id;
select id from context where instance_id=@pconline_id into @pconline_ctx_id;

-- 添加iPhone品牌
-- 添加Asus（华硕）品牌
insert into brand(name,datetime) 
values('iPhone',now()),
('Asus',now()),
('湖南人民出版社',now()),
('天津教育出版社',now()),
('耐克',now()),
('Samsung',now()),
('Motorola',now()),
('Nokia',now());
select id from brand where name='iPhone' into @iphone_brand_id;
select id from brand where name='Asus' into @asus_brand_id;
select id from brand where name='湖南人民出版社' into @hrc_brand_id;
select id from brand where name='天津教育出版社' into @tjc_brand_id;
select id from brand where name='耐克' into @nike_brand_id;
select id from brand where name='Samsung' into @samsung_brand_id;
select id from brand where name='Motorola' into @motorola_brand_id;
select id from brand where name='Nokia' into @nokia_brand_id;



-- 添加iPhone4S
-- tmall网址http://detail.tmall.com/item.htm?id=15179732651
-- 添加UX31KI2557E
-- tmall网址http://detail.tmall.com/venus/spu_detail.htm?spu_id=140313197
insert into commodity(name,brand_id,instance_id,is_unique,datetime)
values('Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】',@iphone_brand_id,'iPhone 4S(无锁)',0,now()),
('Asus/华硕 UX31KI2557E笔记本/Zenbook/I5/4G/256G固态硬盘',@asus_brand_id,'UX31KI2557E',0,now()),
('青春（韩寒最新作品，上市两月销售突破90万，好评如潮）',@hrc_brand_id,'9787543877450',0,now()),
('福尔摩斯探案全集（上、中、下）（当当网全国独家）',@tjc_brand_id,'9787530955574',0,now()),
('现货 专柜正品 耐克Nike男式跑步鞋-472502-012',@nike_brand_id,'472502-012',0,now()),
('Samsung/三星 SCH-I929 双模双待正品行货 全国联保 白色现货',@samsung_brand_id,'SCH-I929',0,now()),
('【回馈顾客 特惠包邮】Motorola/摩托罗拉 Defy/ME525三防 行货',@motorola_brand_id,'ME525/MB525',0,now()),
('【电保包】Nokia/诺基亚 N9/n9 MeeGo米狗智能 不跟随 正品非定制',@nokia_brand_id,'N9',0,now()),
('Nokia/诺基亚 N8/N8-00导航智能3G手机正品行货 全国联保带发票',@nokia_brand_id,'N8',0,now()),
('诺基亚900',@nokia_brand_id,'900',0,now());



select id from commodity 
where name='Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】'
into @iphone4s_tmall_id;
select id from commodity 
where name='Asus/华硕 UX31KI2557E笔记本/Zenbook/I5/4G/256G固态硬盘'
into @zenbook_tmall_id;
select id from commodity 
where name='青春（韩寒最新作品，上市两月销售突破90万，好评如潮）'
into @qingchun_dangdang_id;
select id from commodity 
where name='福尔摩斯探案全集（上、中、下）（当当网全国独家）'
into @Holmes_dangdang_id;
select id from commodity 
where name='现货 专柜正品 耐克Nike男式跑步鞋-472502-012'
into @nike_tmall_id;
select id from commodity 
where name='Samsung/三星 SCH-I929 双模双待正品行货 全国联保 白色现货'
into @samsungi9_tmall_id;
select id from commodity 
where name='【回馈顾客 特惠包邮】Motorola/摩托罗拉 Defy/ME525三防 行货'
into @motoroladefy_tmall_id;
select id from commodity 
where name='【电保包】Nokia/诺基亚 N9/n9 MeeGo米狗智能 不跟随 正品非定制'
into @nokian9_tmall_id;
select id from commodity 
where name='Nokia/诺基亚 N8/N8-00导航智能3G手机正品行货 全国联保带发票'
into @nokian8_tmall_id;
select id from commodity 
where name='诺基亚900'
into @nokia9_pconline_id;



-- 添加采集iphone4s信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@iphone4s_tmall_id,@tmall_ctx_id,4799,7899,'月 销 量：1411件','4.8分(已有1654人评论)','http://detail.tmall.com/item.htm?id=15179732651',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Apple/苹果 iPhone 4S'),
(@gather_id,'手机价格区间','4000元以上'),
(@gather_id,'上市时间','2011年'),
(@gather_id,'11年上市月份','1月'),
(@gather_id,'网络类型','联通3G GSM/WCDMA(3G)'),
(@gather_id,'外观样式','直板'),
(@gather_id,'主屏尺寸','3.5英寸'),
(@gather_id,'机身颜色','16G 黑色 原封 （64G）7899 预存送手机 （64G）6899 购机入网 32G 白（拆封激活+装软件） 64G 黑（拆封激活+装软件） （32G）6899 预存送手机 32G 黑（拆封激活+装软件） 16G 白色 原封 （32G）5899 购机入网 32G 白色 原封 16G 白（拆封激活+装软件） 64G 白色 原封 （16G）5880 预存送手机 32G 黑色 原封 16G 黑（拆封激活+装软件） 64G 黑色 原封 （16G）4999 购机入网'), 
(@gather_id,'手机套餐','官方标配 套餐一 套餐二 套餐三 套餐四 套餐五 套餐六 套餐七 套餐八'),
(@gather_id,'摄像头','800万'),
(@gather_id,'是否智能手机','智能手机'),
(@gather_id,'操作系统','iPhone'),
(@gather_id,'高级功能','WIFI上网 GPS导航 高清视频'),
(@gather_id,'宝贝成色','全新'),
(@gather_id,'售后服务','全国联保'),
(@gather_id,'触摸屏','电容式触摸屏'),
(@gather_id,'手机CPU','双核1G'),
(@gather_id,'运行内存RAM','512M'),
(@gather_id,'机身内存ROM','16g'),
(@gather_id,'键盘类型','虚拟触屏键盘'),
(@gather_id,'厚度','超薄(小于9mm)'),
(@gather_id,'主屏分辨率','960×640像素');

-- 添加采集zenbook信息
Insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@zenbook_tmall_id,@tmall_ctx_id,8500.00,11300.00,'月 销 量：14件','5.0分(已有9人评论)', 'http://detail.tmall.com/venus/spu_detail.htm?spu_id=140313197',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Asus/华硕 UX31KI2557E'),
(@gather_id,'UX31系列型号','UX31KI2557E'),
(@gather_id,'CPU平台','Intel GMA HD 3000'),
(@gather_id,'集成显卡型号','Intel GMA HD 3000'),
(@gather_id,'固态硬盘','256g'),
(@gather_id,'笔记本定位','轻薄便携'),
(@gather_id,'笔记本价格区间','7000-10000元'),
(@gather_id,'上市时间','2011年下半年'), 
(@gather_id,'输入设备','触摸板'),
(@gather_id,'成色','全新'),
(@gather_id,'品牌','Asus/华硕'),
(@gather_id,'屏幕尺寸','13寸'),
(@gather_id,'Intel Core/酷睿 i5','i5-2557M'),
(@gather_id,'显存容量','共享内存容量'),
(@gather_id,'内存容量','4G'),
(@gather_id,'重量','1-1.5公斤'),
(@gather_id,'售后服务','全国联保'),
(@gather_id,'操作系统','Windows 7'),
(@gather_id,'机身内存ROM','16g'),
(@gather_id,'其它功能','摄像头 扬声器 USB 3.0'),
(@gather_id,'系列','UX31系列'),
(@gather_id,'屏幕比例','宽屏'),
(@gather_id,'显卡类型','集成'),
(@gather_id,'硬盘容量','256G固态硬盘'),
(@gather_id,'光驱类型','无'),
(@gather_id,'电池类型','6芯锂电池'),
(@gather_id,'颜色分类','水星银'),
(@gather_id,'通信功能','无线网卡 蓝牙'),
(@gather_id,'笔记本套餐','官方标配');

-- 添加采集信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@qingchun_dangdang_id,@dangdang_ctx_id, 17.90, 29.00,'月 销 量： ','5星(已有15355人评论)','http://product.dangdang.com/product.aspx?product_id=22507045',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'作　　者','韩寒'),
(@gather_id,'出 版 社','湖南人民出版社'),
(@gather_id,'出版时间','2011-10-1'),
(@gather_id,'版　　次','1'),
(@gather_id,'印刷时间','2011-10-1'),
(@gather_id,'印　　次','1'),
(@gather_id,'页　　数','208'),
(@gather_id,'开　　本','大32开'), 
(@gather_id,'I S B N','9787543877450'),
(@gather_id,'字　　数','110000'),
(@gather_id,'纸　　张','胶版纸'),
(@gather_id,'包　　装','平装');

-- 添加采集信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@Holmes_dangdang_id,@dangdang_ctx_id,43.20,108.00,'月 销 量：','4星半(已有2021人评论)','http://product.dangdang.com/product.aspx?product_id=20531088',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'作　　者','（英）柯南道尔　著，王知一　译'),
(@gather_id,'出 版 社','天津教育出版社'),
(@gather_id,'出版时间','2009-3-1'),
(@gather_id,'版　　次','1'),
(@gather_id,'印刷时间','2009-3-1'),
(@gather_id,'印　　次','1'),
(@gather_id,'页　　数','全三册'),
(@gather_id,'开　　本','16开'), 
(@gather_id,'I S B N','9787530955574'),
(@gather_id,'字　　数','1700000'),
(@gather_id,'纸　　张','胶版纸'),
(@gather_id,'包　　装', '平装');

-- 添加采集信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@nike_tmall_id,@tmall_ctx_id,528.00,849.00,'月 销 量：51件','4.7分(已有14人评论)','http://detail.tmall.com/venus/spu_detail.htm?spu_id=143041358',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'颜色分类','浅灰色 黑色'),
(@gather_id,'上市年份','2012年春季'),
(@gather_id,'是否现货','现货'),
(@gather_id,'货号','472502-012'),
(@gather_id,'市场价格','849'),
(@gather_id,'尺码','38.5 39 40 40.5 41 42 42.5'),
(@gather_id,'品牌','Nike/耐克'),
(@gather_id,'性别','男性'), 
(@gather_id,'价格区间','501-800元');

-- 添加采集samsungi9信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@samsungi9_tmall_id,@tmall_ctx_id,4690.00,4960.00,'月 销 量：85件','4.8分(已有133人评论)','http://detail.tmall.com/venus/spu_detail.htm?spu_id=142615668',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Samsung/三星 SCH-I929'),
(@gather_id,'手机价格区间','4000元以上'),
(@gather_id,'上市时间','2011年'),
(@gather_id,'11年上市月份','12月'),
(@gather_id,'网络类型','双模(GSM/CDMA2000)'),
(@gather_id,'外观样式','直板'),
(@gather_id,'主屏尺寸','4.5英寸'),
(@gather_id,'机身颜色','黑色【现货】 黑色【未开封不做保卡】 釉白【现货】 釉白【未开封不做保卡】'), 
(@gather_id,'手机套餐','官方标配 套餐一'),
(@gather_id,'摄像头','800万'),
(@gather_id,'是否智能手机','智能手机'),
(@gather_id,'操作系统','Android/安卓'),
(@gather_id,'高级功能','WWIFI上网 GPS导航 双卡双待 高清视频'),
(@gather_id,'宝贝成色','全新'),
(@gather_id,'售后服务','全国联保'),
(@gather_id,'触摸屏','电容式触摸屏'),
(@gather_id,'手机CPU','双核1.5G'),
(@gather_id,'运行内存RAM','1G'),
(@gather_id,'机身内存ROM','16g'),
(@gather_id,'键盘类型','虚拟触屏键盘'),
(@gather_id,'厚度','薄(9mm~1cm)'),
(@gather_id,'主屏分辨率','1280×800像素');

-- 添加采集motoroladefy信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@motoroladefy_tmall_id,@tmall_ctx_id,1499.00,1599.00,'月 销 量：1361件','4.7分(已有1769人评论)','http://detail.tmall.com/venus/spu_detail.htm?spu_id=121896053',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Motorola/摩托罗拉 Defy/ME525三防 行货'),
(@gather_id,'手机价格区间','1001-2000元'),
(@gather_id,'上市时间','2011年'),
(@gather_id,'11年上市月份','1月'),
(@gather_id,'网络类型','联通3G GSM/WCDMA(3G)'),
(@gather_id,'外观样式','直板'),
(@gather_id,'主屏尺寸','3.7英寸'),
(@gather_id,'机身颜色','机身颜色: 黑色定制版送8G+品电+品充 黑色定制版 特惠无赠品'), 
(@gather_id,'手机套餐','官方标配 套餐一 套餐二 套餐三 套餐四 套餐五 套餐六'),
(@gather_id,'摄像头','500万'),
(@gather_id,'是否智能手机','智能手机'),
(@gather_id,'操作系统','Android/安卓'),
(@gather_id,'高级功能','WIFI上网 GPS导航'),
(@gather_id,'宝贝成色','全新'),
(@gather_id,'售后服务','全国联保'),
(@gather_id,'触摸屏','电容式触摸屏'),
(@gather_id,'手机CPU','800M'),
(@gather_id,'运行内存RAM','512M'),
(@gather_id,'机身内存ROM','1G'),
(@gather_id,'键盘类型','虚拟触屏键盘'),
(@gather_id,'厚度','普通(大于1cm)'),
(@gather_id,'主屏分辨率','854×480像素');

-- 添加采集nokian9信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@nokian9_tmall_id,@tmall_ctx_id,2599.00,3050.00,'月 销 量：265件','4.8分(已有374人评论)','http://detail.tmall.com/venus/spu_detail.htm?spu_id=122079535',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Nokia/诺基亚 N9'),
(@gather_id,'手机价格区间','2001-3000元'),
(@gather_id,'上市时间','2011年'),
(@gather_id,'11年上市月份','9月'),
(@gather_id,'网络类型','联通3G GSM/WCDMA(3G)'),
(@gather_id,'外观样式','直板'),
(@gather_id,'主屏尺寸','4.0英寸'),
(@gather_id,'机身颜色','粉色(送剪卡器+RG进口屏保） 蓝色(送剪卡器+RG进口屏保） 黑色(送剪卡器+RG进口屏保） 联通版黑色移动可用 64G白色(送剪卡器+RG膜) 联通版粉色（预售） 联通版蓝色移动可用（送礼）'), 
(@gather_id,'手机套餐','官方标配 套餐一 套餐二 套餐三 套餐四 套餐五'),
(@gather_id,'摄像头','800万'),
(@gather_id,'是否智能手机','智能手机'),
(@gather_id,'操作系统','meego'),
(@gather_id,'高级功能','WIFI上网 GPS导航'),
(@gather_id,'宝贝成色','全新'),
(@gather_id,'售后服务','全国联保'),
(@gather_id,'触摸屏','电容式触摸屏'),
(@gather_id,'手机CPU','1G'),
(@gather_id,'运行内存RAM','1G'),
(@gather_id,'机身内存ROM','16g'),
(@gather_id,'键盘类型','虚拟触屏键盘'),
(@gather_id,'厚度','普通(大于1cm)'),
(@gather_id,'主屏分辨率','854×480像素');

-- 添加采集Nokian8信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@nokian8_tmall_id,@tmall_ctx_id,2149.00,2259.00,'月 销 量：139件','4.8分(已有227人评论)','http://detail.tmall.com/venus/spu_detail.htm?spu_id=120328865',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Nokia/诺基亚 N8/N8-00'),
(@gather_id,'手机价格区间','2001-3000元'),
(@gather_id,'上市时间','2010年'),
(@gather_id,'10年上市月份','10月'),
(@gather_id,'网络类型','联通3G GSM/WCDMA(3G)'),
(@gather_id,'外观样式','直板'),
(@gather_id,'主屏尺寸','3.5英寸'),
(@gather_id,'机身颜色','黑色【送贴膜手包带机打发票】 橙色【送贴膜手包带机打发票】 蓝色【送贴膜手包带机打发票】 粉色【送贴膜手包带机打发票】 绿色【送贴膜手包带机打发票】 银色【送贴膜手包带机打发票】 铜色【送贴膜手包带机打发票】'), 
(@gather_id,'手机套餐','官方标配 套餐一 套餐二'),
(@gather_id,'摄像头','1200万'),
(@gather_id,'是否智能手机','智能手机'),
(@gather_id,'操作系统','Symbian/塞班'),
(@gather_id,'高级功能','WIFI上网 GPS导航'),
(@gather_id,'宝贝成色','全新'),
(@gather_id,'售后服务','全国联保'),
(@gather_id,'触摸屏','电容式触摸屏'),
(@gather_id,'手机CPU','680M'),
(@gather_id,'运行内存RAM','256M'),
(@gather_id,'机身内存ROM','512M'),
(@gather_id,'键盘类型','虚拟触屏键盘'),
(@gather_id,'厚度','普通(大于1cm)'),
(@gather_id,'主屏分辨率','640×360像素');



-- 添加采集iphone4s信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@nokia9_pconline_id,@pconline_ctx_id,4999,5300,'月 销 量：','4.4分(339位网友评分)','http://product.pconline.com.cn/mobile/nokia/479092.html',now());
-- 保存本次gather的id
select max(id) from gathering into @gather_id;
-- 添加本次采集的属性
insert into gather_meta(gather_id,meta_key,meta_value)
values(@gather_id,'产品名称','Nokia 900'),
(@gather_id,'手机类型','智能手机,音乐手机,拍照手机,3G手机,4G手机'),
(@gather_id,'上市时间','2012年'),
(@gather_id,'手机制式','GSM,WCDMA(联通3G),CDMA EV-DO(电信3G),LTE(4G)'),
(@gather_id,'手机频段','WCDMA(联通3G),CDMA 2000/1x ev-do(电信3G),GSM 850/900/1800/1900'),
(@gather_id,'系统','Windows phone 7.5(Mango)'),
(@gather_id,'手机外形','直板'),
(@gather_id,'主屏尺寸','4.3英寸'),
(@gather_id,'主屏材质','ClearBlack AMOLED'), 
(@gather_id,'主屏色彩','1600万色'),
(@gather_id,'主屏参数','480×800像素(WVGA)'),
(@gather_id,'CPU','1.4GHz'),
(@gather_id,'内存容量','512MB RAM'),
(@gather_id,'标准配置','锂电池,说明书,充电器,数据线,耳机 '),
(@gather_id,'电池容量','1830mAH'),
(@gather_id,'外壳颜色','黑色,蓝色 '),
(@gather_id,'尺寸','125.5×65.8×11.5mm'),
(@gather_id,'重量','160g'),
(@gather_id,'机身特点','延续了Lumia 800的外型设计，采用一体成型的聚碳酸酯材质，厚度压缩至11.5mm，是目前最薄的Lumia手机。'),
(@gather_id,'产品特性','重力感应,距离感应,光线感应'),
(@gather_id,'铃声','和弦,支持MP3铃声'),
(@gather_id,'通讯录','分组管理'),
(@gather_id,'信息功能','SMS短信'),
(@gather_id,'E-mail收发','支持E-mail'),
(@gather_id,'输入法','手写输入,英文输入法,中文输入法,笔划中文输入法,拼音中文输入法'),
(@gather_id,'办公功能','支持TXT'),
(@gather_id,'主要功能','内置天线,时钟,内置震动,情景模式,通话时间提示,免提通话,待机图片,来电图片识别,来电铃声识别'),
(@gather_id,'蓝牙','蓝牙v4.0,A2DP蓝牙立体声'),
(@gather_id,'数据业务','GPRS,EDGE,HSDPA,HSPA+'),
(@gather_id,'JAVA','支持Java'),
(@gather_id,'WAP上网','wap 2.0'),
(@gather_id,'WWW浏览器','支持WWW浏览器'),
(@gather_id,'数据线','USB 2.0'),
(@gather_id,'扩展卡','支持TF卡(microSD卡),最大支持32GB扩展'),
(@gather_id,'WiFi(WLAN)','支持WiFi'),
(@gather_id,'GPS定位系统','支持GPS'),
(@gather_id,'摄像头像素','800万像素'),
(@gather_id,'副摄像头','内置副摄像头,130万像素'),
(@gather_id,'视频播放','支持JPEG,PNG,GIF,BMP等格式'),
(@gather_id,'质保时间','主机1年，电池6个月，充电器1年，有线耳机3个月'),
(@gather_id,'客服电话','400-880-0121');








