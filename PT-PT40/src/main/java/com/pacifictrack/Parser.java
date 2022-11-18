/*     */ package com.pacifictrack;
/*     */ 
/*     */ import com.pacifictrack.report.Report;
/*     */ import com.pacifictrack.report.ReportBuilder;
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
/*     */ import com.pacifictrack.utils.ParserUtils;
/*     */ import com.pacifictrack.utils.Payload;
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
/*     */ public class Parser
/*     */ {
/*     */   private boolean DEBUG = false;
/*     */   
/*     */   public void enableDebug() {
/*  78 */     this.DEBUG = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disableDebug() {
/*  86 */     this.DEBUG = false;
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
/*     */   public Report Parse(byte[] input, int length) {
/*  98 */     ReportBuilder report = new ReportBuilder();
/*     */ 		
/*     */     
/* 101 */     if (this.DEBUG) {
/* 102 */       System.out.println("RECV: " + ParserUtils.ConvertStringToHex(input, length));
/*     */     }
/*     */     
/* 105 */     Payload p = new Payload(input, length);
				//System.out.println(p.getByte());
/*     */ 
/*     */     
/* 108 */     if (p.getByte() != 251)
/*     */     {
/* 110 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 114 */     long rptControl = p.getBitext();
/* 115 */     if (rptControl == -1L)
/*     */     {
/* 117 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 121 */     long rptLength = p.getBitext();
/* 122 */     if (rptLength == -1L)
/*     */     {
/* 124 */       return null;
/*     */     }
/*     */     
/* 127 */     int currentIndex = p.getIndex();
/* 128 */     if (this.DEBUG) {
/* 129 */       System.out.println("rptControl: 0x" + Integer.toHexString((int)rptControl));
/* 130 */       System.out.println("length: " + rptLength);
/*     */     } 
/*     */ 
/*     */     
/* 134 */     if (rptLength != (length - currentIndex))
/*     */     {
/* 136 */       return null; }  do {
/*     */       int rptEvent; GpsData.GpsTypeA rpt; HardwareData.HardwareTypeA hardwareTypeA; CellData.CellTypeA typeA; DeviceData deviceData; DeviceStatusData data; Map<Integer, Long> acc; int busType; EngineData engine;
/*     */       String sIMEI, sSerial, iSerial;
/*     */       Integer temp;
/*     */       int mil, numDTC;
/*     */       DtcData.OBD2 obd2;
/*     */       DtcData.J1708 j1708;
/*     */       DtcData.J1939 j1939;
/* 144 */       int segmentId = (int)p.getBitext();
/* 145 */       int segmentLength = (int)p.getBitext();
/* 146 */       switch (segmentId) {
/*     */         case 1:
/* 148 */           rptEvent = (int)p.getBitext();
/* 149 */           report.setReportNumber(Integer.valueOf(rptEvent));
/*     */ 
/*     */           
/* 152 */           if (this.DEBUG) {
/* 153 */             System.out.println("Event: 0x" + Integer.toHexString(rptEvent));
/*     */           }
/*     */           break;
/*     */         
/*     */         case 16:
/*     */         case 17:
/*     */         case 18:
/* 160 */           rpt = GpsData.parseGpsTypeA(p);
/* 161 */           report.setTypeA(rpt);
/*     */ 
/*     */           
/* 164 */           if (this.DEBUG) {
/* 165 */             rpt.Output();
/*     */           }
/*     */           
/* 168 */           if (segmentId >= 17) {
/* 169 */             GpsData.GpsTypeB rptB = GpsData.parseGpsTypeB(p);
/*     */             
/* 171 */             report.setTypeB(rptB);
/*     */ 
/*     */             
/* 174 */             if (this.DEBUG) {
/* 175 */               rptB.Output();
/*     */             }
/*     */           } 
/* 178 */           if (segmentId >= 18) {
/* 179 */             GpsData.GpsTypeC rptC = GpsData.parseGpsTypeC(p);
/*     */             
/* 181 */             report.setTypeC(rptC);
/*     */ 
/*     */             
/* 184 */             if (this.DEBUG) {
/* 185 */               rptC.Output();
/*     */             }
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 32:
/*     */         case 33:
/* 192 */           hardwareTypeA = HardwareData.parseHardwareDataA(p);
/* 193 */           report.setHwA(hardwareTypeA);
/*     */ 
/*     */           
/* 196 */           if (this.DEBUG) {
/* 197 */             hardwareTypeA.Output();
/*     */           }
/*     */           
/* 200 */           if (segmentId == 33) {
/* 201 */             HardwareData.HardwareTypeB typeB = HardwareData.parseHardwareDataB(p);
/* 202 */             report.setHwB(typeB);
/*     */ 
/*     */             
/* 205 */             if (this.DEBUG) {
/* 206 */               typeB.Output();
/*     */             }
/*     */           } 
/*     */           break;
/*     */ 
/*     */         
/*     */         case 48:
/*     */         case 49:
/*     */         case 50:
/* 215 */           typeA = CellData.parseCellTypeA(p);
/*     */ 
/*     */           
/* 218 */           report.setCellA(typeA);
/*     */ 
/*     */           
/* 221 */           if (this.DEBUG) {
/* 222 */             typeA.Output();
/*     */           }
/*     */           
/* 225 */           if (segmentId >= 49) {
/*     */             
/* 227 */             CellData.CellTypeB typeB = CellData.parseCellTypeB(p);
/*     */ 
/*     */             
/* 230 */             report.setCellB(typeB);
/*     */ 
/*     */             
/* 233 */             if (this.DEBUG) {
/* 234 */               typeB.Output();
/*     */             }
/*     */           } 
/*     */           
/* 238 */           if (segmentId == 50) {
/*     */             
/* 240 */             CellData.CellTypeC typeC = CellData.parseCellTypeC(p, segmentLength);
/*     */ 
/*     */             
/* 243 */             report.setCellC(typeC);
/*     */ 
/*     */             
/* 246 */             if (this.DEBUG) {
/* 247 */               typeC.Output();
/*     */             }
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 64:
/* 253 */           deviceData = DeviceData.parseDeviceData(p);
/* 254 */           report.setDevice_data(deviceData);
/*     */           break;
/*     */         
/*     */         case 66:
/* 258 */           data = DeviceStatusData.parseDeviceStatus(p);
/* 259 */           report.setDevice_status(data);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 80:
/* 264 */           acc = Accumulators.parseAccumulators(p, segmentLength);
/*     */           
/* 266 */           report.setAccumulators(acc);
/*     */           break;
/*     */         
/*     */         case 144:
/* 270 */           busType = p.getByte();
/* 271 */           mil = busType >> 7;
/* 272 */           numDTC = p.getByte();
/* 273 */           switch (busType & 0xF) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 1:
/* 280 */               obd2 = DtcData.parseOBDII(p, Integer.valueOf(numDTC), Integer.valueOf(mil));
/* 281 */               report.setDtcType(DtcData.DtcType.OBDII);
/* 282 */               report.setObd2(obd2);
/*     */ 
/*     */               
/* 285 */               if (this.DEBUG) {
/* 286 */                 obd2.Output();
/*     */               }
/*     */               break;
/*     */ 
/*     */ 
/*     */             
/*     */             case 2:
/* 293 */               j1708 = DtcData.parseJ1708(p, Integer.valueOf(numDTC), Integer.valueOf(mil));
/* 294 */               report.setDtcType(DtcData.DtcType.J1708);
/* 295 */               report.setJ1708(j1708);
/*     */               
/* 297 */               if (this.DEBUG) {
/* 298 */                 j1708.Output();
/*     */               }
/*     */               break;
/*     */ 
/*     */             
/*     */             case 4:
/* 304 */               j1939 = DtcData.parseJ1939(p, Integer.valueOf(numDTC), Integer.valueOf(mil));
/* 305 */               report.setDtcType(DtcData.DtcType.J1939);
/* 306 */               report.setJ1939(j1939);
/*     */               
/* 308 */               if (this.DEBUG) {
/* 309 */                 j1939.Output();
/*     */               }
/*     */               break;
/*     */           } 
/*     */ 
/*     */           
/*     */           break;
/*     */         
/*     */         case 146:
/* 318 */           engine = EngineData.parseEngineData(p, Integer.valueOf(segmentLength));
/* 319 */           report.setEngine(engine);
/* 320 */           if (this.DEBUG) {
/* 321 */             engine.Output();
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case 256:
/* 327 */           sIMEI = AuthenticationData.parseIMEI(p, segmentLength);
/* 328 */           report.setIMEI(sIMEI);
/*     */ 
/*     */           
/* 331 */           if (this.DEBUG) {
/* 332 */             System.out.format("AUTH IMEI: %s\n", new Object[] { sIMEI });
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case 259:
/* 338 */           sSerial = AuthenticationData.parseSerial(p, segmentLength);
/* 339 */           report.setSerialNo(sSerial);
/*     */ 
/*     */           
/* 342 */           if (this.DEBUG) {
/* 343 */             System.out.format("AUTH SERIAL: %s\n", new Object[] { sSerial });
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case 288:
/* 349 */           iSerial = iButtonData.parseIButton(p, segmentLength);
/* 350 */           report.setIButton(iSerial);
/*     */           
/* 352 */           if (this.DEBUG) {
/* 353 */             System.out.format("iButton Serial: %s\n", new Object[] { iSerial });
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case 296:
/* 359 */           temp = TemperatureData.parseTemperature(p);
/* 360 */           report.setTemperature(temp);
/*     */           
/* 362 */           if (this.DEBUG) {
/* 363 */             System.out.format("Temperature: %d\n", new Object[] { temp });
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case -1:
/* 369 */           return null;
/*     */ 
/*     */         
/*     */         default:
/* 373 */           if (this.DEBUG) {
/* 374 */             System.out.println("SegmentId 0x" + Integer.toHexString(segmentId) + " not decoded");
/*     */           }
/*     */           
/* 377 */           p.setIndex(p.getIndex() + segmentLength);
/*     */           break;
/*     */       } 
/*     */     
/* 381 */     } while (p.getIndex() < length);
/*     */ 
/*     */ 
/*     */     
/* 385 */     if ((rptControl & 0x4L) != 0L) {
/* 386 */       byte[] ack = ParserUtils.getAck(rptControl);
/* 387 */       report.setAck(ack);
/*     */     } 
/*     */ 
/*     */     
/* 391 */     return report.build();
/*     */   }
/*     */ }




/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\Parser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */