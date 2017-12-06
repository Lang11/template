package com.huadao.channel.${l_channel_name}.service.impl;

import com.huadao.channel.base.service.SMService;
import com.ielpm.pay.common.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 扫码支付服务实现类
 * @author ${author}
 * ${date}
 */
@Service
public class SMServiceImpl implements SMService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SMServiceImpl.class);

	public Results pay(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results notify(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results query(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
