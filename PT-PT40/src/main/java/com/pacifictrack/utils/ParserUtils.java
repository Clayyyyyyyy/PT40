/*    */ package com.pacifictrack.utils;
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
/*    */ public final class ParserUtils
/*    */ {
/*    */   public static String ByteArrayToString(byte[] ba) {
/* 42 */     StringBuilder hex = new StringBuilder();
/* 43 */     for (byte i : ba) {
/* 44 */       hex.append(String.format("%02X", new Object[] { Byte.valueOf(i) }));
/*    */     } 
/* 46 */     return hex.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String ConvertStringToHex(byte[] input, int numBytes) {
/* 57 */     StringBuilder sbBytes = new StringBuilder();
/* 58 */     for (int i = 0; i < numBytes; i++) {
/* 59 */       sbBytes.append(String.format("%02X", new Object[] { Byte.valueOf(input[i]) }));
/*    */     } 
/* 61 */     return sbBytes.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte[] getAck(long rptControl) {
/* 71 */     byte[] ack = new byte[3];
/* 72 */     ack[0] = -5;
/* 73 */     ack[1] = (byte)(int)(0x88L | rptControl & 0x3L);
/* 74 */     ack[2] = Byte.MIN_VALUE;
/* 75 */     return ack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrac\\utils\ParserUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */