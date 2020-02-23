package com.shiningcity.main;
 
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
 
/**
 * Created by badado on 2019/4/25.
 */
public class MyBatisPlusGenerator1 {

    public static void main(String[] args) {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        //设置是否支持AR模式
        config.setActiveRecord(true)
            //设置生成代码的作者
            .setAuthor("ShiningCity")
            //设置输出代码的位置
            .setOutputDir("D:\\MyBatisPlusGenerator")
            .setEnableCache(false)// XML 二级缓存，不推荐使用二级缓存
            .setBaseResultMap(true)// XML ResultMap
            .setBaseColumnList(true)// XML columList
            //.setKotlin(true) 是否生成 kotlin 代码
            //设置是否覆盖原来的代码
            .setFileOverride(true)
            .setMapperName("%sMapper")
            .setXmlName("%sMapper")
            .setServiceName("%sService")
            .setServiceImplName("%sServiceImpl")
            .setControllerName("%sController");
            
        //******************************数据源配置***************************************
        //数据库连接url
        //String dbUrl = "jdbc:sqlserver://;DatabaseName=";
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库类型 枚举
        dataSourceConfig.setDbType(DbType.MYSQL)    //DbType.SQL_SERVER
            //设置url
            //.setUrl("jdbc:mysql://localhost:3306/youfan_shop?useUnicode=true&amp;characterEncoding=utf8")
            .setUrl("jdbc:mysql://localhost:3306/mooc_meetingfilm?useUnicode=true&amp;characterEncoding=utf8")
            //设置用户名
            .setUsername("root")
            //设置密码
            .setPassword("root")
            //设置数据库驱动
            .setDriverName("com.mysql.jdbc.Driver") //com.microsoft.sqlserver.jdbc.SQLServerDriver
            //.setDriverName("com.mysql.cj.jdbc.Driver")
//            // 自定义数据库表字段类型转换【可选】
//            .setTypeConvert(new MySqlTypeConvert() {
//                @Override
//                public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
//                    //System.out.println("转换类型：" + fieldType);
//                    //tinyint转换成Boolean
//                    if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
//                        return DbColumnType.BOOLEAN;
//                    }
//                    //将数据库中datetime转换成date
//                    if ( fieldType.toLowerCase().contains( "datetime" ) ) {
//                        return DbColumnType.DATE;
//                    }
//                    return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
//                 }
//            })
            ;
             
        //******************************策略配置******************************************************
//        // 自定义需要填充的字段 数据库中的字段
//        List<TableFill> tableFillList = new ArrayList<TableFill>();
//        tableFillList.add(new TableFill("gmt_modified", FieldFill.INSERT_UPDATE));
//        tableFillList.add(new TableFill("modifier_id", FieldFill.INSERT_UPDATE));
//        tableFillList.add(new TableFill("creator_id", FieldFill.INSERT));
//        tableFillList.add(new TableFill("gmt_creat", FieldFill.INSERT));
//        tableFillList.add(new TableFill("available_flag", FieldFill.INSERT));
//        tableFillList.add(new TableFill("deleted_flag", FieldFill.INSERT));
//        tableFillList.add(new TableFill("sync_flag", FieldFill.INSERT));
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
            //全局大写命名是否开启
            .setCapitalMode(true)
            //【实体】是否为lombok模型
            //.setEntityLombokModel(true)
            //表名生成策略  下划线转驼峰
            .setNaming(NamingStrategy.underline_to_camel)
            //自动填充设置
            //.setTableFillList(tableFillList)
            // 表前缀
            //.setTablePrefix("tb_")
            // 没有去除后缀的配置
            //修改替换成你需要的表名，多个表名传数组
            //.setInclude("tb_base_company","tb_base_manager")
            //.setInclude("employee","mechant","orderdetail","ordermain","product","productdetail","producttype","user")
            .setInclude("mooc_actor_t","mooc_user_t")
            // 自定义实体父类
            // .setSuperEntityClass("com.baomidou.demo.TestEntity")
            // 自定义实体，公共字段
            // .setSuperEntityColumns(new String[] { "test_id", "age" })
            // 自定义 mapper 父类
            //.setSuperMapperClass("com.youfan.common.base.SuperMapper")
            .setSuperMapperClass("com.mooc.meetingfilm.common.base.SuperMapper")
            // 自定义 service 父类
            //.setSuperServiceClass("com.youfan.common.base.SuperService")
            .setSuperServiceClass("com.mooc.meetingfilm.common.base.SuperService")
            // 自定义 service 实现类父类
            //.setSuperServiceImplClass("com.youfan.common.base.SuperServiceImpl");
            .setSuperServiceImplClass("com.mooc.meetingfilm.common.base.SuperServiceImpl");
            // 自定义 controller 父类
            // .setSuperControllerClass("com.baomidou.demo.TestController");
            //集成注入设置
            //注入全局设置
        new AutoGenerator()
            .setGlobalConfig(config)
            //注入数据源配置
            .setDataSource(dataSourceConfig)
            //注入策略配置
            .setStrategy(strategyConfig)
            //设置包名信息
            .setPackageInfo(
                new PackageConfig()
                //提取公共父级包名
                //.setParent("com.youfan.company")
                .setParent("com.mooc.meetingfilm.backend.common")
                //设置controller信息
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setXml("mapper.xml")
                //设置实体类信息
                .setEntity("pojo")
            )
//            //设置自定义模板
//            .setTemplate(
//                new TemplateConfig()
//                //.setXml(null)//指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
//                //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
//                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
//                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
//                // .setController("...");
//                // .setEntity("...");
//                // .setMapper("...");
//                // .setXml("...");
//                // .setService("...");
//                .setServiceImpl("templates/serviceImpl.java")
//            )
            //开始执行代码生成
            .execute();
    }
}
