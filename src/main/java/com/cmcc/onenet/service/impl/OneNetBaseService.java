package com.cmcc.onenet.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.onenet.model.request.OneNetBaseRequestBean;
import com.cmcc.onenet.util.HttpUtil;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * OneNet基类
 *
 * @author wannengjia@gmail.com
 * @Description:
 * @Date: Create in 2017/12/7 0:24
 */
public abstract class OneNetBaseService extends BaseService {

	protected JSONObject connectionJson(OneNetBaseRequestBean bean) {
		JSONObject object = null;

		Map<String, Object> headers = new HashMap<>();
		headers.put("api-key", bean.getApiKey());
		headers.put("Content-Type", bean.getContentType());
		bean.setUrl(bean.getUrl() + buildUrl(bean.getUrlParam()));
		try {
			object = HttpUtil.doPostJson(bean.getUrl(), JSONObject.toJSONString(bean.getContent()), headers);
		} catch (Exception e) {
			logger.info("请求异常： {}", e);
		}
		return object;
	}

	protected JSONObject connectionGet(OneNetBaseRequestBean bean) {
		JSONObject object = null;

		Map<String, Object> headers = new HashMap<>();
		headers.put("api-key", bean.getApiKey());
		bean.setUrl(bean.getUrl() + buildUrl(bean.getUrlParam()));
		try {
			object = HttpUtil.doGet(bean.getUrl(), headers);
		} catch (Exception e) {
			logger.info("请求异常： {}", e);
		}
		return object;
	}

	private String buildUrl(Map<String, Object> urlParam) {
		if (urlParam == null || urlParam.isEmpty()) {
			return "";
		}
		StringBuilder url = new StringBuilder();
		url.append("?cmcc-onenet=1");
		urlParam.forEach((k, v) -> {
			url.append("&" + k + "=" + v);
		});
		return url.toString();

	}

}
