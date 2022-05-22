package com.example.labyrinth

import android.widget.TextView

fun wynikTest(tab: Array<Array<Pole>>, poleWynik: Pole, _textView: TextView){
    if (poleWynik.x == 0 || poleWynik.y == 0 || poleWynik.x == 7 || poleWynik.y == 7 ){
        _textView.text = ""
        wypiszTabLicz(tab, _textView)
        _textView.append("\n\nK O N I E C  !!!")
        _textView.append("\nŻeby wyjść z labiryntu trzeba wykonać ${poleWynik.licz} kroków.")
    } else if(poleWynik.hasChild < 1){
        poleWynik.sign = 'z'
        lastNode.sign = '*'
        _counter = lastNode.licz
        try {
            nodeQueue.removeAt(nodeQueue.lastIndex)
        } catch (e:Exception){
            _textView.append(e.toString())
        }
        lastNode = nodeQueue[nodeQueue.lastIndex]
    }
}