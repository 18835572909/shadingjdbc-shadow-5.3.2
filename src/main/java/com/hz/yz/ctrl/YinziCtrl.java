package com.hz.yz.ctrl;

import cn.hutool.json.JSONUtil;
import com.hz.yz.entity.OrderTbl;
import com.hz.yz.service.OrderTblService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author rhb
 * @date 2025/11/10 16:51
 **/
@RestController
@RequestMapping("/sharding")
public class YinziCtrl {

    @Resource
    OrderTblService orderTblService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/db/{userId}/{orderNo}")
    public List<OrderTbl> getOrderByUserId(@PathVariable("userId") String userId, @PathVariable("orderNo")String orderNo){
        List<OrderTbl> orders = orderTblService.getOrderByUserIdAndOrderNo(userId, orderNo);
        System.out.println(JSONUtil.toJsonStr(orders));
        return orders;
    }

    @GetMapping("/shadow/mock")
    public String saveShadowMock(){
        try{
            orderTblService.mockDataByBatchSave();
        }catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
        return "OK";
    }

    @GetMapping("/shadow/mock1")
    public String saveShadowMock1(){
        try{
            orderTblService.mockDataByCyclicSave();
        }catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
        return "OK";
    }

    @GetMapping("/shadow/mock2")
    public String saveShadowMock2(){
        try{
            orderTblService.mockShadowSave();
        }catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
        return "OK";
    }

}
