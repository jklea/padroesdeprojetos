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
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Banco do Bradesco.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author Manoel Campos da Silva Filho
 */
 // tag::class-start[]
public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(URI caminhoArquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(caminhoArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                // end::class-start[]
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                String[] vetorData = vetor[5].split(" ");
                String[] vetorHora = vetorData[1].split(":");
                boleto.setDataPagamento(LocalDate.parse(vetorData[0], FORMATO_DATA).atTime(Integer.parseInt(vetorHora[0]), Integer.parseInt(vetorHora[1]), Integer.parseInt(vetorHora[2])));

                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));

                // tag::class-end[]
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
 // end::class-end[]
