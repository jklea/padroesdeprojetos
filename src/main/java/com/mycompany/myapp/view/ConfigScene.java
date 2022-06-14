/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.view;

import com.mycompany.myapp.App;
import com.mycompany.myapp.model.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


public class ConfigScene extends AbstractScene {

    private final Config config = Config.getInstance();
    
    
    public ConfigScene(App app) {
        super(app);
        var label1 = new Label("Formato de Relatórios");
        var fieldFormatoRelatorios = new TextField(config.getFormatRelatorios());
        var label2 = new Label("Tipos de Gráficos");
        var fieldTipoGraficos = new TextField(config.getTipoGraficos());
        var btnOk = new Button("Ok");
        
        setRoot(new VBox(label1,fieldFormatoRelatorios,label2,fieldTipoGraficos,btnOk));
    
        btnOk.setOnAction(event-> {
            config.setFormatRelatorios(fieldFormatoRelatorios.getText());
            config.setTipoGraficos(fieldTipoGraficos.getText());
            app.setScene(new MainScene(app));
        });
    }
    
}
