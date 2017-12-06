package com.cmcc.onenet.web.request.datapoint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @Author: wannengjia@gamil.com
 * @Description:
 * @Date: Create in 2017/12/7 1:18
 */
@ApiModel
public class DatapointsRequestBean {
	@ApiModelProperty(value = "上传数据点时间，可选。如果为空，则设备云会取当前时间。如果存在其格式必须为\"YYYY-MM-DD hh:mm:ss\"的形式（例如：2015-03-22 22:31:12）")
	private Date at;
	@ApiModelProperty(value = "上传数据点值")
	private Object value;

	public Date getAt() {
		return at;
	}

	public void setAt(Date at) {
		this.at = at;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
