package com.lv.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.common.utils.PageUtils;
import com.lv.mall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 14:32:55
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

