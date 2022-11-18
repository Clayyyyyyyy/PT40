/*     */ package com.pacifictrack.report.reportdata;
/*     */ 
/*     */ import com.pacifictrack.utils.ParserUtils;
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
/*     */ public class CellData
/*     */ {
/*     */   private final CellType cellular;
/*     */   
/*     */   public static interface CellType
/*     */   {
/*     */     int getRoaming();
/*     */     
/*     */     int getRSSI();
/*     */     
/*     */     int getMode();
/*     */     
/*     */     String getMCC();
/*     */     
/*     */     String getMNC();
/*     */     
/*     */     String getLAC();
/*     */     
/*     */     String getCID();
/*     */     
/*     */     String getICCID();
/*     */     
/*     */     void Output();
/*     */   }
/*     */   
/*     */   public static class CellTypeA
/*     */     implements CellType
/*     */   {
/*     */     private final int roaming;
/*     */     private final int RSSI;
/*     */     
/*     */     public int getRoaming() {
/*  60 */       return this.roaming;
/*     */     } public int getRSSI() {
/*  62 */       return this.RSSI;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CellTypeA(int roaming, int rssi) {
/*  71 */       this.roaming = roaming;
/*  72 */       this.RSSI = rssi;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getMode() {
/*  81 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getMCC() {
/*  90 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getMNC() {
/*  98 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getLAC() {
/* 106 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getCID() {
/* 115 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getICCID() {
/* 124 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 131 */       System.out.format("CELL_A Roaming: %d RSSI: %d\n", new Object[] { Integer.valueOf(this.roaming), Integer.valueOf(this.RSSI) });
/*     */     } }
/*     */   
/*     */   public static class CellTypeB extends CellTypeA {
/*     */     private final int mode;
/*     */     private final String MCC;
/*     */     private final String MNC;
/*     */     private final String LAC;
/*     */     private final String CID;
/*     */     
/*     */     public int getMode() {
/* 142 */       return this.mode;
/*     */     }
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
/*     */     public CellTypeB(int roaming, int rssi, int mode, String mcc, String mnc, String lac, String cid) {
/* 161 */       super(roaming, rssi);
/* 162 */       this.mode = mode;
/* 163 */       this.MCC = mcc;
/* 164 */       this.MNC = mnc;
/* 165 */       this.LAC = lac;
/* 166 */       this.CID = cid;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getMCC() {
/* 176 */       return this.MCC;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getMNC() {
/* 184 */       return this.MNC;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getLAC() {
/* 194 */       return this.LAC;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getCID() {
/* 204 */       return this.CID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 212 */       System.out.format("CELL_B Mode: 0x%02X MCC: %s MNC: %s \n", new Object[] { Integer.valueOf(this.mode), this.MCC, this.MNC });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CellTypeC
/*     */     extends CellTypeB
/*     */   {
/*     */     private final String iccid;
/*     */ 
/*     */     
/*     */     public CellTypeC(int roaming, int rssi, int mode, String MCC, String MNC, String LAC, String CID, String iccid) {
/* 224 */       super(roaming, rssi, mode, MCC, MNC, LAC, CID);
/* 225 */       this.iccid = iccid;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getICCID() {
/* 230 */       return this.iccid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void Output() {
/* 235 */       System.out.format("CELL_C ICCID: %s \n", new Object[] { this.iccid });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CellTypeA parseCellTypeA(Payload p) {
/* 246 */     int rnr = p.getByte();
/*     */     
/* 248 */     int roaming = parseRoamingStatus(rnr);
/* 249 */     int rssi = parseRSSI(rnr);
/*     */     
/* 251 */     return new CellTypeA(roaming, rssi);
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
/*     */   public static CellTypeB parseCellTypeB(Payload p) {
/* 263 */     int mode = p.getByte();
/*     */     
/* 265 */     byte[] MCC_MNC_LAC_CID = p.getByteArray(9);
/* 266 */     String str = ParserUtils.ByteArrayToString(MCC_MNC_LAC_CID);
/* 267 */     String mcc = str.substring(0, 3);
/* 268 */     String mnc = str.substring(3, 6);
/* 269 */     String LAC = str.substring(6, 10);
/* 270 */     String CID = str.substring(10, 18);
/*     */     
/* 272 */     return new CellTypeB(-1, -1, mode, mcc, mnc, LAC, CID);
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
/*     */   public static CellTypeC parseCellTypeC(Payload p, int segment_length) {
/* 284 */     int thisLength = segment_length - 11;
/*     */     
/* 286 */     byte[] iccid = p.getByteArray(thisLength);
/* 287 */     String ICCID = ParserUtils.ByteArrayToString(iccid).substring(0, thisLength * 2);
/*     */     
/* 289 */     return new CellTypeC(-1, -1, -1, null, null, null, null, ICCID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int parseRoamingStatus(int rnr) {
/* 299 */     return (rnr & 0x80) >> 7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int parseRSSI(int rnr) {
/* 309 */     int temp = rnr & 0x1F;
/* 310 */     return (temp == 0) ? 99 : temp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellData(CellType report) {
/* 319 */     this.cellular = report;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRoaming() {
/* 329 */     return this.cellular.getRoaming();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRSSI() {
/* 339 */     return this.cellular.getRSSI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMode() {
/* 349 */     return this.cellular.getMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMCC() {
/* 358 */     return this.cellular.getMCC();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMNC() {
/* 366 */     return this.cellular.getMNC();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLAC() {
/* 375 */     return this.cellular.getLAC();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCID() {
/* 385 */     return this.cellular.getCID();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getICCID() {
/* 395 */     return this.cellular.getICCID();
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\CellData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */