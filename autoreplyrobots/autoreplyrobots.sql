DROP DATABASE IF EXISTS `mybatis_autoreplyrobots`;
CREATE DATABASE `mybatis_autoreplyrobots` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mybatis_autoreplyrobots`;

#
# Source for table message
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `command` varchar(16) DEFAULT NULL comment '指令',
  `description` varchar(32) DEFAULT NULL comment '描述',
  `content` varchar(2048) DEFAULT NULL comment '内容',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into message values(1,'a','a desc','a content');
insert into message values(2,'b','b desc','b content');
insert into message values(3,'c','c desc','c content');
insert into message values(4,'d','d desc','d content');
insert into message values(5,'e','e desc','e content');
insert into message values(6,'f','f desc','f content');
insert into message values(7,'g','g desc','g content');
insert into message values(8,'h','h desc','h content');
insert into message values(9,'i','i desc','i content');
insert into message values(10,'j','j desc','j content');
insert into message values(11,'k','k desc','k content');
insert into message values(12,'l','l desc','l content');
insert into message values(13,'m','m desc','m content');
insert into message values(14,'n','n desc','n content');
insert into message values(15,'o','o desc','o content');
insert into message values(16,'p','p desc','p content');


#为了解决一个命令有多个对应内容的情况，将message表拆分为command表和content表

#
# Source for table name
#

DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(16) DEFAULT NULL comment '指令',
                         `description` varchar(32) DEFAULT NULL comment '描述',
                         PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into command values(1,'a','a desc');
insert into command values(2,'b','b desc');
insert into command values(3,'c','c desc');
insert into command values(4,'d','d desc');
insert into command values(5,'e','e desc');

#
# Source for table commandContent
#

DROP TABLE IF EXISTS `commandcontent`;
CREATE TABLE `commandcontent` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `content` varchar(2048) DEFAULT NULL comment '内容',
                         `command_id` int(11) NOT NULL,
                         PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
alter table commandcontent add constraint foreign key fk_command_id(command_id) references name(id);

insert into commandcontent values(1,'a1 content',1);
insert into commandcontent values(2,'a2 content',1);
insert into commandcontent values(3,'a3 content',1);

insert into commandcontent values(4,'b1 content',2);
insert into commandcontent values(5,'b2 content',2);
insert into commandcontent values(6,'b3 content',2);

insert into commandcontent values(7,'c1 content',3);
insert into commandcontent values(8,'c2 content',3);
insert into commandcontent values(9,'c3 content',3);

insert into commandcontent values(10,'d1 contentt',4);
insert into commandcontent values(11,'d2 contentt',4);
insert into commandcontent values(12,'d3 contentt',4);

insert into commandcontent values(13,'e1 contentt',5);
insert into commandcontent values(14,'e2 contentt',5);
insert into commandcontent values(15,'e3 contentt',5);