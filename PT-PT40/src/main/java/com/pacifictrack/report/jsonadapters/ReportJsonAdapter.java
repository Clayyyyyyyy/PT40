/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

/*    */ import java.util.Map;
/*    */ 
/*    */ public class ReportJsonAdapter {
/*    */   private static class JsonObject {
/*    */     private final Integer Event;
/*    */     private final String UniqueID;
/*    */     private final Map<String, Object> CELL;
/*    */     private final Map<Integer, Long> accumulators;
/*    */     private final DeviceDataAdapter.DeviceDataJson device_data;
/*    */     private final Map<String, String> device_status;
/*    */     private final DtcAdapter.JsonDtc DTC;
/*    */     private final Map<String, Object> GPS;
/*    */     private final Map<String, Object> HW;
/*    */     private final Map<String, Object> Engine;
/*    */     private final String iButton;
/*    */     private final Integer oneWireTemp1;
/*    */     
/*    */     public JsonObject(Integer Event, String UniqueID, Map<String, Object> CELL, Map<Integer, Long> accumulators, DeviceDataAdapter.DeviceDataJson device_data, Map<String, String> device_status, DtcAdapter.JsonDtc DTC, Map<String, Object> GPS, Map<String, Object> HW, Map<String, Object> Engine, String iButton, Integer oneWireTemp1) {
/* 21 */       this.Event = Event; this.UniqueID = UniqueID; this.CELL = CELL; this.accumulators = accumulators; this.device_data = device_data; this.device_status = device_status; this.DTC = DTC; this.GPS = GPS; this.HW = HW; this.Engine = Engine; this.iButton = iButton; this.oneWireTemp1 = oneWireTemp1;
/*    */     }
/*    */     
/* 24 */     public Integer getEvent() { return this.Event; }
/* 25 */     public String getUniqueID() { return this.UniqueID; }
/* 26 */     public Map<String, Object> getCELL() { return this.CELL; }
/* 27 */     public Map<Integer, Long> getAccumulators() { return this.accumulators; }
/* 28 */     public DeviceDataAdapter.DeviceDataJson getDevice_data() { return this.device_data; }
/* 29 */     public Map<String, String> getDevice_status() { return this.device_status; }
/* 30 */     public DtcAdapter.JsonDtc getDTC() { return this.DTC; }
/* 31 */     public Map<String, Object> getGPS() { return this.GPS; }
/* 32 */     public Map<String, Object> getHW() { return this.HW; }
/* 33 */     public Map<String, Object> getEngine() { return this.Engine; }
/* 34 */     public String getIButton() { return this.iButton; } public Integer getOneWireTemp1() {
/* 35 */       return this.oneWireTemp1;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @ToJson
/*    */   public JsonObject toJSON(ReportJson report) {
/* 47 */     Integer reportNumber = report.getEventValue();
/* 48 */     String auth = AuthAdapter.toJSON(report.getAuthentication());
/* 49 */     Map<String, Object> cellular = CellAdapter.toJSON(report.getCellular());
/* 50 */     Map<Integer, Long> acc = AccumulatorAdapter.toJSON(report.getAccumulators());
/* 51 */     DeviceDataAdapter.DeviceDataJson device = DeviceDataAdapter.toJSON(report.getDevice_data());
/* 52 */     Map<String, String> deviceStatus = DeviceStatusAdapter.toJSON(report.getDevice_status());
/* 53 */     DtcAdapter.JsonDtc dtc = DtcAdapter.toJSON(report.getDtc());
/* 54 */     Map<String, Object> gps = GpsAdapter.toJSON(report.getGps());
/* 55 */     Map<String, Object> hardware = HwAdapter.toJSON(report.getHw());
/* 56 */     Map<String, Object> engine = EngineAdapter.toJSON(report.getEngine());
/* 57 */     String ibuttonSerial = report.getIbutton().getSerial();
/* 58 */     Integer temp = report.getTemp().getTemperature();
/* 59 */     return new JsonObject(reportNumber, auth, cellular, acc, device, deviceStatus, dtc, gps, hardware, engine, ibuttonSerial, temp);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @FromJson
/*    */   public ReportJson fromJSON(String report) {
/* 69 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\ReportJsonAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */