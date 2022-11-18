/*     */ package com.pacifictrack.report.reportdata;
/*     */ 
/*     */ import com.pacifictrack.utils.Payload;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
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
/*     */ public class DtcData
/*     */ {
/*     */   private final Fault data;
/*     */   
/*     */   public enum DtcType
/*     */   {
/*  51 */     OBDII,
/*     */ 
/*     */ 
/*     */     
/*  55 */     J1939,
/*     */ 
/*     */ 
/*     */     
/*  59 */     J1708,
/*     */ 
/*     */ 
/*     */     
/*  63 */     UNKNOWN;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Fault
/*     */   {
/*     */     Integer mil;
/*     */ 
/*     */     
/*     */     abstract Integer getMil();
/*     */ 
/*     */     
/*     */     abstract DtcData.DtcType getDtcType();
/*     */ 
/*     */     
/*     */     abstract Integer getNumberOfFaults();
/*     */ 
/*     */     
/*     */     abstract List<Map<String, Object>> getFaults();
/*     */   }
/*     */ 
/*     */   
/*     */   public static class OBD2
/*     */     extends Fault
/*     */   {
/*     */     private final Integer number_of_faults;
/*     */     
/*     */     private final List<Map<String, Object>> faults;
/*     */ 
/*     */     
/*     */     public OBD2(Integer mil, Integer number_of_faults, List<Map<String, Object>> faults) {
/*  94 */       this.mil = mil;
/*  95 */       this.number_of_faults = number_of_faults;
/*  96 */       this.faults = faults;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DtcData.DtcType getDtcType() {
/* 103 */       return DtcData.DtcType.OBDII;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getMil() {
/* 110 */       return this.mil;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getNumberOfFaults() {
/* 117 */       return this.number_of_faults;
/*     */     }
/*     */     
/*     */     public List<Map<String, Object>> getFaults() {
/* 121 */       return this.faults;
/*     */     }
/*     */     
/*     */     public void Output() {
/* 125 */       System.out.format("DTC MIL: %d DTC#: %d ", new Object[] { this.mil, this.number_of_faults });
/* 126 */       System.out.format("BUS: OBD-II CODES:", new Object[0]);
/* 127 */       for (Map<String, Object> fault : this.faults) {
/* 128 */         System.out.format(" [%s]", new Object[] { fault.get("CODE") });
/*     */       } 
/* 130 */       System.out.println("\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class J1708
/*     */     extends Fault
/*     */   {
/*     */     private final Integer numberOfFaults;
/*     */     private final List<Map<String, Object>> faults;
/*     */     
/*     */     public J1708(Integer numberOfFaults, List<Map<String, Object>> faults, Integer mil) {
/* 142 */       this.numberOfFaults = numberOfFaults;
/* 143 */       this.faults = faults;
/* 144 */       this.mil = mil;
/*     */     }
/*     */     
/*     */     public Integer getMil() {
/* 148 */       return this.mil;
/*     */     }
/*     */     
/*     */     public DtcData.DtcType getDtcType() {
/* 152 */       return DtcData.DtcType.J1708;
/*     */     }
/*     */     
/*     */     public Integer getNumberOfFaults() {
/* 156 */       return this.numberOfFaults;
/*     */     }
/*     */     
/*     */     public List<Map<String, Object>> getFaults() {
/* 160 */       return this.faults;
/*     */     }
/*     */     
/*     */     public void Output() {
/* 164 */       System.out.format("BUS: J1708", new Object[0]);
/* 165 */       System.out.format("DTC MIL: %d DTC#: %d ", new Object[] { this.mil, this.numberOfFaults });
/* 166 */       for (Map<String, Object> value : this.faults) {
/* 167 */         int sid = ((Integer)value.get("sid_pid")).intValue();
/* 168 */         int isSid = ((Integer)value.get("isSID")).intValue();
/* 169 */         int isExpansion = ((Integer)value.get("isExpansion")).intValue();
/* 170 */         int isActive = ((Integer)value.get("isActive")).intValue();
/* 171 */         int fmi = ((Integer)value.get("failureModeIdentifier")).intValue();
/* 172 */         int oc = ((Integer)value.get("occurrenceCount")).intValue();
/* 173 */         String formatted = String.format("[SID_PID:%d, IS_SID:%d, IS_EXPANSION:%d, IS_ACTIVE:%d, FMI:%d, OC:%d]", new Object[] {
/*     */               
/* 175 */               Integer.valueOf(sid), Integer.valueOf(isSid), Integer.valueOf(isExpansion), Integer.valueOf(isActive), Integer.valueOf(fmi), Integer.valueOf(oc) });
/* 176 */         System.out.format(" [%s]\n", new Object[] { formatted });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class J1939
/*     */     extends Fault
/*     */   {
/*     */     private final List<Map<String, Object>> faults;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Integer number_of_faults;
/*     */ 
/*     */ 
/*     */     
/*     */     public J1939(Integer mil, List<Map<String, Object>> faults, Integer number_of_dtc) {
/* 196 */       this.mil = mil;
/* 197 */       this.faults = faults;
/* 198 */       this.number_of_faults = number_of_dtc;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getMil() {
/* 206 */       return this.mil;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getNumberOfFaults() {
/* 214 */       return this.number_of_faults;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DtcData.DtcType getDtcType() {
/* 223 */       return DtcData.DtcType.J1939;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<Map<String, Object>> getFaults() {
/* 231 */       return this.faults;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 238 */       System.out.format("BUS: J1939 CODES:", new Object[0]);
/* 239 */       System.out.format("DTC MIL: %d DTC#: %d ", new Object[] { this.mil, this.number_of_faults });
/*     */       
/* 241 */       for (Map<String, Object> value : this.faults) {
/* 242 */         StringBuilder spnString; if (((Integer)value.get("ConversionMethod")).intValue() == 0) {
/* 243 */           spnString = new StringBuilder(Integer.toString(((Integer)value.get("SPN")).intValue()));
/*     */         } else {
/*     */           
/* 246 */           spnString = new StringBuilder("[");
/*     */           
/* 248 */           ArrayList<Integer> it = (ArrayList<Integer>)value.get("SPN");
/* 249 */           for (Integer i : it) {
/* 250 */             spnString.append(i);
/* 251 */             spnString.append(", ");
/*     */           } 
/* 253 */           spnString.append("]");
/*     */         } 
/* 255 */         int oc = ((Integer)value.get("occurrenceCount")).intValue();
/* 256 */         int fmi = ((Integer)value.get("failureModeIdentifier")).intValue();
/* 257 */         int cm = ((Integer)value.get("conversionMethod")).intValue();
/* 258 */         String formatted = String.format("SPN:%s, OC:%d, FMI:%d, CM:%d", new Object[] { spnString
/* 259 */               .toString(), Integer.valueOf(oc), Integer.valueOf(fmi), Integer.valueOf(cm) });
/* 260 */         System.out.format("[%s]", new Object[] { formatted });
/*     */       } 
/* 262 */       System.out.println("\n");
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
/*     */ 
/*     */   
/*     */   public static OBD2 parseOBDII(Payload p, Integer numberOfDtc, Integer mil) {
/* 276 */     List<Map<String, Object>> list = new ArrayList<>();
/* 277 */     for (int i = 0; i < numberOfDtc.intValue(); i++) {
/* 278 */       Map<String, Object> faults = new HashMap<>();
/* 279 */       Integer nextdtc = Integer.valueOf((int)p.getULong(2));
/* 280 */       String dtcString = parseObdErrorCode(nextdtc);
/* 281 */       faults.put("Code", dtcString);
/*     */       
/* 283 */       list.add(faults);
/*     */     } 
/* 285 */     return new OBD2(mil, numberOfDtc, list);
/*     */   }
/*     */   
/*     */   private static Integer parseJ1708SidOrPid(Integer error) {
/* 289 */     int SidPid = error.intValue() >> 16;
/*     */     
/* 291 */     if ((error.intValue() & 0x2000) != 0) {
/* 292 */       SidPid += 256;
/*     */     }
/* 294 */     return Integer.valueOf(SidPid);
/*     */   }
/*     */   
/*     */   private static Integer parseJ1708OccurrenceCount(Integer error) {
/* 298 */     if ((error.intValue() & 0x8000) != 0) {
/* 299 */       return Integer.valueOf(error.intValue() & 0xFF);
/*     */     }
/* 301 */     return Integer.valueOf(0);
/*     */   }
/*     */   
/*     */   private static Integer parseJ1708CurrentStatus(Integer error) {
/* 305 */     return Integer.valueOf((error.intValue() & 0x4000) >> 14);
/*     */   }
/*     */   
/*     */   private static Integer parseJ1708IsSid(Integer error) {
/* 309 */     return Integer.valueOf((error.intValue() & 0x1000) >> 12);
/*     */   }
/*     */   
/*     */   private static Integer parseJ1708FailureMode(Integer error) {
/* 313 */     return Integer.valueOf(error.intValue() >> 8 & 0xF);
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
/*     */   public static J1708 parseJ1708(Payload p, Integer numberOfDtc, Integer mil) {
/* 325 */     List<Map<String, Object>> list = new ArrayList<>();
/* 326 */     for (int i = 0; i < numberOfDtc.intValue(); i++) {
/* 327 */       Map<String, Object> faults = new HashMap<>();
/* 328 */       Integer nextdtc = Integer.valueOf((int)p.getULong(3));
/*     */       
/* 330 */       Integer sid_pid = parseJ1708SidOrPid(nextdtc);
/* 331 */       Integer oc = parseJ1708OccurrenceCount(nextdtc);
/* 332 */       Integer cs = parseJ1708CurrentStatus(nextdtc);
/* 333 */       Integer isSID = parseJ1708IsSid(nextdtc);
/* 334 */       Integer fmi = parseJ1708FailureMode(nextdtc);
/*     */       
/* 336 */       faults.put("SID_PID", sid_pid);
/* 337 */       faults.put("OccurrenceCount", oc);
/* 338 */       faults.put("isActive", cs);
/* 339 */       faults.put("isSID", isSID);
/* 340 */       faults.put("FMI", fmi);
/*     */       
/* 342 */       list.add(faults);
/*     */     } 
/*     */     
/* 345 */     return new J1708(numberOfDtc, list, mil);
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
/*     */   public static J1939 parseJ1939(Payload p, Integer numberOfDtc, Integer mil) {
/* 357 */     List<Map<String, Object>> list = new ArrayList<>();
/*     */     
/* 359 */     for (int i = 0; i < numberOfDtc.intValue(); i++) {
/* 360 */       Map<String, Object> faults = new HashMap<>();
/* 361 */       Integer nextdtc = Integer.valueOf((int)p.getULong(4));
/*     */       
/* 363 */       Integer oc = parseJ1939OccurrenceCount(nextdtc);
/* 364 */       Integer fmi = parseJ1939FailureModeIdentifier(nextdtc);
/* 365 */       Integer cm = parseJ1939ConversionMethod(nextdtc);
/* 366 */       if (cm.intValue() == 0) {
/* 367 */         Integer spn = parseJ1939SPN(nextdtc);
/* 368 */         faults.put("SPN", spn);
/*     */       } else {
/* 370 */         List<Integer> spn = parseOlderSPN(nextdtc);
/* 371 */         faults.put("SPN", spn);
/*     */       } 
/*     */       
/* 374 */       faults.put("OccurrenceCount", oc);
/* 375 */       faults.put("FMI", fmi);
/* 376 */       faults.put("ConversionMethod", cm);
/*     */       
/* 378 */       list.add(faults);
/*     */     } 
/*     */     
/* 381 */     return new J1939(mil, list, numberOfDtc);
/*     */   }
/*     */   
/* 384 */   private static final byte[] First = new byte[] { 80, 67, 66, 85 };
/* 385 */   private static final byte[] Other = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String parseObdErrorCode(Integer error) {
/* 396 */     byte[] code = new byte[5];
/* 397 */     code[0] = First[error.intValue() >> 14 & 0x3];
/* 398 */     code[1] = Other[error.intValue() >> 12 & 0x3];
/* 399 */     code[2] = Other[error.intValue() >> 8 & 0xF];
/* 400 */     code[3] = Other[error.intValue() >> 4 & 0xF];
/* 401 */     code[4] = Other[error.intValue() & 0xF];
/*     */     
/* 403 */     return new String(code);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseJ1939SPN(Integer error) {
/* 413 */     return Integer.valueOf(((error.intValue() & 0xE000) << 3) + ((error.intValue() & 0xFF0000) >>> 8) + ((error.intValue() & 0xFF000000) >>> 24));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<Integer> parseOlderSPN(Integer error) {
/* 422 */     ArrayList<Integer> spns = new ArrayList<>();
/*     */     
/* 424 */     spns.add(Integer.valueOf((error.intValue() & 0xFFFFE000) >>> 13));
/*     */     
/* 426 */     spns.add(Integer.valueOf(((error.intValue() & 0xFF000000) >>> 21) + ((error.intValue() & 0xFF0000) >>> 5) + ((error.intValue() & 0xE000) >>> 13)));
/*     */     
/* 428 */     spns.add(parseJ1939SPN(error));
/* 429 */     return spns;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseJ1939OccurrenceCount(Integer error) {
/* 439 */     return Integer.valueOf(error.intValue() & 0x7F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseJ1939FailureModeIdentifier(Integer error) {
/* 449 */     return Integer.valueOf(error.intValue() >> 8 & 0x1F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseJ1939ConversionMethod(Integer error) {
/* 459 */     return Integer.valueOf(error.intValue() >> 7 & 0x1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtcData(Fault fault) {
/* 468 */     this.data = fault;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtcType getDtcType() {
/* 476 */     return this.data.getDtcType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getMil() {
/* 484 */     return this.data.getMil();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map<String, Object>> getFaultCodes() {
/* 493 */     return this.data.getFaults();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getNumberOfFaults() {
/* 501 */     return this.data.getNumberOfFaults();
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\DtcData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */