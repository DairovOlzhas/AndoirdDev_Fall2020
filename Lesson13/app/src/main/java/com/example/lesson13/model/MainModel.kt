package com.example.lesson13.model

import com.example.lesson13.contract.ContractInterface

class MainModel: ContractInterface.Model {

    private var counter = 0

    override fun getCounter(): Int {
        return counter
    }

    override fun incrementCounter() {
        counter += 1
    }
}