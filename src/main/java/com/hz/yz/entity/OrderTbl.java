package com.hz.yz.entity;

import lombok.Data;

/**
 * @author rhb
 * @date 2025/11/10 16:51
 *
 * CREATE TABLE `order_tbl` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_id` varchar(255) DEFAULT NULL,
 *   `commodity_code` varchar(255) DEFAULT NULL,
 *   `count` int(11) DEFAULT '0',
 *   `money` int(11) DEFAULT '0',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 **/
@Data
public class OrderTbl {

    private Long id;

    private String userId;

    private String orderNo;

    private String commodityCode;

    private Long count;

    private Long money;

}
