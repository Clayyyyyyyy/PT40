/*     */ package com.pacifictrack.report.reportdata;

import com.pacifictrack.utils.Payload;

public class DeviceData { private final Device device; private final Revision revision; private final DeviceFeatures features;
/*     */   private final UpgradeProtocol protocol;
/*     */   private final Long main_firmware;
/*     */   private final Long secondary_firmware;
/*     */   private final String configuration;
/*     */   
/*     */   public DeviceData(Device device, Revision revision, DeviceFeatures features, UpgradeProtocol protocol, Long main_firmware, Long secondary_firmware, String configuration) {
/*   8 */     this.device = device; this.revision = revision; this.features = features; this.protocol = protocol; this.main_firmware = main_firmware; this.secondary_firmware = secondary_firmware; this.configuration = configuration;
/*     */   }
/*     */   
/*     */   public enum DeviceModel
/*     */   {
/*  13 */     PT30(0),
/*  14 */     PT40(1),
/*  15 */     PT10(2),
/*  16 */     PT20(3),
/*  17 */     PTxx(255); DeviceModel(int type) { this.type = type; } private final int type;
/*     */     public int getType() {
/*  19 */       return this.type;
/*     */     }
/*     */     public static DeviceModel make_model(byte type) {
/*  22 */       switch (type) {
/*     */         case 0:
/*  24 */           return PT30;
/*     */         case 1:
/*  26 */           return PT40;
/*     */         case 2:
/*  28 */           return PT10;
/*     */         case 3:
/*  30 */           return PT20;
/*     */       } 
/*  32 */       return PTxx;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  38 */       switch (this.type) {
/*     */         case 0:
/*  40 */           return "PT30";
/*     */         case 1:
/*  42 */           return "PT40";
/*     */         case 2:
/*  44 */           return "PT10";
/*     */         case 3:
/*  46 */           return "PT20";
/*     */       } 
/*  48 */       return "PTxx";
/*     */     } }
/*     */   public static class Device { private final DeviceData.DeviceModel model;
/*     */     private final int variant;
/*     */     
/*     */     public Device(DeviceData.DeviceModel model, int variant) {
/*  54 */       this.model = model; this.variant = variant;
/*     */     }
/*  56 */     public DeviceData.DeviceModel getModel() { return this.model; } public int getVariant() {
/*  57 */       return this.variant;
/*     */     } }
/*     */   public static class Revision { private final int pcb_version; private final int assy_version;
/*     */     public Revision(int pcb_version, int assy_version) {
/*  61 */       this.pcb_version = pcb_version; this.assy_version = assy_version;
/*     */     }
/*  63 */     public int getPcb_version() { return this.pcb_version; } public int getAssy_version() {
/*  64 */       return this.assy_version;
/*     */     } }
/*     */   public static class DeviceFeatures { private final boolean has_ble; private final boolean has_cell; private final boolean has_can; private final boolean has_j1708;
/*     */     public DeviceFeatures(boolean has_ble, boolean has_cell, boolean has_can, boolean has_j1708) {
/*  68 */       this.has_ble = has_ble; this.has_cell = has_cell; this.has_can = has_can; this.has_j1708 = has_j1708;
/*     */     }
/*  70 */     public boolean isHas_ble() { return this.has_ble; }
/*  71 */     public boolean isHas_cell() { return this.has_cell; }
/*  72 */     public boolean isHas_can() { return this.has_can; } public boolean isHas_j1708() {
/*  73 */       return this.has_j1708;
/*     */     } }
/*     */   public static class UpgradeProtocol { private final boolean has_tftp; private final boolean has_ftp;
/*     */     public UpgradeProtocol(boolean has_tftp, boolean has_ftp, boolean has_ftps, boolean has_http, boolean has_https) {
/*  77 */       this.has_tftp = has_tftp; this.has_ftp = has_ftp; this.has_ftps = has_ftps; this.has_http = has_http; this.has_https = has_https;
/*     */     } private final boolean has_ftps; private final boolean has_http; private final boolean has_https; public boolean isHas_tftp() {
/*  79 */       return this.has_tftp; }
/*  80 */     public boolean isHas_ftp() { return this.has_ftp; }
/*  81 */     public boolean isHas_ftps() { return this.has_ftps; }
/*  82 */     public boolean isHas_http() { return this.has_http; } public boolean isHas_https() {
/*  83 */       return this.has_https;
/*     */     } }
/*     */   
/*  86 */   public Device getDevice() { return this.device; }
/*  87 */   public Revision getRevision() { return this.revision; }
/*  88 */   public DeviceFeatures getFeatures() { return this.features; }
/*  89 */   public UpgradeProtocol getProtocol() { return this.protocol; }
/*  90 */   public Long getMain_firmware() { return this.main_firmware; }
/*  91 */   public Long getSecondary_firmware() { return this.secondary_firmware; } public String getConfiguration() {
/*  92 */     return this.configuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DeviceData parseDeviceData(Payload p) {
/* 100 */     long device = p.getULong(2);
/* 101 */     byte model = (byte)(int)((device & 0xFF00L) >> 8L);
/* 102 */     byte variant = (byte)(int)(device & 0xFFL);
/* 103 */     DeviceModel _model = DeviceModel.make_model(model);
/* 104 */     Device _device = new Device(_model, variant);
/*     */     
/* 106 */     int revision = p.getByte();
/* 107 */     int assy = revision & 0xE0;
/* 108 */     int pcb = revision & 0x1F;
/* 109 */     Revision _revision = new Revision(pcb, assy);
/*     */     
/* 111 */     int features = p.getByte();
/* 112 */     boolean has_ble = ((features & 0x1) == 1);
/* 113 */     boolean has_cell = ((features & 0x2) >> 1 == 1);
/* 114 */     boolean has_can = ((features & 0x4) >> 2 == 1);
/* 115 */     boolean has_j1708 = ((features & 0x8) >> 3 == 1);
/*     */     
/* 117 */     DeviceFeatures _features = new DeviceFeatures(has_ble, has_cell, has_can, has_j1708);
/*     */     
/* 119 */     int protocol = p.getByte();
/* 120 */     boolean has_tftp = ((protocol & 0x1) == 1);
/* 121 */     boolean has_ftp = ((protocol & 0x2) >> 1 == 1);
/* 122 */     boolean has_ftps = ((protocol & 0x4) >> 2 == 1);
/* 123 */     boolean has_http = ((protocol & 0x8) >> 3 == 1);
/* 124 */     boolean has_https = ((protocol & 0x10) >> 4 == 1);
/*     */     
/* 126 */     UpgradeProtocol _protocol = new UpgradeProtocol(has_tftp, has_ftp, has_ftps, has_http, has_https);
/*     */     
/* 128 */     Long firmware = Long.valueOf(p.getULong(2));
/*     */     
/* 130 */     Long secondary = Long.valueOf(p.getULong(2));
/*     */     
/* 132 */     long script = p.getULong(6);
/* 133 */     long rev_mask = 255L;
/* 134 */     long _id = (script & (rev_mask ^ 0xFFFFFFFFFFFFFFFFL)) >> 16L;
/* 135 */     long _rev = script & rev_mask;
/* 136 */     String config = _id + "." + _rev;
/*     */     
/* 138 */     return new DeviceData(_device, _revision, _features, _protocol, firmware, secondary, config);
/*     */   } }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\reportdata\DeviceData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */