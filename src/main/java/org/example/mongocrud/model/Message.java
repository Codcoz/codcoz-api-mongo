package org.example.mongocrud.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class Message {
    private Integer index;
    private String mensagem;
    private LocalDate data;
    private String origem;


    public Message(Integer index, String mensagem, LocalDate data, String origem) {
        this.index = index;
        this.mensagem = mensagem;
        this.data = data;
        this.origem = origem;
    }
    public Message(){}

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}
