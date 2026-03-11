import ordenacoes.lista.Lista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args)
    {
        Lista lista = new Lista();
        lista.inicializa();

        //> SELECAO DIRETA
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
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------------------------



    }
}