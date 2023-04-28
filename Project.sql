create database perishables_management_system;
use perishables_management_system;
create table Employee(
	Name char(30) not null,
	ID varchar(10) primary key,
	Age int default 0,
	DOB date not null,
	Designation varchar(30) not null check (designation in("Manager","Supervisor","Staff")),
    tou varchar(20) check (tou in("user","admin")),
    phoneno varchar(10), 
    password varchar(20) default "welcome123"
);
delimiter $$
create procedure update_ages(in uid varchar(10),in dob date)
begin
declare new_age int;
set new_age = FLOOR(DATEDIFF(CURRENT_DATE,dob)/365);
update employee set age = new_age where id = uid;
end; $$
delimiter ;
desc Employee;
insert into Employee(Name,ID,DOB,Designation,tou,phoneno) values("Hari","A001",DATE '2002-12-21',"Manager","admin","7829020080");
insert into Employee(Name,ID,DOB,Designation,tou,phoneno) values("Vasanth","A002",DATE '2002-02-21',"Supervisor","admin","9987654231");
call update_ages("A001",'2002-12-21');
call update_ages("A002",'2002-02-21');
select * from employee;
create table product(
	pid int unsigned auto_increment primary key,
    type_of_product varchar(20) not null check (type_of_product in ("Fruit","Vegetable")),
    product_name varchar(30),
    price_per_kg float,
    stored_date datetime,
    expiry_date datetime,
    no_expiry int,
    quantity float
);
insert into product(type_of_product,product_name,price_per_kg,stored_date,expiry_date,no_expiry,quantity) values("Fruit","Apples",20,'2023-04-26','2023-04-28 12:00:00',10,20);
create table perishable_product(
	pid int primary key references product(pid),
    type_of_product varchar(20) not null check (type_of_product in ("Fruit","Vegetable")),
    product_name varchar(30),
    price_per_kg float,
    stored_date datetime,
    expiry_date datetime,
    no_expiry int,
    quantity float,
    decrease_p double
);
create table expired_product(
	pid int,
    type_of_product varchar(20) not null check (type_of_product in ("Fruit","Vegetable")),
    product_name varchar(30),
    expiry_date datetime,
    quantity float
);
select * from perishable_product;
select * from product pd where not exists(select pid,type_of_product,product_name,price_per_kg,stored_date,expiry_date,no_expiry,quantity from perishable_product where pd.pid=pid);
