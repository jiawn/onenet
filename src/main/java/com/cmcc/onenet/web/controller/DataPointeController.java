package com.cmcc.onenet.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.onenet.service.DatapointsService;
import com.cmcc.onenet.service.impl.BaseService;
import com.cmcc.onenet.web.request.datapoint.DatapointCreateRequestBean;
import com.cmcc.onenet.web.request.datapoint.DatapointQueryRequestBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: wannengjia@gamil.com
 * @Description:
 * @Date: Create in 2017/12/7 1:28
 */
@Api(value = "数据点", produces = "application/json")
@RestController
@RequestMapping("/datapoint")
public class DataPointeController extends BaseController {
	@Resource DatapointsService datapointsService;

	/**
	 * 新增数据点
	 *
	 * @param requestBean
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增", consumes = "application/json")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody @Valid DatapointCreateRequestBean requestBean) {
		datapointsService.createDatapoints(requestBean);
		return ResponseEntity.ok().build();
	}

	/**
	 * 查询数据点
	 *
	 * @param requestBean
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "查询", consumes = "application/json")
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> add(@RequestBody @Valid DatapointQueryRequestBean requestBean) {
		return ResponseEntity.ok(datapointsService.query(requestBean));
	}
}
