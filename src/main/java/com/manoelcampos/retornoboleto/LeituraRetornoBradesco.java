package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do
 * Banco do Bradesco. Esta classe usa o padrão Strategy, representando a
 * implementação da estratégia {@link LeituraRetorno}.
 *
 * @author Manoel Campos da Silva Filho
 */
// tag::class-start[]
public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        // end::class-start[]
        boleto.setAgencia(vetorLinhaArq[2]);
        boleto.setContaBancaria(vetorLinhaArq[3]);

        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[4], FORMATO_DATA));
        String[] vetorData = vetorLinhaArq[5].split(" ");
        String[] vetorHora = vetorData[1].split(":");
        boleto.setDataPagamento(LocalDate.parse(vetorData[0], FORMATO_DATA).atTime(Integer.parseInt(vetorHora[0]), Integer.parseInt(vetorHora[1]), Integer.parseInt(vetorHora[2])));

        boleto.setCpfCliente(vetorLinhaArq[6]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[7]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[8]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[9]));
        return boleto;
    }
}
 // end::class-end[]
