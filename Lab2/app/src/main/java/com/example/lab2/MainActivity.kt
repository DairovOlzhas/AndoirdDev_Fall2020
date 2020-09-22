package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    var counter = 0
    var first = 0.0
    var second = 0.0
    var op = ""
    var res = 0.0
    var hasDot = false
    var numsAfterDot = 0
    var last = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "OnCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("first", first)
        outState.putDouble("second", second)
        outState.putString("op", op)
        outState.putDouble("res", res)
        outState.putBoolean("hasDot", hasDot)
        outState.putInt("numsAfterDot", numsAfterDot)
        outState.putString("last", last)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        first = savedInstanceState.getDouble("first")
        second = savedInstanceState.getDouble("second")
        op = savedInstanceState.getString("op").toString()
        res = savedInstanceState.getDouble("res")
        hasDot = savedInstanceState.getBoolean("hasDot")
        numsAfterDot = savedInstanceState.getInt("numsAfterDot")
        last = savedInstanceState.getString("last").toString()
        calcDisplay.text = first.toString()
    }

    fun reset() {
        first = 0.0
        second = 0.0
        op = ""
        res = 0.0
        hasDot = false
        numsAfterDot = 0
        last = ""
        calcDisplay.text = "0"
    }

    fun makeOp(a: Double, b: Double):Double {
        when (op) {
            "*" -> return a * b
            "-" -> return a - b
            "+" -> return a + b
            "/" -> {
                return a / b
            }
            else -> return 0.0
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClick(view: View) {
        when (view.tag) {
            "numButton" -> {
                if (last == "op") {
                    first = 0.0
                    numsAfterDot = 0
                    hasDot = false
                }
                val num = (view as TextView).text.toString().toDouble()
                Log.e("numButton $num", "OnClick")

                if (!hasDot) {
                    first = if (first == 0.0)
                        num
                    else
                        (first * 10.0) + first.sign*num
                    calcDisplay.text = first.toInt().toString()
                } else {
                    numsAfterDot++
                    first += num/(10.0.pow(numsAfterDot))
                    calcDisplay.text = String.format("%.${numsAfterDot}f", first)
                }
                last = "num"
            }
            "operButton" -> {
                Log.e("operButton", "OnClick")

                op = (view as TextView).text.toString()
                second = first
                numsAfterDot = 0
                hasDot = false
                last = "op"
            }
            "resButton" -> {
                Log.e("resButton", "OnClick")
                if (op != "") {
                    when (last) {
                        "res" -> {
                            first = makeOp(first, second)
                        }
                        "op" -> {
                            first = makeOp(second, first)
                        }
                        "num" -> {
                            var tmp = first
                            first = second
                            second = tmp
                            first = makeOp(first, second)
                        }
                    }

                    calcDisplay.text = String.format("%.2f", first)
                    numsAfterDot = 2
                }
                last = "res"
            }
            "dotButton" -> {
                Log.e("dotButton", "OnClick")
                if (!hasDot) {
                    hasDot = true
                    calcDisplay.text = "${first.toInt()}."
                }
                last = "num"
            }
            "clearButton" -> {
                Log.e("clearButton", "OnClick")
                reset()
            }
            "percentButton" -> {
                first = second*first/100
                var tmp = first
                first = second
                second = tmp
                first = makeOp(first, second)
                calcDisplay.text = String.format("%.${numsAfterDot}f", first)
                 last = "op"
            }
            "changeSignButton" -> {
                Log.e("changeSignButton", "OnClick")
                first = -first
                calcDisplay.text = String.format("%.${numsAfterDot}f", first)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "OnRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "OnStop")
    }

    override fun onDestroy() {
        Log.e("MainActivity", "OnDestroy")
        super.onDestroy()
    }
}