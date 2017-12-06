package com.huadao.channel.${l_channel_name}.service.impl;

import com.huadao.channel.base.service.DFService;
import com.ielpm.pay.common.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 代付服务实现类
 * @author ${author}
 * ${date}
 */
@Service
public class DFServiceImpl implements DFService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DFServiceImpl.class);

	private static final String TAG = "【代付服务】";

	public Results pay(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results query(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Results balanceQuery(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results notify(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results getResponseMessageToUpstream(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
