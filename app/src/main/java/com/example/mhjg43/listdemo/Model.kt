package com.example.mhjg43.listdemo

/**
 * Created by mhjg43 on 5/31/2017.
 */
class Model(name: String, type: String, version_number: String, feature: String){
    var name : String
        internal set
    var type : String
        internal set
    var version_number : String
        internal set
    var feature : String
        internal set

    init {
        this.name = name
        this.type = type
        this.version_number = version_number
        this.feature = feature

    }
}