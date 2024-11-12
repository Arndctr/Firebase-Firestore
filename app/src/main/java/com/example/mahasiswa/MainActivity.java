package com.example.mahasiswa;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private EditText namaMahasiswaEdt, nimEdt, jurusanEdt;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

        namaMahasiswaEdt = findViewById(R.id.idEdtNamaMahasiswa);
        nimEdt = findViewById(R.id.idEdtNIM);
        jurusanEdt = findViewById(R.id.idEdtJurusan);

        Button submitMahasiswaBtn = findViewById(R.id.idBtnSubmitMahasiswa);

        submitMahasiswaBtn.setOnClickListener(v -> {
            String namaMahasiswa = namaMahasiswaEdt.getText().toString();
            String nim = nimEdt.getText().toString();
            String jurusan = jurusanEdt.getText().toString();

            if (TextUtils.isEmpty(namaMahasiswa)) {
                namaMahasiswaEdt.setError("Masukkan Nama Mahasiswa");
            } else if (TextUtils.isEmpty(nim)) {
                nimEdt.setError("Masukkan NIM");
            } else if (TextUtils.isEmpty(jurusan)) {
                jurusanEdt.setError("Masukkan Jurusan");
            } else {
                addDataToFirestore(namaMahasiswa, nim, jurusan);
            }
        });
    }

    private void addDataToFirestore(String namaMahasiswa, String nim, String jurusan) {
        CollectionReference dbMahasiswa = db.collection("Mahasiswa");

        Mahasiswa mahasiswa = new Mahasiswa(namaMahasiswa, nim, jurusan);

        dbMahasiswa.add(mahasiswa)
                .addOnSuccessListener(documentReference ->
                        Toast.makeText(MainActivity.this, "Mahasiswa berhasil ditambahkan", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e ->
                        Toast.makeText(MainActivity.this, "Gagal menambahkan mahasiswa\n" + e, Toast.LENGTH_SHORT).show());
    }
}