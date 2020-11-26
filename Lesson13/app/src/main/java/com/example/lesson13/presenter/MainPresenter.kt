package com.example.lesson13.presenter

import com.example.lesson13.contract.ContractInterface
import com.example.lesson13.model.MainModel

class MainPresenter(private val _view: ContractInterface.View): ContractInterface.Presenter {

    private var mainModel: ContractInterface.Model = MainModel()

    override fun incrementValue() {
        mainModel.incrementCounter()
        _view.updateViewData()
    }

    override fun getCounter(): String {
        return mainModel.getCounter().toString()
    }
}