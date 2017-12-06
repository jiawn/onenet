package com.cmcc.onenet.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.onenet.config.cmcc.OneNetConfig;
import com.cmcc.onenet.model.request.OneNetBaseRequestBean;
import com.cmcc.onenet.service.DatapointsService;
import com.cmcc.onenet.web.request.datapoint.DatapointCreateRequestBean;
import com.cmcc.onenet.web.request.datapoint.DatapointQueryRequestBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wannengjia@gmail.com
 * @Description:
 * @Date: Create in 2017/12/7 0:22
 */
@Service
public class DatapointsServiceImpl extends OneNetBaseService implements DatapointsService {

	//新增数据点
	private static final String ADD_DATAPOINT = "http://api.heclouds.com/devices/#{device_id}/datapoints";
	//查询数据点
	private static final String QUERY_DATAPOINT = "http://api.heclouds.com/devices/#{device_id}/datapoints";

	@Resource OneNetConfig oneNetConfig;

	@Override public void createDatapoints(DatapointCreateRequestBean requestBean) {
		OneNetBaseRequestBean bean =new OneNetBaseRequestBean<DatapointCreateRequestBean>();
		bean.setApiKey(oneNetConfig.getApiKey());
		bean.setUrl(ADD_DATAPOINT.replace("#{device_id}", requestBean.getDeviceId()+""));
		bean.setContent(requestBean);
		Map<String,Object> urlPargam= new HashMap<>();
		urlPargam.put("type", requestBean.getType());
		bean.setUrlParam(urlPargam);
		JSONObject response = connectionJson(bean);

	}

	@Override public JSONObject query(DatapointQueryRequestBean requestBean) {

		OneNetBaseRequestBean bean =new OneNetBaseRequestBean<DatapointCreateRequestBean>();
		bean.setApiKey(oneNetConfig.getApiKey());
		bean.setUrl(ADD_DATAPOINT.replace("#{device_id}", requestBean.getDeviceId()+""));
		bean.setContent(requestBean);
		Map<String,Object> urlPargam= new HashMap<>();
		bean.setUrlParam(urlPargam);
		return connectionGet(bean);
	}
}
