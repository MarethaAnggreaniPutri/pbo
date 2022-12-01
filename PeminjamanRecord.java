/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts;

/**
 *
 * @author win 10
 */
public class PeminjamanRecord {
    private String kode;
    private String nama;
    private String tgl;
    private double jmlhPinjam;
    private int lamaPinjam;
    private double bunga;
    private double angsuran;
    
    public PeminjamanRecord(){
    }

    public void setKode(String kode){
        this.kode=kode;
    }

    public void setNama(String nama){
        this.nama=nama;
    }

    public void setTgl(String tgl){
        this.tgl=tgl;
    }

    public void setJumlahPinjam(double jmlhPinjam){
        this.jmlhPinjam=jmlhPinjam;
    }
    
    public void setLamaPinjam(int lamaPinjam){
    this.lamaPinjam=lamaPinjam;
    }
    
    public String getKode(){
        return kode;
    }

    public String getNama(){
        return nama;
    }
    
    public String getTgl(){
        return tgl;
    }
    
    public double getJumlahPinjam(){
        return jmlhPinjam;
    }
    
    public int getLamaPinjam(){
        return lamaPinjam;
    }
    
    public double getBunga(){
        bunga=(0.1*jmlhPinjam)/lamaPinjam;
        
        return bunga;
    }

    public double getAngsuran(){
        angsuran=(jmlhPinjam/lamaPinjam)+bunga;
        return angsuran;
    }
    
    public void print(String kode,String nama,String tgl,double jmlhPinjam,int lamaPinjam,double bunga,double angsuran){
        System.out.println("\n===Data Peminjaman Nasabah===");
        System.out.println("Kode Pinjam : "+kode);
        System.out.println("Nama Nasabah : "+nama);
        System.out.println("Tanggal Peminjaman : "+tgl);
        System.out.println("Jumlah Peminjaman : "+jmlhPinjam);
        System.out.println("Lama Peminjaman(Bulan): "+lamaPinjam);
        System.out.println("Bunga : "+bunga);
        System.out.println("Angsuran : "+angsuran);
    }
}
