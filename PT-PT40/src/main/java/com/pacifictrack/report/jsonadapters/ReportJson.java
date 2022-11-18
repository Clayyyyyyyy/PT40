/*    */ package com.pacifictrack.report.jsonadapters;

import com.pacifictrack.report.reportdata.Accumulators;
import com.pacifictrack.report.reportdata.AuthenticationData;
import com.pacifictrack.report.reportdata.CellData;
import com.pacifictrack.report.reportdata.DeviceData;
import com.pacifictrack.report.reportdata.DeviceStatusData;
import com.pacifictrack.report.reportdata.DtcData;
import com.pacifictrack.report.reportdata.EngineData;
import com.pacifictrack.report.reportdata.GpsData;
import com.pacifictrack.report.reportdata.HardwareData;
import com.pacifictrack.report.reportdata.TemperatureData;
import com.pacifictrack.report.reportdata.iButtonData;

/*    */ 
/*    */ public class ReportJson {
/*    */   private final byte[] Ack;
/*    */   private final Integer eventValue;
/*    */   private final AuthenticationData authentication;
/*    */   private final CellData cellular;
/*    */   private final Accumulators accumulators;
/*    */   private final DeviceData device_data;
/*    */   
/*    */   public ReportJson(byte[] Ack, Integer eventValue, AuthenticationData authentication, CellData cellular, Accumulators accumulators, DeviceData device_data, DeviceStatusData device_status, DtcData dtc, EngineData engine, GpsData gps, HardwareData hw, iButtonData ibutton, TemperatureData temp) {
/* 12 */     this.Ack = Ack; this.eventValue = eventValue; this.authentication = authentication; this.cellular = cellular; this.accumulators = accumulators; this.device_data = device_data; this.device_status = device_status; this.dtc = dtc; this.engine = engine; this.gps = gps; this.hw = hw; this.ibutton = ibutton; this.temp = temp;
/*    */   } private final DeviceStatusData device_status; private final DtcData dtc; private final EngineData engine; private final GpsData gps; private final HardwareData hw; private final iButtonData ibutton; private final TemperatureData temp; public byte[] getAck() {
/* 14 */     return this.Ack; }
/* 15 */   public Integer getEventValue() { return this.eventValue; }
/* 16 */   public AuthenticationData getAuthentication() { return this.authentication; }
/* 17 */   public CellData getCellular() { return this.cellular; }
/* 18 */   public Accumulators getAccumulators() { return this.accumulators; }
/* 19 */   public DeviceData getDevice_data() { return this.device_data; }
/* 20 */   public DeviceStatusData getDevice_status() { return this.device_status; }
/* 21 */   public DtcData getDtc() { return this.dtc; }
/* 22 */   public EngineData getEngine() { return this.engine; }
/* 23 */   public GpsData getGps() { return this.gps; }
/* 24 */   public HardwareData getHw() { return this.hw; }
/* 25 */   public iButtonData getIbutton() { return this.ibutton; } public TemperatureData getTemp() {
/* 26 */     return this.temp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\ReportJson.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */