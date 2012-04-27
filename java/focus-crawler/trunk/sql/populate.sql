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

-- 添加iPhone4S
-- tmall网址http://detail.tmall.com/item.htm?id=15179732651
insert into commodity(name,instance_id,datetime)
values('Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】','iPhone 4S(无锁)',now());
select id from commodity 
where name='Apple/苹果 iPhone 4S 【16G 32G 64 G 正品 大陆行货 带票】'
into @iphone4s_tmall_id;
-- 添加采集信息
insert into gathering(commodity_id,context_id,market_price,max_price,saled_desc,assessment,url,datetime)
values(@iphone4s_tmall_id,@tmall_ctx_id,4799,7899,'NOT FOUND','NOT FOUND','http://detail.tmall.com/item.htm?id=15179732651',now());
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

