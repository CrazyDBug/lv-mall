package com.lv.mall.ware.vo;

import lombok.Data;

import java.util.List;

@Data
public class MergeVo {

    /**
     * 包装器为了处理空值
     */
    private Long purchaseId;


    private List<Long> items;

}
