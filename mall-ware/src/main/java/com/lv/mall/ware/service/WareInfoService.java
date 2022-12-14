package com.lv.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.common.utils.PageUtils;
import com.lv.mall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 19:27:02
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

