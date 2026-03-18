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
        lista.Inversa();
        //lista.exibe("Lista inversa");
        //lista.ShellSort();
        //lista.exibe("ShellSort");
//        lista.HeapSort();
//        lista.exibe("HeapSort");
//        lista.QuickSemPivo();
//        lista.exibe("Quick sem pivo");
//        lista.QuickComPivo();
//        lista.exibe("Quick com pivo");
        lista.FusaoDiretaImp1();
        lista.exibe("Fusao Direta Imp1");
    }

}
