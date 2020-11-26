package com.example.lesson13.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson13.R
import com.example.lesson13.contract.ContractInterface
import com.example.lesson13.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractInterface.View {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        initView()
    }

    override fun initView() {
        counter_text_view.text = presenter?.getCounter()
        count_button.setOnClickListener {
            presenter?.incrementValue()
        }
    }

    override fun updateViewData() {
        counter_text_view.text = presenter?.getCounter()
    }
}