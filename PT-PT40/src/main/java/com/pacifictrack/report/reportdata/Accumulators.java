/*    */ package com.pacifictrack.report.reportdata;
/*    */ 
/*    */ import com.pacifictrack.utils.Payload;
/*    */ import java.util.Hashtable;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class Accumulators {
/*    */   private final Map<Integer, Long> accumulators;
/*    */   
/*    */   public Accumulators(Map<Integer, Long> accumulators) {
/* 11 */     this.accumulators = accumulators;
/*    */   } public Map<Integer, Long> getAccumulators() {
/* 13 */     return this.accumulators;
/*    */   }
/*    */   public static Map<Integer, Long> parseAccumulators(Payload p, int SegmentLength) {
/* 16 */     Map<Integer, Long> accumulators = new Hashtable<>();
/* 17 */     int numberOfAcc = SegmentLength / 5;
/* 18 */     for (int i = 0; i < numberOfAcc; i++) {
/* 19 */       int num = p.getByte();
/* 20 */       long value = p.getULong(4);
/* 21 */       accumulators.put(Integer.valueOf(num), Long.valueOf(value));
/*    */     } 
/* 23 */     return accumulators;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\Accumulators.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */