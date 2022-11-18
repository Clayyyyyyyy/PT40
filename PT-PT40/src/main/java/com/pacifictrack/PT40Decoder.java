package com.pacifictrack;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.pacifictrack.Parser;
import com.yisuitech.iot.base.protocol.IProtocol;
import com.yisuitech.iot.base.protocol.IProtocolDecoder;
import com.yisuitech.iot.entity.protocol.CmdData;
import com.yisuitech.iot.entity.protocol.para.ProtocolPara;
import com.yisuitech.iot.entity.IotAlarm;
import com.yisuitech.iot.entity.IotAlarmType;
import com.yisuitech.iot.entity.protocol.fun.FunCodeItem;
import com.yisuitech.iot.entity.protocol.fun.FunCodeType;
import com.yisuitech.iot.protocol.ProtocolUtil;
import com.yisuitech.iot.protocol.entity.GpsDataStatusType;
import com.yisuitech.iot.protocol.entity.IotOtherData;
import com.yisuitech.iot.protocol.entity.IotOtherDataType;
import com.yisuitech.iot.protocol.entity.OBDField;
import com.yisuitech.support.ds.ResizableArray;
import com.yisuitech.util.HexUtil;
import com.yisuitech.util.LogUtil;
import com.yisuitech.util.StringUtil;
import com.yisuitech.util.log.CoreLogger;

public class PT40Decoder implements IProtocolDecoder {
	private CoreLogger logger = LogUtil.getLogger(PT40Decoder.class.getName());
	private String protocolName;
	private IProtocol protocol;
	private Parser parse;
	
	private static Map<String,Integer> alertTypeMap = new ConcurrentHashMap<>();
	static {
		alertTypeMap.put("1", IotAlarmType.OverSpeedAlarm.getCode());
		alertTypeMap.put("9", IotAlarmType.OBDEnterSleepAlarm.getCode());
		alertTypeMap.put("10", IotAlarmType.OBDExitSleepAlarm.getCode());
		alertTypeMap.put("13", IotAlarmType.OBDBatteryErrorAlarm.getCode());
		alertTypeMap.put("14", IotAlarmType.LowVoltageAlarm.getCode());
		alertTypeMap.put("15", IotAlarmType.OBDShockedAlarm.getCode());
		alertTypeMap.put("16", IotAlarmType.OBDCrashDetectedAlarm.getCode());
		alertTypeMap.put("33", IotAlarmType.AccOnAlarm.getCode());
		alertTypeMap.put("34", IotAlarmType.AccOffAlarm.getCode());
		alertTypeMap.put("40", IotAlarmType.OBDPowerConnectedAlarm.getCode());
		alertTypeMap.put("41", IotAlarmType.OBDPowerDisconnectedAlarm.getCode());
		alertTypeMap.put("44", IotAlarmType.OBDBatteryConnectedAlarm.getCode());
		alertTypeMap.put("45", IotAlarmType.OBDBatteryDisconnectedAlarm.getCode());
		alertTypeMap.put("63", IotAlarmType.OBDEngineCoolantTemperatureViolationAlarm.getCode());
		alertTypeMap.put("64", IotAlarmType.OBDEngineOilPressureViolationAlarm.getCode());
		alertTypeMap.put("66", IotAlarmType.OBDEngineErrorCodeDTCAlarm.getCode());
		alertTypeMap.put("91", IotAlarmType.OBDFuelLevelLowerAlarm.getCode());
		alertTypeMap.put("92", IotAlarmType.OBDFuelLevelUpperAlarm.getCode());
		alertTypeMap.put("46", IotAlarmType.OBDHarshAccelerationAlarm.getCode());
		alertTypeMap.put("47", IotAlarmType.OBDHarshBrakingAlarm.getCode());
		alertTypeMap.put("48", IotAlarmType.OBDSharpTurnAlarm.getCode());
		alertTypeMap.put("49", IotAlarmType.OBDSharpTurnAlarm.getCode());
		alertTypeMap.put("86", IotAlarmType.OBDDPACalibratedAlarm.getCode());
		alertTypeMap.put("50", IotAlarmType.OBDJammingDetectedAlarm.getCode());
		alertTypeMap.put("29", IotAlarmType.OBDEnterDriveModeAlarm.getCode());
		alertTypeMap.put("31", IotAlarmType.OBDEnterParkModeAlarm.getCode());
		alertTypeMap.put("68", IotAlarmType.OBDEnterIdleModeAlarm.getCode());
		alertTypeMap.put("36", IotAlarmType.OBDEnterSpeedModeAlarm.getCode());
		alertTypeMap.put("27", IotAlarmType.OBDEnterCarryAlarm.getCode());
		alertTypeMap.put("35", IotAlarmType.OBDExcessIdleAlarm.getCode());
		alertTypeMap.put("58", IotAlarmType.OBDEnterTowAlarm.getCode());
		alertTypeMap.put("43", IotAlarmType.OBDLowBackupBatteryAlarm.getCode());
		alertTypeMap.put("73", IotAlarmType.OBDSimCardRemovedAlarm.getCode());
	}
	
	public PT40Decoder(IProtocol protocol) {
		this.protocol = protocol;
		this.protocolName = protocol.getProtocolName();
		this.parse = new Parser();
	}
	
	@Override
	public Object decode(CmdData cmd, boolean needHandle) {
		FunCodeItem fci = protocol.getFunCodes().get(cmd.getFunCode());
		
		ResizableArray<Object> result = new ResizableArray<Object>(Object.class);
		String[] data = new String(cmd.getData()).split(";");
	}

	@Override
	public byte[] assembleCmd(String arg0, ProtocolPara arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] assembleResp(CmdData arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmdData parse(byte[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
