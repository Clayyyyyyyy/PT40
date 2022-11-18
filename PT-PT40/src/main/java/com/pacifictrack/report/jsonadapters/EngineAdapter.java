/*     */ package com.pacifictrack.report.jsonadapters;
/*     */ 
/*     */ import com.pacifictrack.report.reportdata.EngineData;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EngineAdapter
/*     */ {
/*     */   public static Map<String, Object> toJSON(EngineData engine) {
/*  47 */     if (engine == null) {
/*  48 */       return null;
/*     */     }
/*  50 */     Map<String, Object> result = new HashMap<>();
/*  51 */     if (engine.getBus() != null) {
/*  52 */       result.put("Bus", engine.getBus());
/*  53 */       String yesno = (engine.getComputedOdometer().intValue() == 1) ? "Yes" : "No";
/*  54 */       result.put("OdometerComputed", yesno);
/*  55 */       yesno = (engine.getComputedEngineHours().intValue() == 1) ? "Yes" : "No";
/*  56 */       result.put("EngineHoursComputed", yesno);
/*     */     } 
/*  58 */     if (engine.getGear() != null) {
/*  59 */       result.put("Gear", engine.getGear());
/*     */     }
/*  61 */     if (engine.getSeatBelt() != null) {
/*  62 */       result.put("Seatbelt", engine.getSeatBelt());
/*     */     }
/*  64 */     if (engine.getEngineRPM() != null) {
/*  65 */       result.put("RPM", engine.getEngineRPM());
/*     */     }
/*  67 */     if (engine.getEngineSpeed() != null) {
/*  68 */       result.put("Speed", engine.getEngineSpeed());
/*     */     }
/*  70 */     if (engine.getOilPressure() != null) {
/*  71 */       result.put("OilPressure", engine.getOilPressure());
/*     */     }
/*  73 */     if (engine.getOilTemperature() != null) {
/*  74 */       result.put("OilTemp", engine.getOilTemperature());
/*     */     }
/*  76 */     if (engine.getCoolantTemperature() != null) {
/*  77 */       result.put("CoolantTemp", engine.getCoolantTemperature());
/*     */     }
/*  79 */     if (engine.getIntakeTemperature() != null) {
/*  80 */       result.put("IntakeTemp", engine.getIntakeTemperature());
/*     */     }
/*  82 */     if (engine.getFuelTankTemperature() != null) {
/*  83 */       result.put("FuelTankTemp", engine.getFuelTankTemperature());
/*     */     }
/*  85 */     if (engine.getIntercoolerTemperature() != null) {
/*  86 */       result.put("IntercoolerTemp", engine.getIntercoolerTemperature());
/*     */     }
/*  88 */     if (engine.getTurboOilTemperature() != null) {
/*  89 */       result.put("TurboOilTemp", engine.getTurboOilTemperature());
/*     */     }
/*  91 */     if (engine.getTransmissionOilTemperature() != null) {
/*  92 */       result.put("TransmissionOilTemp", engine.getTransmissionOilTemperature());
/*     */     }
/*  94 */     if (engine.getDtc_no() != null) {
/*  95 */       result.put("NumDTC", engine.getDtc_no());
/*     */     }
/*  97 */     if (engine.getAmbientTemperature() != null) {
/*  98 */       result.put("AmbientTemp", engine.getAmbientTemperature());
/*     */     }
/* 100 */     if (engine.getEngineOdometer() != null) {
/* 101 */       result.put("Odometer", engine.getEngineOdometer());
/*     */     }
/* 103 */     if (engine.getEngineLoad() != null) {
/* 104 */       result.put("EngineLoad", engine.getEngineLoad());
/*     */     }
/* 106 */     if (engine.getOilLevelPercent() != null) {
/* 107 */       result.put("OilLevelPct", engine.getOilLevelPercent());
/*     */     }
/* 109 */     if (engine.getCoolantLevelPercent() != null) {
/* 110 */       result.put("CoolantLevelPct", engine.getCoolantLevelPercent());
/*     */     }
/* 112 */     if (engine.getFuelLevelPercent() != null) {
/* 113 */       result.put("FuelLevelPct", engine.getFuelLevelPercent());
/*     */     }
/* 115 */     if (engine.getFuelLevel2Percent() != null) {
/* 116 */       result.put("FuelLevel2Pct", engine.getFuelLevel2Percent());
/*     */     }
/* 118 */     if (engine.getDefLevelPercent() != null) {
/* 119 */       result.put("DefLevelPct", engine.getDefLevelPercent());
/*     */     }
/* 121 */     if (engine.getEngineFuelRate() != null) {
/* 122 */       result.put("FuelRate", engine.getEngineFuelRate());
/*     */     }
/* 124 */     if (engine.getEngineFuelEconomy() != null) {
/* 125 */       result.put("FuelEconomy", engine.getEngineFuelEconomy());
/*     */     }
/* 127 */     if (engine.getAmbientPressure() != null) {
/* 128 */       result.put("AmbientPressure", engine.getAmbientPressure());
/*     */     }
/* 130 */     if (engine.getTotalEngineHours() != null) {
/* 131 */       result.put("EngineHours", engine.getTotalEngineHours());
/*     */     }
/* 133 */     if (engine.getTotalEngineIdleTime() != null) {
/* 134 */       result.put("IdleHours", engine.getTotalEngineIdleTime());
/*     */     }
/* 136 */     if (engine.getTotalPtoTime() != null) {
/* 137 */       result.put("PtoHours", engine.getTotalPtoTime());
/*     */     }
/* 139 */     if (engine.getTotalEngineIdleFuel() != null) {
/* 140 */       result.put("FuelIdle", engine.getTotalEngineIdleFuel());
/*     */     }
/* 142 */     if (engine.getTotalFuelUsed() != null) {
/* 143 */       result.put("FuelUsed", engine.getTotalFuelUsed());
/*     */     }
/* 145 */     if (engine.getVIN() != null) {
/* 146 */       result.put("VIN", engine.getVIN());
/*     */     }
/*     */     
/* 149 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\EngineAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */