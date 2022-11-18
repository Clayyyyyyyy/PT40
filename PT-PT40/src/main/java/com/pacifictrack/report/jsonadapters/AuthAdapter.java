/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.AuthenticationData;
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
/*    */ public class AuthAdapter
/*    */ {
/*    */   public static String toJSON(AuthenticationData auth) {
/* 45 */     if (auth == null || (auth.getImei() == null && auth.getSerialNo() == null)) {
/* 46 */       return null;
/*    */     }
/* 48 */     String result = "";
/* 49 */     if (auth.getImei() != null) {
/* 50 */       result = auth.getImei();
/*    */     }
/* 52 */     if (auth.getSerialNo() != null) {
/* 53 */       result = auth.getSerialNo();
/*    */     }
/* 55 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\AuthAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */