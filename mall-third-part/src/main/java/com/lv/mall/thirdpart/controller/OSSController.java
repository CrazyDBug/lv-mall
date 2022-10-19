package com.lv.mall.thirdpart.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.lv.mall.thirdpart.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: OSSController</p>
 * Description：生成后端签名
 * date：2020/6/1 17:18
 * todo @Value获取不到值
 */
@RestController
public class OSSController {



//	private String accessId;
//	private PolicyConditions policyConds;
//


    private String bucket = "lv-mall-test";

    private String endpoint = "oss-cn-hangzhou.aliyuncs.com";

    private String accessId = "LTAI5tLVN3UZ9aGRsRyXZVC9";

    private PolicyConditions policyConds;


    @Autowired
    OSS ossClient;

    /**
     * 获取对象存储的签名数据
     *
     * @return
     */
    @RequestMapping("/oss/policy")
    public R policy() {
        String bucket = "lv-mall-test";
        String host = "https://" + bucket + "." + endpoint;

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dir = format + "/"; // 用户上传文件时指定的前缀。
        Map<String, String> respMap = null;
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);


            respMap = new LinkedHashMap<>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
        } catch (Exception e) {

        }
        return R.ok().put("data", respMap);
    }
}
