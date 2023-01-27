/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian.controller;
import pengembalian.model.BukuDao;
import pengembalian.model.BukuDaoImpl;
import pengembalian.model.Peminjaman;
import pengembalian.model.Anggota;
import pengembalian.model.PeminjamanDaoImpl;
import pengembalian.model.AnggotaDaoImpl;
import pengembalian.model.AnggotaDao;
import pengembalian.model.Buku;
import pengembalian.model.PeminjamanDao;
import pengembalian.view.FormPeminjaman;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private Peminjaman peminjaman;
    private PeminjamanDao peminjamanDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        this.formPeminjaman=formPeminjaman;
        anggotaDao= new AnggotaDaoImpl();
        bukuDao= new BukuDaoImpl();
        peminjamanDao=new PeminjamanDaoImpl();
    }
    
    public void bersihForm(){
        formPeminjaman.getTxttglpinjam().setText("");
        formPeminjaman.getTxttglkembali().setText("");
    }
    
    public void setCboNobp(){
        formPeminjaman.getCbonobp().removeAllItems();
        List<Anggota> list= anggotaDao.getAll();
        for(Anggota anggota : list){
            formPeminjaman.getCbonobp().
                    addItem(anggota.getNobp()+"-"+anggota.getNama());
        } 
    }
    
    public void setCboKodeBuku(){
        formPeminjaman.getCbokode().removeAllItems();
        List<Buku> list= bukuDao.getAll();
        for(Buku buku : list){
            formPeminjaman.getCbokode().
                    addItem(buku.getKodebuku());
        } 
    }
    
    public void save(){
        peminjaman=new Peminjaman();
        peminjaman.setNobp(formPeminjaman.getCbonobp()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKode(formPeminjaman.getCbokode()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxttglpinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxttglkembali().getText());
        peminjamanDao.save(peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman,"Entri Data Ok");
    }
    
    public void getPeminjaman(){
        int index=formPeminjaman.getTblpinjam().getSelectedRow();
        peminjaman=peminjamanDao.getPeminjaman(index);
        if(peminjaman!=null){
            List<Anggota> listAnggota=anggotaDao.getAll();
            for(Anggota anggota:listAnggota){
                if(peminjaman.getNobp()==anggota.getNobp()){
                    formPeminjaman.getCbonobp()
                    .setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
                    break;
                }
            }
            formPeminjaman.getCbokode().setSelectedItem(peminjaman.getKode());
            formPeminjaman.getTxttglpinjam().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxttglkembali().setText(peminjaman.getTglkembali());
        }
    }
    
    public void update(){
        int index=formPeminjaman.getTblpinjam().getSelectedRow();
        peminjaman=peminjamanDao.getPeminjaman(index);
        peminjaman.setNobp(formPeminjaman.getCbonobp()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKode(formPeminjaman.getCbokode()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxttglpinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxttglkembali().getText());
        peminjamanDao.update(index,peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman,"Update Data Ok");
    }
    
    public void delete(){
        int index=formPeminjaman.getTblpinjam().getSelectedRow();
        peminjamanDao.delete(index);
        JOptionPane.showMessageDialog(formPeminjaman,"Delete Data Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel=
                (DefaultTableModel) formPeminjaman.getTblpinjam().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman>listPeminjaman=peminjamanDao.getAllPeminjaman();
        for(Peminjaman peminjaman : listPeminjaman){
            Object[] data={
                peminjaman.getNobp(),
                peminjaman.getKode(),
                peminjaman.getTglpinjam(),
                peminjaman.getTglkembali()
            };
            tabelModel.addRow(data);
        }
    }
}
