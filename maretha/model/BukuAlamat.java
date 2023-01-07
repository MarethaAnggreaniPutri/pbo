/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maretha.model;

/**
 *
 * @author user
 */
public class BukuAlamat {
    private String kode;
    private String judul;
    private String pengarang;
    private String tahunTerbit;
    
    public BukuAlamat(){
        
    }

    public BukuAlamat(String kode, String judul, String pengarang, String tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }
    
    
    
    public void setKode(String kode){
        this.kode=kode;
    }
    
    public void setJudul(String judul){
        this.judul=judul;
    }
    
    public void setPengarang(String pengarang){
        this.pengarang=pengarang;
    }
    
    public void setTahunterbit(String tahunTerbit){
        this.tahunTerbit=tahunTerbit;
    }
    
    public String getKode(){
        return kode;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public String getPengarang(){
        return pengarang;
    }
    
    public String getTahunterbit(){
        return tahunTerbit;
    }
}
