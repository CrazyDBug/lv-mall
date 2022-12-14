package com.lv.mall.product.controller;

import com.lv.common.utils.PageUtils;
import com.lv.common.utils.R;
import com.lv.common.valid.AddGroup;
import com.lv.common.valid.UpdateGroup;
import com.lv.common.valid.UpdateStatusGroup;
import com.lv.mall.product.entity.BrandEntity;
import com.lv.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 品牌
 *
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 13:51:59
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
//    @RequestMapping("/save")
//    public R save(@Valid @RequestBody BrandEntity brand){
//		brandService.save(brand);
//
//        return R.ok();
//    }

//    /**
//     * @param brand
//     * @param result    封装校验结果
//     * @return
//     */
//    @RequestMapping("/save")
//    public R save(@Valid @RequestBody BrandEntity brand, BindingResult result){
//        Map<String,String> map = new HashMap<>();
//        if (result.hasErrors()) {
//            // 获取校验的错误结果
//            result.getFieldErrors().forEach((item) -> {
//                // 获取错误提示
//                String message = item.getDefaultMessage();
//                // 获取错误的属性名字
//                String field = item.getField();
//                map.put(field,message);
//            });
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }
//        brandService.save(brand);
//
//        return R.ok();
//    }

//    /**
//     * 异常捕捉
//     *
//     * @param brand
//     * @return
//     */
//    @RequestMapping("/save")
//    public R save(@Valid @RequestBody BrandEntity brand){
//        brandService.save(brand);
//
//        return R.ok();
//    }
    @RequestMapping("/save")
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand) {
        brandService.save(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand) {
        brandService.updateByIdDetail(brand);

        return R.ok();
    }


    /**
     * 修改品牌状态
     */
    @RequestMapping("/update/status")
    public R updateStatus(@Validated(UpdateStatusGroup.class) @RequestBody BrandEntity brand) {
        brandService.updateById(brand);

        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
