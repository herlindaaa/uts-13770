package uts13770;

import java.util.ArrayList;

public class Mahasiswa {
    String nim;
    String nama;
    int semester;
    int usia;
    String[] krs;
    private ArrayList<Float> nilai;

    public Mahasiswa() {
        nilai = new ArrayList<>();
    }

    public float hitungRataNilai() {
        if (nilai != null && !nilai.isEmpty()) {
            int total = 0;
            for (int i = 0; i < nilai.size(); i++) {
                total += nilai.get(i);
            }
            return (float) total / nilai.size();
        } else {
            return 0.0f;
        }
    }
    
    public void infoMahasiswa() {
        System.out.println("NIM : " + nim);
        System.out.println("Nama : " + nama);
        System.out.println("Semester : " + semester);
        System.out.println("Usia : " + usia);
    }
    
    public void infoKrsMahasiswa() {
        System.out.println("KRS : ");
        for(int i = 0; i < krs.length; i++)
        {
            System.out.println("- "+krs[i]);
        }
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void setUsia(int usia) {
        this.usia = usia;
    }
    
    public void setKrs(String[] krs) {
        this.krs = krs;
    }

    public void addNilai(float nilai) {
        this.nilai.add(nilai);
    }

    public ArrayList<Float> getNilai() {
        return nilai;
    }
}

class MahasiswaBaru extends Mahasiswa {
    private String asalSekolah;
    private String ikutOspek;
    
    public boolean ikutOspek() {
        return true;
    }
    
    @Override
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Asal Sekolah: " + asalSekolah);
        System.out.println("Ikut OSPEK: " + ikutOspek);
    }
    
    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public void setIkutOspek(String ikutOspek) {
        this.ikutOspek = ikutOspek;
    }
}

class MahasiswaLulus extends Mahasiswa {
    private int tahunWisuda;
    private float ipk;

    public boolean ikutWisuda() {
        return true;
    }
    
    @Override
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Tahun Wisuda : " + tahunWisuda);
        System.out.println("IPK : " + ipk);
    }
    
    @Override
    public void infoKrsMahasiswa() {
        System.out.println("KRS tidak tersedia karena sudah lulus.");
    }
    
    public void setTahunWisuda(int tahunWisuda) {
        this.tahunWisuda = tahunWisuda;
    }
    
    public void setIpk(float ipk) {
        this.ipk = ipk;
    }
}

class MahasiswaTransfer extends MahasiswaBaru {
    private String asalUniversitas;

    
    @Override
    public boolean ikutOspek() {
        return false;
    }
    
    @Override
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Asal Universitas: " + asalUniversitas);
    }
    
    public void setAsalUniversitas(String asalUniversitas) {
        this.asalUniversitas = asalUniversitas;
    }
}

