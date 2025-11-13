//package com.hz.yz.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
//import org.apache.shardingsphere.infra.config.rule.RuleConfiguration;
//import org.apache.shardingsphere.shadow.api.config.ShadowRuleConfiguration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.Collection;
//
///**
// *
// * @author rhb
// * @date 2025/11/12 14:20
// **/
//@Slf4j
//@Component
//public class ShadowDebugInterceptor {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @EventListener
//    public void handleContextRefresh(ContextRefreshedEvent event) {
//        // 应用启动后检查配置
//        if (dataSource instanceof ShardingSphereDataSource) {
//            ShardingSphereDataSource shardingDataSource = (ShardingSphereDataSource) dataSource;
//            Map<String, DataSource> dataSourceMap = shardingDataSource.getContextManager()
//                    .getMetaDataContexts().getMetaData().getDatabases();
//
//            log.info("=== ShardingSphere 数据源配置 ===");
//            dataSourceMap.forEach((name, ds) -> {
//                log.info("数据源: {}", name);
//            });
//
//            // 检查影子库规则
//            Collection<RuleConfiguration> rules = shardingDataSource.getContextManager()
//                    .getMetaDataContexts().getMetaData().getGlobalRuleMetaData().getConfigurations();
//
//            rules.forEach(rule -> {
//                if (rule instanceof ShadowRuleConfiguration) {
//                    ShadowRuleConfiguration shadowRule = (ShadowRuleConfiguration) rule;
//                    logger.info("=== 影子库规则 ===");
//                    logger.info("数据源映射: {}", shadowRule.getDataSources());
//                    logger.info("表配置: {}", shadowRule.getTables());
//                    logger.info("算法配置: {}", shadowRule.getShadowAlgorithms());
//                }
//            });
//        }
//    }
//}
