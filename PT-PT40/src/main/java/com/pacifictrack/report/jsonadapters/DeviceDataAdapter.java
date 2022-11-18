/*    */ package com.pacifictrack.report.jsonadapters;

import java.util.ArrayList;

import com.pacifictrack.report.reportdata.DeviceData;

/*    */ 
/*    */ public class DeviceDataAdapter {
/*    */   public static class DeviceDataJson {
/*    */     String device;
/*    */     int variant;
/*    */     String revision;
/*    */     String[] features;
/*    */     
/*    */     public DeviceDataJson(String device, int variant, String revision, String[] features, String[] protocols, Long main_fw, Long sec_fw, String configuration) {
/* 11 */       this.device = device; this.variant = variant; this.revision = revision; this.features = features; this.protocols = protocols; this.main_fw = main_fw; this.sec_fw = sec_fw; this.configuration = configuration;
/*    */     } String[] protocols; Long main_fw; Long sec_fw; String configuration; public String getDevice() {
/* 13 */       return this.device; }
/* 14 */     public int getVariant() { return this.variant; }
/* 15 */     public String getRevision() { return this.revision; }
/* 16 */     public String[] getFeatures() { return this.features; }
/* 17 */     public String[] getProtocols() { return this.protocols; }
/* 18 */     public Long getMain_fw() { return this.main_fw; }
/* 19 */     public Long getSec_fw() { return this.sec_fw; } public String getConfiguration() {
/* 20 */       return this.configuration;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DeviceDataJson toJSON(DeviceData data) {
/* 29 */     if (data == null) {
/* 30 */       return null;
/*    */     }
/* 32 */     DeviceData.Device _device = data.getDevice();
/* 33 */     String _model = _device.getModel().toString();
/* 34 */     int _variant = _device.getVariant();
/*    */     
/* 36 */     DeviceData.Revision _rev = data.getRevision();
/* 37 */     int pcb = _rev.getPcb_version();
/* 38 */     int assy = _rev.getAssy_version();
/* 39 */     String revision = String.format("%d.%d", new Object[] { Integer.valueOf(pcb), Integer.valueOf(assy) });
/*    */     
/* 41 */     DeviceData.DeviceFeatures _features = data.getFeatures();
/* 42 */     ArrayList<String> features = new ArrayList<>();
/* 43 */     if (_features.isHas_ble()) features.add("BLE"); 
/* 44 */     if (_features.isHas_cell()) features.add("Cellular"); 
/* 45 */     if (_features.isHas_can()) features.add("CAN"); 
/* 46 */     if (_features.isHas_j1708()) features.add("J1708"); 
/* 47 */     String[] __features = new String[features.size()];
/* 48 */     features.toArray(__features);
/*    */     
/* 50 */     DeviceData.UpgradeProtocol _protocols = data.getProtocol();
/* 51 */     ArrayList<String> protocols = new ArrayList<>();
/* 52 */     if (_protocols.isHas_tftp()) protocols.add("TFTP"); 
/* 53 */     if (_protocols.isHas_ftp()) protocols.add("FTP"); 
/* 54 */     if (_protocols.isHas_ftps()) protocols.add("FTPS"); 
/* 55 */     if (_protocols.isHas_http()) protocols.add("HTTP"); 
/* 56 */     if (_protocols.isHas_https()) protocols.add("HTTPS"); 
/* 57 */     String[] __protocols = new String[protocols.size()];
/* 58 */     protocols.toArray(__protocols);
/*    */     
/* 60 */     Long _main = data.getMain_firmware();
/* 61 */     Long _secondary = data.getSecondary_firmware();
/* 62 */     String _config = data.getConfiguration();
/*    */     
/* 64 */     return new DeviceDataJson(_model, _variant, revision, __features, __protocols, _main, _secondary, _config);
/*    */   }
/*    */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrack\report\jsonadapters\DeviceDataAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */