package com.cmcc.onenet.web.request.datapoint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.MapKey;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: wannengjia@gamil.com
 * @Description:
 * @Date: Create in 2017/12/7 1:49
 */
@ApiModel
public class DatapointQueryRequestBean {

	//设备ID
	@ApiModelProperty(value = "设备ID")
	@NotNull(message = "设备ID不能为空")
	private Long deviceId;

	@ApiModelProperty(value = " //查询的数据流，多个数据流之间用逗号分隔（可选）")
	@MapKey(name = "datastream_Id")
	private String datastreamId;
	@ApiModelProperty(value = "//提取数据点的开始时间（可选）")
	private Date start;
	@ApiModelProperty(value = "//提取数据点的结束时间（可选）")
	private Date end;
	@ApiModelProperty(value = "  //查询时间区间（可选，单位为秒）start+duration：按时间顺序返回从start开始一段时间内的数据点 end+duration：按时间倒序返回从end回溯一段时间内的数据点")
	private Long duration;
	@ApiModelProperty(value = "    //限定本次请求最多返回的数据点数，0<n<=6000（可选，默认1440）")
	private Long limit=1440L;
	@ApiModelProperty(value = " //指定本次请求继续从cursor位置开始提取数据（可选）")
	private Long cursor;
	@ApiModelProperty(value = " //值为DESC|ASC时间排序方式，DESC:倒序，ASC升序，默认升序")
	private String sort="ASC";

	public String getDatastreamId() {
		return datastreamId;
	}

	public void setDatastreamId(String datastreamId) {
		this.datastreamId = datastreamId;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public Long getCursor() {
		return cursor;
	}

	public void setCursor(Long cursor) {
		this.cursor = cursor;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
}
