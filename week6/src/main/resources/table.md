-- 用户表 
create table t_user (
    user_id varchar(36) primary key comment '用户id',
    user_name varchar(50) not null comment '用户名',
    nickname  varchar(50) null comment '昵称',
    name varchar(30) null comment '姓名',
    sex varchar(1) null comment '性别。1-男；2-女',
    cellphone varchar(11) not null comment '手机号',
    email varchar(50) null comment '邮箱',
    address varchar(200) null comment '地址',
    create_time TIMESTAMP default current_timestamp comment '创建时间',
    update_time TIMESTAMP  default current_timestamp comment '更新时间'
) 

-- 商品
create table t_commodity(
    id varchar(36) primary key comment '商品id',
    name varchar(200) not null comment '商品名称',
    price decimal(10, 2) not null comment '商品单价',
    storage int(4) null	comment '库存量', 
    description	varchar(2000) null comment '商品描述信息',
    create_time TIMESTAMP default current_timestamp comment '创建时间',
    update_time TIMESTAMP  default current_timestamp comment '更新时间'
)

-- 订单
create table t_order (
    order_id varchar(36) not null comment '订单号',
    user_id varchar(36) not null comment '用户id',
    commodity_id varchar(36) not null comment '商品id',
    commodity_num int(4) not null comment '商品数量',
    create_time TIMESTAMP default current_timestamp comment '创建时间',
    update_time TIMESTAMP  default current_timestamp comment '更新时间',
    primary key (order_id, user_id, commodity_id)
)