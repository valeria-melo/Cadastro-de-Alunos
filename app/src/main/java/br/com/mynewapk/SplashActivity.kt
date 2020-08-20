package br.com.mynewapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class SplashActivity : AppCompatActivity() { //herança

    //override subescreve o metodo.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //Tudo aqui faz parte do onCreate
        setContentView(R.layout.activity_splash) //pegado a Activity_sphash da pasta layout
        //Tela apareça por 3s // Após 3s, abrir uma nova Activity
        Handler ().postDelayed({
        val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        },3000)

    }
}