/*     */ package com.pacifictrack.report;
/*     */ 
/*     */ import com.pacifictrack.report.reportdata.Accumulators;
/*     */ import com.pacifictrack.report.reportdata.AuthenticationData;
/*     */ import com.pacifictrack.report.reportdata.CellData;
/*     */ import com.pacifictrack.report.reportdata.DeviceData;
/*     */ import com.pacifictrack.report.reportdata.DeviceStatusData;
/*     */ import com.pacifictrack.report.reportdata.DtcData;
/*     */ import com.pacifictrack.report.reportdata.EngineData;
/*     */ import com.pacifictrack.report.reportdata.GpsData;
/*     */ import com.pacifictrack.report.reportdata.HardwareData;
/*     */ import com.pacifictrack.report.reportdata.TemperatureData;
/*     */ import com.pacifictrack.report.reportdata.iButtonData;
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
/*     */ public final class ReportBuilder
/*     */ {
/*     */   private byte[] ack;
/*     */   private Integer reportNumber;
/*     */   private String IMEI;
/*     */   private String SerialNo;
/*     */   private CellData.CellTypeA cellA;
/*     */   private CellData.CellTypeB cellB;
/*     */   private CellData.CellTypeC cellC;
/*     */   private HardwareData.HardwareTypeA hwA;
/*     */   private HardwareData.HardwareTypeB hwB;
/*     */   private Map<Integer, Long> accumulators;
/*     */   private DeviceData device_data;
/*     */   private DeviceStatusData device_status;
/*     */   private DtcData.DtcType dtcType;
/*     */   private DtcData.OBD2 obd2;
/*     */   private DtcData.J1708 j1708;
/*     */   private DtcData.J1939 j1939;
/*     */   private GpsData.GpsTypeA typeA;
/*     */   private GpsData.GpsTypeB typeB;
/*     */   private GpsData.GpsTypeC typeC;
/*     */   private EngineData engine;
/*     */   private String iButton;
/*     */   private Integer temperature;
/*     */   
/*     */   public void setAck(byte[] ack) {
/*  54 */     this.ack = ack; } public void setReportNumber(Integer reportNumber) { this.reportNumber = reportNumber; } public void setIMEI(String IMEI) { this.IMEI = IMEI; } public void setSerialNo(String SerialNo) { this.SerialNo = SerialNo; } public void setCellA(CellData.CellTypeA cellA) { this.cellA = cellA; } public void setCellB(CellData.CellTypeB cellB) { this.cellB = cellB; } public void setCellC(CellData.CellTypeC cellC) { this.cellC = cellC; } public void setHwA(HardwareData.HardwareTypeA hwA) { this.hwA = hwA; } public void setHwB(HardwareData.HardwareTypeB hwB) { this.hwB = hwB; } public void setAccumulators(Map<Integer, Long> accumulators) { this.accumulators = accumulators; } public void setDevice_data(DeviceData device_data) { this.device_data = device_data; } public void setDevice_status(DeviceStatusData device_status) { this.device_status = device_status; } public void setDtcType(DtcData.DtcType dtcType) { this.dtcType = dtcType; } public void setObd2(DtcData.OBD2 obd2) { this.obd2 = obd2; } public void setJ1708(DtcData.J1708 j1708) { this.j1708 = j1708; } public void setJ1939(DtcData.J1939 j1939) { this.j1939 = j1939; } public void setTypeA(GpsData.GpsTypeA typeA) { this.typeA = typeA; } public void setTypeB(GpsData.GpsTypeB typeB) { this.typeB = typeB; } public void setTypeC(GpsData.GpsTypeC typeC) { this.typeC = typeC; } public void setEngine(EngineData engine) { this.engine = engine; } public void setIButton(String iButton) { this.iButton = iButton; } public void setTemperature(Integer temperature) { this.temperature = temperature; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportBuilder() {
/*  61 */     this.reportNumber = null;
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
/*     */   public Report build() {
/*     */     HardwareData hw;
/*     */     DtcData dtc;
/* 112 */     AuthenticationData auth = new AuthenticationData(this.IMEI, this.SerialNo);
/*     */     
/* 114 */     CellData cell = null;
/* 115 */     if (this.cellC == null && this.cellB == null) {
/* 116 */       if (this.cellA != null) {
/* 117 */         cell = new CellData((CellData.CellType)this.cellA);
/*     */       }
/* 119 */     } else if (this.cellC == null && this.cellA != null) {
/* 120 */       if (this.cellB != null) {
/*     */         
/* 122 */         CellData.CellTypeB temp = new CellData.CellTypeB(this.cellA.getRoaming(), this.cellA.getRSSI(), this.cellB.getMode(), this.cellB.getMCC(), this.cellB.getMNC(), this.cellB.getLAC(), this.cellB.getCID());
/* 123 */         cell = new CellData((CellData.CellType)temp);
/*     */       } 
/* 125 */     } else if (this.cellA != null && this.cellB != null && 
/* 126 */       this.cellC != null) {
/*     */       
/* 128 */       CellData.CellTypeC temp = new CellData.CellTypeC(this.cellA.getRoaming(), this.cellA.getRSSI(), this.cellB.getMode(), this.cellB.getMCC(), this.cellB.getMNC(), this.cellB.getLAC(), this.cellB.getCID(), this.cellC.getICCID());
/* 129 */       cell = new CellData((CellData.CellType)temp);
/*     */     } 
/*     */ 
/*     */     
/* 133 */     GpsData gps = null;
/* 134 */     if (this.typeC == null && this.typeB == null) {
/* 135 */       if (this.typeA != null) {
/* 136 */         gps = new GpsData((GpsData.GpsReport)this.typeA);
/*     */       }
/* 138 */     } else if (this.typeC == null && this.typeB != null) {
/*     */       
/* 140 */       this
/*     */ 
/*     */         
/* 143 */         .typeB = new GpsData.GpsTypeB(this.typeA.getGpsFix(), this.typeA.getSatellites(), this.typeA.getDateTime(), this.typeA.getLatitude(), this.typeA.getLongitude(), this.typeA.getHeading(), this.typeA.getGpsSpeed(), this.typeA.getReportSequence(), this.typeB.getAltitude(), this.typeB.getDOP(), this.typeB.getAge());
/* 144 */       gps = new GpsData((GpsData.GpsReport)this.typeB);
/* 145 */     } else if (this.typeC != null) {
/*     */       
/* 147 */       this
/*     */ 
/*     */         
/* 150 */         .typeC = new GpsData.GpsTypeC(this.typeA.getGpsFix(), this.typeA.getSatellites(), this.typeA.getDateTime(), this.typeA.getLatitude(), this.typeA.getLongitude(), this.typeA.getHeading(), this.typeA.getGpsSpeed(), this.typeA.getReportSequence(), this.typeB.getAltitude(), this.typeB.getDOP(), this.typeB.getAge(), this.typeC.getRtcDateTime());
/* 151 */       gps = new GpsData((GpsData.GpsReport)this.typeC);
/*     */     } 
/*     */ 
/*     */     
/* 155 */     if (this.hwB == null && this.hwA != null) {
/* 156 */       hw = new HardwareData((HardwareData.HardwareType)this.hwA);
/* 157 */     } else if (this.hwB != null && this.hwA != null) {
/*     */       
/* 159 */       this.hwB = new HardwareData.HardwareTypeB(this.hwA.getMainVoltage(), this.hwA.getBackupVoltage(), this.hwB.getInput(), this.hwB.getOutput());
/* 160 */       hw = new HardwareData((HardwareData.HardwareType)this.hwB);
/*     */     } else {
/* 162 */       hw = null;
/*     */     } 
/*     */     
/* 165 */     Accumulators acc = (this.accumulators != null) ? new Accumulators(this.accumulators) : null;
/*     */ 
/*     */     
/* 168 */     if (this.dtcType != null)
/* 169 */     { iButtonData button; TemperatureData temp; switch (this.dtcType)
/*     */       { case OBDII:
/* 171 */           dtc = new DtcData((DtcData.Fault)this.obd2);
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
/* 186 */           button = new iButtonData(this.iButton);
/* 187 */           temp = new TemperatureData(this.temperature);
/*     */           
/* 189 */           return new Report(this.ack, this.reportNumber, auth, cell, acc, this.device_data, this.device_status, dtc, this.engine, gps, hw, button, temp);case J1939: dtc = new DtcData((DtcData.Fault)this.j1939); button = new iButtonData(this.iButton); temp = new TemperatureData(this.temperature); return new Report(this.ack, this.reportNumber, auth, cell, acc, this.device_data, this.device_status, dtc, this.engine, gps, hw, button, temp);case J1708: dtc = new DtcData((DtcData.Fault)this.j1708); button = new iButtonData(this.iButton); temp = new TemperatureData(this.temperature); return new Report(this.ack, this.reportNumber, auth, cell, acc, this.device_data, this.device_status, dtc, this.engine, gps, hw, button, temp); }  dtc = null; } else { dtc = null; }  iButtonData iButtonData = new iButtonData(this.iButton); TemperatureData temperatureData = new TemperatureData(this.temperature); return new Report(this.ack, this.reportNumber, auth, cell, acc, this.device_data, this.device_status, dtc, this.engine, gps, hw, iButtonData, temperatureData);
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\ReportBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */