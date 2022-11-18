package com.pacifictrack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.yisuitech.iot.base.protocol.IProtocol;
import com.yisuitech.iot.base.protocol.IProtocolContext;
import com.yisuitech.iot.base.protocol.IProtocolDecoder;
import com.yisuitech.iot.base.protocol.SocketDecoderType;
import com.yisuitech.iot.entity.protocol.CmdDataType;
import com.yisuitech.iot.entity.protocol.fun.FunCodeItem;
import com.yisuitech.iot.entity.protocol.fun.FunCodeType;
import com.yisuitech.iot.entity.protocol.para.ProtocolPara;
import com.yisuitech.iot.entity.protocol.para.ProtocolParaItem;
import com.yisuitech.iot.entity.protocol.para.ProtocolParaValueType;
import com.yisuitech.iot.protocol.base.AbstractProtocol;
import com.yisuitech.iot.protocol.util.ProtocolBuilder;

public class PT40Protocol extends AbstractProtocol implements IProtocol {
	private PT40Decoder decoder;
	public static final String protocolName = "PacificTrack";

	@Override
	public String getProtocolName() {
		return protocolName;
	}
	
	@Override
	public CmdDataType getCmdDataType() {
		return CmdDataType.AtString;
	}
	
	@Override
	public Map<String, FunCodeItem> getFunCodes() {
		return ProtocolBuilder.builder()
				.add(new FunCodeItem("STT",false,true,FunCodeType.Position), false)
				.add(new FunCodeItem("ASTT",true,true,FunCodeType.Position), false)
				
				.add(new FunCodeItem("ALT",false,true,FunCodeType.Alarm), false)
				.add(new FunCodeItem("AALT",true,true,FunCodeType.Alarm), false)
				
				.add(new FunCodeItem("ALV",false,false,FunCodeType.Other), false)//3.Keep-Alive Report:ALV
				.add(new FunCodeItem("CRR",false,true,FunCodeType.Other), false)//8.Crash Reconstruction Report(Optional):CRR
				.add(new FunCodeItem("MNT",false,true,FunCodeType.Other), false)//9.Maintenance Report:MNT
				
				.add(new FunCodeItem("TPR",false,true,FunCodeType.Other), false)//13.Temperature Report:TPR
				.add(new FunCodeItem("GED",false,true,FunCodeType.Other), false)//14.Parameter Report:PRM
				.add(new FunCodeItem("PRM",false,true,FunCodeType.Other), false)//14.Parameter Report:PRM
				
				.add(new FunCodeItem("RES",false,true,FunCodeType.Response), false)//Response of cmd: RES; 4309999001;01;01
				
				.add(new FunCodeItem("RPR",false,true,FunCodeType.Response), false)//Parameter Response of PRG: ERR;[Parameter];successe
				.add(new FunCodeItem("ERR",false,true,FunCodeType.Response), false)//Parameter Response of PRG: ERR;[Parameter];error
				.add(new FunCodeItem("USP",false,true,FunCodeType.Response), false)//Parameter Response of PRG: USP;[Parameter];not support parameter
				.build();
	}
	
	@Override public IProtocolDecoder getDecoder() {
		if(decoder == null)	decoder = new PT40Decoder(this);
		return decoder;
	}
	
	@Override
	protected void initPara() {
		if(null==paras) {
			synchronized (PT40Protocol.class) {
				if(null==paras) {
					String protocolName = getProtocolName();
					paras = new HashMap<String,ProtocolPara>();
					
					//设置后端参数
					paras.put("GTQSS", new ProtocolPara(protocolName,"GTQSS","GTQSS","设置后端参数",Lists.newArrayList(
							new ProtocolParaItem("Server IP","服务器IP/域名",ProtocolParaValueType.String,"notEmpty"),
							new ProtocolParaItem("Server Port","服务器端口",ProtocolParaValueType.Integer,"range|1025,65535"),
							new ProtocolParaItem("Server Type","通信类型",ProtocolParaValueType.String,"enumStr|TCP,UDP")
					)));
				}
			}
		}
	}
	
	public int getInterval() {
		return 60;//1小时
	}
	
	@Override
	public SocketDecoderType getSocketDecoderType() {
		return SocketDecoderType.DefaultDecoder;
	}

	@Override
	public boolean allNeedResp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IProtocolContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProtocolPara getPara(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSeq() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSeqHex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSettingFunCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnableAcc() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAccuracyThreshold(double arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContext(IProtocolContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
