/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.lv.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R<T> extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

//	public T getData() {
//		return data;
//	}
//
//	public void setData(T data) {
//		this.data = data;
//	}
//
//	private T data;

	public R setData(Object data) {
		put("data",data);
		return this;
	}

	/**
	 * 利用fastjson进行逆转
	 * 返回指定类型的数据
	 * @param typeReference
	 * @return
	 */
	public  <T> T getData(TypeReference<T> typeReference) {
//		Object data = get("data");// 默认map类型
////		JSON.toJSONString(data)
//		String s = JSON.toJSONString(data);
//
//		T  t = JSON.parseObject(s,typeReference);
//		return t;
		Object data = get("data");
		return JSON.parseObject(JSON.toJSONString(data), typeReference);
	}

	public R() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

//	public Object get



	public  Integer getCode () {
//		return this.getCode();
		Object code = this.get("code");
//		String s = (String) code;
		return (Integer) code;
////		return (Integer) this.getCode();
//		// TODO: 2022/10/22 下面无效 编译报错？？？
////		return Integer.parseInt((String)this.getCode("code"));
	}

//	public Integer getCode() {
//
//		return (Integer) this.get("code");
//	}
}
