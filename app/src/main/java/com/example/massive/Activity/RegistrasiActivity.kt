package com.example.massive.Activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.massive.UbahKataSandi
import com.example.massive.databinding.ActivityRegistrasiBinding
import com.google.android.gms.tasks.OnCanceledListener
import com.google.firebase.auth.FirebaseAuth

 class RegistrasiActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrasiBinding
    lateinit var auth : FirebaseAuth

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        binding.btnMasukDaftar.setOnClickListener {
            val email = binding.edtEmailDaftar.text.toString()
            val sandi = binding.edtSandiDaftar.text.toString()
            val sandikonfirm = binding.edtSandiDaftarKonfirm.text.toString()

            if (email.isEmpty()) {
                binding.edtEmailDaftar.error = "Email Harus Diisi"
                binding.edtEmailDaftar.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmailDaftar.error = "Email Tidak Valid"
                binding.edtEmailDaftar.requestFocus()
                return@setOnClickListener
            }

            if (sandi.isEmpty()) {
                binding.edtSandiDaftar.error = "Sandi Tidak Valid"
                binding.edtSandiDaftar.requestFocus()
                return@setOnClickListener
            }

            if (sandi.length < 6) {
                binding.edtSandiDaftar.error = "Sandi minimal 6"
                binding.edtSandiDaftar.requestFocus()
                return@setOnClickListener
            }

            if (sandi.isEmpty()) {
                binding.edtSandiDaftarKonfirm.error = "Sandi Tidak Valid"
                binding.edtSandiDaftarKonfirm.requestFocus()
                return@setOnClickListener
            }

            if (sandi.length < 6) {
                binding.edtSandiDaftarKonfirm.error = "Sandi minimal 6"
                binding.edtSandiDaftarKonfirm.requestFocus()
                return@setOnClickListener
            }

            RegistrasiFirebase(email,sandi)
        }

    }

    private fun RegistrasiFirebase(email: String, sandi: String) {
        auth.createUserWithEmailAndPassword(email, sandi)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Daftar Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

 }
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.btn_masuk -> {
//                val intent = Intent(this@RegistrasiActivity, FiturActivity::class.java)
//                startActivity(intent)
//            }
//
//            R.id.tv_login -> {
//                val intent = Intent(this@RegistrasiActivity, LoginActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }
//}