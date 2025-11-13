//package com.hz.yz;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
//
//import java.nio.file.Paths;
//import java.sql.Types;
//
///**
// *
// * @author rhb
// * @date 2024/12/25 22:24
//**/
//@SuppressWarnings("all")
//public class MapperGenerator {
//
//    public static void main(String[] args) {
//        System.out.println("Root Path: "+System.getProperty("user.dir"));
//
//        String[] tables = {"order_tbl"};
//        generator(tables);
//    }
//
//    private static String authorName = "rhb"; // 作者
//    static String username = "root";
//    static String password = "nZHdc8WxdK3Y";
//    static String url = "jdbc:mysql://120.27.156.17:3306/db_2";
//
//    @SuppressWarnings("all")
//    static void generator(String[] tables) {
//        FastAutoGenerator.create(url, username, password)
//                .globalConfig(builder -> {
//                    builder.author(authorName) // 设置作者
//                            .enableSwagger()
//                            .disableOpenDir() // 开启 swagger 模式
//                            .outputDir(Paths.get(System.getProperty("user.dir"))+"/src/main/java"); // 指定输出目录
//                })
//                .dataSourceConfig(builder ->
//                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                            if (typeCode == Types.BIGINT) {
//                                return DbColumnType.LONG;
//                            }
//                            if (typeCode == Types.TIMESTAMP){
//                                return DbColumnType.LOCAL_DATE_TIME;
//                            }
//                            return typeRegistry.getColumnType(metaInfo);
//                        })
//                )
//                .packageConfig(builder ->
//                        builder.parent("com.hz.yz")
//                                .entity("entity")// 设置
//                                .mapper("mapper")
//                                .service("service")
//                                .serviceImpl("service.impl")// 父包名
//                                .xml("mapper")// 设置父包模块名
//                )
//                .strategyConfig(builder ->
//                        builder.addInclude(tables)
//                                .controllerBuilder()
//                                .disable()
//                                .entityBuilder()
//                                .enableLombok()
//                                .enableChainModel()
//                                .versionColumnName("version")
//                                .logicDeleteColumnName("logic_del")
//                                .idType(IdType.AUTO)
//                                .mapperBuilder()
//                                .enableBaseResultMap()
//                                .serviceBuilder()
//                                .formatServiceFileName("%sService")
//                )
//                .templateEngine(null)
//                .execute();
//    }
//}
