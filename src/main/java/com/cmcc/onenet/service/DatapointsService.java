package com.cmcc.onenet.service;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.onenet.web.request.datapoint.DatapointCreateRequestBean;
import com.cmcc.onenet.web.request.datapoint.DatapointQueryRequestBean;

/**
 * @author wannengjia@gmail.com
 * @Description:
 * @Date: Create in 2017/12/7 0:22
 */
public interface DatapointsService {
	/**
	 * 新增数据点
	 *
	 * @param requestBean
	 */
	void createDatapoints(DatapointCreateRequestBean requestBean);

	/**
	 * 查询
	 * @param requestBean
	 * @return
	 */
	JSONObject query(DatapointQueryRequestBean requestBean);



}
