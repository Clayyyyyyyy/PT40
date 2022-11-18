/*     */ package com.pacifictrack.report.reportdata;
/*     */ 
/*     */ import com.pacifictrack.utils.Payload;
/*     */ import java.time.YearMonth;
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
/*     */ public class GpsData
/*     */ {
/*     */   private final GpsReport data;
/*     */   
/*     */   public static interface GpsReport
/*     */   {
/*     */     Integer getGpsFix();
/*     */     
/*     */     Integer getSatellites();
/*     */     
/*     */     Integer getHeading();
/*     */     
/*     */     Integer getReportSequence();
/*     */     
/*     */     Integer getAge();
/*     */     
/*     */     Integer getAltitude();
/*     */     
/*     */     Double getDOP();
/*     */     
/*     */     Double getLatitude();
/*     */     
/*     */     Double getLongitude();
/*     */     
/*     */     Double getGpsSpeed();
/*     */     
/*     */     String getDateTime();
/*     */     
/*     */     String getRtcDateTime();
/*     */     
/*     */     void Output();
/*     */   }
/*     */   
/*     */   public static class GpsTypeA
/*     */     implements GpsReport
/*     */   {
/*     */     private final Integer gpsFix;
/*     */     private final Integer satellites;
/*     */     private final String dateTime;
/*     */     private final Double latitude;
/*     */     private final Double longitude;
/*     */     private final Integer heading;
/*     */     private final Double gpsSpeed;
/*     */     private final Integer reportSequence;
/*     */     
/*     */     public GpsTypeA(Integer gpsFix, Integer satellites, String dateTime, Double latitude, Double longitude, Integer heading, Double gpsSpeed, Integer reportSequence) {
/*  69 */       this.gpsFix = gpsFix; this.satellites = satellites; this.dateTime = dateTime; this.latitude = latitude; this.longitude = longitude; this.heading = heading; this.gpsSpeed = gpsSpeed; this.reportSequence = reportSequence;
/*     */     } public Integer getGpsFix() {
/*  71 */       return this.gpsFix;
/*     */     } public Integer getSatellites() {
/*  73 */       return this.satellites;
/*     */     } public String getDateTime() {
/*  75 */       return this.dateTime;
/*     */     } public Double getLatitude() {
/*  77 */       return this.latitude;
/*     */     } public Double getLongitude() {
/*  79 */       return this.longitude;
/*     */     } public Integer getHeading() {
/*  81 */       return this.heading;
/*     */     } public Double getGpsSpeed() {
/*  83 */       return this.gpsSpeed;
/*     */     } public Integer getReportSequence() {
/*  85 */       return this.reportSequence;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getAge() {
/*  91 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer getAltitude() {
/*  96 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Double getDOP() {
/* 101 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getRtcDateTime() {
/* 106 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 112 */       System.out.format("GPS_A Fix: %d Sat: %d Time: %s Lat/Lon: %.6f/%.6f Speed: %.1f Heading: %d Sequence: %d\n", new Object[] { this.gpsFix, this.satellites, this.dateTime, this.latitude, this.longitude, this.gpsSpeed, this.heading, this.reportSequence });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GpsTypeB
/*     */     extends GpsTypeA
/*     */   {
/*     */     private final Integer Altitude;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Double dop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Integer age;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GpsTypeB(Integer gps_fix, Integer satellites, String date_time, Double latitude, Double longitude, Integer heading, Double gps_speed, Integer report_sequence, Integer Altitude, Double dop, Integer age) {
/* 145 */       super(gps_fix, satellites, date_time, latitude, longitude, heading, gps_speed, report_sequence);
/* 146 */       this.Altitude = Altitude;
/* 147 */       this.dop = dop;
/* 148 */       this.age = age;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getAltitude() {
/* 157 */       return this.Altitude;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Double getDOP() {
/* 166 */       return this.dop;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getAge() {
/* 175 */       return this.age;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 183 */       byte unit = GpsData.parseAgeUnit(this.age);
/* 184 */       System.out.format("GPS_B Altitude: %d DOP: %.1f Age: %d%c\n", new Object[] { this.Altitude, this.dop, Integer.valueOf(this.age.intValue() & 0x3F), Byte.valueOf(unit) });
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
/*     */ 
/*     */   
/*     */   public static class GpsTypeC
/*     */     extends GpsTypeB
/*     */   {
/*     */     private final String RtcDateTime;
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
/*     */     public GpsTypeC(Integer gps_fix, Integer satellites, String date_time, Double latitude, Double longitude, Integer heading, Double gps_speed, Integer report_sequence, Integer Altitude, Double dop, Integer age, String RtcDateTime) {
/* 216 */       super(gps_fix, satellites, date_time, latitude, longitude, heading, gps_speed, report_sequence, Altitude, dop, age);
/* 217 */       this.RtcDateTime = RtcDateTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getRtcDateTime() {
/* 226 */       return this.RtcDateTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void Output() {
/* 234 */       System.out.format("GPS_C RTC Time: %s\n", new Object[] { this.RtcDateTime });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Builder
/*     */   {
/*     */     private final Payload payload;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder(Payload parse) {
/* 251 */       this.payload = parse;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GpsData.GpsTypeA buildA() {
/* 260 */       int rptGpsStatus = this.payload.getByte();
/*     */       
/* 262 */       Integer gps_fix = Integer.valueOf(((rptGpsStatus & 0x10) == 0) ? 0 : 1);
/* 263 */       Integer satellites = Integer.valueOf(rptGpsStatus & 0xF);
/*     */ 
/*     */       
/* 266 */       String date_time = GpsData.parseDateTime(this.payload.getULong(5));
/*     */       
/* 268 */       Double latitude = Double.valueOf(this.payload.getULong(4) / 1000000.0D - 90.0D);
/* 269 */       Double longitude = Double.valueOf(this.payload.getULong(4) / 1000000.0D - 180.0D);
/*     */       
/* 271 */       long heading_speed = this.payload.getULong(3);
/*     */       
/* 273 */       Double gps_speed = Double.valueOf((heading_speed & 0xFFFL) / 10.0D);
/* 274 */       Integer heading = Integer.valueOf((int)(heading_speed >> 12L));
/*     */       
/* 276 */       Integer report_sequence = Integer.valueOf((int)this.payload.getULong(2));
/* 277 */       return new GpsData.GpsTypeA(gps_fix, satellites, date_time, latitude, longitude, heading, gps_speed, report_sequence);
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
/*     */     public GpsData.GpsTypeB buildB() {
/* 295 */       Integer Altitude = GpsData.parseAltitude(this.payload);
/* 296 */       Double dop = GpsData.parseDop(this.payload);
/* 297 */       Integer age = GpsData.parseGpsAge(this.payload);
/*     */       
/* 299 */       return new GpsData.GpsTypeB(Integer.valueOf(-1), Integer.valueOf(-1), "", Double.valueOf(-1.0D), Double.valueOf(-1.0D), Integer.valueOf(-1), Double.valueOf(-1.0D), Integer.valueOf(-1), Altitude, dop, age);
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
/*     */     public GpsData.GpsTypeC buildC() {
/* 316 */       String rtc_date_time = GpsData.parseDateTime(this.payload.getULong(5));
/*     */       
/* 318 */       return new GpsData.GpsTypeC(Integer.valueOf(-1), Integer.valueOf(-1), "", Double.valueOf(-1.0D), Double.valueOf(-1.0D), Integer.valueOf(-1), Double.valueOf(-1.0D), Integer.valueOf(-1), Integer.valueOf(-1), Double.valueOf(-1.0D), Integer.valueOf(-1), rtc_date_time);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GpsTypeA parseGpsTypeA(Payload p) {
/* 329 */     return (new Builder(p)).buildA();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GpsTypeB parseGpsTypeB(Payload p) {
/* 339 */     return (new Builder(p)).buildB();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GpsTypeC parseGpsTypeC(Payload p) {
/* 349 */     return (new Builder(p)).buildC();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer getYear(Integer incomingLast) {
/* 359 */     int current_year = YearMonth.now().getYear();
/*     */ 
/*     */     
/* 362 */     Integer last_digit = Integer.valueOf(current_year % 10);
/* 363 */     int delta = last_digit.intValue() - incomingLast.intValue();
/* 364 */     current_year -= delta;
/*     */     
/* 366 */     if (delta > 5) {
/* 367 */       current_year += 10;
/* 368 */     } else if (delta < -5) {
/* 369 */       current_year -= 10;
/*     */     } 
/* 371 */     return Integer.valueOf(current_year);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String parseDateTime(long status) {
/* 381 */     return String.format("%d-%02d-%02dT%02d:%02d:%02d", new Object[] {
/* 382 */           getYear(Integer.valueOf((int)(status >> 36L))), 
/* 383 */           Long.valueOf(status >> 32L & 0xFL), 
/* 384 */           Long.valueOf(status >> 24L & 0xFFL), 
/* 385 */           Long.valueOf(status >> 16L & 0xFFL), 
/* 386 */           Long.valueOf(status >> 8L & 0xFFL), 
/* 387 */           Long.valueOf(status >> 0L & 0xFFL)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseAltitude(Payload payload) {
/* 396 */     return Integer.valueOf((int)payload.getULong(2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double parseDop(Payload payload) {
/* 405 */     return Double.valueOf((int)payload.getULong(1) / 10.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer parseGpsAge(Payload payload) {
/* 414 */     return Integer.valueOf((int)payload.getULong(1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte parseAgeUnit(Integer age) {
/* 423 */     switch (age.intValue() & 0xC0) {
/*     */       case 0:
/* 425 */         return 115;
/*     */       case 64:
/* 427 */         return 109;
/*     */       case 128:
/* 429 */         return 104;
/*     */       case 192:
/* 431 */         return 100;
/*     */     } 
/* 433 */     return 63;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GpsData(GpsReport data) {
/* 442 */     this.data = data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getGpsFix() {
/* 450 */     return this.data.getGpsFix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSatellites() {
/* 460 */     return this.data.getSatellites();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDateTime() {
/* 468 */     return this.data.getDateTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getLatitude() {
/* 477 */     return this.data.getLatitude();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getLongitude() {
/* 485 */     return this.data.getLongitude();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getGpsSpeed() {
/* 493 */     return this.data.getGpsSpeed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getGpsHeading() {
/* 501 */     return this.data.getHeading();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getReportSequence() {
/* 509 */     return this.data.getReportSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getAltitude() {
/* 517 */     return this.data.getAltitude();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getDoP() {
/* 525 */     return this.data.getDOP();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getGpsAge() {
/* 533 */     return this.data.getAge();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRtcDateTime() {
/* 541 */     return this.data.getRtcDateTime();
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\GpsData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */