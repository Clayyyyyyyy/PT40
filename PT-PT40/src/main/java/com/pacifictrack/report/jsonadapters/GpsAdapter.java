/*    */ package com.pacifictrack.report.jsonadapters;
/*    */ 
/*    */ import com.pacifictrack.report.reportdata.GpsData;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class GpsAdapter
/*    */ {
/*    */   public static Map<String, Object> toJSON(GpsData gps) {
/* 19 */     if (gps == null) {
/* 20 */       return null;
/*    */     }
/* 22 */     Map<String, Object> result = new HashMap<>();
/* 23 */     Integer gpsFix = gps.getGpsFix();
/* 24 */     Integer satellites = gps.getSatellites();
/* 25 */     String dateTime = gps.getDateTime();
/* 26 */     Double latitude = gps.getLatitude();
/* 27 */     Double longitude = gps.getLongitude();
/* 28 */     Integer heading = gps.getGpsHeading();
/* 29 */     Integer reportSequence = gps.getReportSequence();
/* 30 */     Double gpsSpeed = gps.getGpsSpeed();
/* 31 */     Integer Altitude = gps.getAltitude();
/* 32 */     Double dop = gps.getDoP();
/* 33 */     Integer age = gps.getGpsAge();
/* 34 */     result.put("Locked", gpsFix);
/* 35 */     result.put("NumSat", satellites);
/* 36 */     result.put("Time", dateTime);
/* 37 */     result.put("Latitude", latitude);
/* 38 */     result.put("Longitude", longitude);
/* 39 */     result.put("Heading", heading);
/* 40 */     result.put("Sequence", reportSequence);
/* 41 */     result.put("Speed", gpsSpeed);
/*    */     
/* 43 */     if (Altitude != null) {
/* 44 */       result.put("Altitude", Altitude);
/*    */     }
/* 46 */     if (dop != null) {
/* 47 */       result.put("DOP", dop);
/*    */     }
/* 49 */     if (age != null) {
/* 50 */       int seconds = age.intValue() & 0x3F;
/* 51 */       char unit = '?';
/* 52 */       switch (age.intValue() & 0xC0) {
/*    */         case 0:
/* 54 */           unit = 's';
/*    */           break;
/*    */         case 64:
/* 57 */           unit = 'm';
/*    */           break;
/*    */         case 128:
/* 60 */           unit = 'h';
/*    */           break;
/*    */         case 192:
/* 63 */           unit = 'd';
/*    */           break;
/*    */       } 
/* 66 */       String Age = String.format("%d%c", new Object[] { Integer.valueOf(seconds), Character.valueOf(unit) });
/* 67 */       result.put("Age", Age);
/*    */     } 
/* 69 */     String RtcDateTime = gps.getRtcDateTime();
/* 70 */     if (RtcDateTime != null) {
/* 71 */       result.put("RtcTime", RtcDateTime);
/*    */     }
/* 73 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\GpsAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */