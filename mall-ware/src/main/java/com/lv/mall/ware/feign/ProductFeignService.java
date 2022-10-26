package com.lv.mall.ware.feign;

import com.lv.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-product")
public interface ProductFeignService {

    /**
     * 两种写法
     * 1、所以请求过网关
     * 2、直接指定后台服务处理
     * @param skuId
     * @return
     */
    @RequestMapping("/product/skuinfo/info/{skuId}")
     R info(@PathVariable("skuId") Long skuId);
}
