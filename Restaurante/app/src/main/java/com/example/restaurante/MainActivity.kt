package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Cria a var binding servirá para manipular a tela
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
    // Define o layout do MainActivity e atribui a var binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        // Manda o Android usar o layout especificado pelo binding.root para exibir a interface do usuário da atividade atual
        setContentView(binding.root)

       // Passa o username do intent
        val username = intent.extras?.getString("username")

        // Exibe uma mensagem de saudação se o username não for vazio
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá, $username")
        }
        // Define um botão clicável para o botão "Fechar" que termina todas as atividades
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }
        // Define um botão clicável para o botão de "Pedir".
        binding.buttonPedir.setOnClickListener {
            // Cria um intent para iniciar o SplashActivity
            val i = Intent(this, SplashActivity::class.java)
           // Adiciona a quantidade de pizza, salada e hambúrguer como extras para o intent
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            // Inicia o Splash e termina o MainActivity
            startActivity(i)
            finish()
        }

        // Define um botão clicável para o checkbox da pizza.
        binding.checkPizza.setOnClickListener {

            if(binding.checkPizza.isChecked()){
                // Se o checkbox estiver marcado, define a quantidade de pizza para "1".
                binding.editQuantidadePizza.setText("1")
                // Torna o preço da pizza visível.
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                // Se o checkbox não estiver marcado, define a quantidade de pizzas para 0 e oculta o preço
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }
        // Define um botão clicável para o checkbox da salada.
        binding.checkSalada.setOnClickListener {

            if(binding.checkSalada.isChecked()){
                // Se o checkbox estiver marcado, define a quantidade de salada para "1".
                binding.editQuantidadeSalada.setText("1")
                // Torna o preço da salada visível.
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                // Se o checkbox não estiver marcado, define a quantidade de saladas para 0 e oculta o preço
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }
        // Define um botão de clique para o checkbox do Hambúrguer.
        binding.checkHamburger.setOnClickListener {

            if(binding.checkHamburger.isChecked()){
                // Se o checkbox estiver marcado, torna o preço do hambúrguer visível.
                binding.editQuantidadeHamburguer.setText("1")
                // Torna o preço do hambúrguer visível.
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                // Se o checkbox não estiver marcado, define a quantidade do hambúrguer para 0 e oculta o preço
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}
