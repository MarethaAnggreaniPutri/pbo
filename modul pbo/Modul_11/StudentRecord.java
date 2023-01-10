/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_11;

/**
 *
 * @author Abennaya
 */
public class StudentRecord {
public String name;
private String address;
private int age;
private double mathGrade;
private double englishGrade;
private double scienceGrade;
private double average;
private static int studentCount;

/*Menghasilkan nama dari Siswa*/

public String getName(){
return name;
}
/*Mengubah nama siswa */

public void setName( String temp ){
name = temp;
}

/* Menghitung rata – rata nilai Matematik, Bahasa Inggris, Ilmu Pasti */

public double getAverage(){
double result = 0;
result = ( mathGrade+englishGrade+scienceGrade )/3;
return result;
}/** * Menghasilkan jumlah instance StudentRecord */
public static int getStudentCount(){
return studentCount;
}
}

class StudentRecord_Implementasinya {

public static void main( String[] args ){
//membuat 3 object StudentRecord
StudentRecord annaRecord = new StudentRecord();
StudentRecord beahRecord = new StudentRecord();
StudentRecord crisRecord = new StudentRecord();

//Memberi nama siswa
annaRecord.setName("Anna");
beahRecord.setName("Beah");
crisRecord.setName("Cris");
//Menampilkan nama siswa “Anna”
System.out.println( annaRecord.getName() );

//Menampilkan jumlah siswa
System.out.println("Count="+StudentRecord.getStudentCount());
}
}

/*Untuk override, method getName dalam subclass*/

class apaajabole extends StudentRecord{
@Override
public String getName(){
System.out.println("Student: Fendy_Ganteng");
return name;
}
}
