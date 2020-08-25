package com.one46health.medis.model

//1
class DataHolder {
    //2
    private var hhhName: String? = null
    private var issue: String? = null
    private var dataDate: String? = null


    fun DataHolder() {

    }


    fun DataHolder(hhhName: String, dataDate: String, issue: String?) {
        this.hhhName = hhhName
        this.issue = issue
        this.dataDate = dataDate
    }


    fun getHhhName(): String? {
        return hhhName
    }

    fun getIssue(): String? {
        return issue
    }

    fun getDataDate(): String? {
        return dataDate
    }

    fun setHhhName() {
        this.hhhName = hhhName
    }

    fun setIssue() {
        this.issue = issue
    }

    fun setDataDate() {
        this.dataDate = dataDate
    }

}

