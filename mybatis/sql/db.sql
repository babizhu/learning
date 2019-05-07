create table login_record
(
    id           int auto_increment
        primary key,
    user_name    varchar(50) not null,
    login_date   datetime    null,
    login_result tinyint(1)  null
)
    comment '登陆信息';

create table tb_item
(
    id         int            not null
        primary key,
    itemName   varchar(255)   null,
    itemPrice  decimal(10, 2) null,
    itemDetail varchar(255)   null
)
    charset = utf8;

create table tb_order
(
    id           int auto_increment
        primary key,
    user_id      int          null,
    order_number varchar(255) null,
    created      datetime     null,
    updated      datetime     null
)
    charset = utf8;

create table tb_orderdetail
(
    id          int auto_increment
        primary key,
    order_id    int                   null,
    total_price decimal               null,
    item_id     int                   null,
    status      int unsigned zerofill null comment '0成功非0失败'
)
    charset = utf8;

create table user
(
    id       int auto_increment
        primary key,
    name     varchar(50)  not null,
    age      int          not null,
    password varchar(100) null,
    birthday datetime     null,
    sex      tinyint      null,
    updated  bigint       null
);

