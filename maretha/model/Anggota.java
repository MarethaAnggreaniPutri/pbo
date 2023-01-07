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
public class Anggota {
    private String nama;
    private String alamat;
    private String nobp;
    
    public Anggota(){
        
    }

    public Anggota(String nama, String alamat, String nobp) {
        this.nama = nama;
        this.alamat = alamat;
        this.nobp = nobp;
    }
    
    
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public void setNobp(String nobp){
        this.nobp=nobp;
    }
    
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getNobp(){
        return nobp;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
}
