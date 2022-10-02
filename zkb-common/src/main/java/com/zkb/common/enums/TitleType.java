package com.zkb.common.enums;

public enum TitleType {

    O("")
    ,
    Warframe("Warframe")



    ;
    final String TYPE;
    TitleType(String type){
        this.TYPE = type;
    }
    public String getType(){
        return TYPE;
    }
}
