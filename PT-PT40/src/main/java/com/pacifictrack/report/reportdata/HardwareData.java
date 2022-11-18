/*     */ package com.pacifictrack.report.reportdata;
/*     */ 
/*     */ import com.pacifictrack.utils.Payload;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HardwareData
/*     */ {
/*     */   private final HardwareType hardware;
/*     */   
/*     */   public static interface HardwareType
/*     */   {
/*     */     Double getMainVoltage();
/*     */     
/*     */     Double getBackupVoltage();
/*     */     
/*     */     Integer getInput();
/*     */     
/*     */     Integer getOutput();
/*     */     
/*     */     void Output();
/*     */   }
/*     */   
/*     */   public static class HardwareTypeA
/*     */     implements HardwareType
/*     */   {
/*     */     private final Double mainVoltage;
/*     */     private final Double backupVoltage;
/*     */     
/*     */     public HardwareTypeA(Double mainVoltage, Double backupVoltage) {
/*  59 */       this.mainVoltage = mainVoltage; this.backupVoltage = backupVoltage;
/*     */     } public Double getMainVoltage() {
/*  61 */       return this.mainVoltage;
/*     */     } public Double getBackupVoltage() {
/*  63 */       return this.backupVoltage;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getInput() {
/*  69 */       return null; } public Integer getOutput() {
/*  70 */       return null;
/*     */     }
/*     */     public void Output() {
/*  73 */       System.out.format("HW_A Main: %.3fV Backup: %.3fV\n", new Object[] { this.mainVoltage, this.backupVoltage });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class HardwareTypeB
/*     */     extends HardwareTypeA
/*     */   {
/*     */     private final Integer Input;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Integer Output;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public HardwareTypeB(Double main_voltage, Double backup_voltage, Integer Input, Integer Output) {
/*  95 */       super(main_voltage, backup_voltage);
/*  96 */       this.Input = Input;
/*  97 */       this.Output = Output;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getInput() {
/* 106 */       return this.Input;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getOutput() {
/* 115 */       return this.Output;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 123 */       System.out.format("HW_B Input: 0x%02X Output: 0x%02X\n", new Object[] { this.Input, this.Output });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HardwareTypeA parseHardwareDataA(Payload p) {
/* 133 */     Integer temp = Integer.valueOf((int)p.getULong(3));
/* 134 */     Double main_voltage = parseMainVoltage(temp);
/* 135 */     Double backup_voltage = parseBackupVoltage(temp);
/* 136 */     return new HardwareTypeA(main_voltage, backup_voltage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HardwareTypeB parseHardwareDataB(Payload p) {
/* 146 */     Integer IO = parseIO(p);
/* 147 */     return new HardwareTypeB(Double.valueOf(-1.0D), Double.valueOf(-1.0D), Integer.valueOf(IO.intValue() >> 8), Integer.valueOf(IO.intValue() & 0xFF));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double parseMainVoltage(Integer input) {
/* 156 */     return Double.valueOf((input.intValue() >> 12) / 100.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double parseBackupVoltage(Integer input) {
/* 165 */     return Double.valueOf((input.intValue() & 0xFFF) / 100.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseIO(Payload payload) {
/* 174 */     return Integer.valueOf((int)payload.getULong(2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HardwareData(HardwareType data) {
/* 182 */     this.hardware = data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getMainVoltage() {
/* 192 */     return this.hardware.getMainVoltage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getBackupVoltage() {
/* 202 */     return this.hardware.getBackupVoltage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getInput() {
/* 212 */     return this.hardware.getInput();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getOutput() {
/* 222 */     return this.hardware.getOutput();
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\HardwareData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */