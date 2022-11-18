/*    */ package com.pacifictrack.report.reportdata;
/*    */ 
/*    */ import com.pacifictrack.utils.ParserUtils;
/*    */ import com.pacifictrack.utils.Payload;
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
/*    */ public class AuthenticationData
/*    */ {
/*    */   private final String imei;
/*    */   private final String serialNo;
/*    */   
/*    */   public AuthenticationData(String imei, String serialNo) {
/* 40 */     this.imei = imei; this.serialNo = serialNo;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getImei() {
/* 46 */     return this.imei;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSerialNo() {
/* 51 */     return this.serialNo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String parseIMEI(Payload p, int segmentLength) {
/* 62 */     byte[] imei = p.getByteArray((byte)segmentLength);
/* 63 */     return ParserUtils.ByteArrayToString(imei).substring(0, 15);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String parseSerial(Payload p, int segmentLength) {
/* 74 */     byte[] serial = p.getByteArray((byte)segmentLength);
/* 75 */     return new String(serial);
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\AuthenticationData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */