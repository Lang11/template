package com.huadao.channel.${l_channel_name}.service.impl;

import com.huadao.channel.base.service.KJService;
import com.ielpm.pay.common.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 快捷支付服务实现类
 * @author ${author}
 * ${date}
 */
@Service
public class KJServiceImpl implements KJService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KJServiceImpl.class);

	@Override
	public Results<Map<String, String>> bind(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> bindSend(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> bindVertify(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> bindNotify(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> bindQuery(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> pay(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> paySend(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> payVertify(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> payNotify(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> payQuery(Map<String, String> reqDataMap, String channelNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results<Map<String, String>> unbind(Map<String, String> reqDataMap, String channelNo){
		// TODO Auto-generated method stub
		return null;
	}
}
