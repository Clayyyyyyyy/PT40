/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.Accumulators;
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
/*    */ public class AccumulatorAdapter
/*    */ {
/*    */   public static Map<Integer, Long> toJSON(Accumulators acc) {
/* 19 */     if (acc == null) {
/* 20 */       return null;
/*    */     }
/*    */     
/* 23 */     return acc.getAccumulators();
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\AccumulatorAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */