package com.cmcc.onenet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 系统初始化
 *
 * @author wannengjia@gmail.com
 */
public class SystemInit implements ApplicationListener<ContextRefreshedEvent> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static boolean isStart = false;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (!isStart) {
			logger.info("系统初始化开始....");
			isStart = true;
			// 配置全局的FastJSON变量
			logger.info("配置全局的fastjson变量");
			JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();

			logger.info("系统初始化结束....");
		}
	}

}
