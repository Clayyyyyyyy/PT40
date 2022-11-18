/*    */ package com.pacifictrack.report;
/*    */ 
/*    */ import com.pacifictrack.report.jsonadapters.ReportJson;
/*    */ import com.pacifictrack.report.jsonadapters.ReportJsonAdapter;
/*    */ import com.pacifictrack.report.reportdata.Accumulators;
/*    */ import com.pacifictrack.report.reportdata.AuthenticationData;
/*    */ import com.pacifictrack.report.reportdata.CellData;
/*    */ import com.pacifictrack.report.reportdata.DeviceData;
/*    */ import com.pacifictrack.report.reportdata.DeviceStatusData;
/*    */ import com.pacifictrack.report.reportdata.DtcData;
/*    */ import com.pacifictrack.report.reportdata.EngineData;
/*    */ import com.pacifictrack.report.reportdata.GpsData;
/*    */ import com.pacifictrack.report.reportdata.HardwareData;
/*    */ import com.pacifictrack.report.reportdata.TemperatureData;
/*    */ import com.pacifictrack.report.reportdata.iButtonData;
/*    */ import com.squareup.moshi.JsonAdapter;
/*    */ import com.squareup.moshi.Moshi;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Report
/*    */ {
/*    */   private final byte[] Ack;
/*    */   private final Integer report_event_number;
/*    */   private final AuthenticationData auth;
/*    */   private final CellData cell;
/*    */   private final Accumulators accumulators;
/*    */   private final DeviceData device_data;
/*    */   private final DeviceStatusData device_status;
/*    */   private final DtcData dtc;
/*    */   private final EngineData engine;
/*    */   private final GpsData gps;
/*    */   private final HardwareData hw;
/*    */   private final iButtonData ibutton;
/*    */   private final TemperatureData temp;
/*    */   
/*    */   public Report(byte[] Ack, Integer report_event_number, AuthenticationData auth, CellData cell, Accumulators accumulators, DeviceData device_data, DeviceStatusData device_status, DtcData dtc, EngineData engine, GpsData gps, HardwareData hw, iButtonData ibutton, TemperatureData temp) {
/* 49 */     this.Ack = Ack; this.report_event_number = report_event_number; this.auth = auth; this.cell = cell; this.accumulators = accumulators; this.device_data = device_data; this.device_status = device_status; this.dtc = dtc; this.engine = engine; this.gps = gps; this.hw = hw; this.ibutton = ibutton; this.temp = temp;
/*    */   }
/* 51 */   public byte[] getAck() { return this.Ack; }
/* 52 */   public Integer getReport_event_number() { return this.report_event_number; }
/* 53 */   public AuthenticationData getAuth() { return this.auth; }
/* 54 */   public CellData getCell() { return this.cell; }
/* 55 */   public Accumulators getAccumulators() { return this.accumulators; }
/* 56 */   public DeviceData getDevice_data() { return this.device_data; }
/* 57 */   public DeviceStatusData getDevice_status() { return this.device_status; }
/* 58 */   public DtcData getDtc() { return this.dtc; }
/* 59 */   public EngineData getEngine() { return this.engine; }
/* 60 */   public GpsData getGps() { return this.gps; }
/* 61 */   public HardwareData getHw() { return this.hw; }
/* 62 */   public iButtonData getIbutton() { return this.ibutton; } public TemperatureData getTemp() {
/* 63 */     return this.temp;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toJsonString(boolean prettify) {
/* 71 */     Moshi moshi = (new Moshi.Builder()).add(new ReportJsonAdapter()).build();
/* 72 */     ReportJson report = new ReportJson(this.Ack, this.report_event_number, this.auth, this.cell, this.accumulators, this.device_data, this.device_status, this.dtc, this.engine, this.gps, this.hw, this.ibutton, this.temp);
/*    */     
/* 74 */     JsonAdapter<ReportJson> reportAdapter = moshi.adapter(ReportJson.class);
/* 75 */     if (prettify) {
/* 76 */       return reportAdapter.nullSafe().indent("    ").toJson(report);
/*    */     }
/* 78 */     return reportAdapter.nullSafe().toJson(report);
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\Report.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */