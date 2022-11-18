/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.HardwareData;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HwAdapter
/*    */ {
/*    */   private static Map<String, Object> getHwA(HardwareData hw) {
/* 15 */     Map<String, Object> result = new HashMap<>();
/*    */     
/* 17 */     result.put("MainVoltage", hw.getMainVoltage());
/* 18 */     result.put("BackupVoltage", hw.getBackupVoltage());
/*    */     
/* 20 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Map<String, Object> toJSON(HardwareData hw) {
/*    */     Map<String, Object> result;
/* 32 */     if (hw == null) {
/* 33 */       return null;
/*    */     }
/*    */ 
/*    */     
/* 37 */     if (hw.getInput() == null && hw.getOutput() == null) {
/* 38 */       result = getHwA(hw);
/*    */     } else {
/* 40 */       result = getHwA(hw);
/* 41 */       result.put("Input", hw.getInput());
/* 42 */       result.put("Output", hw.getOutput());
/*    */     } 
/*    */     
/* 45 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\HwAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */