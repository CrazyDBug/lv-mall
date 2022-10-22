package com.lv.mall.product.feign;

import com.lv.common.to.SkuReductionTo;
import com.lv.common.to.SpuBoundTo;
import com.lv.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mall-coupon")
public interface CouponFeignService {
    /**
     * openfeign调用
     * 对象转为json @RequestBody
     * 给服务发送请求  将json放到请求体位置    发送请求
     * 服务收到请求   请求体里有json数据
     * 将json数据转为指定对象
     * 只要json数据模型是兼容的，双方服务无需使用同一个to
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
