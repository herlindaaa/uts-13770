package uts13770;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Mahasiswa mahasiswa = new Mahasiswa();
        boolean isRunning = true;
        
        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Daftar Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine();
            
            switch (menu) {
                case 1:
                    System.out.print("Jumlah mahasiswa yang akan diinput: ");
                    int jumlahMahasiswa = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < jumlahMahasiswa; i++) {
                        System.out.println("\nData Mahasiswa ke-" + (i+1));

                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();

                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();

                        System.out.print("Semester: ");
                        int semester = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Usia: ");
                        int usia = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Jumlah mata kuliah yang diambil: ");
                        int jumlahMatkul = scanner.nextInt();
                        scanner.nextLine();

                        String[] krs = new String[jumlahMatkul];
                        int[] nilai = new int[jumlahMatkul];

                        for (int j = 0; j < jumlahMatkul; j++) {
                            System.out.print("Mata kuliah " + (j+1) + ": ");
                            krs[j] = scanner.nextLine();

                            System.out.print("Nilai mata kuliah "+(j+1)+": ");
                            int nilaiMataKuliah = scanner.nextInt();
                            scanner.nextLine();
                            mahasiswa.addNilai(nilaiMataKuliah);
                        }

                        System.out.println("Pilih tipe mahasiswa: ");
                        System.out.println("1. Mahasiswa Baru");
                        System.out.println("2. Mahasiswa Lulus");
                        System.out.println("3. Mahasiswa Transfer");
                        int tipeMahasiswa = scanner.nextInt();
                        scanner.nextLine();

                        if (tipeMahasiswa == 1) {
                            MahasiswaBaru mBaru = new MahasiswaBaru();
                            mBaru.setNim(nim);
                            mBaru.setNama(nama);
                            mBaru.setSemester(semester);
                            mBaru.setUsia(usia);
                            mBaru.setKrs(krs);
                            System.out.print("Asal Sekolah: ");
                            String asalSekolah = scanner.nextLine();
                            mBaru.setAsalSekolah(asalSekolah);

                            System.out.print("Ikut Ospek : ");
                            String ikutOspek = scanner.nextLine();
                            mBaru.setIkutOspek(ikutOspek);

                            daftarMahasiswa.add(mBaru);
                        } else if (tipeMahasiswa == 2) {
                            MahasiswaLulus mLulus = new MahasiswaLulus();
                            mLulus.setNim(nim);
                            mLulus.setNama(nama);
                            mLulus.setSemester(semester);
                            mLulus.setUsia(usia);
                            mLulus.setKrs(krs);

                            System.out.print("Tahun Wisuda: ");
                            int tahunWisuda = scanner.nextInt();
                            mLulus.setTahunWisuda(tahunWisuda);
                            scanner.nextLine();

                            System.out.print("IPK: ");
                            float ipk = scanner.nextFloat();
                            mLulus.setIpk(ipk);
                            scanner.nextLine();

                            daftarMahasiswa.add(mLulus);
                        } else if (tipeMahasiswa == 3) {
                            MahasiswaTransfer mTransfer = new MahasiswaTransfer();
                            mTransfer.setNim(nim);
                            mTransfer.setNama(nama);
                            mTransfer.setSemester(semester);
                            mTransfer.setUsia(usia);
                            mTransfer.setKrs(krs);
                            System.out.print("Asal Universitas: ");
                            String asalUniversitas = scanner.nextLine();
                            mTransfer.setAsalUniversitas(asalUniversitas);

                            daftarMahasiswa.add(mTransfer);
                        } else {
                            System.out.println("Tipe mahasiswa tidak valid.");
                        }
                    }
                    break;
                case 2:
                    // Output data mahasiswa
                    System.out.println("\nDaftar Mahasiswa:");
                    for (Mahasiswa m : daftarMahasiswa) {
                        m.infoMahasiswa();
                        m.infoKrsMahasiswa();
                        ArrayList<Float> nilai = mahasiswa.getNilai();
                        double rataRataNilai = 0.0;

                        System.out.print("Nilai : ");
                        for(int i=0; i<nilai.size(); i++)
                        {
                            float nilaiMataKuliah = nilai.get(i);
                            System.out.print(nilaiMataKuliah + " ");
                            rataRataNilai += nilaiMataKuliah;
                        }
                        if(nilai.size() > 0)
                        {
                            rataRataNilai /= nilai.size();
                        }
                        System.out.println("\nRata-rata nilai : "+rataRataNilai);
                    }
                    break;
                case 3:
                    // Keluar dari program
                    isRunning = false;
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
                            
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}