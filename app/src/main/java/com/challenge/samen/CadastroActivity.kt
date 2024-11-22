package com.challenge.samen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CadastroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val etNome: EditText = findViewById(R.id.etNome)
        val etCargo: EditText = findViewById(R.id.etCargo)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etTelefone: EditText = findViewById(R.id.etTelefone)
        val etSenha: EditText = findViewById(R.id.etSenha)
        val btnCadastrar: Button = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val cargo = etCargo.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val telefone = etTelefone.text.toString().trim()
            val senha = etSenha.text.toString().trim()

            if (nome.isEmpty() || cargo.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                // Criar o usuário no Firebase Authentication
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            saveUserData(email, nome, cargo, telefone, senha)
                        } else {
                            Toast.makeText(this, "Erro ao cadastrar: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    private fun saveUserData(email: String, nome: String, cargo: String, telefone: String, senha: String) {
        val user = hashMapOf(
            "nome" to nome,
            "cargo" to cargo,
            "email" to email,
            "telefone" to telefone,
            "senha" to senha
        )

        db.collection("users")
            .document(email) // Usando o email como ID
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Cadastro e dados salvos com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Erro ao salvar dados no Firestore: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
