package com.example.usjul.mypc;

public class getSet {
    private int id_pc;
    private String nama_pc, brand_pc, prosessor_pc, motherboard_pc, ssd_pc, hhd_pc, ram_pc, vga_pc, psu_pc, cooler_pc, tanggal_pc;


    public getSet(int id_pc,String nama_pc,String brand_pc,String prosessor_pc,String motherboard_pc,String ssd_pc,String hhd_pc,String ram_pc,String vga_pc,String psu_pc,String cooler_pc,String tanggal_pc){
        this.id_pc = id_pc;
        this.nama_pc = nama_pc;
        this.brand_pc = brand_pc;
        this.prosessor_pc = prosessor_pc;
        this.motherboard_pc = motherboard_pc;
        this.ssd_pc = ssd_pc;
        this.hhd_pc = hhd_pc;
        this.ram_pc = ram_pc;
        this.vga_pc = vga_pc;
        this.psu_pc = psu_pc;
        this.cooler_pc = cooler_pc;
        this.tanggal_pc = tanggal_pc;
    }

    public int getId_pc() {
        return id_pc;
    }

    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }

    public String getNama_pc() {
        return nama_pc;
    }

    public void setNama_pc(String nama_pc) {
        this.nama_pc = nama_pc;
    }

    public String getBrand_pc() {
        return brand_pc;
    }

    public void setBrand_pc(String brand_pc) {
        this.brand_pc = brand_pc;
    }

    public String getProsessor_pc() {
        return prosessor_pc;
    }

    public void setProsessor_pc(String prosessor_pc) {
        this.prosessor_pc = prosessor_pc;
    }

    public String getMotherboard_pc() {
        return motherboard_pc;
    }

    public void setMotherboard_pc(String motherboard_pc) {
        this.motherboard_pc = motherboard_pc;
    }

    public String getSsd_pc() {
        return ssd_pc;
    }

    public void setSsd_pc(String ssd_pc) {
        this.ssd_pc = ssd_pc;
    }

    public String getHhd_pc() {
        return hhd_pc;
    }

    public void setHhd_pc(String hhd_pc) {
        this.hhd_pc = hhd_pc;
    }

    public String getRam_pc() {
        return ram_pc;
    }

    public void setRam_pc(String ram_pc) {
        this.ram_pc = ram_pc;
    }

    public String getVga_pc() {
        return vga_pc;
    }

    public void setVga_pc(String vga_pc) {
        this.vga_pc = vga_pc;
    }

    public String getPsu_pc() {
        return psu_pc;
    }

    public void setPsu_pc(String psu_pc) {
        this.psu_pc = psu_pc;
    }

    public String getCooler_pc() {
        return cooler_pc;
    }

    public void setCooler_pc(String cooler_pc) {
        this.cooler_pc = cooler_pc;
    }

    public String getTanggal_pc() {
        return tanggal_pc;
    }

    public void setTanggal_pc(String tanggal_pc) {
        this.tanggal_pc = tanggal_pc;
    }
}

