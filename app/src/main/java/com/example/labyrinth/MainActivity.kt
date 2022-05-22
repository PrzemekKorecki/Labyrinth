package com.example.labyrinth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = File(applicationContext.getExternalFilesDir(null), "labyrinth.txt")
         file.writeText("xxxxxxxx")
        file.appendText("x*000xxx")
        file.appendText("xx0x0xxx")
        file.appendText("x00x000x")
        file.appendText("00xx0xxx")
        file.appendText("xxx00xxx")
        file.appendText("x000xxxx")
        file.appendText("xxxxxxxx")

        val readResult = FileInputStream(file).bufferedReader().use { it.readText() }
        var editText = findViewById<EditText>(R.id.editText)

        var tablica: Array<Array<Pole>> = Array(8){Array<Pole>(8){Pole('n')} }

        fun wypelnijTablice(tab: Array<Array<Pole>>){
            var licznik = 0
            for( i in 0 until tab.size){
                for(j in 0 until tab[0].size){
                    tab[i][j].sign = readResult[licznik]
                    tab[i][j].x = i
                    tab[i][j].y = j
                    licznik++
                }
            }
        }

        fun wypiszKoordynaty(tab: Array<Array<Pole>>, _textView: TextView){
            try {
                for (i in 0 until tab.size){
                    for (j in 0 until tab[0].size){
                        if (tab[i][j].sign == editText.text.first()){
                            _textView.append("coordinates of * (x = $i, y = $j)  ")
                        }
                    }
                    _textView.append("\n")
                }
            }catch (e: Exception){
                _textView.text = e.toString()
                _textView.append("\n")
            }
        }

        button.setOnClickListener(){
            wypelnijTablice(tablica)
        }

        button2.setOnClickListener(){
            mazeTest(tablica, tablica2)
            wynikTest(tablica, poleWynik, textView)
        }

        button3.setOnClickListener(){
            textView.text = ""
            wypiszTabZnak(tablica, textView)
//            wypiszTabLicz(tablica, textView)
        }

        button4.setOnClickListener(){
            wypiszTabHasChild(tablica, textView)
        }

        button5.setOnClickListener(){
            wypiszTabVisited(tablica, textView)
        }
    }
}