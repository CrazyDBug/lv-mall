package com.lv.mall.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.lv.mall.product.entity.BrandEntity;
import com.lv.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class MallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        System.out.println(brandService.save(brandEntity));
    }



    @Test
    public void testUpload() throws FileNotFoundException {

//        alibaba.cloud.oss.endpoint=oss-cn-hangzhou.aliyuncs.com
//        alibaba.cloud.access-key=LTAI5tLVN3UZ9aGRsRyXZVC9
//        alibaba.cloud.secret-key=CX7WUkmWXwQs0ta2Qgb6XNBAv5byGM
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI5tLVN3UZ9aGRsRyXZVC9";
        String accessKeySecret = "CX7WUkmWXwQs0ta2Qgb6XNBAv5byGM";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\27375\\Pictures\\a.png");
        ossClient.putObject("lv-mall-test", "upload1.png", inputStream);

// 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("上传成功");
    }


}
