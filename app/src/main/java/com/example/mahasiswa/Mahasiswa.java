package com.example.mahasiswa;

public class Mahasiswa  {

    private String namaMahasiswa, nim, jurusan;

    public Mahasiswa() {
        // Empty constructor for Firebase
    }

    public Mahasiswa(String namaMahasiswa, String nim, String jurusan) {
        this.namaMahasiswa = namaMahasiswa;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
