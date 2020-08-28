package com.one46health.medis.model

//1
public class DataHolder {
    //2
    public var houseHeadName: String? = null
    public var householdNumber: String? = null
    public var dateofData: String? = null


    public fun DataHolder() {

    }


    public fun DataHolder(houseHeadName: String, dateofData: String, householdNumber: String?) {
        this.houseHeadName = houseHeadName
        this.householdNumber = householdNumber
        this.dateofData = dateofData
    }


    fun getHouseheadName(): String? {
        return houseHeadName
    }

    public fun getHouseHoldNumber(): String? {
        return householdNumber
    }
    fun getDateData(): String? {
        return dateofData
    }


    fun setHouseHeadName() {
        this.houseHeadName = houseHeadName
    }

    fun setHouseholdNumber() {
        this.householdNumber = householdNumber
    }

    fun setDateofData() {
        this.dateofData = dateofData
    }

}

