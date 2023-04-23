package br.com.opus.talento.robo.enums;

import lombok.Getter;

@Getter
public enum SituacaoEnum {

    CARREGADO("CARREGADO"),

    ENVIADO("ENVIADO");

    private String value;

    SituacaoEnum(String value) {
        this.value = value;
    }
}
