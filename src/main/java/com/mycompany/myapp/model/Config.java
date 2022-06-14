/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.model;

/**
 *
 * @author aluno
 */
public class Config {
    private static final Config instance = new Config();
    
    
    private String formatRelatorios="html";
    private String tipoGraficos="pizza";

    private Config(){}
    
    public static Config getInstance() {
        return instance;
    }
    
    /**
     * @return the formatRelatorios
     */
    public String getFormatRelatorios() {
        return formatRelatorios;
    }

    /**
     * @param formatRelatorios the formatRelatorios to set
     */
    public void setFormatRelatorios(String formatRelatorios) {
        this.formatRelatorios = formatRelatorios;
    }

    /**
     * @return the tipoGraficos
     */
    public String getTipoGraficos() {
        return tipoGraficos;
    }

    /**
     * @param tipoGraficos the tipoGraficos to set
     */
    public void setTipoGraficos(String tipoGraficos) {
        this.tipoGraficos = tipoGraficos;
    }
    
}
