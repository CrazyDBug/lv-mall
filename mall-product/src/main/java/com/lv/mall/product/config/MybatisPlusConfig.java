package com.lv.mall.product.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.lv.mall.product.dao")
public class MybatisPlusConfig {

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
//        // paginationInterceptor.setOverflow(false);
//        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//        // paginationInterceptor.setLimit(500);
//        // 开启 count 的 join 优化,只针对部分 left join
//        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
//        return paginationInterceptor;
//    }
//
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        // 添加分页插件
//        PaginationInnerInterceptor pageInterceptor = new PaginationInnerInterceptor();
//        // 设置请求的页面大于最大页后操作，true调回到首页，false继续请求。默认false
//        pageInterceptor.setOverflow(false);
//        // 单页分页条数限制，默认无限制
//        pageInterceptor.setMaxLimit(500L);
//        // 设置数据库类型
//        pageInterceptor.setDbType(DbType.MYSQL);
//
//        interceptor.addInnerInterceptor(pageInterceptor);
//        return interceptor;
//    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pageInterceptor = new PaginationInnerInterceptor();
        pageInterceptor.setOverflow(true);
        pageInterceptor.setMaxLimit(1000L);
        interceptor.addInnerInterceptor(pageInterceptor);
        return interceptor;
    }
}