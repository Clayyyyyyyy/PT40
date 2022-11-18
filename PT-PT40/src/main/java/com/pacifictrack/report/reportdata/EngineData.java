/*     */ package com.pacifictrack.report.reportdata;
/*     */ 
/*     */ import com.pacifictrack.utils.Payload;
/*     */ 
/*     */ public class EngineData {
/*     */   private final Integer bus;
/*     */   private final Integer computedOdometer;
/*     */   private final Integer computedEngineHours;
/*     */   private final Integer gear;
/*     */   private final Integer seatBelt;
/*     */   private final Integer engineRPM;
/*     */   private final Integer engineSpeed;
/*     */   private final Long oilPressure;
/*     */   private final Long oilTemperature;
/*     */   private final Long coolantTemperature;
/*     */   private final Long IntakeTemperature;
/*     */   private final Long fuelTankTemperature;
/*     */   private final Long intercoolerTemperature;
/*     */   private final Long turboOilTemperature;
/*     */   private final Long transmissionOilTemperature;
/*     */   private final Long dtc_no;
/*     */   private final Double ambientTemperature;
/*     */   private final Double engineOdometer;
/*     */   private final Long engineLoad;
/*     */   private final Double oilLevelPercent;
/*     */   private final Double coolantLevelPercent;
/*     */   private final Double fuelLevelPercent;
/*     */   private final Double fuelLevel2Percent;
/*     */   private final Double defLevelPercent;
/*     */   private final Double engineFuelRate;
/*     */   private final Double engineFuelEconomy;
/*     */   private final Double ambientPressure;
/*     */   private final Double totalEngineHours;
/*     */   private final Double totalEngineIdleTime;
/*     */   private final Double totalPtoTime;
/*     */   private final Double totalEngineIdleFuel;
/*     */   private final Double totalFuelUsed;
/*     */   private final String VIN;
/*     */   
/*     */   public EngineData(Integer bus, Integer computedOdometer, Integer computedEngineHours, Integer gear, Integer seatBelt, Integer engineRPM, Integer engineSpeed, Long oilPressure, Long oilTemperature, Long coolantTemperature, Long IntakeTemperature, Long fuelTankTemperature, Long intercoolerTemperature, Long turboOilTemperature, Long transmissionOilTemperature, Long dtc_no, Double ambientTemperature, Double engineOdometer, Long engineLoad, Double oilLevelPercent, Double coolantLevelPercent, Double fuelLevelPercent, Double fuelLevel2Percent, Double defLevelPercent, Double engineFuelRate, Double engineFuelEconomy, Double ambientPressure, Double totalEngineHours, Double totalEngineIdleTime, Double totalPtoTime, Double totalEngineIdleFuel, Double totalFuelUsed, String VIN) {
/*  41 */     this.bus = bus; this.computedOdometer = computedOdometer; this.computedEngineHours = computedEngineHours; this.gear = gear; this.seatBelt = seatBelt; this.engineRPM = engineRPM; this.engineSpeed = engineSpeed; this.oilPressure = oilPressure; this.oilTemperature = oilTemperature; this.coolantTemperature = coolantTemperature; this.IntakeTemperature = IntakeTemperature; this.fuelTankTemperature = fuelTankTemperature; this.intercoolerTemperature = intercoolerTemperature; this.turboOilTemperature = turboOilTemperature; this.transmissionOilTemperature = transmissionOilTemperature; this.dtc_no = dtc_no; this.ambientTemperature = ambientTemperature; this.engineOdometer = engineOdometer; this.engineLoad = engineLoad; this.oilLevelPercent = oilLevelPercent; this.coolantLevelPercent = coolantLevelPercent; this.fuelLevelPercent = fuelLevelPercent; this.fuelLevel2Percent = fuelLevel2Percent; this.defLevelPercent = defLevelPercent; this.engineFuelRate = engineFuelRate; this.engineFuelEconomy = engineFuelEconomy; this.ambientPressure = ambientPressure; this.totalEngineHours = totalEngineHours; this.totalEngineIdleTime = totalEngineIdleTime; this.totalPtoTime = totalPtoTime; this.totalEngineIdleFuel = totalEngineIdleFuel; this.totalFuelUsed = totalFuelUsed; this.VIN = VIN;
/*     */   }
/*  43 */   public Integer getBus() { return this.bus; }
/*  44 */   public Integer getComputedOdometer() { return this.computedOdometer; }
/*  45 */   public Integer getComputedEngineHours() { return this.computedEngineHours; }
/*  46 */   public Integer getGear() { return this.gear; }
/*  47 */   public Integer getSeatBelt() { return this.seatBelt; }
/*  48 */   public Integer getEngineRPM() { return this.engineRPM; }
/*  49 */   public Integer getEngineSpeed() { return this.engineSpeed; }
/*  50 */   public Long getOilPressure() { return this.oilPressure; }
/*  51 */   public Long getOilTemperature() { return this.oilTemperature; }
/*  52 */   public Long getCoolantTemperature() { return this.coolantTemperature; }
/*  53 */   public Long getIntakeTemperature() { return this.IntakeTemperature; }
/*  54 */   public Long getFuelTankTemperature() { return this.fuelTankTemperature; }
/*  55 */   public Long getIntercoolerTemperature() { return this.intercoolerTemperature; }
/*  56 */   public Long getTurboOilTemperature() { return this.turboOilTemperature; }
/*  57 */   public Long getTransmissionOilTemperature() { return this.transmissionOilTemperature; }
/*  58 */   public Long getDtc_no() { return this.dtc_no; }
/*  59 */   public Double getAmbientTemperature() { return this.ambientTemperature; }
/*  60 */   public Double getEngineOdometer() { return this.engineOdometer; }
/*  61 */   public Long getEngineLoad() { return this.engineLoad; }
/*  62 */   public Double getOilLevelPercent() { return this.oilLevelPercent; }
/*  63 */   public Double getCoolantLevelPercent() { return this.coolantLevelPercent; }
/*  64 */   public Double getFuelLevelPercent() { return this.fuelLevelPercent; }
/*  65 */   public Double getFuelLevel2Percent() { return this.fuelLevel2Percent; }
/*  66 */   public Double getDefLevelPercent() { return this.defLevelPercent; }
/*  67 */   public Double getEngineFuelRate() { return this.engineFuelRate; }
/*  68 */   public Double getEngineFuelEconomy() { return this.engineFuelEconomy; }
/*  69 */   public Double getAmbientPressure() { return this.ambientPressure; }
/*  70 */   public Double getTotalEngineHours() { return this.totalEngineHours; }
/*  71 */   public Double getTotalEngineIdleTime() { return this.totalEngineIdleTime; }
/*  72 */   public Double getTotalPtoTime() { return this.totalPtoTime; }
/*  73 */   public Double getTotalEngineIdleFuel() { return this.totalEngineIdleFuel; }
/*  74 */   public Double getTotalFuelUsed() { return this.totalFuelUsed; } public String getVIN() {
/*  75 */     return this.VIN;
/*     */   }
/*     */   public static class EngineDataBuilder {
/*     */     private Integer bus; private Integer computedOdometer; private Integer computedEngineHours; private Integer gear; private Integer seatBelt; private Integer engineRPM; private Long oilPressure; private Long oilTemperature; private Long coolantTemperature; private Long IntakeTemperature; private Integer engineSpeed; private Long fuelTankTemperature; private Long intercoolerTemperature; private Long turboOilTemperature; private Long transmissionOilTemperature;
/*     */     private Long dtc_no;
/*     */     
/*  81 */     public void setBus(Integer bus) { this.bus = bus; } private Double ambientTemperature; private Double engineOdometer; private Long engineLoad; private Double oilLevelPercent; private Double coolantLevelPercent; private Double fuelLevelPercent; private Double fuelLevel2Percent; private Double defLevelPercent; private Double engineFuelRate; private Double engineFuelEconomy; private Double ambientPressure; private Double totalEngineHours; private Double totalEngineIdleTime; private Double totalPtoTime; private Double totalEngineIdleFuel; private Double totalFuelUsed; private String VIN; public void setComputedOdometer(Integer computedOdometer) { this.computedOdometer = computedOdometer; } public void setComputedEngineHours(Integer computedEngineHours) { this.computedEngineHours = computedEngineHours; } public void setGear(Integer gear) { this.gear = gear; } public void setSeatBelt(Integer seatBelt) { this.seatBelt = seatBelt; } public void setEngineRPM(Integer engineRPM) { this.engineRPM = engineRPM; } public void setOilPressure(Long oilPressure) { this.oilPressure = oilPressure; } public void setOilTemperature(Long oilTemperature) { this.oilTemperature = oilTemperature; } public void setCoolantTemperature(Long coolantTemperature) { this.coolantTemperature = coolantTemperature; } public void setIntakeTemperature(Long IntakeTemperature) { this.IntakeTemperature = IntakeTemperature; } public void setEngineSpeed(Integer engineSpeed) { this.engineSpeed = engineSpeed; } public void setFuelTankTemperature(Long fuelTankTemperature) { this.fuelTankTemperature = fuelTankTemperature; } public void setIntercoolerTemperature(Long intercoolerTemperature) { this.intercoolerTemperature = intercoolerTemperature; } public void setTurboOilTemperature(Long turboOilTemperature) { this.turboOilTemperature = turboOilTemperature; } public void setTransmissionOilTemperature(Long transmissionOilTemperature) { this.transmissionOilTemperature = transmissionOilTemperature; } public void setDtc_no(Long dtc_no) { this.dtc_no = dtc_no; } public void setAmbientTemperature(Double ambientTemperature) { this.ambientTemperature = ambientTemperature; } public void setEngineOdometer(Double engineOdometer) { this.engineOdometer = engineOdometer; } public void setEngineLoad(Long engineLoad) { this.engineLoad = engineLoad; } public void setOilLevelPercent(Double oilLevelPercent) { this.oilLevelPercent = oilLevelPercent; } public void setCoolantLevelPercent(Double coolantLevelPercent) { this.coolantLevelPercent = coolantLevelPercent; } public void setFuelLevelPercent(Double fuelLevelPercent) { this.fuelLevelPercent = fuelLevelPercent; } public void setFuelLevel2Percent(Double fuelLevel2Percent) { this.fuelLevel2Percent = fuelLevel2Percent; } public void setDefLevelPercent(Double defLevelPercent) { this.defLevelPercent = defLevelPercent; } public void setEngineFuelRate(Double engineFuelRate) { this.engineFuelRate = engineFuelRate; } public void setEngineFuelEconomy(Double engineFuelEconomy) { this.engineFuelEconomy = engineFuelEconomy; } public void setAmbientPressure(Double ambientPressure) { this.ambientPressure = ambientPressure; } public void setTotalEngineHours(Double totalEngineHours) { this.totalEngineHours = totalEngineHours; } public void setTotalEngineIdleTime(Double totalEngineIdleTime) { this.totalEngineIdleTime = totalEngineIdleTime; } public void setTotalPtoTime(Double totalPtoTime) { this.totalPtoTime = totalPtoTime; } public void setTotalEngineIdleFuel(Double totalEngineIdleFuel) { this.totalEngineIdleFuel = totalEngineIdleFuel; } public void setTotalFuelUsed(Double totalFuelUsed) { this.totalFuelUsed = totalFuelUsed; } public void setVIN(String VIN) { this.VIN = VIN; }
/*     */     
/*  83 */     public Integer getBus() { return this.bus; }
/*  84 */     public Integer getComputedOdometer() { return this.computedOdometer; }
/*  85 */     public Integer getComputedEngineHours() { return this.computedEngineHours; }
/*  86 */     public Integer getGear() { return this.gear; }
/*  87 */     public Integer getSeatBelt() { return this.seatBelt; }
/*  88 */     public Integer getEngineRPM() { return this.engineRPM; }
/*  89 */     public Long getOilPressure() { return this.oilPressure; }
/*  90 */     public Long getOilTemperature() { return this.oilTemperature; }
/*  91 */     public Long getCoolantTemperature() { return this.coolantTemperature; }
/*  92 */     public Long getIntakeTemperature() { return this.IntakeTemperature; }
/*  93 */     public Integer getEngineSpeed() { return this.engineSpeed; }
/*  94 */     public Long getFuelTankTemperature() { return this.fuelTankTemperature; }
/*  95 */     public Long getIntercoolerTemperature() { return this.intercoolerTemperature; }
/*  96 */     public Long getTurboOilTemperature() { return this.turboOilTemperature; }
/*  97 */     public Long getTransmissionOilTemperature() { return this.transmissionOilTemperature; }
/*  98 */     public Long getDtc_no() { return this.dtc_no; }
/*  99 */     public Double getAmbientTemperature() { return this.ambientTemperature; }
/* 100 */     public Double getEngineOdometer() { return this.engineOdometer; }
/* 101 */     public Long getEngineLoad() { return this.engineLoad; }
/* 102 */     public Double getOilLevelPercent() { return this.oilLevelPercent; }
/* 103 */     public Double getCoolantLevelPercent() { return this.coolantLevelPercent; }
/* 104 */     public Double getFuelLevelPercent() { return this.fuelLevelPercent; }
/* 105 */     public Double getFuelLevel2Percent() { return this.fuelLevel2Percent; }
/* 106 */     public Double getDefLevelPercent() { return this.defLevelPercent; }
/* 107 */     public Double getEngineFuelRate() { return this.engineFuelRate; }
/* 108 */     public Double getEngineFuelEconomy() { return this.engineFuelEconomy; }
/* 109 */     public Double getAmbientPressure() { return this.ambientPressure; }
/* 110 */     public Double getTotalEngineHours() { return this.totalEngineHours; }
/* 111 */     public Double getTotalEngineIdleTime() { return this.totalEngineIdleTime; }
/* 112 */     public Double getTotalPtoTime() { return this.totalPtoTime; }
/* 113 */     public Double getTotalEngineIdleFuel() { return this.totalEngineIdleFuel; }
/* 114 */     public Double getTotalFuelUsed() { return this.totalFuelUsed; } public String getVIN() {
/* 115 */       return this.VIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public EngineData build() {
/* 123 */       return new EngineData(this.bus, this.computedOdometer, this.computedEngineHours, this.gear, this.seatBelt, this.engineRPM, this.engineSpeed, this.oilPressure, this.oilTemperature, this.coolantTemperature, this.IntakeTemperature, this.fuelTankTemperature, this.intercoolerTemperature, this.turboOilTemperature, this.transmissionOilTemperature, this.dtc_no, this.ambientTemperature, this.engineOdometer, this.engineLoad, this.oilLevelPercent, this.coolantLevelPercent, this.fuelLevelPercent, this.fuelLevel2Percent, this.defLevelPercent, this.engineFuelRate, this.engineFuelEconomy, this.ambientPressure, this.totalEngineHours, this.totalEngineIdleTime, this.totalPtoTime, this.totalEngineIdleFuel, this.totalFuelUsed, this.VIN);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void Output() {
/* 135 */     System.out.format("ENG CURRENT BUS: %d\n", new Object[] { this.bus });
/* 136 */     System.out.format("ENG CURRENT GEAR: %d\n", new Object[] { this.gear });
/* 137 */     System.out.format("ENG SEATBELT: %d\n", new Object[] { this.seatBelt });
/* 138 */     System.out.format("ENG Speed: %d km/h\n", new Object[] { this.engineSpeed });
/* 139 */     System.out.format("ENG RPM: %d\n", new Object[] { this.engineRPM });
/* 140 */     System.out.format("ENG DTC#: %d\n", new Object[] { this.dtc_no });
/* 141 */     System.out.format("ENG VIN: %s\n", new Object[] { this.VIN });
/* 142 */     System.out.format("ENG OIL P: %d kPa\n", new Object[] { this.oilPressure });
/* 143 */     System.out.format("ENG OIL L: %.1f %%\n", new Object[] { this.oilLevelPercent });
/* 144 */     System.out.format("ENG OIL T: %d C\n", new Object[] { this.oilTemperature });
/* 145 */     System.out.format("ENG COOLANT L: %.1f %%\n", new Object[] { this.coolantLevelPercent });
/* 146 */     System.out.format("ENG COOLANT T: %d C\n", new Object[] { this.coolantTemperature });
/* 147 */     System.out.format("ENG FUEL L1: %.1f %%\n", new Object[] { this.fuelLevelPercent });
/* 148 */     System.out.format("ENG FUEL L2: %.1f %%\n", new Object[] { this.fuelLevel2Percent });
/* 149 */     System.out.format("ENG DEF L: %.1f %%\n", new Object[] { this.defLevelPercent });
/* 150 */     System.out.format("ENG LOAD: %d %%\n", new Object[] { this.engineLoad });
/* 151 */     System.out.format("ENG AMBIENT P: %.1f kPa\n", new Object[] { this.ambientPressure });
/* 152 */     System.out.format("ENG INTAKE T: %d C\n", new Object[] { this.IntakeTemperature });
/* 153 */     System.out.format("ENG FUEL T: %d C\n", new Object[] { this.fuelTankTemperature });
/* 154 */     System.out.format("ENG INTERCOOLER T: %d C\n", new Object[] { this.intercoolerTemperature });
/* 155 */     System.out.format("ENG TURBO OIL T: %d C\n", new Object[] { this.turboOilTemperature });
/* 156 */     System.out.format("ENG TRANS OIL T: %d C\n", new Object[] { this.transmissionOilTemperature });
/* 157 */     System.out.format("ENG FUEL RATE: %.2f l/h\n", new Object[] { this.engineFuelRate });
/* 158 */     System.out.format("ENG FUEL ECONOMY: %.3f km/l\n", new Object[] { this.engineFuelEconomy });
/* 159 */     System.out.format("ENG AMBIENT TEMP: %.2f C\n", new Object[] { this.ambientTemperature });
/* 160 */     System.out.format("ENG ODOMETER: %.1f km\n", new Object[] { this.engineOdometer });
/* 161 */     System.out.format("ENG ENGINE HRS: %.2f hr\n", new Object[] { this.totalEngineHours });
/* 162 */     System.out.format("ENG IDLE HRS: %.2f hr\n", new Object[] { this.totalEngineIdleTime });
/* 163 */     System.out.format("ENG PTO HRS: %.2f hr\n", new Object[] { this.totalPtoTime });
/* 164 */     System.out.format("ENG TOTAL FUEL IDLE: %.1f l\n", new Object[] { this.totalEngineIdleFuel });
/* 165 */     System.out.format("ENG TOTAL FUEL USED: %.1f l\n", new Object[] { this.totalFuelUsed });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EngineData parseEngineData(Payload p, Integer length) {
/* 177 */     EngineDataBuilder builder = new EngineDataBuilder();
/*     */     
/* 179 */     Integer engineLength = length;
/*     */ 
/*     */     
/* 182 */     while (engineLength.intValue() > 0) {
/*     */       int sublength; long value; Integer bus, gear, seatbelt, Engine_RPM; Double engineFuelRate, Engine_Odometer; Integer computedOdometer; Long engineOilPressure; Double engineFuelEconomy, Total_Engine_Hours; Integer computedEngineHours; Double OilLevelPercent, ambientTemp, Total_Engine_Idle_Time; Long OilTemp; Double Total_PTO_Time, CoolantLevelPercent, Total_Engine_Idle_Fuel; Long Coolant_Temp; Double Total_Fuel_Used, FuelLevelPercent, FuelLevelPercent2, DefLevelPercent, AmbientPressure; Long Intake_Temp, Fuel_Temp, Intercooler_Temp, Turbo_Temp, Trans_Temp;
/* 184 */       int type = p.getByte();
/* 185 */       engineLength = Integer.valueOf(engineLength.intValue() - 1);
/* 186 */       int subtype = type >> 5;
/* 187 */       switch (subtype) {
/*     */ 
/*     */         
/*     */         case 0:
/* 191 */           bus = Integer.valueOf(type & 0x7);
/* 192 */           builder.setBus(bus);
/* 193 */           computedOdometer = Integer.valueOf(type >> 3 & 0x1);
/* 194 */           builder.setComputedOdometer(computedOdometer);
/* 195 */           computedEngineHours = Integer.valueOf(type >> 4 & 0x1);
/* 196 */           builder.setComputedEngineHours(computedEngineHours);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 202 */           gear = Integer.valueOf(type & 0x1F);
/* 203 */           builder.setGear(gear);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 209 */           seatbelt = Integer.valueOf(type & 0x1F);
/* 210 */           builder.setSeatBelt(seatbelt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 4:
/* 218 */           value = p.getByte();
/* 219 */           engineLength = Integer.valueOf(engineLength.intValue() - 1);
/* 220 */           switch (type) {
/*     */             
/*     */             case 128:
/* 223 */               builder.setEngineSpeed(Integer.valueOf((int)value));
/*     */ 
/*     */             
/*     */             case 129:
/* 227 */               Engine_RPM = Integer.valueOf(Math.toIntExact(value) * 32);
/* 228 */               builder.setEngineRPM(Engine_RPM);
/*     */ 
/*     */             
/*     */             case 130:
/* 232 */               builder.setDtc_no(Long.valueOf(value));
/*     */ 
/*     */             
/*     */             case 131:
/* 236 */               engineOilPressure = Long.valueOf(value * 4L);
/* 237 */               builder.setOilPressure(engineOilPressure);
/*     */ 
/*     */             
/*     */             case 132:
/* 241 */               OilLevelPercent = Double.valueOf(value * 0.4D);
/* 242 */               builder.setOilLevelPercent(OilLevelPercent);
/*     */             
/*     */             case 133:
/* 245 */               OilTemp = Long.valueOf(value - 40L);
/* 246 */               builder.setOilTemperature(OilTemp);
/*     */ 
/*     */             
/*     */             case 134:
/* 250 */               CoolantLevelPercent = Double.valueOf(value * 0.4D);
/* 251 */               builder.setCoolantLevelPercent(CoolantLevelPercent);
/*     */             
/*     */             case 135:
/* 254 */               Coolant_Temp = Long.valueOf(value - 40L);
/* 255 */               builder.setCoolantTemperature(Coolant_Temp);
/*     */ 
/*     */             
/*     */             case 136:
/* 259 */               FuelLevelPercent = Double.valueOf(value * 0.4D);
/* 260 */               builder.setFuelLevelPercent(FuelLevelPercent);
/*     */ 
/*     */             
/*     */             case 145:
/* 264 */               FuelLevelPercent2 = Double.valueOf(value * 0.4D);
/* 265 */               builder.setFuelLevel2Percent(FuelLevelPercent2);
/*     */ 
/*     */             
/*     */             case 137:
/* 269 */               DefLevelPercent = Double.valueOf(value * 0.4D);
/* 270 */               builder.setDefLevelPercent(DefLevelPercent);
/*     */ 
/*     */             
/*     */             case 138:
/* 274 */               builder.setEngineLoad(Long.valueOf(value));
/*     */             
/*     */             case 139:
/* 277 */               AmbientPressure = Double.valueOf(value / 2.0D);
/* 278 */               builder.setAmbientPressure(AmbientPressure);
/*     */             
/*     */             case 140:
/* 281 */               Intake_Temp = Long.valueOf(value - 40L);
/* 282 */               builder.setIntakeTemperature(Intake_Temp);
/*     */             
/*     */             case 141:
/* 285 */               Fuel_Temp = Long.valueOf(value - 40L);
/* 286 */               builder.setFuelTankTemperature(Fuel_Temp);
/*     */             
/*     */             case 142:
/* 289 */               Intercooler_Temp = Long.valueOf(value - 40L);
/* 290 */               builder.setIntercoolerTemperature(Intercooler_Temp);
/*     */             
/*     */             case 143:
/* 293 */               Turbo_Temp = Long.valueOf(value - 40L);
/* 294 */               builder.setTurboOilTemperature(Turbo_Temp);
/*     */             
/*     */             case 144:
/* 297 */               Trans_Temp = Long.valueOf(value - 40L);
/* 298 */               builder.setTransmissionOilTemperature(Trans_Temp);
/*     */           } 
/*     */         
/*     */         
/*     */ 
/*     */         
/*     */         case 5:
/* 305 */           value = p.getULong(2);
/* 306 */           engineLength = Integer.valueOf(engineLength.intValue() - 2);
/* 307 */           switch (type) {
/*     */             
/*     */             case 160:
/* 310 */               engineFuelRate = Double.valueOf(value * 0.05D);
/* 311 */               builder.setEngineFuelRate(engineFuelRate);
/*     */ 
/*     */             
/*     */             case 161:
/* 315 */               engineFuelEconomy = Double.valueOf(value / 512.0D);
/* 316 */               builder.setEngineFuelEconomy(engineFuelEconomy);
/*     */             
/*     */             case 162:
/* 319 */               ambientTemp = Double.valueOf(value * 0.03125D - 273.0D);
/* 320 */               builder.setAmbientTemperature(ambientTemp);
/*     */           } 
/*     */         
/*     */         
/*     */         
/*     */         case 6:
/* 326 */           value = p.getULong(4);
/* 327 */           engineLength = Integer.valueOf(engineLength.intValue() - 4);
/* 328 */           switch (type) {
/*     */             
/*     */             case 192:
/* 331 */               Engine_Odometer = Double.valueOf(value * 0.1D);
/* 332 */               builder.setEngineOdometer(Engine_Odometer);
/*     */ 
/*     */             
/*     */             case 193:
/* 336 */               Total_Engine_Hours = Double.valueOf(value * 0.05D);
/* 337 */               builder.setTotalEngineHours(Total_Engine_Hours);
/*     */ 
/*     */             
/*     */             case 194:
/* 341 */               Total_Engine_Idle_Time = Double.valueOf(value * 0.05D);
/* 342 */               builder.setTotalEngineIdleTime(Total_Engine_Idle_Time);
/*     */ 
/*     */             
/*     */             case 195:
/* 346 */               Total_PTO_Time = Double.valueOf(value * 0.05D);
/* 347 */               builder.setTotalPtoTime(Total_PTO_Time);
/*     */ 
/*     */             
/*     */             case 196:
/* 351 */               Total_Engine_Idle_Fuel = Double.valueOf(value * 0.5D);
/* 352 */               builder.setTotalEngineIdleFuel(Total_Engine_Idle_Fuel);
/*     */ 
/*     */             
/*     */             case 197:
/* 356 */               Total_Fuel_Used = Double.valueOf(value * 0.5D);
/* 357 */               builder.setTotalFuelUsed(Total_Fuel_Used);
/*     */           } 
/*     */         
/*     */         
/*     */ 
/*     */         
/*     */         case 7:
/* 364 */           sublength = p.getByte();
/* 365 */           engineLength = Integer.valueOf(engineLength.intValue() - 1 + sublength);
/* 366 */           if (type == 224) {
/* 367 */             byte[] vin = p.getByteArray(sublength);
/* 368 */             String sVin = new String(vin);
/* 369 */             builder.setVIN(sVin); continue;
/*     */           } 
/* 371 */           p.getByteArray(sublength);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 378 */     return builder.build();
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\EngineData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */