package com.lv.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.common.utils.PageUtils;
import com.lv.mall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 14:32:55
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

