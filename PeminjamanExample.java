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
import java.util.Scanner;
public class PeminjamanExample {
     public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        PeminjamanRecord nasabah=new PeminjamanRecord();
        
        String nama,kode,tgl;
        double jmlhPinjam,angsuran,bunga;
        int lamaPinjam;
        
        System.out.print("Masukkan Kode Pinjam : ");
        kode=in.nextLine();
        System.out.print("Masukkan Nama Nasabah : ");
        nama=in.nextLine();
        System.out.print("Masukkan Tanggal Peminjaman : ");
        tgl=in.nextLine();
        System.out.print("Masukkan Jumlah Peminjaman : ");
        jmlhPinjam=in.nextDouble();
        System.out.print("Masukkan Lama Peminjaman(Bulan) : ");
        lamaPinjam=in.nextInt();
        
        nasabah.setKode(kode);
        nasabah.setNama(nama);
        nasabah.setTgl(tgl);
        nasabah.setJumlahPinjam(jmlhPinjam);
        nasabah.setLamaPinjam(lamaPinjam);
        
        nasabah.print(nasabah.getKode(),nasabah.getNama(),nasabah.getTgl(),nasabah.getJumlahPinjam(),nasabah.getLamaPinjam(),nasabah.getBunga(),nasabah.getAngsuran());
    }
}