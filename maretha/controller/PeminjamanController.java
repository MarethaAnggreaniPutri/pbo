/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maretha.controller;
import maretha.model.BukuAlamat;
import maretha.model.Anggota;
import maretha.model.Peminjaman;
import java.util.*;
import maretha.model.PeminjamanDao;
import maretha.model.PeminjamanDaoImpl;
import maretha.view.FormPeminjaman;
import maretha.model.AnggotaDao;
import maretha.model.AnggotaDaoImpl;
import maretha.model.BukuAlamatDao;
import maretha.model.BukuAlamatDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private AnggotaDao anggotaDao;
    private BukuAlamatDao bukuDao;
    private Peminjaman peminjaman;
    private PeminjamanDao peminjamanDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        this.formPeminjaman=formPeminjaman;
        anggotaDao= new AnggotaDaoImpl();
        bukuDao= new BukuAlamatDaoImpl();
        peminjamanDao=new PeminjamanDaoImpl();
    }
    
    public void bersihForm(){
        formPeminjaman.getTxtTglPeminjaman().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }
    
    public void setCboNobp(){
        formPeminjaman.getCboNobp().removeAllItems();
        List<Anggota> list= anggotaDao.getAllAnggota();
        for(Anggota anggota : list){
            formPeminjaman.getCboNobp().
                    addItem(anggota.getNobp()+"-"+anggota.getNama());
        } 
    }
    
    public void setCboKodeBuku(){
        formPeminjaman.getCboKodeBuku().removeAllItems();
        List<BukuAlamat> list= bukuDao.getAllBukuAlamat();
        for(BukuAlamat buku : list){
            formPeminjaman.getCboKodeBuku().
                    addItem(buku.getKode());
        } 
    }
    
    public void save(){
        peminjaman=new Peminjaman();
        peminjaman.setNobp(formPeminjaman.getCboNobp()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKode(formPeminjaman.getCboKodeBuku()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglPeminjaman().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
        peminjamanDao.save(peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman,"Entri Data Ok");
    }
    
    public void getPeminjaman(){
        int index=formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman=peminjamanDao.getPeminjaman(index);
        if(peminjaman!=null){
            List<Anggota> listAnggota=anggotaDao.getAllAnggota();
            for(Anggota anggota:listAnggota){
                if(peminjaman.getNobp()==anggota.getNobp()){
                    formPeminjaman.getCboNobp()
                    .setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
                    break;
                }
            }
            formPeminjaman.getCboKodeBuku().setSelectedItem(peminjaman.getKode());
            formPeminjaman.getTxtTglPeminjaman().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
        }
    }
    
    public void update(){
        int index=formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman=peminjamanDao.getPeminjaman(index);
        peminjaman.setNobp(formPeminjaman.getCboNobp()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKode(formPeminjaman.getCboKodeBuku()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglPeminjaman().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
        peminjamanDao.update(index,peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman,"Update Data Ok");
    }
    
    public void delete(){
        int index=formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjamanDao.delete(index);
        JOptionPane.showMessageDialog(formPeminjaman,"Delete Data Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel=
                (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
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
