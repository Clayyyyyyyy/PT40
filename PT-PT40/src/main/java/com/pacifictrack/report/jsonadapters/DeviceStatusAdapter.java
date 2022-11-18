/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.DeviceStatusData;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class DeviceStatusAdapter
/*    */ {
/*    */   public static Map<String, String> toJSON(DeviceStatusData status) {
/* 10 */     if (status != null) {
/* 11 */       Map<String, String> result = new HashMap<>();
/*    */       
/* 13 */       String ignition = status.isIgnitionOn() ? "On" : "Off";
/* 14 */       result.put("Ignition", ignition);
/*    */       
/* 16 */       String engine = status.isEngineOn() ? "On" : "Off";
/* 17 */       result.put("Engine", engine);
/*    */       
/* 19 */       String asset = DeviceStatusData.AssetStatus.toString(status.getAssetStatus());
/* 20 */       result.put("Asset Status", asset);
/*    */       
/* 22 */       String ble = status.isEldBleOn() ? "Connected" : "Disconnected";
/* 23 */       result.put("ELD BLE", ble);
/*    */       
/* 25 */       String uart = status.isEldUartOn() ? "Connected" : "Disconnected";
/* 26 */       result.put("ELD UART", uart);
/*    */       
/* 28 */       return result;
/*    */     } 
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\DeviceStatusAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */