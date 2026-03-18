package ordenacoes;

import ordenacoes.lista.Lista;
import ordenacoes.lista.No;

public class Teste {

    public static void main(String[] args) {
        Teste teste = new Teste();
        teste.TesteAutista();
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

    public void TesteAutista()
    {
        Lista lista = new Lista();
        lista.inicializa();
        lista.emOrdem();
        No sla = lista.BBFiori(16);
        lista.exibe("lista");
        if (sla != null)
            System.out.println(sla.getNum());
        else
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
    }

}
