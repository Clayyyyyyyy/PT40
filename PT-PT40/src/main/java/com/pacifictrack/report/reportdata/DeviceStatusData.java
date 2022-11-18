/*    */ package com.pacifictrack.report.reportdata;

import com.pacifictrack.utils.Payload;

/*    */ 
/*    */ public class DeviceStatusData {
/*    */   boolean ignitionOn;
/*    */   boolean engineOn;
/*    */   
/*    */   public DeviceStatusData(boolean ignitionOn, boolean engineOn, AssetStatus assetStatus, boolean eldBleOn, boolean eldUartOn) {
/*  8 */     this.ignitionOn = ignitionOn; this.engineOn = engineOn; this.assetStatus = assetStatus; this.eldBleOn = eldBleOn; this.eldUartOn = eldUartOn;
/*    */   } AssetStatus assetStatus; boolean eldBleOn; boolean eldUartOn; public boolean isIgnitionOn() {
/* 10 */     return this.ignitionOn; }
/* 11 */   public boolean isEngineOn() { return this.engineOn; }
/* 12 */   public AssetStatus getAssetStatus() { return this.assetStatus; }
/* 13 */   public boolean isEldBleOn() { return this.eldBleOn; } public boolean isEldUartOn() {
/* 14 */     return this.eldUartOn;
/*    */   }
/*    */   
/* 17 */   public enum AssetStatus { Asset_Not_Moving,
/* 18 */     Asset_Idling,
/* 19 */     Asset_In_Motion,
/* 20 */     Asset_In_Tow,
/* 21 */     Unknown;
/*    */     
/*    */     public static AssetStatus make_AssetStatus(byte status) {
/* 24 */       byte state = (byte)((status & 0xF0) >> 4);
/* 25 */       switch (state) {
/*    */         case 0:
/* 27 */           return Asset_Not_Moving;
/*    */         case 1:
/* 29 */           return Asset_Idling;
/*    */         case 2:
/* 31 */           return Asset_In_Motion;
/*    */         case 3:
/* 33 */           return Asset_In_Tow;
/*    */       } 
/* 35 */       return Unknown;
/*    */     }
/*    */ 
/*    */     
/*    */     public static String toString(AssetStatus status) {
/* 40 */       switch (status) {
/*    */         case Asset_Not_Moving:
/* 42 */           return "Asset Not Moving";
/*    */         case Asset_Idling:
/* 44 */           return "Asset Idling";
/*    */         case Asset_In_Motion:
/* 46 */           return "Asset In Motion";
/*    */         case Asset_In_Tow:
/* 48 */           return "Asset In Tow";
/*    */       } 
/* 50 */       return "Unknown";
/*    */     } }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DeviceStatusData parseDeviceStatus(Payload p) {
/* 62 */     int assetStatus = p.getByte();
/* 63 */     boolean ignitionStatus = ((assetStatus & 0x1) == 1);
/* 64 */     boolean engineStatus = ((assetStatus & 0x2) == 2);
/* 65 */     AssetStatus status = AssetStatus.make_AssetStatus((byte)assetStatus);
/*    */     
/* 67 */     int eldStatus = p.getByte();
/* 68 */     boolean eldBleStatus = ((eldStatus & 0x1) == 1);
/* 69 */     boolean eldUartStatus = ((eldStatus & 0x2) == 2);
/*    */     
/* 71 */     return new DeviceStatusData(ignitionStatus, engineStatus, status, eldBleStatus, eldUartStatus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\DeviceStatusData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */