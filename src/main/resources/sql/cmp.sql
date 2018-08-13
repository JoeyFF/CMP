-- cmp数据库

-- 创建cmp数据库
create database cmp;

-- 使用cmp数据库
use cmp;

-- 创建用户表
CREATE TABLE cmp_user (
  openid varchar(30) NOT NULL COMMENT '用户在此公众平台上唯一标识',
  nickname varchar(50) NOT NULL COMMENT '昵称',
  realname varchar(50) DEFAULT NULL COMMENT '真实姓名',
  sex tinyint(4) NOT NULL COMMENT '性别 1：男性 2 女性',
  province varchar(20) DEFAULT NULL COMMENT '用户所在省份',
  city varchar(20) DEFAULT NULL COMMENT '用户所在城市',
  country varchar(20) DEFAULT NULL COMMENT '用户所在国家',
  address varchar(50) DEFAULT NULL COMMENT '用户的详细地址',
  headimgurl varchar(500) DEFAULT NULL COMMENT '用户头像url',
  subscribe tinyint(4) DEFAULT NULL COMMENt '1 已关注 0 未关注 2 卖家',
  groupid bigint(20) DEFAULT NULL COMMENT '用户所在分组id',
  phone varchar(20) DEFAULT NULL COMMENT '注册手机号',
  password varchar(32) DEFAULT NULL COMMENT '密码，md5加密',
  school varchar(50) DEFAULT NULL  COMMENT '学校名称',
  wx varchar(40) DEFAULT NULL COMMENT '注册微信号',
  remark varchar(255) DEFAULT NULL COMMENT '用户备注',
  created timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`openid`),
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `wx` (`wx`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 创建收货地址表
CREATE TABLE cmp_address(
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL COMMENT '收货人姓名',
  phone varchar(20) NOT NULL COMMENT '收货人手机号',
  province varchar(20) NOT NULL COMMENT '用户所在省份',
  city varchar(20) NOT NULL COMMENT '用户所在城市',
  country varchar(20) NOT NULL COMMENT '用户所在国家',
  address varchar(50) NOT NULL COMMENT '用户的详细地址',
  created timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '添加时间',
  openid varchar(30) NOT NULL COMMENT '用户在此公众平台上唯一标识',
  type int DEFAULT 1 COMMENT '-1 表示删除地址 0 表示默认地址 1 表示附加地址',
  PRIMARY KEY (`id`),
  KEY `openid` (`openid`) USING BTREE,
  KEY `phone` (`phone`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址表';

-- 创建商品类目表
CREATE TABLE cmp_item_cat (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  parent_id bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  name varchar(50) DEFAULT NULL COMMENT '类目名称',
  status int(1) DEFAULT 1 COMMENT '状态。可选值:1(正常),2(删除)',
  sort_order int(4) DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  is_parent tinyint(1) DEFAULT 1 COMMENT '该类目是否为父类目，1为true，0为false',
  created timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=1183 DEFAULT CHARSET=utf8 COMMENT='商品类目';

----------------------- 下面的建表语句还未修改，请不要使用-----------------------

-- 创建商品描述表
CREATE TABLE cmp_item_desc (
  item_id bigint(20) NOT NULL COMMENT '商品ID',
  item_desc text COMMENT '商品描述',
  created datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品描述表';

-- 创建商品表
CREATE TABLE cmp_item (
  id bigint(20) NOT NULL COMMENT '商品id，同时也是商品编号',
  title varchar(100) NOT NULL COMMENT '商品标题',
  sell_point varchar(500) DEFAULT NULL COMMENT '商品卖点',
  price bigint(20) NOT NULL COMMENT '商品价格，单位为：分',
  new_price bigint(20) DEFAULT -1 COMMENT '商品优惠价格，单位为：分',
  num int(10) NOT NULL COMMENT '库存数量',
  barcode varchar(30) DEFAULT NULL COMMENT '商品条形码',
  image varchar(500) DEFAULT NULL COMMENT '商品图片',
  cid bigint(10) NOT NULL COMMENT '所属类目，叶子类目',
  status tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  created datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `status` (`status`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';



--
CREATE TABLE `tb_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL COMMENT '内容类目ID',
  `title` varchar(200) DEFAULT NULL COMMENT '内容标题',
  `sub_title` varchar(100) DEFAULT NULL COMMENT '子标题',
  `title_desc` varchar(500) DEFAULT NULL COMMENT '标题描述',
  `url` varchar(500) DEFAULT NULL COMMENT '链接',
  `pic` varchar(300) DEFAULT NULL COMMENT '图片绝对路径',
  `pic2` varchar(300) DEFAULT NULL COMMENT '图片2',
  `content` text COMMENT '内容',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
CREATE TABLE `tb_content_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `is_parent` tinyint(1) DEFAULT '1' COMMENT '该类目是否为父类目，1为true，0为false',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='内容分类';



--
CREATE TABLE `tb_item_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_cat_id` bigint(20) DEFAULT NULL COMMENT '商品类目ID',
  `param_data` text COMMENT '参数数据，格式为json格式',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_cat_id` (`item_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='商品规则参数';

--
CREATE TABLE `tb_item_param_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `param_data` text COMMENT '参数数据，格式为json格式',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='商品规格和商品的关系表';

--
CREATE TABLE `tb_order` (
  `order_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '订单id',
  `payment` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `payment_type` int(2) DEFAULT NULL COMMENT '支付类型，1、在线支付，2、货到付款',
  `post_fee` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `status` int(10) DEFAULT NULL COMMENT '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单更新时间',
  `payment_time` datetime DEFAULT NULL COMMENT '付款时间',
  `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `shipping_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流名称',
  `shipping_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流单号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `buyer_message` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '买家留言',
  `buyer_nick` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '买家昵称',
  `buyer_rate` int(2) DEFAULT NULL COMMENT '买家是否已经评价',
  PRIMARY KEY (`order_id`),
  KEY `create_time` (`create_time`),
  KEY `buyer_nick` (`buyer_nick`),
  KEY `status` (`status`),
  KEY `payment_type` (`payment_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
CREATE TABLE `tb_order_item` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `item_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品id',
  `order_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '订单id',
  `num` int(10) DEFAULT NULL COMMENT '商品购买数量',
  `title` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品标题',
  `price` bigint(50) DEFAULT NULL COMMENT '商品单价',
  `total_fee` bigint(50) DEFAULT NULL COMMENT '商品总金额',
  `pic_path` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片地址',
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
CREATE TABLE `tb_order_shipping` (
  `order_id` varchar(50) NOT NULL COMMENT '订单ID',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货人全名',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `receiver_mobile` varchar(30) DEFAULT NULL COMMENT '移动电话',
  `receiver_state` varchar(10) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(10) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '收货地址，如：xx路xx号',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮政编码,如：310001',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--

