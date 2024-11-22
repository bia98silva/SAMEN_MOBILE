package com.challenge.samen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val loginButton = findViewById<Button>(R.id.bt_entrar)
        val registerButton = findViewById<Button>(R.id.bt_cadastrar)
        val emailField = findViewById<EditText>(R.id.Edit_Text)
        val passwordField = findViewById<EditText>(R.id.Edit_Senha)
        val progressBar = findViewById<ProgressBar>(R.id.ProgressBar)

        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            progressBar.visibility = ProgressBar.VISIBLE

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {

                            db.collection("users").document(email)
                                .get()
                                .addOnSuccessListener { document ->
                                    if (document != null && document.exists()) {
                                        val nomeUsuario = document.getString("nome") ?: "Usuário"

                                        // Envia o nome para a MonitoramentoActivity
                                        val intent = Intent(this, MonitoramentoActivity::class.java)
                                        intent.putExtra("nomeUsuario", nomeUsuario)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        Toast.makeText(this, "Dados do usuário não encontrados.", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(this, "Erro ao obter dados: ${e.message}", Toast.LENGTH_SHORT).show()
                                }
                        } else {
                            Toast.makeText(this, "Erro no login: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                progressBar.visibility = ProgressBar.INVISIBLE
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}
