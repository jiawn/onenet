package com.cmcc.onenet.web.request.datapoint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: wannengjia@gamil.com
 * @Description:
 * @Date: Create in 2017/12/7 1:17
 */
@ApiModel
public class DatastreamsRequestBean {
	@ApiModelProperty(value = "数据流名称或数据流模板名称")
	@NotBlank(message = "数据流名称不能为空")
	private String id;

	@ApiModelProperty(value = "数据流")
	@Valid
	private List<DatapointsRequestBean> datapoints;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DatapointsRequestBean> getDatapoints() {
		return datapoints;
	}

	public void setDatapoints(List<DatapointsRequestBean> datapoints) {
		this.datapoints = datapoints;
	}



}
