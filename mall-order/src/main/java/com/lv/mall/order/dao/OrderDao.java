package com.lv.mall.order.dao;

import com.lv.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 19:21:35
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
