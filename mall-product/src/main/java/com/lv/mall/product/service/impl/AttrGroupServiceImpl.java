package com.lv.mall.product.service.impl;

import com.lv.mall.product.entity.AttrEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lv.common.utils.PageUtils;
import com.lv.common.utils.Query;

import com.lv.mall.product.dao.AttrGroupDao;
import com.lv.mall.product.entity.AttrGroupEntity;
import com.lv.mall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @param params
     * @param catelogId 三级分类ID，三级分类ID为0，查询所有
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        // 检索
        String key = (String) params.get("key");
        // select * from pms_attr_group where catelog_id = ? and
        // attr_group_id = key  or attr_group_name like %key%
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>()
                ;
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) -> {
                obj.eq("attr_group_id",key).or().eq("attr_group_name",key);
            });
        }

        if(catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
            return new PageUtils(page);
        } else {
            wrapper.eq("catelog_id",catelogId);
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
            return new PageUtils(page);
        }
    }

//    /**
//     * 根据分组id查找关联的所有基本属性
//     * @param attrgroupId
//     * @return
//     */
//    @Override
//    public List<AttrEntity> getRelationAttr(Long attrgroupId) {
//        reld
//        return null;
//    }

}