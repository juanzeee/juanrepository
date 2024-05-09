package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Manda o Android usar o layout especificado pelo binding.root para mostrar a interface do usuário da atividade atual.
        setContentView(R.layout.activity_splash)
        // Cria um handler para o looper principal
        Handler(Looper.getMainLooper()).postDelayed({
            // Declara os valores passados pela intent
            val i = intent
            // Cria uma nova intent para iniciar o PedidoActivity
            val j = Intent(this,PedidoActivity::class.java)
            // Copia o dados extras da intent atual para a nova intent
            j.putExtras(i)
            // Inicia o Activity
            startActivity(j)
            // Coloca um atraso de 2000 milissegundos (2 segundos) antes de iniciar o PedidoActivity
        },2000)

    }
}
