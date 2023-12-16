package com.example.massive.Activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.massive.databinding.ActivityLoginBinding
import com.example.massive.databinding.ActivityRegistrasiBinding
import com.google.firebase.auth.FirebaseAuth

 class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToDaftar.setOnClickListener {
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
        }

        binding.btnMasukLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val sandi = binding.edtKatasandiLogin.text.toString()

            if (email.isEmpty()) {
                binding.edtEmailLogin.error = "Email Harus Diisi"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmailLogin.error = "Email Tidak Valid"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            if (sandi.isEmpty()) {
                binding.edtKatasandiLogin.error = "Sandi Tidak Valid"
                binding.edtKatasandiLogin.requestFocus()
                return@setOnClickListener
            }

            if (sandi.length < 6) {
                binding.edtKatasandiLogin.error = "Sandi minimal 6"
                binding.edtKatasandiLogin.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,sandi)
        }

    }

    private fun LoginFirebase(email: String, sandi: String) {
        auth.signInWithEmailAndPassword(email, sandi)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, FiturActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }



//    override fun onClick(v: View) {
//        when (v.id) {
//
//            R.id.btn_masuk1 -> {
//                val intent = Intent(this@LoginActivity, FiturActivity::class.java)
//                startActivity(intent)
//            }
//
//            R.id.tv_daftar -> {
//                val intent = Intent(this@LoginActivity, RegistrasiActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }
}
