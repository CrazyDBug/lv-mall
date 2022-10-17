package com.lv.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.common.utils.PageUtils;
import com.lv.mall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 14:32:55
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

