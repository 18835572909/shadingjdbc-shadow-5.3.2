package com.hz.yz.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.ImmutableList;
import com.hz.yz.entity.OrderTbl;
import com.hz.yz.mapper.OrderTblMapper;
import com.hz.yz.service.OrderTblService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rhb
 * @since 2025-11-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderTblServiceImpl implements OrderTblService {

    ImmutableList<String> userIds = ImmutableList.of("x2", "x3", "x4", "x5");

    @Resource
    OrderTblMapper orderTblMapper;

    @Override
    public List<OrderTbl> getOrderByUserIdAndOrderNo(String userId, String orderNo) {
        return orderTblMapper.getOrderByUserIdAndOrderNo(userId, orderNo);
    }

    @Override
    public void deleteAll() {
        orderTblMapper.deleteAll();
    }

    @Override
    public void saveBatch(List<OrderTbl> orderTbls) {
        orderTblMapper.saveBatch(orderTbls);
    }

    @Override
    public void mockDataByBatchSave() {
        List<OrderTbl> list = new ArrayList<>(16);
        for (int i=0 ; i<10 ; i++){
            OrderTbl order =new OrderTbl();
            order.setCount(i+ RandomUtil.randomLong(5,10));
            order.setMoney(i + RandomUtil.randomLong(20,50));
            order.setCommodityCode(IdUtil.fastSimpleUUID());
            order.setUserId(userIds.get(RandomUtil.randomInt(0,3)));
            order.setOrderNo(IdUtil.getSnowflakeNextIdStr());
            System.out.println("库：" + Math.abs(order.getUserId().hashCode() % 2) + "，表：" + Math.abs(order.getOrderNo().hashCode() % 2) +" -- "+ JSONUtil.toJsonStr(order));
            list.add(order);
        }

        orderTblMapper.saveBatch(list);
    }

    @Override
    public void mockDataByCyclicSave() {
        for (int i=0 ; i<10 ; i++){
            OrderTbl order =new OrderTbl();
            order.setCount(i+ RandomUtil.randomLong(5,10));
            order.setMoney(i + RandomUtil.randomLong(20,50));
            order.setCommodityCode(IdUtil.fastSimpleUUID());
            order.setUserId(userIds.get(RandomUtil.randomInt(0,3)));
            order.setOrderNo(IdUtil.getSnowflakeNextIdStr());
            System.out.println("库：" + Math.abs(order.getUserId().hashCode() % 2) + "，表：" + Math.abs(order.getOrderNo().hashCode() % 2) +" -- "+ JSONUtil.toJsonStr(order));
            orderTblMapper.save(order);
        }
    }

    @Override
    public void mockShadowSave() {
        OrderTbl order =new OrderTbl();
        order.setCount(1L);
        order.setMoney(1 + RandomUtil.randomLong(20,50));
        order.setCommodityCode(IdUtil.fastSimpleUUID());
        order.setUserId("x3");
        order.setOrderNo(IdUtil.getSnowflakeNextIdStr());
        orderTblMapper.save(order);
    }
}
