/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.DtcData;
/*    */ import java.util.List;
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
/*    */ public class DtcAdapter
/*    */ {
/*    */   public static class JsonDtc
/*    */   {
/*    */     private final String Source;
/*    */     private final int Number;
/*    */     private final int MIL;
/*    */     private final List<Map<String, Object>> List;
/*    */     
/*    */     public JsonDtc(String Source, int Number, int MIL, List<Map<String, Object>> list) {
/* 47 */       this.Source = Source; this.Number = Number; this.MIL = MIL; this.List = list;
/*    */     }
/* 49 */     public String getSource() { return this.Source; }
/* 50 */     public int getNumber() { return this.Number; }
/* 51 */     public int getMIL() { return this.MIL; } public List<Map<String, Object>> getList() {
/* 52 */       return this.List;
/*    */     }
/*    */   }
/* 55 */   public static final String[] DtcSource = new String[] { "OBD-II", "J1939", "J1708", "UNKNOWN" };
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
/*    */   public static JsonDtc toJSON(DtcData dtc) {
/* 69 */     if (dtc == null) {
/* 70 */       return null;
/*    */     }
/* 72 */     String type = DtcSource[dtc.getDtcType().ordinal()];
/* 73 */     int noFaults = dtc.getNumberOfFaults().intValue();
/* 74 */     int mil = dtc.getMil().intValue();
/* 75 */     List<Map<String, Object>> faults = dtc.getFaultCodes();
/* 76 */     if (faults.size() == 0) {
/* 77 */       faults = null;
/*    */     }
/* 79 */     return new JsonDtc(type, noFaults, mil, faults);
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\DtcAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */