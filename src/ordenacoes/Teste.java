package ordenacoes;

import ordenacoes.lista.Lista;

public class Teste {

    public static void main(String[] args) {
        Teste teste = new Teste();
        teste.TesteFiori();
    }

    public void TesteFiori()
    {
        Lista lista = new Lista();
        lista.inicializa();
        lista.Randomico();
        lista.exibe("Lista randomica");
        lista.ShellSort();
        lista.exibe("ShellSort");
    }

}
