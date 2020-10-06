package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_display.*
import javax.script.ScriptEngineManager
import kotlin.math.exp


class MainActivity : AppCompatActivity() {

    var expression = ""
    var res = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            Log.e("onCreate", "null")
            supportFragmentManager.beginTransaction().add(R.id.display, DisplayFragment()).commit()
            supportFragmentManager.beginTransaction().add(R.id.buttons, ButtonsFragment()).commit()
        } else {
            Log.e("onCreate", "non-null")
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("expression", expression)
        outState.putString("res", res)
        Log.e("onSaveInstanceState", "Save")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("onRestoreInstanceState", "Restore")
        expression = savedInstanceState.getString("expression").toString()
        res = savedInstanceState.getString("res").toString()
        calcDisplay.text  = expression
        result.text = res
    }

    fun reset() {
        expression = ""
        res = ""
    }

    fun onClick(view: View) {
        view as TextView
        when (view.tag) {
            "numButton" -> {
                expression += view.text.toString()
                Log.e("NUM Button", view.text.toString())
            }
            "operButton" -> {
                expression += view.text.toString()
                Log.e("OPER Button", view.text.toString())
            }
            "clearButton" -> {
                reset()
                Log.e("CLEAR Button", (view as TextView).text.toString())
            }
//            "changeSignButton" -> {
//                Log.e("SIGN Button", (view as TextView).text.toString())
//            }
//            "percentButton" -> {
//                Log.e("PERCENT Button", (view as TextView).text.toString())
//            }
            "dotButton" -> {
                expression += view.text.toString()
                Log.e("DOT Button", (view as TextView).text.toString())
            }
            "resButton" -> {
                val engine = ScriptEngineManager().getEngineByExtension("js")!!
                res = try {
                    val res = engine.eval(expression)
                    res.toString()
                } catch (e: Exception){
                    "error"
                }
                Log.e("EQUAL Button", (view as TextView).text.toString())

            }
        }
        Log.e("OnClick", calcDisplay.text.toString())
        calcDisplay.text  = expression
        result.text = res
    }
}