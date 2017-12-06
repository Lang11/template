package com.huadao.channel.${l_channel_name}.service;


import com.huadao.channel.base.service.*;
import com.huadao.channel.${l_channel_name}.${c_channel_name}ChannelService4d;
import com.ielpm.pay.common.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 通道服务实现类
 * 
 * @author ${author}
 * ${date}
 */
@Service("${l_channel_name}ChannelService4dImpl")
public class ${c_channel_name}ChannelService4dImpl implements ${c_channel_name}ChannelService4d,InitializingBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(com.huadao.channel.${l_channel_name}.service.${c_channel_name}ChannelService4dImpl.class);
	private static final String TAG = "【通道服务接口】";

	@Autowired
	private GWService gwService;

	@Autowired
	private H5GWService h5GWService;

	@Autowired
	private SMService smService;

	@Autowired
	private DFService dfService;

	@Autowired
	private KJService kjService;
	
	private ChannelServiceDispatcher dispatcher = ChannelServiceDispatcher.getInstance();
	
	@SuppressWarnings("rawtypes")
	public Results service(Map reqMap, Map metaMap) {
		return dispatcher.handle(reqMap, metaMap);
	}

	public void afterPropertiesSet() throws Exception {
		dispatcher.setGwService(gwService);
		dispatcher.setH5GWService(h5GWService);
		dispatcher.setKjService(kjService);
		dispatcher.setDfService(dfService);
		dispatcher.setSmService(smService);
	}
	
}
