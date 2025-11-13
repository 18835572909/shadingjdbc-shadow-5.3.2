package com.hz.yz.service;

import com.hz.yz.entity.OrderTbl;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rhb
 * @since 2025-11-10
 */
public interface OrderTblService {

    List<OrderTbl> getOrderByUserIdAndOrderNo(String userId,String orderNo);

    void deleteAll();

    void saveBatch(List<OrderTbl> orderTbls);

    void mockDataByBatchSave();

    void mockDataByCyclicSave();

    void mockShadowSave();
}
