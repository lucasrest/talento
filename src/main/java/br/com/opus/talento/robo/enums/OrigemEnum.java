package br.com.opus.talento.robo.enums;

import lombok.Getter;

@Getter
public enum OrigemEnum {

    BNE("BNE"),

    ABLER("ABLER");



    private String value;

    OrigemEnum(String value) {
        this.value = value;
    }
}
