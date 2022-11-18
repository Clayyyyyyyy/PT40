/*    */ package com.pacifictrack.report.reportdata;
/*    */ 
/*    */ import com.pacifictrack.utils.Payload;
/*    */ 
/*    */ public class TemperatureData
/*    */ {
/*    */   public TemperatureData(Integer temperature) {
/*  8 */     this.temperature = temperature;
/*    */   } private final Integer temperature;
/*    */   public Integer getTemperature() {
/* 11 */     return this.temperature;
/*    */   }
/*    */   public static Integer parseTemperature(Payload p) {
/* 14 */     return Integer.valueOf(p.getByte());
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\TemperatureData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */