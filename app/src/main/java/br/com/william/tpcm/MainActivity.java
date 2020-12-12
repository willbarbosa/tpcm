/*
    Trabalho pratico para a disciplina de Computação Movel
    Professor: Daniel Avila Vecchiato
    Aluno/Autor: William Rodrigues Barbosa
 */

package br.com.william.tpcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = (TextView) findViewById(R.id.textOutput);
        Button btn = (Button) findViewById(R.id.button1);

        String txt = numbersToString();
        txtView.setText(txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = numbersToString();
                txtView.setText(txt);
            }
        });
    }

//    Função que gera o array com numeros de 1 à 60 sem repetir
    public static Set<Integer> getRandomNumbers(int min, int max) {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>(); // Utilizei o hashset devido a sua natureza de não permitir numeros repetidos no array
        int number;

        while(numbers.size() < 6) {
            number = random.nextInt(max) + min;
            numbers.add(number);
        }

        return numbers;
    }

    // Função para converter o hashset de numeros aleatorios em uma string
    public static String numbersToString() {
        String output;
        output = getRandomNumbers(1, 60).toString();
        output = output.replaceAll("[^\\d.]", " "); // Regex para remover caracteres não numericos da string
        output = output.replace("  ", " - ");

        return output;
    }
}