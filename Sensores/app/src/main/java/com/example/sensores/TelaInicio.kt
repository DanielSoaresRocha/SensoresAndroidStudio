package com.example.sensores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_inicio.*

class TelaInicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)

        listener()
    }

    fun listener(){
        proximidadeBtn.setOnClickListener {
            var telaProximidade = Intent(this, Proximidade::class.java)
            startActivity(telaProximidade)
        }

        luzBtn.setOnClickListener {
            var telaLuz = Intent(this, Luz::class.java)
            startActivity(telaLuz)
        }
        acelerometroBtn.setOnClickListener {
            var telaAcelerometro= Intent(this, Acelerometro::class.java)
            startActivity(telaAcelerometro)
        }
        giroscopioBtn.setOnClickListener {
            var telaGiroscopio = Intent(this, Giroscopio::class.java)
            startActivity(telaGiroscopio)
        }

    }

}
