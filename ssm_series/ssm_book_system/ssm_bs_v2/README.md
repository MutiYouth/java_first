## 项目介绍
开发工具：intelliJ IDEA

项目相关：maven-3.39、jdk-8、github

相关框架：Spring-4.17、SpringMVC-4.17、Mybatis-3.30

数 据 库：mysql(存放数据)、redis(缓存)

模板引擎：thymeleaf


## 通过命令行导入数据库
1. 查看所有的数据库
```
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| employees          |
| mysql              |
| performance_schema |
| ssm                |
| sys                |
+--------------------+
6 rows in set (0.00 sec)
```

2. 如果不存在【booksystem】则创建
```
mysql> create database booksystem;
Query OK, 1 row affected (0.00 sec)
```
3. 选择数据库
```
mysql> use booksystem;
Database changed
```

4. 设置数据库编码
```
mysql> set names utf8;
Query OK, 0 rows affected (0.00 sec)
```

5. 导入数据库文件
```
mysql> source sql/booksystem.sql
```

6. 查看数据库拥有的表
```
mysql> show tables;
+----------------------+
| Tables_in_booksystem |
+----------------------+
| appointment          |
| book                 |
| user                 |
+----------------------+
3 rows in set (0.00 sec)
```

7. 完毕

## 开发过程中的感想
1. 目前aop没有具体的用处
2. AOP可以用的地方：参数校验，错误拦截，日志记录
3. 以后尽量少用jsp，不利于前后端分离（SOA：面向服务）
4. 为了安全尽量把bean分开。入参：form、出参：VO、DAO层：DTO
