package ordenacoes.arquivo;

public class Teste {
    public static void main(String[] args) {
        Teste teste = new Teste();
        teste.Teste();
    }

    private void Teste()
    {
        Arquivo arq = new Arquivo("arquivo.dat");
        arq.geraArqInverso();
        arq.exibirArq();
        arq.selecaoDireta();
        System.out.println("\nOrdenada");
        arq.exibirArq();
    }
}
