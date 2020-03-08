//package com.funtl.spring.cloud.alibaba.consumer.configure;
//
//import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
//import com.alibaba.csp.sentinel.init.InitFunc;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//import com.alibaba.fastjson.JSON;
//
//import java.util.List;
//
//public class DataSourceInitFunc implements InitFunc {
//
//    @Override
//    public void init() throws Exception {
//        final String remoteAddress = "localhost";
//        final String groupId = "Sentinel:Demo";
//        final String dataId = "com.alibaba.csp.sentinel.demo.flow.rule";
//
//        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
//                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
//        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
//    }
//}