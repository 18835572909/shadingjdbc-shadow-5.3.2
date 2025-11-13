package com.hz.yz;

import com.hz.yz.service.OrderTblService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@Slf4j
@MapperScan("com.hz.yz.mapper")
@SpringBootApplication
public class YzApplication implements ApplicationRunner {

    @Resource
    OrderTblService orderTblService;

    public static void main(String[] args) {
        SpringApplication.run(YzApplication.class,args);
    }

    public void clearDb(){
        orderTblService.deleteAll();
    }

    public void mockData(){
        orderTblService.mockDataByBatchSave();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //clearDb();
        //mockData();
        log.info("启动成功！");
    }
}