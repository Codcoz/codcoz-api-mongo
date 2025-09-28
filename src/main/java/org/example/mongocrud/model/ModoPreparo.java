package org.example.mongocrud.model;

public class ModoPreparo {

    private Integer ordem;
    private String passo;

    public Integer getOrdem(){
        return this.ordem;
    }
    public String getPasso(){
        return this.passo;
    }

    public void setOrdem(Integer ordem){
        this.ordem = ordem;
    }
    public void setPasso(String passo){
        this.passo = passo;
    }
}