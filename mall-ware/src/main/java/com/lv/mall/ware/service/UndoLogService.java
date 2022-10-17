package com.lv.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.common.utils.PageUtils;
import com.lv.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 19:27:02
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

