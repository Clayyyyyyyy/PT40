/*     */ package com.pacifictrack.utils;
/*     */ 
/*     */ import java.util.List;
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
/*     */ public class Payload
/*     */ {
/*     */   private final byte[] payload;
/*     */   private final int size;
/*     */   private int index;
/*     */   
/*     */   public Payload(byte[] b, int len) {
/*  45 */     this.payload = b;
/*  46 */     this.size = len;
/*  47 */     this.index = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndex() {
/*  55 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndex(int index) {
/*  63 */     this.index = index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getByte() {
/*  72 */     int value = this.payload[this.index] & 0xFF;
/*  73 */     this.index++;
/*  74 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteArray(int size) {
/*  79 */     byte[] array = new byte[size];
/*     */ 
/*     */     
/*  82 */     int index = 0;
/*  83 */     while (size != 0 && this.index < this.size) {
/*     */       
/*  85 */       array[index] = (byte)getByte();
/*  86 */       index++;
/*  87 */       size--;
/*     */     } 
/*  89 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getULong(int size) {
/*  96 */     long value = 0L;
/*  97 */     while (size != 0) {
/*     */ 
/*     */ 
/*     */       
/* 101 */       if (this.index >= this.size) {
/* 102 */         return value;
/*     */       }
/* 104 */       value = (value << 8L) + getByte();
/* 105 */       size--;
/*     */     } 
/* 107 */     return value;
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
/*     */   public static int toBitExt(List<Byte> frame, int offset, int data) {
/* 131 */     int count = 0;
/* 132 */     byte[] encoded = new byte[4];
/*     */     do {
/* 134 */       encoded[count++] = (byte)(data & 0x7F);
/* 135 */       data >>= 7;
/* 136 */     } while (data != 0);
/*     */     
/* 138 */     encoded[0] = (byte)(encoded[0] | 0x80);
/*     */     
/* 140 */     for (int i = count; i > 0; i--) {
/* 141 */       frame.set(offset++, Byte.valueOf(encoded[i - 1]));
/*     */     }
/*     */     
/* 144 */     return count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getBitext() {
/* 155 */     long data = 0L;
/* 156 */     int extension = 0;
/* 157 */     while (extension == 0) {
/*     */ 
/*     */ 
/*     */       
/* 161 */       if (this.index >= this.size) {
/* 162 */         return -1L;
/*     */       }
/*     */       
/* 165 */       int current = getByte();
/* 166 */       extension = current & 0x80;
/* 167 */       current = (byte)(current & 0x7F);
/* 168 */       data = (data << 7L) + current;
/*     */     } 
/* 170 */     return data;
/*     */   }
/*     */ }


/* Location:              C:\Users\Ryann\OneDrive\Desktop\PT_Telematics_Protocol_Parser\PT40_Telematics_Protocol_Parser-1.8.0.jar!\com\pacifictrac\\utils\Payload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */