package retornoboleto1;

public class Principal {
    public static void main(String[] args) {
        ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        String nomeArquivo;
        
        nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        processador.processar(nomeArquivo);
        
        nomeArquivo = Principal.class.getResource("bradesco-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        
        processador.setLeituraRetorno(new LeituraRetornoBradesco());
        processador.processar(nomeArquivo);
    }
}
