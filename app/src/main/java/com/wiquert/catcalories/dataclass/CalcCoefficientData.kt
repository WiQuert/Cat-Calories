package com.wiquert.catcalories.dataclass

data class CalcCoefficientData(
    var coefficient : Double,
    var description : String
)
{

    override fun toString(): String {
        return description
    }

}
