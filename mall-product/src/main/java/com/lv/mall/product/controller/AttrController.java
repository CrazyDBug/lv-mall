package com.lv.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.lv.mall.product.vo.AttrGroupRelationVo;
import com.lv.mall.product.vo.AttrRespVo;
import com.lv.mall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lv.mall.product.entity.AttrEntity;
import com.lv.mall.product.service.AttrService;
import com.lv.common.utils.PageUtils;
import com.lv.common.utils.R;


/**
 * 商品属性
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 13:51:59
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    //    @GetMapping("/base/list/{catelogId}")
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String, Object> params,
                          @PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrType") String type) {
        PageUtils page = attrService.queryBaseAttrPage(params, catelogId,type);
        return R.ok().put("page", page);
    }

//    @GetMapping("/sale/list/{catelogId}")
//    public R baseAttrList(@RequestParam Map<String, Object> params,
//                          @PathVariable("catelogId") Long catelogId) {
//        PageUtils page = attrService.queryBaseAttrPage(params,catelogId);
//        return R.ok().put("page", page);
//    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId) {
        AttrRespVo respVo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", respVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr) {
        attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr) {
        attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }



}
