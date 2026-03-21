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
        boolean flag = true;
        if (flag) {
            lista.Inversa();
            lista.exibe("Lista inversa");
        }
        else
        {
            lista.Randomico();
            lista.exibe("Lista randomica");
        }
        //lista.ShellSort();
        //lista.exibe("ShellSort");
//        lista.HeapSort();
//        lista.exibe("HeapSort");
//        lista.QuickSemPivo();
//        lista.exibe("Quick sem pivo");
//        lista.QuickComPivo();
//        lista.exibe("Quick com pivo");
//        lista.FusaoDiretaImp1();
//        lista.exibe("Fusao Direta Imp1");
//        lista.Counting();
//        lista.exibe("Counting Sort");
//        lista.Bucket();
//        lista.exibe("Bucket Sort");
//        lista.Counting();
//        lista.exibe("Radix");
        lista.FusaoDiretaImp2();
        lista.exibe("Fusão direta imp2");
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
