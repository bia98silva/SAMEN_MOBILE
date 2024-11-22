package com.challenge.samen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class ModificarCadastroActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificarcadastro)

        val nome = findViewById<EditText>(R.id.editTextNome)
        val cargo = findViewById<EditText>(R.id.editTextCargo)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val telefone = findViewById<EditText>(R.id.editTextTelefone)
        val senha = findViewById<EditText>(R.id.editTextSenha)

        val btnSalvar = findViewById<Button>(R.id.buttonSalvar)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnSalvar.setOnClickListener {
            val emailTexto = email.text.toString().trim()

            if (emailTexto.isNotEmpty()) {
                val updates = mutableMapOf<String, Any>()

                val nomeTexto = nome.text.toString().trim()
                if (nomeTexto.isNotEmpty()) {
                    updates["nome"] = nomeTexto
                }

                val cargoTexto = cargo.text.toString().trim()
                if (cargoTexto.isNotEmpty()) {
                    updates["cargo"] = cargoTexto
                }

                val telefoneTexto = telefone.text.toString().trim()
                if (telefoneTexto.isNotEmpty()) {
                    updates["telefone"] = telefoneTexto
                }

                val senhaTexto = senha.text.toString().trim()
                if (senhaTexto.isNotEmpty()) {
                    updates["senha"] = senhaTexto
                }

                if (updates.isNotEmpty()) {
                    // Verificar se o documento existe antes de atualizar
                    db.collection("users") // Corrigido para 'users'
                        .document(emailTexto) // Usando o email como ID
                        .get()
                        .addOnSuccessListener { document ->
                            if (document.exists()) {
                                // Atualizar apenas os campos modificados no Firestore
                                db.collection("users")
                                    .document(emailTexto)
                                    .update(updates)
                                    .addOnSuccessListener {
                                        Toast.makeText(this, "Informações atualizadas com sucesso!", Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener { e ->
                                        Toast.makeText(this, "Erro ao atualizar: ${e.message}", Toast.LENGTH_SHORT).show()
                                    }
                            } else {
                                Toast.makeText(this, "Usuário não encontrado no Firestore!", Toast.LENGTH_SHORT).show()
                            }
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Erro ao verificar documento: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    Toast.makeText(this, "Nenhuma alteração detectada.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "O campo Email é obrigatório!", Toast.LENGTH_SHORT).show()
            }
        }

        // Botão para voltar
        btnVoltar.setOnClickListener {
            finish() // Fecha a tela e volta para a anterior
        }
    }
}