# SpringBootMockServer

MockServer平台介绍
================================
## 1.	框架介绍
主要框架：
Springboot2.1.8
Mysql(请注意Mysql版本和connector的版本对应，否则会出错)
Mybatis
Layui
Jquery
因为有jacoco的功能，所以也有jacoco的源码，
整个工程通过多模块来实现统一打包。
## 4. 部署方式
假如下载到/home/admin/mock，此时目录下有诸多工程。
Org.jacoco开始的为jacoco源码相关；
mockserver为web端
在manager_platform下运行
mvn clean package -Dmavek.test.skip=true -Dmaven.javadoc.skip=true
此步骤为打包，后面两个参数设置为跳过测试和javadoc生成，因为有些jacoco工程生成javadoc会报错，所以以此忽略。

## 5. 设置数据库
目前引用数据库为mysql，数据库为autotest_platform_mockserver，登陆账号和密码自行设置,已经设置好允许远程连接。
如果自己要重新部署，则按照以下步骤
1.	安装mysql，或者直接找一台现成的，建一个新的库，记得设置好允许远程连接(此步骤请自行百度解决)
2.	到manager_platform\mockserver\src\main\resources下，找到application-product.properties
修改里面的数据库实例名称、登录用户名和密码
3.	后续步骤，按照后面的顺序即可
后端主要代码在mockserver工程中，
数据库初始化sql在：mockserver/src/main/resources/data/sql/data-mysql.sql
以此sql初始化即可，执行完之后，顺序执行update*.sql文件，按照日期先后执行。
如果是全新的数据库里面没有任何表结构，则可以直接执行data-mysql-full.sql里面的内容，执行此一个文件即可(未做测试，不保证成功哈)。
## 6. 关于配置文件

配置文件在以下目录中，使用的为properties文件，也可以转为相应的yml文件
mockserver/src/main/resources
激活的配置文件在application.properties 中默认是dev

## 7. 启动
日志的产生，跟运行命令的目录有关，
建议，cd到mockserver中运行

nohup java -jar target/mockserver-0.0.1.jar > log.file 2>&1 &

运行之后,不切换目录，运行
tail -200f log.file
等待日志中出现，Started **Application in 5.437 seconds (JVM running for 6.246)
如此内容，代表启动成功，默认端口为8029
稍后可以http://xxxx:8029访问

可以查看启动日志
另外每天的日志备份，和及时日志，在当前运行命令目录的上一层，也就是manager_platform下的logs中，因此运行：
cd ..
cd logs
ls
可以查看当前日志，最新的日志为springboot.log
   另外，跟logs同级的还有个my-tomcat目录，其下的logs文件夹下，存放了access日志，就是在网页中方位的url记录



