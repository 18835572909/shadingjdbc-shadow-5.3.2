package com.hz.yz.mapper;

import com.hz.yz.entity.OrderTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rhb
 * @since 2025-11-10
 */
public interface OrderTblMapper {

    Long saveBatch(List<OrderTbl> orders);

    Long save(@Param("order") OrderTbl orderTbl);

    List<OrderTbl> getOrderByUserIdAndOrderNo(String userId,String orderNo);

    void deleteAll();

}
