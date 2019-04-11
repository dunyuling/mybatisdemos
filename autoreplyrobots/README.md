##Mybatis

##注意事项
    * 第三方jar包找不到的时候,需要在Artificts中的WEB-INF/lib目录下添加相应jar(对于IDEA)
    

##SqlSession
    + 作用
        * 向SQL语句传入参数
        * 执行SQL语句
        * 获取执行SQL语句的结果
        * 事务控制
        
        
    + 获取
        * 通过配置文件获取数据库连接相关信息
        * 通过配置信息构建SqlSessionFactory
        * 通过SqlSessionFactory打开数据库会话
        
        
## jdbc type 
    查看java.sql.Types  
    
    
##OGNL表达式 
    + 取值写法
        * 类型---> MyBatis中的OGNL表达式的写法
        * String与基本类型--->_parameter
        * 自定义类型(Message)--->属性名
        + 集合--->{数组:array,List:list,Map:_parameter}
            + 从集合中取出一条数据
                + 数组
                    * array[索引](基本类型)
                    * array[索引].属性名(自定义类型)
                + List    
                    * list[索引](基本类型)
                    * list[索引].属性名(自定义类型)
                + Map
                    * _paramete.key(基本类型)
                    * key.属性名(自定义类型)              
        
            + 遍历集合
                * <foreach collection="array" index="i" item="item">
                + 数组/List
                    * i:索引（下标）
                    * item(基本类型)              
                    * item.属性名(自定义类型)              
                + Map
                    * i:key
                    * item(基本类型)              
                    * item.属性名(自定义类型)
    + 操作符
        + java常用操作符：+,-,×,/,==,!=,||,&&等
        + 特有操作符：and,or,mod,in,not in等
        
## slf4j 调试动态 SQL
    + slf4j通过下面两个依赖的引入，使用log4j
        * org.slf4j:slf4j-api:version 
        * org.slf4j:slf4j-log4j12:version
    + slf4j屏蔽了底层具体的日志库(如log4j,apache common log)来使得应用变得简单
    
## jquery
    + jquery对于checkbox的操作
        $("#cb1").prop("checked",true); //标准写法，推荐！  
        $("#cb1").attr("checked",true); //不标准，不推荐了(实测不支持)
    
                                 
##标签
    + where
        * 不用再写where 1=1
        * 去掉多余and
    + 定义sql语句
        * insert                                        
        * delete                                        
        * update                                          
        * select   
    + 配置java对象属性与查询结果集中列名对应关系
        * resultMap
    + 控制动态SQL拼接
        * foreach                                             
        * if                                              
        * choose
    + 格式化输出
        + where
            * 不用再写where 1=1
            * 去掉多余and
        + set 
            * 去掉多余','号 
        * trim
    + 配置关联关系
        * collection
        * association
    + 定义常量
        * sql
    + 引用常量
        * include    
        
##容易混淆的概念
    + resultMap，resultType
        * resultMap可以让数据库中的列与pojo中的属性对应更加灵活
        * resultMap可以使用typeHandler进行类型转换
    + parameterType,parameterMap(不推荐)        
    + #{},${}
        * #{}有预编译效果
        * ${}无预编译效果，(order by)
    + #{},ognl     
    
##未完成
    + 一对多关联添加，修改，删除未完成
        * 难点在于如何把多次对于数据库的操作放在同一个事务之中
        
##总结
    通过本次学习只是对于mybatis有了一个基本的概念，还有很多东西没有掌握。虽然很多年前都已经
    用过了，但由于是在别人已有的基础上的应用，而自己并没有系统的进行学习，导致很多年后，重新
    应用时，困难重重。故每一项技术都要经过自己切实的理解原理，应用实践才能够真正得掌握。
                                                                        