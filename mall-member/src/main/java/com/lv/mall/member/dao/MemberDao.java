package com.lv.mall.member.dao;

import com.lv.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author BUG
 * @email 2737550037@qq.com
 * @date 2022-10-17 19:12:37
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
