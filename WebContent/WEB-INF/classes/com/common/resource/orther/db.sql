/*********************************************************/ 
function:SQL MSSQL TECHNOLOGY ARTICLE 
file :SQL-MSSQL.TXT 
author :chinayaosir QQ:44633197 
Tools :MSSQL QUERY ANALYSIS 
date :4/01/2010 
blog :http://blog.csdn.net/chinayaosir 
note :禁止其它网站转载此文章 
/*********************************************************/ 
目录清单CONTEXT LIST 
/*********************************************************/ 
1.数据库DataBase 
1.1数据库建立/删除create/drop database 
1.2数据库备份与恢复backup/restore database 
/*********************************************************/ 
2.数据查询DATA QUERY LANGUAGE 
2.1选择查询Select Query 
2.2聚集查询Aggregate Query 
2.3子查询 Sub Query 
2.4连接查询Table Joins 
2.5汇总查询Group Query 
/*********************************************************/ 
3.数据修改DATA MODIFY LANGUAGE 
3.1插入数据Insert 
3.2修改数据Update 
3.3删除数据Delete 
/*********************************************************/ 
4.数据定义DATA DEFINE LANGUAGE 
4.1表Table 
4.2列Column 
4.3序列Identity 
4.4约束Constraints 
4.5索引Index 
4.6视图view 
4.7权限Privilege 
/*********************************************************/ 
5.数据库函数Functions 
5.1转换函数Data Convert Functions 
5.2聚集函数Aggregate Functions 
5.3字符函数char Functions 
5.4日期函数Date Functions 
5.5数学函数Math Functions 
5.6分析函数Analytical Functions 
/*********************************************************/ 
6.数据库脚本Script 
6.1数据类型Data Types 
6.2脚本语法Statements 
6.3脚本游标Cursor 
6.4存储过程Procedure 
6.5存储函数Function 
6.6触发器Trigger 
6.7事务Transaction 
6.8其它Other 
/*********************************************************/ 

SQL明细 SQL DETAIL 
/**********************************************************/ 
1.数据库DataBase 
1.1数据库建立/删除create/drop database 
1.2备份与恢复backup/restore database 
/**********************************************************/ 
1.1数据库建立/删除create/drop database 
1.1.1.建立数据库 
语法:create database <数据库名> ［其它参数］ 
代码: 
//建立数据库 hr 
create database hr 

1.1.2.删除数据库。 
语法:drop database <数据库名> 
代码: 
//删除数据库hr 
drop database hr 
//如果存在hr数据库,则删除数据库hr 
IF DB_ID('hr') IS NOT NULL 
DROP DATABASE TestDB 
----------------------------------------------------------- 
1.2备份与恢复backup/restore database 
1.2.1.添加备份设备 
语法:sp_addumpdevice <keyword> <devicename> <devicepath> 

代码: 
//添加备份设备为本地硬盘 
sp_addumpdevice 'disk', 'localbackup', 'e:\database\backup\localbak.bak' 
//备份到网络硬盘 
sp_addumpdevice 'disk', 'netbackup', '\\computer1\database\backup\netbak.bak' 
//备份到磁带 
sp_addumpdevice 'tape', 'tapebackup', '\\.\tape1bak' 
//备份到命名管道 
sp_addumpdevice 'pipe', 'pipebackup', 'e:\database\backup\pipebak' 

1.2.2.备份数据库 
语法:backup database <databasename> to <devicename>| disk=<backupnamepath> 

代码: 
//备份数据库到备份设备 
backup database pubs to localbackup 
//备份数据库到指定路径下面的指定文件 
backup database pubs to disk='e:\database\backup\pubsbak.bak' 

1.2.3.恢复数据库 
语法:restore database <databasename> from <devicename>| disk=<backupnamepath> 
代码: 
//从备份设备中恢复数据库 
restore database pubs from localbackup 
//从备份文件中恢复数据库 

/**********************************************************/ 
2.数据查询DATA QUERY LANGUAGE 
2.1选择查询Select Query 
2.2子查询 Sub Query 
2.3连接查询Table Joins 
2.4汇总查询Group Query 
----------------------------------------------------------- 
2.1选择查询Select Query 
语法: 
select [top n][/all]/[distinct] [*] / [columnlist...] [<columnlist as alias...] [const/sql/function expression] 
from (<tablelist,>...) [as alias] 
[where search expression...] 
[group by groupnamelist ....] 
[having search-expression...] 
[order by sort-expression...] 

//select选项说明: 
top n:只显示第一条到n条记录 
//重复与不重复记录 
all:表示包含重复的记录 
distinct:表示去掉重复的记录 
//所有字段与选中字段和字段别名 
*:表示所有的列名 
columnlist:表示字段列表 
columnlist as alias:表示字段的别名 

//其它字段 
const-expression:常量表达式(如数字/字符串/日期/时间常量) 
sql-expression:常见的sql语句的加减乘除表达式运算字段 
function expression:数据库函数和自定义函数字段 

//测试条件 
比较测试条件(=,<>,>,<,>=,<=) 
范围测试条件(betweeen 下限值 and 上限值) 
成员测试条件(in,not in) 
存在测试条件(exists,not exists) 
匹配测试条件(like) 
限定测试条件(any,all) 
空值测试条件(is null) 

//复合搜索条件(and, or,not,()) 
and:逻辑与运算 
and:逻辑或运算 
not:逻辑非运算 
():可改变优先级的运算符 

//子句说明 
select子句:指出检索的数据项 
from 子句:指出检索的数据表 
where 子句:指出检索的数据条件 
group by子句:指出检索的数据进行汇总 
having子句:指出检索的数据进行汇总之前的条件 
order by子句:指出检索的数据条件进行排序 
代码: 
//所有字段方式显示orders全部记录 
select * from orders 
//按字段显示全部记录 
select order_num,order_date,amount from orders 
//按字段显示全部记录,但除掉重复的记录 
select order_num,order_date,amount from orders 
//用sql-expression乘运算计算列 
select amount,amount*0.08 as discount_amt from orders 
//用自定义函数计算指定列 
select order_num,order_date,amount,f_amt_to_chn(amount) as 金额 from orders 

select选项太多，代码例子就省略... 
----------------------------------------------------------- 
2.2子查询 Sub Query 
语法:select ... 
from <tablename> 
where / having column 测试条件 (Sub Query) 
//测试条件 
比较测试条件(=,<>,>,<,>=,<=) 
范围测试条件(betweeen 下限值 and 上限值) 
成员测试条件(in,not in) 
存在测试条件(exists,not exists) 
匹配测试条件(like) 
限定测试条件(any,all) 
空值测试条件(is null) 

代码: 
//列出没有完成销售目标10%的销售人员清单[<测试] 
select name from salesreps where quota < (0.1 * select sum(target) from offices)) 
//列出公司的销售目标超过各个销售人员定额总和的销售点[>测试] 
select city from offices where target > (select sum(quota) from salesreps where rep_office=office) 
//列出超过销售目标的销售点的业务人员[in测试] 
select name from salesreps where office in (select office from offies where sales > target) 
//列出订单大于2500元的产品名称[exists测试] 
select description from products where exists ( 
select * from orders where product=prodct_id and amount > 2500.00 
) 
//列出完成销售目标10%的销售人员清单[any测试] 
select name from salesreps where (0.1* quota) < any(select amount from orders where rep=empl_num) 

----------------------------------------------------------- 
2.3连接查询Table Joins 
多表连接类型可分为三类(内/外/交叉连接) 
主从表或者父子表进行多表连接多以主键和外键进行关联 
Outer joins(LEFT OUTER, RIGHT OUTER, and FULL OUTER joins) 
left outer join:查询的结果以左边表行数为准 
right outer join:查询的结果以右边表行数为准 

2.3.1.内连接inner join 
功能: 
语法: 
SELECT select_list 
FROM table_1 
[INNER] JOIN table_2 
ON join_condition_1 
[[INNER] JOIN table_3 
ON join_condition_2]... 
代码: 
//没有where子句的内连接 
SELECT * 
FROM Products 
INNER JOIN Suppliers 
ON Products.SupplierID = Suppliers.SupplierID 

//有where子句的内连接 
SELECT p.ProductID, s.SupplierID, p.ProductName, s.CompanyName 
FROM Products p 
INNER JOIN Suppliers s 
ON p.SupplierID = s.SupplierID 
WHERE p.ProductID < 4 

----------------------------------------------------------- 
2.3.2.外连接outer join 
功能:包括三种连接LEFT OUTER, RIGHT OUTER, and FULL OUTER joins 
left outer :查询的结果以左边表行数为准 
right outer :查询的结果以右边表行数为准 
语法:select ... from table1 [left/right/full outer join ]table2 where ... 
代码: 
//以Customers表行数为标准去连接Orders表 
SELECT c.CustomerID, CompanyName 
FROM Customers c 
LEFT OUTER JOIN Orders o 
ON c.CustomerID = o.CustomerID 
WHERE o.CustomerID IS NULL 

----------------------------------------------------------- 
2.3.3.交叉连接cross join 
功能:以主从表或者父子表之间的主键进行连接，最终以笛卡尔乘积运算的结果 
语法:select ... from table1 cross join table2 where ... 

代码: 
//显示结果以表1行数*表2行数 
假设Departments为4行记录 
假设Jobs为3行记录 
下面的显示结果为4*3=12行记录 
SELECT deptname,jobdesc FROM Departments CROSS JOIN Jobs 
//用关键字匹配的交叉连接 
oc_head/oc_detail是主从表 
oc_head(主键oc_number) 
oc_detail(主键oc_number,item_number,ship_date) 

SELECT h.customerid,d.item_number,d.ship_date 
from oc_head as h CROSS JOIN oc_detail as d 
where h.oc_number=d.oc_number 
----------------------------------------------------------- 
2.4汇总查询Group Query 
//汇总查询相当于会计报表中的小计汇总的功能 

语法: select ... 
from <tablename> 
group by <column-name > 
[having search expression] 

代码: 
//求出每名销售人员的销售金额 
select rep,sum(amount) from orders group by rep 
//每个销售点分配了多少销售人员 
select rep_office,count(*) from salesreps group by rep_office 
//计算每名销售人员的每个客户和订单金额 
select cust,rep,sum(amount) from orders group by cust,rep 
//Having子句应用 
select rep,avg(amount) from orders having sum(quota) > 3000.00 

/**********************************************************/ 
3.数据修改DATA MODIFY LANGUAGE 
3.1插入数据Insert 
3.2修改数据Update 
3.3删除数据Delete 
----------------------------------------------------------- 
3.1插入数据Insert 
3.1.1.单行插入 
语法:insert into <tablename>[<columnlist,>...] values(<valuelist,>...); 

代码: 
//不省略字段清单 
insert into salesreps(name,age,empl_no,sales,title,hire_date,rep_office) 
values('jack toms',36,111,0.00,'sales mgr','10-05-2010',13) 
//省略字段清单 
insert into salesreps 
values('jack toms',36,111,0.00,'sales mgr','10-05-2010',13) 
3.1.2.多行插入 
语法:insert into <tablename>[(<columnlist,>...)] values(<valuelist,>...) <select Query>; 

代码: 
//把一批数据批量插入到一个备份表中 
insert into history_order(order_num,order_date,amount) 
select order_num,order_date,amount 
from orders where order_date < '01/01/2000' 
----------------------------------------------------------- 
3.2修改数据Update 
语法:update <tablename> set (cloumn=expression...) [where ...] [SubQuery..] 

代码: 
//更新所有记录 
update salesreps set quota=1.05 * quota 
//按条件更新表记录 
update salesreps set quota=1.08 * quota where area='china' 
//按子查询更新表记录 
update customers set cust_rep=105 
where cust_rep in ( 
selct empl_num from salesreps where sales < (0.8 * quota) 
) 

----------------------------------------------------------- 
3.3删除数据Delete 
语法1:delete from <tablename> [where ...] 
代码: 
//所有删除记录 
delete from orders 

语法2:truncate table <tablename> 
代码2: 
//所有删除记录 
truncate table orders 

//按条件删除记录 
delete from orders where order_date < '01/01/2000' 

/**********************************************************/ 
4.数据定义DATA DEFINE LANGUAGE 
4.1表Table 
4.2列Column 
4.3序列Indentity 
4.4约束Constraints 
4.5索引Index 
4.6视图view 
4.7权限Privilege 
/**********************************************************/ 
4.1表Table 
4.1.1.建立表 
语法: 
create table <表名>( 
<列名> <数据类型> [长度] <,> 
<列名...> 
) 

代码: 
//建立公司部门表 
create table tb_basic_dept( 
id int not null, 
name varchar(20) , 
chair varchar(20) 
) 

4.1.2.删除表 
语法: 
drop table <表名> 
代码: 
//删除部门表 
drop table tb_basic_dept 
----------------------------------------------------------- 
4.2列Column 
4.2.1.列添加 
语法: 
alter table <表名> add 
<列名> <数据类型> [长度] <,> 
<列名...> 

代码: 
alter table tb_basic_dept add 
remark varchar(50) 
4.2.2.列删除 
语法:alter table <表名> drop column <列名> 
代码: 
alter table tb_basic_dept drop column remark 

4.2.3.列修改 
语法:alter table <表名> alter column 
<列名> <数据类型> [长度] [null | not null] 

代码: 
//修改工资列为dec(8,2) 
alter table tb_hr_gz alter column gz dec(8,2) null 
----------------------------------------------------------- 
4.3序列Identity 
//特别要求 
IDENTITY字段数据类型只能是(int, bigint, smallint, tinyint, decimal, or numeric(x,0)) 
IDENTITY字段必须是not null约束 

4.3.1Identity 
语法: 
IDENTITY(<data_type> [, <seed>, <increment>]) AS column_name, 

代码: 
//使用Identity 
CREATE TABLE MyTable ( 
key_col int NOT NULL IDENTITY (1,1), 
abc char(1) NOT NULL 
) 
INSERT INTO MyTable VALUES ('a') 
INSERT INTO MyTable VALUES ('b') 
INSERT INTO MyTable VALUES ('c') 

----------------------------------------------------------- 
4.4约束Constraints 
4.4.1缺省约束(default) 
4.4.2非空约束(not null) 
4.4.3规则约束(rule) 
4.4.4检查约束(check) 
4.4.5唯一约束(unique) 
4.4.6主键约束(primary key) 
4.4.7外键约束(foreign key) 
4.4.8商业规则(business rule) 

以下面两个表为例进行演示 
create table tb_hr_bm( 
bm varchar(20) not null , 
remark varchar(100) default '' 
) 
create table tb_hr_gz( 
id int not null, 
name varchar(30) not null, 
hrid char(18) null, 
workage int null , 
bm varchar(20) null, 
gz real null, 
remark varchar(100) null 
) 
hrid=身份证号码 
workage=工作年数 
gz=工资金额 
----------------------------------------------------------- 
4.4.1缺省约束(default) 
语法:CREATE DEFAULT default_name AS expression 
代码:CREATE DEFAULT zip_default AS 94710 
----------------------------------------------------------- 
4.4.2非空约束(not null) 
//表的主键和其它必填字段必须为not null. 
语法:create table (column-name datatype not null... ) 
代码:create table tb_hr_gz(id int not null,...) 
----------------------------------------------------------- 
4.4.3规则约束(rule) 
语法:CREATE RULE rulename AS condition 
代码: 
//邮编号码6位100000-999999 
//建立一个自定义zip类型 
CREATE TYPE zip FROM CHAR(6) NOT NULL 
//建立一个规则约束 
CREATE RULE zip_rule AS @number >100000 and @number < 999999 
//绑定规则约束到zip类型 
EXEC sp_bindrule zip_rule, 'zip' 
//应用自定义zip类型 
2> CREATE TABLE address( 
city CHAR(25) NOT NULL, 
zip_code ZIP, 
street CHAR(30) NULL 
) 

----------------------------------------------------------- 

4.4.4检查约束(建立/删除) 
//检查约束建立 
语法: 
alter table name 
add constraint <检查约束名> check<取值范围表达式> 

代码: 
//工资添加取值范围0 ~ 1000000 
方法1: 
create table tb_hr_gz( 
gz real default 0.0 check(gz >=0 and gz <=1000000), 
... 
) 
方法2: 
alter table tb_hr_gz 
add constraint tb_hr_gz_ck check(gz >=0 and gz <=1000000) 

//检查约束删除 
语法: 
alter table name drop constraint <检查约束名> 
代码: 
//删除工资的检查约束 
alter table tb_hr_gz drop constraint tb_hr_gz_ck 
----------------------------------------------------------- 
4.4.5唯一约束 
4.4.5.1.唯一约束添加 
语法: 
alter table name add constraint <唯一约束名> unique<列名> 
代码: 
//列如身份证号码是唯一的! 
alter table tb_hr_gz Add constraint tb_hr_gz_uk unique(hrid) 

4.4.5.2.唯一约束删除 
语法: 
alter table name drop constraint <唯一约束名> 
代码: 
alter table tb_hr_gz drop constraint tb_hr_gz_uk 

----------------------------------------------------------- 
4.4.6主键约束 
4.4.6.1主键约束添加 
语法: 
alter table table_name 
add constraint <主键名称> Primary Key <列名> 
代码: 
create table tb_hr_bm( 
bm varchar(20) not null , 
remark varchar(100) default '' 
) 
alter table tb_hr_bm 
add constraint tb_hr_bm_pk Primary Key (bm) 

4.4.6.2主键约束删除 
语法: 
alter table table_name 
drop constraint <主键名称> 
代码: 
alter table table_name 
drop constraint tb_hr_bm_pk 

----------------------------------------------------------- 
4.4.7外键约束 
4.4.7.1外键约束添加 
语法: 
alter table <表名> 
add constraint <外键名> 
foreign key(列名) 
references <参考表名><列名> 
<ON UPDATE|ON DELETE(RESTRICT|CASCADE|SET NULL|SET DEFAULT)> 

//补充说明 
常用选项是下面3项: 
ON UPDATE SET NULL //级联更新 
ON DELETE CASCADE //级联删除 
ON DELETE SET NULL //级联置空 

ON UPDATE(RESTRICT|CASCADE|SET NULL|SET DEFAULT) 表示父表更新后,子表的行为 
ON DELETE(RESTRICT|CASCADE|SET NULL|SET DEFAULT) 表示父表删除后,子表的行为 
RESTRICT 限制功能:父表一行记录不能更新/删除，当子表有一条记录以上时 
CASCADE 级联功能:父表一行记录记录更新/删除删除,子表对应所有的记录自动更新/删除 
SET NULL 置空功能:父表一行记录记录更新/删除删除,子表对应所有的记录自动为空 
SET DEFAULT 默认值功能:父表一行记录记录更新/删除删除,子表对应所有的记录自动写入默认值 


代码: 
建立外键的主要代码 
alter table tb_hr_personl_info 
add constraint tb_hr_personl_info__bm_fk 
foreign key(bm) 
references tb_hr_bm (bm) 
on update cascade 
on delete cascade 


//建立参考表部门 
create table tb_hr_bm 
( 
bm varchar(20) not null , 
remark varchar(100) default '' 
) 
alter table tb_hr_bm 
add constraint tb_hr_bm_pk Primary Key (bm) 
//建立个人信息表 
use hr 
create table tb_hr_personl_info 
( 
userid int not null , 
username varchar(20) null, 
bm varchar(20) null 
) 
/*为此表添加主键约束*/ 
alter table tb_hr_personl_info 
add constraint tb_hr_personl_info_pk Primary Key (userid) 
/*为个人信息表添加外键约束*/ 
alter table tb_hr_personl_info 
add constraint tb_hr_personl_info__bm_fk 
foreign key(bm) 
references tb_hr_bm (bm) 
on update cascade 
on delete cascade 
----------------------------------------------------------- 

4.4.7.2外键约束删除 
语法: 
alter table <表名> 
drop constraint <外键名> 
代码: 
//删除tb_hr_personl_info表的外键 
alter table tb_hr_personl_info drop constraint tb_hr_personl_info__bm_fk; 
----------------------------------------------------------- 
4.4.8商业规则(business rule) 
//用触发器或者存储过程来实现 

----------------------------------------------------------- 
4.5索引Index 
//4.5.1建立索引 
语法: 
create index <索引名> 
on <表名> <列名清表> 
代码: 
create index tb_hr_personl_info_ix 
on tb_hr_personl_info (userid) 

//4.5.2删除索引 
语法: 
drop index <表名><.><索引名> 
代码: 
//删除索引名tb_hr_personl_info_ix 
drop index tb_hr_personl_info.tb_hr_personl_info_ix 
----------------------------------------------------------- 
4.6视图view 
4.6.1视图view的概念： 
视图不是表，也不是表数据的备份，在数据库模式中只是select语句的集合! 

----------------------------------------------------------- 
4.6.2建立视图Create View 
语法: 
CREATE VIEW <view name> 
AS 
<SELECT statement> 
WITH CHECK OPTION 

代码: 
CREATE VIEW vw_customerlist 
AS 
SELECT * 
FROM Customers 
----------------------------------------------------------- 
4.6.3查询视图Query view 
语法:select * from viewname 
代码:select * from vw_customerlist 
----------------------------------------------------------- 
4.6.4修改视图ALTER VIEW 
语法:select * from viewname 
代码:select * from vw_customerlist 
----------------------------------------------------------- 
4.6.5视图删除DROP VIEW 
//4.6.2视图删除 
语法: 
drop view <视图名> 
代码: 
//视图删除v_hr_personl_info 
drop view v_hr_personl_info 

----------------------------------------------------------- 
4.6.6.过滤视图Filter view 
语法: 
select * from viewname where/having expressions 
代码: 
CREATE VIEW BankersMin 
AS 
SELECT BankerName, BankerState 
FROM Bankers 
where BankerID < 5 

SELECT * FROM BankersMin 
WHERE BankerState = 'CA' 
ORDER BY BankerName 

----------------------------------------------------------- 
4.6.7.可更新的视图Updatable View 
语法: 
CREATE VIEW <view name> 
AS 
SELECT statement 
WITH CHECK OPTION 
代码: 
CREATE VIEW OregonShippers_vw 
AS 
SELECT ShipperID, 
CompanyName, 
Phone 
FROM Shippers 
WITH CHECK OPTION 

//此视图的记录可以进行delete/update/insert 
insert into <view name> values(values....) 
delete from <view name> where/having expressions 
update <view name> set column =values... where/having expressions 

----------------------------------------------------------- 
4.7权限Privilege 
4.7.1数据库用户添加 
语法: 
sp_addlogin [ @loginame = ] 'login' 
[ , [ @passwd = ] 'password' ] 
[ , [ @defdb = ] 'database' ] 
[ , [ @deflanguage = ] 'language' ] 
[ , [ @sid = ] sid ] 
[ , [ @encryptopt= ] 'encryption_option' ] 

代码: 
数据库testdb上面添加一个登陆用户test,密码为tt 
EXEC sp_addlogin 'test', 'tt', 'testdb', 'us_english' 
EXEC sp_addlogin 'yao', 'it', 'mtyjxc', 'us_english' 
----------------------------------------------------------- 
4.7.2数据库用户删除 
语法:DROP LOGIN <登陆名称> 
代码:DROP LOGIN test 

----------------------------------------------------------- 
4.7.3用户权限授予grant 
grant语法: 
GRANT privilege [, ...] ON object [, ...] 
TO { PUBLIC | GROUP group | username } 

privilege取值范围如下: 
SELECT:访问声明的表/视图的所有列/字段． 
INSERT:向声明的表中插入所有列字段． 
UPDATE:更新声明的表所有列/字段． 
DELETE:从声明的表中删除所有行． 
RULE:在表/视图上定义规则 （参见 CREATE RULE 语句）． 
ALL:赋予所有权限． 

object取值范围如下: 
table 
view 
sequence 

PUBLIC:代表是所有用户的简写. 
GROUP:将要赋予权限的组 group 
username:将要赋予权限的用户名． 
如果成功，返回输出CHANGE信息． 
代码: 
GRANT all on mtyjxc to 'yao' 

----------------------------------------------------------- 
7.7.4用户权限解除REVOKE 
REVOKE { ALL | statement [ ,...n ] } 
FROM security_account [ ,...n ] 
ALL: 
指定将删除所有适用的权限。 
对于语句权限，只有 sysadmin 固定服务器角色成员可以使用 ALL。 
对于对象权限，sysadmin 固定服务器角色成员、db_owne 固定数据库角色成员和数据库对象所有者都可以使用 ALL。 
statement: 
是要删除其权限的授权语句。语句列表可以包括: 
* CREATE DATABASE 
* CREATE DEFAULT 
* CREATE FUNCTION 
* CREATE PROCEDURE 
* CREATE RULE 
* CREATE TABLE 
* CREATE VIEW 
* BACKUP DATABASE 
* BACKUP LOG 

FROM: 
指定安全帐户列表。 
security_account: 
是当前数据库内将要被删除权限的安全帐户。 
安全帐户可以是:SQL Server用户,SQL Server角色。 
代码: 
REVOKE all ON mtyjxc.* TO yao 
REVOKE all ON mtyjxc TO yao 

/**********************************************************/ 
5.数据库函数Functions 
5.1转换函数Data Convert Functions 
5.2聚集函数Aggregate Functions 
5.3字符函数char Functions 
5.4日期函数Date Functions 
5.5数学函数Math Functions 
5.6分析函数Analytical Functions 
----------------------------------------------------------- 
5.1转换函数Data Convert Functions 
5.1.1 CAST() 
功能:数据类型转换 
语法:CAST(expression AS data_type) 
代码: 
SELECT BillingDate, 
BillingTotal, 
CAST(BillingDate AS varchar) AS varcharDate, 
CAST(BillingTotal AS int) AS integerTotal, 
CAST(BillingTotal AS varchar) AS varcharTotal 
FROM Billings 
----------------------------------------------------------- 
5.1.2 COALESCE() 
功能:返回表达式列表中第一个非空值表达式的值 
语法:COALESCE(expression1, expression2, ... expressionN) 
代码: 
SELECT BankerName, 
COALESCE(CAST(BillingTotal AS varchar), 'No Billings') AS BillingTotal 
FROM Bankers LEFT JOIN Billings 
ON Bankers.BankerID = Billings.BankerID 
ORDER BY BankerName 

----------------------------------------------------------- 
5.1.3 CONVERT() 
功能:把表达式值转换为指定sytle的数据类型 
语法:CONVERT(data_ type(<length>), expression, <style>) 
代码: 
//日期风格转换 
datetime转指定日期格式style number清单 
Number Style Number Output Type Style 
- 0 or 100 Default mon dd yyyy hh:miAM (or PM) 
1 101 USA mm/dd/yyyy 
2 102 ANSI yyyy.mm.dd 
3 103 British/French dd/mm/yyyy 
4 104 German dd.mm.yyyy 
5 105 Italian dd-mm-yyyy 
6 106 - dd mon yyyy 
7 107 - mon dd, yyyy 
10 110 USA mm-dd-yy 
11 111 JAPAN yy/mm/dd 
12 112 ISO yymmdd 
14 114 - hh:mi:ss:mmm (24h) 

//字符串转数字 
CONVERT (INTEGER , '12345') 
//字符转日期 
CONVERT(datetime, '20000704') 

CREATE TABLE my_date (Col1 datetime) 
GO 
INSERT INTO my_date VALUES (CONVERT(char(10), GETDATE(), 112)) 
GO 
drop table my_date; 
GO 

----------------------------------------------------------- 
5.1.4 ISNULL() 
功能:检查check_expression是空值，就用replacement_value替代 
语法:ISNULL(check_expression, replacement_value) 

代码: 
SELECT BillingDate, 
ISNULL(BillingDate, '1900-01-01') AS NewDate 
FROM Billings 

----------------------------------------------------------- 
5.1.5 NULLIF() 
功能:两个表达式相等，返回null,否则返回第1个表达式 
语法:ISNULL(expression1, expression2) 

代码: 
DECLARE @Value1 int 
DECLARE @Value2 int 
SET @Value1 = 55 
SET @Value2 = 955 
SELECT NULLIF(@Value1, @Value2) 
GO 
输出 
55 
DECLARE @Value1 int 
DECLARE @Value2 int 
SET @Value1 = 55 
SET @Value2 = 55 
SELECT NULLIF(@Value1, @Value2) 
GO 
输出 
NULL 

----------------------------------------------------------- 
5.2聚集函数Aggregate Functions 
语法:select AggregateFunctions(column-name) 
sum(column-name):计算字段总和 
avg(column-name):计算字段平均值 
min(column-name):计算字段最小值 
max(column-name):计算字段最大值 
count(column-name):计算字段非空值的个数 
count(*):计算查询结果的记录个数 

代码: 
//use pubs 
select sum(qty) as sum_qty, 
avg(qty) as avg_qty, 
min(qty) as min_qty, 
max(qty) as max_qty, 
count(qty) as count_qty, 
count(*) as total_qty 
from sales 

----------------------------------------------------------- 
5.3字符函数char Functions 
1. ASCII() 
//函数返回字符表达式最左端字符的ASCII 码值 
2. Char() 
//函数用于将ASCII 码转换为字符--如果没有输入0 ~ 255 之间的ASCII 码值CHAR 函数会返回一个NULL 
3. CHARINDEX() 
//函数返回字符串中某个指定的子串出现的开始位置 
4. DIFFERENCE() 
5. FORMATMESSAGE() 
6. LEFT() 
7. LEN() 
8. LOWER() 
//函数把字符串全部转换为小写 
9. LTRIM() 
//函数把字符串头部的空格去掉 
10.nchar() 
11.PATINDEX() 
12.QUOTENAME() 
13.REPLACE() 
//函数返回被替换了指定子串的字符串 
14.REPLICATE() 
/函数返回一个重复指定次数的字符串 
15.REVERSE() 
//函数将指定的字符串的字符排列顺序颠倒 
16.Right() 
17.RTRIM() 
/函数把字符串尾部的空格去掉 
18.SOUNDEX() 
19.SPACE() 
//函数返回一个有指定长度的空白字符串 
20.STR() 
//函数把数值型数据转换为字符型数据 
21.STUFF() 
//函数用另一子串替换字符串指定位置长度的子串 
22.SUBSTRING() 
//函数返回子字符串 
23.UNICODE() 
24.UPPER() 
//函数把字符串全部转换为大写 

----------------------------------------------------------- 

5.4日期函数Date Functions 
5.4.1. CURRENT_TIMESTAMP 
功能: 
得到当前数据库的日期 
代码: 
//直接得到当前日期 
SELECT CURRENT_TIMESTAMP 
go 

//调用变量中的当前日期 
DECLARE @today datetime 
SELECT @today = current_timestamp 
select @today 
go 
----------------------------------------------------------- 
5.4.2. 日期计算Date calculation 
功能:日期计算 
代码: 
DECLARE @MonthChar VarChar(2), @DayChar VarChar(2), @DateOut Char(8) 
SET @MonthChar = CAST(MONTH(GETDATE()) AS VarChar(2)) 
SET @DayChar = CAST(DAY(GETDATE()) AS VarChar(2)) 
--自动补齐月份到2位 
IF LEN(@MonthChar) = 1 
SET @MonthChar = '0'+@MonthChar 
IF LEN(@DayChar) = 1 
SET @DayChar = '0' + @DayChar 
--生成日期字符串 
SET @DateOut = @MonthChar + @DayChar + CAST(YEAR(GETDATE()) AS Char(4)) 
SELECT @DateOut 
GO 
运行结果是mmddyyyy格式的字符串 
----------------------------------------------------------- 
5.4.3. DATEADD() 
功能:日期相加或者相减n天后的日期 
语法:DATEADD(what_to_add,number_to_add,date_to_add_it_to) 
代码: 
//4-29-2009加90天，保存到day 
SELECT DATEADD(DY, 90,'4-29-2009') 
GO 
//4-29-2009减60天，保存到day 
SELECT DATEADD(DY, -60,'4-29-2009') 
GO 
----------------------------------------------------------- 
5.4.4. DATEDIFF() 
功能:日期相加或者相减n天后的日期 
语法:DATEDIFF ( datepart , startdate , enddate ) 
datepart列表: 
day:单位=天 
month:单位=月 
year:单位=年 
hour:单位=小时 
minute:单位=分 
second:单位=秒 
week:单位=周 
代码: 
//10/01/2009国庆到今天的天数 
SELECT DATEDIFF(day,'10/1/2009',CURRENT_TIMESTAMP) 
GO 
//10/01/2009国庆到今天的月数 
SELECT DATEDIFF(month,'10/1/2009',CURRENT_TIMESTAMP) 
GO 
//10/01/2009国庆到今天的年数 
SELECT DATEDIFF(year,'10/1/2009',CURRENT_TIMESTAMP) 
GO 
//10/01/2009国庆到今天的周数 
SELECT DATEDIFF(week,'10/1/2009',CURRENT_TIMESTAMP) 
GO 

----------------------------------------------------------- 
5.4.5. DATEFIRST() 
功能:设置或者查询一周的第一天 
SELECT @@DATEFIRST 'First Day of the Week' 
GO 
value is 7 
SELECT DATEPART(weekday, CAST('20091001' AS DATETIME) + @@DATEFIRST); 
GO 
value is 3 
----------------------------------------------------------- 
6. DATEFORMAT() 
功能:设置日期格式 
语法:SET DATEFORMAT <format> 
format(ymd,mdy,dmy) 
代码:set dataformat mdy 
----------------------------------------------------------- 
7. DATENAME() 
功能:日期date按datepart风格之后变成字符串 
语法:DATENAME (datepart,date) 
datepart列表(day,month,year,hour,minute,second,week,weekday) 
代码: 
select datename(day,CURRENT_TIMESTAMP) 
select datename(month,CURRENT_TIMESTAMP) 
select datename(year,CURRENT_TIMESTAMP) 
select datename(hour,CURRENT_TIMESTAMP) 
select datename(minute,CURRENT_TIMESTAMP) 
select datename(week,CURRENT_TIMESTAMP) 
select datename(weekday,CURRENT_TIMESTAMP) 
----------------------------------------------------------- 
8. DATEPART() 
功能:日期date按datepart风格之后变成字符串 
语法:DATENAME (datepart,date) 
datepart列表(day,month,year,hour,minute,second,week,weekday) 
代码: 
----------------------------------------------------------- 
9. Day() 
功能:求日期的天 
语法:day(date) 
代码:select day(CURRENT_TIMESTAMP) 
----------------------------------------------------------- 
10. GETDATE() 
功能:求当前日期和时间 
语法:GETDATE() 
代码:select GETDATE() 和select CURRENT_TIMESTAMP相同 
----------------------------------------------------------- 
11. GETUTCDATE() 

----------------------------------------------------------- 
12. ISDATE() 

----------------------------------------------------------- 
13. MONTH() 
功能:求日期的月 
语法:MONTH(date) 
代码:select month(CURRENT_TIMESTAMP) 
----------------------------------------------------------- 
14. Year() 
功能:求日期的年 
语法:Year(date) 
代码:select Year(CURRENT_TIMESTAMP) 
----------------------------------------------------------- 
5.5数学函数Math Functions 
1. ABS() 
2. ACOS() 
3. ASIN() 
4. ATAN() 
5. CEILING() 
6. COS() 
7. COT() 
8. DEGREES() 
9. EXP() 
10. FLOOR() 
11. ISNUMERIC() 
12. LOG() 
13. LOG10() 
14. PI() 
15. Power() 
16. RADIANS() 
11. 17. RAND() 
18. ROUND() 
19. SIGN() 
20. Sin() 
21. SQRT() 
22. SQUARE() 
23. TAN() 
----------------------------------------------------------- 
5.6分析函数Analytical Functions 
1. COMPUTE() 
2. CUBE() 
3. DENSE_RANK() 
4. GROUPING() 
5. NTILE() 
6. PARTITION() 
7. PIVOT() 
8. ROLLUP() 
9. ROW_NUMBER() 
10. STDEV() 
11. STDEVP() 
12. VAR() 
13. VARP() 
/**********************************************************/ 
6.Transact SQL 
6.1数据类型Data Types 
6.2脚本语法sytanx 
6.3脚本游标Cursor 
6.4存储过程Procedure 
6.5存储函数Function 
6.6触发器Trigger 
6.7事务Transaction 
6.8其它other 
/**********************************************************/ 
6.1数据类型Data Types 
1. bigint 
2. bit 
3. bitwise operators 
4. Char 
5. collate 
6. Create Type 
7. Data type 
8. Date Type 
9. datetime 
10. decimal 
11. Float 
12. FULLTEXT 
13. integer 
14. Large Text 
15. money 
16. nchar 
17. nVarChar 
18. OPENROWSET 
19. READTEXT 
20. smalldatetime 
21. Smallint 
22. SQL_VARIANT 
23. text 
24. TEXTPTR 
25. timestamp 
26. VARBINARY 
27. VARCHAR 
28. WRITETEXT 
29. Unicode 

----------------------------------------------------------- 
6.2脚本语法syntax 

6.2.0局部/全局变量定义 
局部变量 (以@开头) 
格式:declare @变量名 数据类型 
代码:declare @x int 

全局变量 (必须以@@开头) 
格式:declare @@变量名 类型 
代码:select @@id = '10010001' 

6.2.1块语句 
格式: 
begin 
... 
end 
----------------------------------------------------------- 
6.2.2赋值语句set/select 
set @id = '10010001' 
select @id = '10010001' 

6.2.3条件语句(if/case) 
6.2.3.1 if语句 
declare @x int @y int @z int 
select @x = 1 @y = 2 @z=3 
if @x > @y 
print 'x > y' --打印字符串'x > y' 
else if @y > @z 
print 'y > z' 
else print 'z > y' 

6.2.3.2 CASE语句 
--CASE 
复制代码 代码如下:
use pangu 
update employee 
set e_wage = 
case 
when job_level = '1' then e_wage*1.08 
when job_level = '2' then e_wage*1.07 
when job_level = '3' then e_wage*1.06 
else 
e_wage*1.05 
end 

6.2.4循环语句(while) 
--WHILE 
复制代码 代码如下:
declare @x int @y int @c int 
select @x = 1 @y=1 
while @x < 3 
begin 
print @x --打印变量x 的值 
while @y < 3 
begin 
select @c = 100*@x + @y 
print @c --打印变量c 的值 
select @y = @y + 1 
end 
select @x = @x + 1 
select @y = 1 
end 

6.2.5定时执行(waitfor) 

--WAITFOR 
--例 等待1 小时2 分零3 秒后才执行SELECT 语句 
waitfor delay '01:02:03' 
select * from employee 
--例 等到晚上11 点零8 分后才执行SELECT 语句 
waitfor time '23:08:00' 
select * from employee 

----------------------------------------------------------- 
6.3脚本游标Cursor 
//游标应用顺序 
1.DECLARE --为查询设定游标 
2.OPEN --检索查询结果打开一个游标 
3.FETCH --检索一行查询结果 
4.CLOSE / DEALLOCATE--关闭游标或者重新分配游标 

语法: 
DECLARE <游标名称> CURSOR FOR(select sql) 
OPEN <游标名称> 
while @@fetch_status = 0 
begin 
FETCH NEXT FROM <游标名称> INTO <变量名清单> 
{其它代码处理} 
end 
CLOSE <游标名称> 

代码1: 
复制代码 代码如下:
/*带游标的存储过程*/ 
create procedure p_fill_remark_tb_hr_gz 
as 
declare @id1 int 
declare @name1 varchar(30) 
declare @bm1 varchar(20) 

begin 
declare cursor1 cursor for select id,name,bm from tb_hr_gz 
open cursor1 
fetch next from cursor1 into @id1,@name1,@bm1 

while @@fetch_status <> 0 
begin 
update tb_hr_gz set remark=@name1+'-'+@bm1 where id=@id1 
fetch next from cursor1 into @id1,@name1,@bm1 
end 
close cursor1 
end 

//测试带游标的存储过程 
EXEC dbo.p_fill_remark_tb_hr_gz 

----------------------------------------------------------- 
6.4存储过程Procedure 



//存储过程建立 
语法: 
create procedure <存储过程名>( 
[输入参数列表],[返回参数列表 output] 
) 
as 
[局部变量定义] 
begin 
{语句体} 
end 

代码: 
create procedure p_update_name_tb_hr_gz(@id int,@newname varchar(30)) 
as 
begin 
if (exists(select * from tb_hr_gz where id=@id)) 
begin 
update tb_hr_gz set name=@newname where id=@id 
end 
end 

//测试 
EXEC dbo.p_update_name_tb_hr_gz '112','chenglei' 

//存储过程删除 
语法: 
drop procedure <存储过程名> 
代码: 
drop procedure p_update_name_tb_hr_gz 

----------------------------------------------------------- 
6.5存储函数Function 

//存储函数建立 
语法: 
CREATE FUNCTION <函数名>(参数变量列表) 
[返回值RETURNS 数据类型] [WITH ENCRYPTION] 
AS 
BEGIN 
{函数代码体....} 

END 

代码: 
复制代码 代码如下:
//函数f_amt_to_eng()功能:数字金额转换为英文字母金额 
CREATE FUNCTION f_amt_to_eng(@num numeric(15,2)) 
RETURNS varchar(400) WITH ENCRYPTION 
AS 
BEGIN 

DECLARE @i int,@hundreds int,@tenth int,@one int 
DECLARE @thousand int,@million int,@billion int 
DECLARE @numbers varchar(400),@s varchar(15),@result varchar(400) 
SET @numbers='one two three four five ' 
+'six seven eight nine ten ' 
+'eleven twelve thirteen fourteen fifteen ' 
+'sixteen seventeen eighteen nineteen ' 
+'twenty thirty forty fifty ' 
+'sixty seventy eighty ninety ' 
SET @s=RIGHT('000000000000000'+CAST(@num AS varchar(15)),15) 
SET @billion=CAST(SUBSTRING(@s,1,3) AS int)--将12位整数分成4段:十亿、百万、千、百十个 
SET @million=CAST(SUBSTRING(@s,4,3) AS int) 
SET @thousand=CAST(SUBSTRING(@s,7,3) AS int) 
SET @result='' 
SET @i=0 
WHILE @i<=3 
BEGIN 
SET @hundreds=CAST(SUBSTRING(@s,@i*3+1,1) AS int)--百位0-9 
SET @tenth=CAST(SUBSTRING(@s,@i*3+2,1) AS int) 
SET @one=(CASE @tenth WHEN 1 THEN 10 ELSE 0 END)+CAST(SUBSTRING(@s,@i*3+3,1) AS int)--个位0-19 
SET @tenth=(CASE WHEN @tenth<=1 THEN 0 ELSE @tenth END)--十位0、2-9 
IF (@i=1 and @billion>0 and (@million>0 or @thousand>0 or @hundreds>0)) or 
(@i=2 and (@billion>0 or @million>0) and (@thousand>0 or @hundreds>0)) or 
(@i=3 and (@billion>0 or @million>0 or @thousand>0) and (@hundreds>0)) 
SET @result=@result+', '--百位不是0则每段之间加连接符, 
IF (@i=3 and (@billion>0 or @million>0 or @thousand>0) and (@hundreds=0 and (@tenth>0 or @one>0))) 
SET @result=@result+' and '--百位是0则加连接符AND 
IF @hundreds>0 
SET @result=@result+RTRIM(SUBSTRING(@numbers,@hundreds*10-9,10))+' hundred' 
IF @tenth>=2 and @tenth<=9 
BEGIN 
IF @hundreds>0 
SET @result=@result+' and ' 
SET @result=@result+RTRIM(SUBSTRING(@numbers,@tenth*10+171,10)) 
END 
IF @one>=1 and @one<=19 
BEGIN 
IF @tenth>0 
SET @result=@result+'-' 
ELSE 
IF @hundreds>0 
SET @result=@result+' and ' 
SET @result=@result+RTRIM(SUBSTRING(@numbers,@one*10-9,10)) 
END 
IF @i=0 and @billion>0 
SET @result=@result+' billion' 
IF @i=1 and @million>0 
SET @result=@result+' million' 
IF @i=2 and @thousand>0 
SET @result=@result+' thousand' 
SET @i=@i+1 
END 
IF SUBSTRING(@s,14,2)<>'00' 
BEGIN 
SET @result=@result+' AND ' 
IF SUBSTRING(@s,14,1)='0' 
SET @result=@result+'zero' 
ELSE 
SET @result=@result+RTRIM(SUBSTRING(@numbers,CAST(SUBSTRING(@s,14,1) AS int)*10-9,10)) 
IF SUBSTRING(@s,15,1)<>'0' 
SET @result=@result+' '+RTRIM(SUBSTRING(@numbers,CAST(SUBSTRING(@s,15,1) AS int)*10-9,10)) 
END 
RETURN(@result) 
END 


复制代码 代码如下:
CREATE FUNCTION f_amt_to_chn (@num numeric(14,2)) 
RETURNS varchar(100) WITH ENCRYPTION 
AS 
BEGIN 
DECLARE @n_data VARCHAR(20),@c_data VARCHAR(100),@n_str VARCHAR(10),@i int 
SET @n_data=RIGHT(SPACE(14)+CAST(CAST(ABS(@num*100) AS bigint) AS varchar(20)),14) 
SET @c_data='' 
SET @i=1 
WHILE @i<=14 
BEGIN 
SET @n_str=SUBSTRING(@n_data,@i,1) 
IF @n_str<>' ' 
BEGIN 
IF not ((SUBSTRING(@n_data,@i,2)='00') or ((@n_str='0') and ((@i=4) or (@i=8) or (@i=12) or (@i=14)))) 
SET @c_data=@c_data+SUBSTRING('零壹贰叁肆伍陆柒捌玖',CAST(@n_str AS int)+1,1) 
IF not ((@n_str='0') and (@i<>4) and (@i<>8) and (@i<>12)) 
SET @c_data=@c_data+SUBSTRING('仟佰拾亿仟佰拾万仟佰拾元角分',@i,1) 
IF SUBSTRING(@c_data,LEN(@c_data)-1,2)='亿万' 
SET @c_data=SUBSTRING(@c_data,1,LEN(@c_data)-1) 
END 
SET @i=@i+1 

END 

IF @num<0 
SET @c_data='负'+@c_data 

IF @num=0 
SET @c_data='零元' 

IF @n_str='0' 
SET @c_data=@c_data+'整' 

RETURN(@c_data) 

END 


//测试函数 
select name, gz,dbo.f_amt_to_chn(gz) as 中文金额,dbo.f_amt_to_eng(gz) as 英文金额 from tb_hr_gz 

//删除函数 
语法: 
drop function <函数名称> 

代码: 
drop function f_num_to_eng 
----------------------------------------------------------- 
6.6触发器Trigger 

22. 1. Trigger( 14 ) 22. 10. Trigger order( 2 ) 
22. 2. Alter Trigger( 4 ) 22. 11. Drop trigger( 2 ) 
22. 3. Trigger for after( 4 ) 22. 12. COLUMNS_UPDATED( 1 ) 
22. 4. Trigger for Delete( 4 ) 22. 13. Update function( 3 ) 
22. 5. Trigger for insert( 1 ) 22. 14. Deleted table( 2 ) 
22. 6. Trigger for update( 4 ) 22. 15. Inserted table( 5 ) 
22. 7. Trigger on database( 2 ) 22. 16. RECURSIVE_TRIGGERS( 1 ) 
22. 8. Trigger on server( 1 ) 22. 17. Utility trigger( 4 ) 
22. 9. Trigger on view( 3 ) 



//触发器建立 
语法: 
create trigger <触发器名称> on <表名> 
[for insert | update | delete] 
as 
[定义变量] 
begin 
{代码块...} 
end 

代码0: 
复制代码 代码如下:
create trigger tg_tb_hr_bm on tb_hr_bm 
for insert,update,delete 
as 
declare @bm_d varchar(20) 
declare @bm_i varchar(20) 
begin 
set @bm_d=(select bm from deleted) 
set @bm_i=(select bm from inserted) 
if exists(select * from tb_hr_gz ,deleted where(tb_hr_gz.bm =deleted.bm )) 
begin 
update tb_hr_gz set bm='' where bm =@bm_d 
end 

if update(bm) 
begin 
update tb_hr_gz set bm=@bm_i where bm =@bm_i 
end 
end 

//删除触发器 
语法: 
drop trigger <触发器名称> 
代码: 
drop trigger tg_w_house_center 
----------------------------------------------------------- 
6.7事务Transaction 
事务(COMMIT/ROLLBACK) 
SET TRANSACTION --定义当前事务数据访问特征 
COMMIT --提交当前事务 
ROLLBACK --取消当前事务 Tags：MSSQL 常用代码 
 /*
 最 近 更 新
sqlserver 千万数量级分页存储过程代码SQLServer 全文检索(full-text)语法删除Table表中的重复行的方法SQL学习笔记七函数 数字，日期，类型转换将Sql Server对象的当前拥有者更改成目标在查询结果中添加一列表示记录的行数的sqSQL查找某一条记录的方法sql 批量修改数据库表SQL 合并多行记录的方法总汇sql中返回参数的值热 点 排 行
SQL Server 2008图文安装教程SQL命令大全-中英文对照SQL语句去掉重复记录，获取重复记sql语句优化之用EXISTS替代IN、用非常不错的SQL语句学习手册实例版SQLServer2005 按照日期自动备份SQL语句技巧:按月统计数据sql convert函数使用小结搜索sql语句有用的SQL语句（删除重复记录，收
Js与CSS工具
CSS在线压缩格式化(中文) css 格式化整理工具(英文) CSS整形格式化 JavaScript 格式化整理工具 jsbeautifier Js格式化整理工具(英文) php 格式化整理工具(英文) HTML/JS互相转换工具 javascript pack加密压缩工具 JS Minifier压缩 JS混淆工具 在线JS脚本校验器错误 JavaScript 正则表达式在线测试工具 代码转换工具
Base64编码加密 Escape加解密 HTML/UBB代码转换 GB2312/BIG5繁简字转换 经典小工具集 数字转换 HTML多功能代码转换器 迅雷快车加/解密 汉字转换拼音 

 */
 