package com.example.primeiroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
    
            //Mensagem()
            //ExemploLinha()
            ExemploBotao()
        }
    }
}

@Composable
fun ExemploLinha(){
    Row {
        Text(text = "Esquerda")
        Text(text = "Central")
        Text(text = "Direita")
    }


}

@Composable //assinatura que permite a Função mensagem possa compor o layout 
fun Mensagem(){
    Text(text = "aaaaaa")
}

@Preview(showBackground = true) // permite dar um preview sem iniciar o emulador
@Composable // uma função preview Tambem precisa ser um Composable
fun PreviewLayout(){ // serve apenas para ver  um preview sem o emulador
    //Mensagem()
    //ExemploLinha()
    //ExemploColuna()
    //ExemploLayout()
    ExemploBotao()
}

@Composable
fun ExemploColuna(){
    Column {
        Text(text = "Superior")
        Text(text = "Central")
        Text(text = "Inferior")
    }
}

@Composable
fun ExemploLayout(){
    val name = "Jason"
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Exemplo de layout centralizado")
        Text(text = "App desenvolvido por $name")
    }
}

@Composable
fun ExemploBotao(){
    // qualquer variavel que vai ser alterada durante tempo de exec precisa fazer isso aqui
    var textoBotao by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
        Text(text = "Clique no botao abaixo:")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            if(textoBotao.isEmpty()){
                textoBotao = "Você clicou no Botao"
            }else{
                textoBotao = ""
            }

        }){

            Text(text = "Clique aqui")

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = textoBotao)


    }
}