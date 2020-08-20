package br.com.mynewapk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Criar uma lista de opções para o Spinner
        val listaGenero = arrayListOf("Selecione o Genero", "Feminino", "Masculino", "Outros")
        // Criar um adaptador para o Spiner

        val generoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,listaGenero)

        // Plugar o adaptador para o Spinner
        spnGenero.adapter = generoAdapter

        // Escutando o dados digitados
        val nome = edtNome.text.toString().trim()
        val sobrenome = edtSobrenome.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val senha = editSenha.text.toString().trim()

        //Atribuição condicional

        var genero = if (spnGenero.selectedItemId.toInt() > 0) {
            spnGenero.selectedItem.toString()
        } else {
            ""
        }

        //Validação de Dados - caso o usurario tenha preenchido tudo, a logica cai dentro do corpo do else
        if (nome.isEmpty() || sobrenome.isEmpty()|| email.isEmpty()
            || senha.isEmpty() || genero.isEmpty()){
            //Retornando mensahem de erro
            Toast.makeText(
                this, "Preencha todos os campos", Toast.LENGTH_LONG).show()


        } else {
            // Acessar o arquivo de preferências compartilhadas
            val minhasPreferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE )

            //Salvar dados no arquivo preferencias compartilhadas
                val editPrefs = minhasPreferencias.edit()
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME",sobrenome )
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)
                editPrefs.apply()

        }

    }
}