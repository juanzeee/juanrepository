package com.example.jogodavelha

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelha.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Vetor bidimensional que representará o tabuleiro de jogo
    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    // Qual o Jogador está jogando
    var jogadorAtual = "X"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
    }

    // Função associada com todos os botões @param view é o botão clicado
    fun buttonClick(view: View) {
        val buttonSelecionado = view as Button

        // De acordo com o botão clicado, a posição da matriz receberá o Jogador
        when (buttonSelecionado.id) {
            binding.buttonZero.id -> tabuleiro[0][0] = jogadorAtual
            binding.buttonUm.id -> tabuleiro[0][1] = jogadorAtual
            binding.buttonDois.id -> tabuleiro[0][2] = jogadorAtual
            binding.buttonTres.id -> tabuleiro[1][0] = jogadorAtual
            binding.buttonQuatro.id -> tabuleiro[1][1] = jogadorAtual
            binding.buttonCinco.id -> tabuleiro[1][2] = jogadorAtual
            binding.buttonSeis.id -> tabuleiro[2][0] = jogadorAtual
            binding.buttonSete.id -> tabuleiro[2][1] = jogadorAtual
            binding.buttonOito.id -> tabuleiro[2][2] = jogadorAtual
        }

        // Definir imagem de acordo com o jogador atual (Cebolinha)
        if (jogadorAtual == "X") {
            buttonSelecionado.setBackgroundResource(R.drawable.cebolinhaaaa_capa)
        }

        buttonSelecionado.isEnabled = false

        // Verificar se há um vencedor após a jogada
        var vencedor = verificaVencedor(tabuleiro)

        if (!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Adicionar um atraso antes da jogada do computador
        Handler().postDelayed({
            jogadaComputador()
        }, 1500) // Atraso de 1.5 segundo (1500 milissegundos)
    }

    // Função para a jogada do computador
    private fun jogadaComputador() {
        var rX: Int
        var rY: Int
        var i = 0

        // Inicializar rX e rY para evitar erro de compilação
        rX = 0
        rY = 0

        // Realizar até encontrar uma posição válida no tabuleiro
        while (i < 9) {
            rX = Random.nextInt(0, 3)
            rY = Random.nextInt(0, 3)

            if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                break
            }

            i++
        }

        tabuleiro[rX][rY] = "O"

        // Atualizar o botão correspondente com a imagem da Mônica
        val posicao = rX * 3 + rY
        when(posicao){
            0 -> {
                binding.buttonZero.setBackgroundResource(R.drawable.monica)
                binding.buttonZero.isEnabled = false
            }
            1 -> {
                binding.buttonUm.setBackgroundResource(R.drawable.monica)
                binding.buttonUm.isEnabled = false
            }
            2 -> {
                binding.buttonDois.setBackgroundResource(R.drawable.monica)
                binding.buttonDois.isEnabled = false
            }
            3 -> {
                binding.buttonTres.setBackgroundResource(R.drawable.monica)
                binding.buttonTres.isEnabled = false
            }
            4 -> {
                binding.buttonQuatro.setBackgroundResource(R.drawable.monica)
                binding.buttonQuatro.isEnabled = false
            }
            5 -> {
                binding.buttonCinco.setBackgroundResource(R.drawable.monica)
                binding.buttonCinco.isEnabled = false
            }
            6 -> {
                binding.buttonSeis.setBackgroundResource(R.drawable.monica)
                binding.buttonSeis.isEnabled = false
            }
            7 -> {
                binding.buttonSete.setBackgroundResource(R.drawable.monica)
                binding.buttonSete.isEnabled = false
            }
            8 -> {
                binding.buttonOito.setBackgroundResource(R.drawable.monica)
                binding.buttonOito.isEnabled = false
            }
        }


        // Verificar se há um vencedor após a jogada do computador
        var vencedor = verificaVencedor(tabuleiro)

        if(!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Função para verificar se há um vencedor
    fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
        // Verificar linhas e colunas
        for (i in 0 until 3) {
            // Verificar se há três itens iguais na linha
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0]
            }
            // Verificar se há três itens iguais na coluna
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i]
            }
        }
        // Verificar diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0]
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2]
        }
        // Verificar empate
        var empate = 0
        for (linha in tabuleiro) {
            for (valor in linha) {
                if (valor == "X" || valor == "O") {
                    empate++
                }
            }
        }
        // Se existem 9 jogadas e não há três letras iguais, houve um empate
        if (empate == 9) {
            return "Empate"
        }
        // Nenhum vencedor
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val modoDificuldade = intent.getStringExtra("modoDificuldade")
        if (modoDificuldade != null) {
            // Aqui você pode configurar o jogo com base no modo de dificuldade escolhido
            // Exemplo: iniciar o jogo com a dificuldade selecionada
            if (modoDificuldade == "Fácil") {
                // Configuração para o modo fácil
            } else if (modoDificuldade == "Difícil") {
                // Configuração para o modo difícil
            }
        }
    }

    private fun jogadaComputadorFacil() {
        var rX: Int
        var rY: Int
        var i = 0

        // Realizar até encontrar uma posição válida no tabuleiro
        while (i < 9) {
            rX = Random.nextInt(0, 3)
            rY = Random.nextInt(0, 3)

            if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                break
            }

            i++
        }

        tabuleiro[rX][rY] = "O"

        // Atualizar o botão correspondente com a imagem da Mônica
        val posicao = rX * 3 + rY
        atualizaBotao(posicao)

        // Verificar se há um vencedor após a jogada do computador
        verificaETrataVencedor()
    }
    // Função para a jogada do computador (modo difícil)
    private fun jogadaComputadorDificil() {
        // Implementação da lógica para jogada difícil aqui

        // Exemplo de estratégia simples: verificar se há uma jogada que vence o jogo
        var posicaoVitoria = encontraJogadaVitoriosa("O")
        if (posicaoVitoria == null) {
            // Se não há jogada de vitória iminente, bloquear jogada do jogador se houver
            posicaoVitoria = encontraJogadaVitoriosa("X")
            if (posicaoVitoria == null) {
                // Se não há jogada de bloqueio, jogar aleatoriamente
                var rX: Int
                var rY: Int
                var i = 0

                // Realizar até encontrar uma posição válida no tabuleiro
                while (i < 9) {
                    rX = Random.nextInt(0, 3)
                    rY = Random.nextInt(0, 3)

                    if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                        break
                    }

                    i++
                }

                posicaoVitoria = Pair(rX, rY)
            }
        }

        // Realiza a jogada no tabuleiro
        tabuleiro[posicaoVitoria.first][posicaoVitoria.second] = "O"

        // Atualiza o botão correspondente com a imagem da Mônica
        val posicao = posicaoVitoria.first * 3 + posicaoVitoria.second
        atualizaBotao(posicao)

        // Verifica se há um vencedor após a jogada do computador
        verificaETrataVencedor()
    }

    // Função auxiliar para encontrar uma jogada que leve à vitória ou bloqueio
    private fun encontraJogadaVitoriosa(jogador: String): Pair<Int, Int>? {
        // Implementação para encontrar uma jogada vitoriosa ou de bloqueio
        // Retorna a posição (linha, coluna) ou null se não houver
        // Aqui você implementaria uma lógica mais sofisticada para análise de possibilidades
        return null
    }

    // Função para atualizar o botão correspondente após a jogada do computador
    private fun atualizaBotao(posicao: Int) {
        val button = when (posicao) {
            0 -> binding.buttonZero
            1 -> binding.buttonUm
            2 -> binding.buttonDois
            3 -> binding.buttonTres
            4 -> binding.buttonQuatro
            5 -> binding.buttonCinco
            6 -> binding.buttonSeis
            7 -> binding.buttonSete
            8 -> binding.buttonOito
            else -> null
        }

        button?.setBackgroundResource(R.drawable.monica)
        button?.isEnabled = false
    }

    // Função para verificar se há um vencedor após a jogada do computador
    private fun verificaETrataVencedor() {
        val vencedor = verificaVencedor(tabuleiro)
        if (!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "Vencedor: $vencedor", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}