drop database if exists focus;
create database focus default character set utf8;

use focus;

-- 1.
-- Table structure for table Commodity
--

drop table if exists commodity;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table commodity(
id bigint unsigned auto_increment primary key,
name varchar(255) not null,
instance_id varchar(50) default null,
datetime datetime not null default '1900-01-01 00:00:00',
index(instance_id)
)engine=innodb;

-- 2.
-- Table structure for table CommodityAlias
--

drop table if exists commodity_alias;
create table commodity_alias(
id bigint unsigned auto_increment primary key,
alias varchar(255) not null,
commodity_id bigint unsigned,
datetime datetime not null default '1900-01-01 00:00:00',
index(commodity_id)
)engine=innodb;

-- 3.
-- Table structure for table Gathering
--
-- ORDER BY: id

drop table if exists gathering;
create table gathering (
id bigint unsigned auto_increment primary key,
commodity_id bigint unsigned,
context_id bigint unsigned,
market_price float not null default 0,
max_price float not null default 0,
promotion_price float not null default 0,
promotion_note varchar(255) not null default 'NOT FOUND',
saled_desc varchar(255) not null default 'NOT FOUND',
assessment varchar(255) not null default 'NOT FOUND',
url varchar(255) not null default 'NOT FOUND',
datetime datetime not null default '1900-01-01 00:00:00',
index(commodity_id)
)engine=innodb;

-- 4.
-- Table structure for table GatherMeta
--
-- ORDER BY: id

drop table if exists gather_meta;
create table gather_meta (
id bigint unsigned auto_increment primary key,
gather_id bigint unsigned,
meta_key varchar(255) not null default 'NOKEY',
meta_value varchar(255) not null default 'NOVALUE',
index(gather_id)
)engine=innodb;

-- 5.
-- Table structure for table Context
--
-- ORDER BY: id

drop table if exists context;
create table context(
id bigint unsigned auto_increment primary key,
path varchar(255) not null,
instance_id bigint unsigned not null,
context_level int not null default 10,
datetime datetime not null default '1900-01-01 00:00:00'
)engine=innodb;

-- 6.
-- Table structure for table Site
--
-- ORDER BY: id

drop table if exists site;
create table site(
id int unsigned auto_increment primary key,
name varchar(50) not null unique,
fullname varchar(255) not null,
url varchar(255) not null,
datetime datetime not null default '1900-01-01 00:00:00',
index(url)
)engine=innodb;

-- 7.
-- Table structure for table Shop
--

drop table if exists shop;
create table shop(
id bigint unsigned auto_increment primary key,
name varchar(255) not null,
site_id int unsigned not null,
url varchar(255) not null default 'NOT FOUND',
-- 对该店的评价，如淘宝网的评价等级
assessment varchar(255) not null default 'NOT FOUND',
-- 商品数量
amount int not null default 0, 
-- 该店创建时间
createdate datetime not null default '1900-01-01 00:00:00',
datetime datetime not null default '1900-01-01 00:00:00',
index(name),index(url)
)engine=innodb;

-- 8.
-- Table structure for table Category
--

drop table if exists category;
create table category(
id bigint unsigned auto_increment primary key,
name varchar(255),
site_id int unsigned,
datetime datetime not null default '1900-01-01 00:00:00',
index(name)
)engine=innodb;

