import ordenacoes.lista.Lista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args)
    {
        Lista lista = new Lista();
        lista.inicializa();

        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- INSERÇÃO DIRETA EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes da inserção direta:");
        lista.insercao_direta();
        lista.exibe("Lista em ordem pós inserção direta:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- INSERÇÃO DIRETA EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes da inserção direta:");
        lista.insercao_direta();
        lista.exibe("Lista em ordem inversa pós inserção direta:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- INSERÇÃO DIRETA EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes da inserção direta:");
        lista.insercao_direta();
        lista.exibe("Lista em ordem randomica pós inserção direta:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- INSERÇÃO BINÁRIA EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes da inserção binária:");
        lista.InsercaoBinaria();
        lista.exibe("Lista em ordem pós inserção binária:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- INSERÇÃO BINÁRIA EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes da inserção binária:");
        lista.InsercaoBinaria();
        lista.exibe("Lista em ordem inversa pós inserção binária:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- INSERÇÃO BINÁRIA EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes da inserção binária:");
        lista.InsercaoBinaria();
        lista.exibe("Lista em ordem randomica pós inserção binária:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- SELEÇÃO DIRETA EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes da seleção direta:");
        lista.selecaoDireta();
        lista.exibe("Lista em ordem pós seleção direta:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- SELEÇÃO DIRETA EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes da seleção direta:");
        lista.selecaoDireta();
        lista.exibe("Lista em ordem inversa pós seleção direta:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- SELEÇÃO DIRETA EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes da seleção direta:");
        lista.selecaoDireta();
        lista.exibe("Lista em ordem randomica pós seleção direta:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- BOLHA EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes da bolha:");
        lista.Bolha();
        lista.exibe("Lista em ordem pós bolha:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- BOLHA EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes da bolha:");
        lista.Bolha();
        lista.exibe("Lista em ordem inversa pós bolha:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- BOLHA EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes da bolha:");
        lista.Bolha();
        lista.exibe("Lista em ordem randomica pós bolha:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- SHAKE EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do shake:");
        lista.Shake();
        lista.exibe("Lista em ordem pós shake:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- SHAKE EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do shake:");
        lista.Shake();
        lista.exibe("Lista em ordem inversa pós shake:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- SHAKE EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do shake:");
        lista.Shake();
        lista.exibe("Lista em ordem randomica pós shake:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- SHELL EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do shell:");
        lista.ShellSort();
        lista.exibe("Lista em ordem pós shell:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- SHELL EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do shell:");
        lista.ShellSort();
        lista.exibe("Lista em ordem inversa pós shell:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- SHELL EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do shell:");
        lista.ShellSort();
        lista.exibe("Lista em ordem randomica pós shell:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- HEAP EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do heap:");
        lista.HeapSort();
        lista.exibe("Lista em ordem pós heap:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- HEAP EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do heap:");
        lista.HeapSort();
        lista.exibe("Lista em ordem inversa pós heap:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- HEAP EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do heap:");
        lista.HeapSort();
        lista.exibe("Lista em ordem randomica pós heap:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- QUICK COM PIVÔ EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do quick com pivô:");
        lista.QuickComPivo();
        lista.exibe("Lista em ordem pós quick com pivô:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- QUICK COM PIVÔ EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do quick com pivô:");
        lista.QuickComPivo();
        lista.exibe("Lista em ordem inversa pós quick com pivô:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- QUICK COM PIVÔ EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do quick com pivô:");
        lista.QuickComPivo();
        lista.exibe("Lista em ordem randomica pós quick com pivô:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- QUICK SEM PIVÔ EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do quick sem pivô:");
        lista.QuickSemPivo();
        lista.exibe("Lista em ordem pós quick sem pivô:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- QUICK SEM PIVÔ EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do quick sem pivô:");
        lista.QuickSemPivo();
        lista.exibe("Lista em ordem inversa pós quick sem pivô:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- QUICK SEM PIVÔ EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do quick sem pivô:");
        lista.QuickSemPivo();
        lista.exibe("Lista em ordem randomica pós quick sem pivô:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- FUSÃO DIRETA / MERGE 1 EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes da fusão direta 1:");
        lista.FusaoDiretaImp1();
        lista.exibe("Lista em ordem pós fusão direta 1:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- FUSÃO DIRETA / MERGE 1 EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes da fusão direta 1:");
        lista.FusaoDiretaImp1();
        lista.exibe("Lista em ordem inversa pós fusão direta 1:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- FUSÃO DIRETA / MERGE 1 EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes da fusão direta 1:");
        lista.FusaoDiretaImp1();
        lista.exibe("Lista em ordem randomica pós fusão direta 1:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- FUSÃO DIRETA / MERGE 2 EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes da fusão direta 2:");
        lista.FusaoDiretaImp2();
        lista.exibe("Lista em ordem pós fusão direta 2:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- FUSÃO DIRETA / MERGE 2 EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes da fusão direta 2:");
        lista.FusaoDiretaImp2();
        lista.exibe("Lista em ordem inversa pós fusão direta 2:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- FUSÃO DIRETA / MERGE 2 EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes da fusão direta 2:");
        lista.FusaoDiretaImp2();
        lista.exibe("Lista em ordem randomica pós fusão direta 2:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- COUNTING EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do counting:");
        lista.Counting();
        lista.exibe("Lista em ordem pós counting:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- COUNTING EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do counting:");
        lista.Counting();
        lista.exibe("Lista em ordem inversa pós counting:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- COUNTING EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do counting:");
        lista.Counting();
        lista.exibe("Lista em ordem randomica pós counting:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- BUCKET EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do bucket:");
        lista.Bucket();
        lista.exibe("Lista em ordem pós bucket:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- BUCKET EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do bucket:");
        lista.Bucket();
        lista.exibe("Lista em ordem inversa pós bucket:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- BUCKET EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do bucket:");
        lista.Bucket();
        lista.exibe("Lista em ordem randomica pós bucket:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- RADIX EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do radix:");
        lista.Radix();
        lista.exibe("Lista em ordem pós radix:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- RADIX EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do radix:");
        lista.Radix();
        lista.exibe("Lista em ordem inversa pós radix:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- RADIX EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do radix:");
        lista.Radix();
        lista.exibe("Lista em ordem randomica pós radix:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- COMB EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do comb:");
        lista.Comb();
        lista.exibe("Lista em ordem pós comb:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- COMB EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do comb:");
        lista.Comb();
        lista.exibe("Lista em ordem inversa pós comb:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- COMB EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do comb:");
        lista.Comb();
        lista.exibe("Lista em ordem randomica pós comb:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- GNOME EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do gnome:");
        lista.Gnome();
        lista.exibe("Lista em ordem pós gnome:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- GNOME EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do gnome:");
        lista.Gnome();
        lista.exibe("Lista em ordem inversa pós gnome:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- GNOME EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do gnome:");
        lista.Gnome();
        lista.exibe("Lista em ordem randomica pós gnome:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

//----------- TIM EM ORDEM
        lista.emOrdem();
        lista.exibe("Lista em ordem antes do tim:");
        lista.Tim();
        lista.exibe("Lista em ordem pós tim:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- TIM EM ORDEM INVERSA
        lista.Inversa();
        lista.exibe("Lista em ordem inversa antes do tim:");
        lista.Tim();
        lista.exibe("Lista em ordem inversa pós tim:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
//----------- TIM EM ORDEM RANDOMICA
        lista.Randomico();
        lista.exibe("Lista em ordem randomica antes do tim:");
        lista.Tim();
        lista.exibe("Lista em ordem randomica pós tim:");
//--------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");



    }
}