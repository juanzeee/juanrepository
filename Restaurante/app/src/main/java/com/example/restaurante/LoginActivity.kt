package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
// Cria a var binding que serve para manipular a tela.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout de Login e a atribui a var binding.
        binding = ActivityLoginBinding.inflate(layoutInflater)
       // Manda Android usar o layout especificado pelo binding.root para exibir a interface do usuário da atividade atual
        setContentView(binding.root)

        // Define um OnClicklistener para o botão "Entrar".
        binding.buttonEntrar.setOnClickListener {

            // Define os valores da var para o nome de Usuário e a Senha inserida pelo usuário, converte para String e elimina os espaços em branco.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // Verifica se o nome de usuário e a senha inserido pelo usuário estão corretos.
            if (username.equals("abc") && password.equals("123")) {
                // Cria um Intent para iniciar o MainActivity
                val i = Intent(this, MainActivity::class.java)
                // Adiciona o nome de usuário como extra para a intent
                i.putExtra("username", username)
              // Inicia o MainActivity
                startActivity(i)
               // Finaliza o LoginActivity
                finish()
            } else {
                // Se o usuário e a senha estiverem errados, mostra uma mensagem de erro.
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}
