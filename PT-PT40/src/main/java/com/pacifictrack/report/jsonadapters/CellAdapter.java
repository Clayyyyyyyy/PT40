/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.CellData;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class CellAdapter
/*    */ {
/*    */   public static Map<String, Object> toJSON(CellData cell) {
/* 47 */     if (cell == null) {
/* 48 */       return null;
/*    */     }
/* 50 */     Map<String, Object> result = new HashMap<>();
/* 51 */     int rssi = cell.getRSSI();
/* 52 */     int roaming = cell.getRoaming();
/*    */     
/* 54 */     result.put("RSSI", Integer.valueOf(rssi));
/* 55 */     result.put("Roaming", Integer.valueOf(roaming));
/* 56 */     if (cell.getCID() != null) {
/* 57 */       result.put("Mode", Integer.valueOf(cell.getMode()));
/* 58 */       result.put("MCC", cell.getMCC());
/* 59 */       result.put("MNC", cell.getMNC());
/* 60 */       result.put("LAC", cell.getLAC());
/* 61 */       result.put("CID", cell.getCID());
/*    */     } 
/* 63 */     if (cell.getICCID() != null) {
/* 64 */       result.put("ICCID", cell.getICCID());
/*    */     }
/* 66 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\CellAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */