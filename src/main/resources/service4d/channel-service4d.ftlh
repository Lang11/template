package com.huadao.channel.${l_channel_name};

import com.ielpm.pay.common.Results;

import java.util.Map;

/**
 * 通道服务接口
 * @author ${author}
 * ${date}
 */
public interface ${c_channel_name}ChannelService4d {
	
	/**
	 * @param reqMap
	 * @param metaMap
	 * @return
	 */
	Results service(Map reqMap, Map metaMap);
}
