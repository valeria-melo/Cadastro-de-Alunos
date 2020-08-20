package br.com.mynewapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    //Metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Escutando o botão entrar
        btnEntrar.setOnClickListener {

            //Capturar os dados digitados
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtLoginSenha.text.toString().trim()

            //Validar e-mail e senha digitados
            if (usuario.isEmpty()){
                edtUsuario.error = "Campo Obrigatorio"
                edtUsuario.requestFocus()
            }else if (senha.isEmpty()){
                edtLoginSenha.error = "Campo obrigatorio"
                edtLoginSenha.requestFocus()
            }else{
                //Verificar email e senha digitados

                if (usuario == "root@root.com" && senha == "123456" ) {

                    //Criando um Toast - Contexto, mensagem e Duração
                    Toast.makeText(this, "Usuario Logado!", Toast.LENGTH_LONG).show()

                    //Abrindo a MainActivit
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)
                    finish()

                }else{
                    Toast.makeText(
                        this,

                        "Usuario ou senha Incorretos",Toast.LENGTH_LONG).show()

                }
            }

        }

        // Escutando o botão btnCadastro

        btnCadastro.setOnClickListener{
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)


        }


    }


}