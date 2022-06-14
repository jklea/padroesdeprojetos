package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Processa arquivos de retorno de boletos bancários utilizando a implementação de
 * alguma estratégia ({@link LeituraRetorno}).
 * Esta é uma classe que chamamos de Estrategista,
 * por poder utilizar diferentes estratégias de acordo com as necessidades,
 * podendo mudar a estratégia a ser utilizada até em tempo de execução.
 *
 * @author Manoel Campos da Silva Filho
 */
public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    /**
     * Instancia a classe estrategista, já indicando
     * @param leituraRetorno
     */
    public ProcessarBoletos(LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

    /**
     * Realiza de fato o processamento de um dado arquivo de retorno de boleto bancário,
     * utilizando uma estratégia definida em {@link #leituraRetorno}.
     * Este método pode realizar diversas operações após a leitura do arquivo,
     * como gravar dados em um banco, enviar emails de notificação, etc.
     * Neste caso, por simplificação, estamos apenas imprimindo os dados no terminal.
     *
     * @param caminhoArquivo Caminho (URI) do arquivo a ser lido
     */
    public final List<Boleto> processar(String nomeArquivo){
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = leituraRetorno.processarLinhaArquivo(vetor);
                boletos.add(boleto);
                System.out.println("boleto");
            }
            return boletos;
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
        
    }

//    /**
//     * Altera a estratégia a ser utilizada para leitura de arquivos de retorno de boletos bancários.
//     * @param leituraRetorno nova estratégia a ser utilizada
//     */
//    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
//        this.leituraRetorno = leituraRetorno;
//    }
}
