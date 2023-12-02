create database fitnes_center;

use fitnes_center;

create table users
(
    id int(50) auto_increment,
    name varchar(30) not null ,
    email varchar(30) not null ,
    password varchar(100) not null ,
    phone varchar(30) ,
    active boolean ,
    otp varchar(20) ,
    otp_generated_time datetime ,
    token varchar(200),
    token_expired_at BIGINT(20),
    name_credit_card varchar(30) not null ,
    number_credit_card varchar(50) not null ,
    expired_credit_card date not null ,
    primary key (id),
    unique (token)
)ENGINE InnoDB;

create table pemesanan_layanan
(
    id INT(50) auto_increment,
    name varchar(30) not null ,
    package varchar(50) not null ,
    primary key (id) ,
    foreign key fk_users_pemesanan (name) references users (name)
)ENGINE InnoDB;

desc users;

delete from users;

drop table users;

select  * from users;

create table menu_layanan
(
    menu_name varchar(50) not null ,
    duration int(10) not null ,
    primary key (menu_name)
)ENGINE InnoDB;

desc menu_layanan;

insert into menu_layanan(menu_name,duration) values ('paket_1',3);

insert into menu_layanan(menu_name,duration) values ('paket_2',3);

select * from menu_layanan;

create table detail_layanan
(
    id_detail int(10) auto_increment,
    menu_name varchar(50) not null ,
    price INT(100),
    day_schedule varchar(10),
    primary key (id_detail),
    foreign key fk_id_menu_layanan (menu_name) references menu_layanan (menu_name)
)ENGINE InnoDB;

desc detail_layanan;

delete from detail_layanan;

drop table menu_layanan;

insert into detail_layanan(id_detail,menu_name,price,day_schedule) values ('1','paket_1', '100000', 'Senin');

insert into detail_layanan(id_detail,menu_name,price,day_schedule) values ('2','paket_2', '100000', 'Selasa');

insert into detail_layanan(id_detail,menu_name,price,day_schedule) values ('3','1', '100000', 'Rabu');

select  * from detail_layanan;

