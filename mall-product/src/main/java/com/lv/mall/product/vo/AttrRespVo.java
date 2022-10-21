package com.lv.mall.product.vo;

import lombok.Data;

@Data
public class AttrRespVo extends AttrVo{

    /**
     * 分类名字
     */
    private String catelogName;

    /**
     * 所属分组名字
     */
    private String groupName;

    private Long[] catelogPath;
}
