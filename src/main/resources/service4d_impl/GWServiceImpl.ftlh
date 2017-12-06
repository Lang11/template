package com.huadao.channel.${l_channel_name}.service.impl;

import com.huadao.channel.base.service.GWService;
import com.ielpm.pay.common.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 网关支付服务实现类
 * @author ${author}
 * ${date}
 */
@Service
public class GWServiceImpl implements GWService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GWServiceImpl.class);

	private static final String TAG = "【网关支付服务】";
	
	public Results pay(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results query(String tranSerialNum, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results checkSignOfCallback(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results convertCallback(Map reqMap, String bankChannelNo, String version) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results notify(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results getResponseMessageToUpstream() {
		// TODO Auto-generated method stub
		return null;
	}

	public Results refund(Map reqMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results refundNotify(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Results refundQuery(Map reqMap, String bankChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
