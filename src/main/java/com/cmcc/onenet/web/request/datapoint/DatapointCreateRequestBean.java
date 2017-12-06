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
 * @Date: Create in 2017/12/7 0:49
 */
@ApiModel
public class DatapointCreateRequestBean {

	@ApiModelProperty(value = "数据流")
	@Valid
	private List<DatastreamsRequestBean> datastreams;

	//上传数据类型（可选，默认为1(完整JSON型)，见HTTP内容示例）
	@ApiModelProperty(value = "上传数据类型（可选，默认为1(完整JSON型)，见HTTP内容示例）")
	private Integer type = 1;
	//设备ID
	@ApiModelProperty(value = "设备ID")
	@NotNull(message = "设备ID不能为空")
	private Long deviceId;

	public List<DatastreamsRequestBean> getDatastreams() {
		return datastreams;
	}

	public void setDatastreams(List<DatastreamsRequestBean> datastreams) {
		this.datastreams = datastreams;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
}
