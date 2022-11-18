/*    */ package com.pacifictrack.report.reportdata;
/*    */ 
/*    */ import com.pacifictrack.utils.Payload;
/*    */ 
/*    */ public class iButtonData
/*    */ {
/*    */   public iButtonData(String serial) {
/*  8 */     this.serial = serial;
/*    */   } private final String serial;
/*    */   public String getSerial() {
/* 11 */     return this.serial;
/*    */   }
/*    */   private static boolean isHex(Integer i) {
/* 14 */     return (i.intValue() >= 10 && i.intValue() <= 15);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String parseIButton(Payload p, int segmentLength) {
/* 19 */     byte[] serial = p.getByteArray((byte)segmentLength);
/* 20 */     StringBuilder iButtonSer = new StringBuilder();
/* 21 */     for (byte i : serial) {
/* 22 */       int firstByte = (i & 0xF0) >> 4;
/* 23 */       int secondByte = i & 0xF;
/* 24 */       firstByte = isHex(Integer.valueOf(firstByte)) ? (firstByte + 55) : (firstByte + 48);
/* 25 */       secondByte = isHex(Integer.valueOf(secondByte)) ? (secondByte + 55) : (secondByte + 48);
/* 26 */       iButtonSer.append((char)firstByte);
/* 27 */       iButtonSer.append((char)secondByte);
/*    */     } 
/* 29 */     return iButtonSer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\iButtonData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */