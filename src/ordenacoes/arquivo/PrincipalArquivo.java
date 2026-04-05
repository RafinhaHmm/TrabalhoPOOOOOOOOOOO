package ordenacoes.arquivo;

import java.io.*;

public class PrincipalArquivo
{
    private Arquivo arqOrd, arqRev, arqRand, auxRev, auxRand;
    private long tini, tfim;
    private long ttotalO, ttotalRev, ttotalRand;
    private int compO, compRev, compRand;
    private int movO, movRev, movRand;
    private static String arqResp = "resultado.txt";

    public PrincipalArquivo()
    {
        arqOrd = new Arquivo("arqOrd.dat");
        arqRev = new Arquivo("arqRev.dat");
        arqRand = new Arquivo("arqRand.dat");
        auxRev = new Arquivo("auxRev.dat");
        auxRand = new Arquivo("auxRand.dat");
        try {
            FileWriter wrt = new FileWriter(arqResp);
            wrt.append(String.format("%-22s | %-38s | %-38s | %-38s|%n","Métodos Ordenação","Arquivo Ordenado","Arquivo em Ordem Reversa","Arquivo Randômico"));
            wrt.append(LinhaSeparacao());
            wrt.append(String.format(
                    "%-22s |%-6s |%-6s |%-6s |%-6s |%-7s |%-6s |%-6s |%-6s |%-6s |%-7s |%-6s |%-6s |%-6s |%-6s |%-7s |%n",
                    "",
                    "C.P", "C.E", "M.P", "M.E", "Tempo",
                    "C.P", "C.E", "M.P", "M.E", "Tempo",
                    "C.P", "C.E", "M.P", "M.E", "Tempo"));
            wrt.append(LinhaSeparacao());
            wrt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String LinhaSeparacao()
    {
        return "-----------------------|----------------------------------------|----------------------------------------|----------------------------------------|\n";
    }

    public void geraTabela()
    {
        arqOrd.geraArqOrdenado();
        arqRev.geraArqInverso();
        arqRand.geraArqRandom();

//        // Insercao Direta
//
//        // Arquivo Ordenado
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.insercaoDireta();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.insercaoDireta();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.insercaoDireta();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Insercao Direta", compO, calculaCompInsDir(arqOrd.filesize()), movO,
//                calculaMovInsDir(arqOrd.filesize()), ttotalO,
//                compRev, calculaCompInsDir(arqRev.filesize()), movRev,
//                calculaMovInsDir(arqRev.filesize()), ttotalRev,
//                compRand, calculaCompInsDir(arqRand.filesize()), movRand,
//                calculaMovInsDir(arqRand.filesize()), ttotalRand);
//
//        // Insercao Binaria
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.insercaoBinaria();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.insercaoBinaria();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.insercaoBinaria();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Insercao Binaria", compO, calculaCompInsBin(arqOrd.filesize()), movO,
//                calculaMovInsBin(arqOrd.filesize()), ttotalO,
//                compRev, calculaCompInsBin(arqRev.filesize()), movRev,
//                calculaMovInsBin(arqRev.filesize()), ttotalRev,
//                compRand, calculaCompInsBin(arqRand.filesize()), movRand,
//                calculaMovInsBin(arqRand.filesize()), ttotalRand);
//
//        // Selecao Direta
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.selecaoDireta();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.selecaoDireta();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.selecaoDireta();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Selecao Direta", compO, calculaCompSelecao(arqOrd.filesize()), movO,
//                calculaMovSelecao(arqOrd.filesize()), ttotalO,
//                compRev, calculaCompSelecao(arqRev.filesize()), movRev,
//                calculaMovSelecao(arqRev.filesize()), ttotalRev,
//                compRand, calculaCompSelecao(arqRand.filesize()), movRand,
//                calculaMovSelecao(arqRand.filesize()), ttotalRand);
//
//        // Bolha
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.bolha();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.bolha();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.bolha();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Bolha", compO, calculaCompBolha(arqOrd.filesize()), movO,
//                calculaMovBolha(arqOrd.filesize()), ttotalO,
//                compRev, calculaCompBolha(arqRev.filesize()), movRev,
//                calculaMovBolha(arqRev.filesize()), ttotalRev,
//                compRand, calculaCompBolha(arqRand.filesize()), movRand,
//                calculaMovBolha(arqRand.filesize()), ttotalRand);
//
//        // Shake
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.shake();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.shake();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.shake();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Shake", compO, calculaCompShake(arqOrd.filesize()), movO,
//                calculaMovShake(arqOrd.filesize()), ttotalO,
//                compRev, calculaCompShake(arqRev.filesize()), movRev,
//                calculaMovShake(arqRev.filesize()), ttotalRev,
//                compRand, calculaCompShake(arqRand.filesize()), movRand,
//                calculaMovShake(arqRand.filesize()), ttotalRand);

        // Shell

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.shell();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.shell();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.shell();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Shell", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Heap

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.heap();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.heap();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.heap();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Heap", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Quick sem pivo

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.quickSemPivo();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.quickSemPivo();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.quickSemPivo();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Quick sem pivo", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Quick com pivo

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.quickComPivo();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.quickComPivo();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.quickComPivo();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Quick com pivo", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Merge 1a Implementacao

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.merge1();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.merge1();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.merge1();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Merge 1a Implementacao", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Merge 2a Implementacao

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.merge2();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.merge2();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.merge2();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Merge 2a Implementacao", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Counting

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.counting();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.counting();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.counting();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Counting", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Bucket

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.bucket();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.bucket();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.bucket();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Bucket", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);

        // Radix

        // Arquivo Ordenado
        
        arqOrd.initComp();
        arqOrd.initMov();
        tini = System.currentTimeMillis();
        arqOrd.radix();
        tfim = System.currentTimeMillis();
        compO = arqOrd.getComp();
        movO = arqOrd.getMov();
        ttotalO = tfim - tini;

        // Arquivo Reverso
        auxRev.copiaArquivo(arqRev.getFile());
        auxRev.initComp();
        auxRev.initMov();
        tini = System.currentTimeMillis();
        auxRev.radix();
        tfim = System.currentTimeMillis();
        compRev = auxRev.getComp();
        movRev = auxRev.getMov();
        ttotalRev = tfim - tini;

        // Arquivo Randomico
        auxRand.copiaArquivo(arqRand.getFile());
        auxRand.initComp();
        auxRand.initMov();
        tini = System.currentTimeMillis();
        auxRand.radix();
        tfim = System.currentTimeMillis();
        compRand = auxRand.getComp();
        movRand = auxRand.getMov();
        ttotalRand = tfim - tini;

        gravaLinhaTabela("Radix", compO, 0, movO, 0, ttotalO,
                compRev, 0, movRev, 0, ttotalRev,
                compRand, 0, movRand, 0, ttotalRand);
//
//        // Comb
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.comb();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.comb();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.comb();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Comb", compO, 0, movO, 0, ttotalO,
//                compRev, 0, movRev, 0, ttotalRev,
//                compRand, 0, movRand, 0, ttotalRand);
//
//        // Gnome
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.gnome();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.gnome();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.gnome();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Gnome", compO, 0, movO, 0, ttotalO,
//                compRev, 0, movRev, 0, ttotalRev,
//                compRand, 0, movRand, 0, ttotalRand);
//
//        // Tim
//
//        // Arquivo Ordenado
//
//        arqOrd.initComp();
//        arqOrd.initMov();
//        tini = System.currentTimeMillis();
//        arqOrd.tim();
//        tfim = System.currentTimeMillis();
//        compO = arqOrd.getComp();
//        movO = arqOrd.getMov();
//        ttotalO = tfim - tini;
//
//        // Arquivo Reverso
//        auxRev.copiaArquivo(arqRev.getFile());
//        auxRev.initComp();
//        auxRev.initMov();
//        tini = System.currentTimeMillis();
//        auxRev.tim();
//        tfim = System.currentTimeMillis();
//        compRev = auxRev.getComp();
//        movRev = auxRev.getMov();
//        ttotalRev = tfim - tini;
//
//        // Arquivo Randomico
//        auxRand.copiaArquivo(arqRand.getFile());
//        auxRand.initComp();
//        auxRand.initMov();
//        tini = System.currentTimeMillis();
//        auxRand.tim();
//        tfim = System.currentTimeMillis();
//        compRand = auxRand.getComp();
//        movRand = auxRand.getMov();
//        ttotalRand = tfim - tini;
//
//        gravaLinhaTabela("Tim", compO, 0, movO, 0, ttotalO,
//                compRev, 0, movRev, 0, ttotalRev,
//                compRand, 0, movRand, 0, ttotalRand);
    }

    public void gravaLinhaTabela(String metodo,
                                 int compO, int compEqO, int movO, int movEqO, long tempoO,
                                 int compRev, int compEqRev, int movRev, int movEqRev, long tempoRev,
                                 int compRand, int compEqRand, int movRand, int movEqRand, long tempoRand)
    {
        try {
            FileWriter wrt = new FileWriter(arqResp,true);
            wrt.append(String.format(
                    "%-22s |%6d |%6d |%6d |%6d |%7.3f |%6d |%6d |%6d |%6d |%7.3f |%6d |%6d |%6d |%6d |%7.3f |%n",
                    metodo,
                    compO, compEqO, movO, movEqO, (float)tempoO / 1000,
                    compRev, compEqRev, movRev, movEqRev, (float)tempoRev/ 1000,
                    compRand, compEqRand, movRand, movEqRand, (float)tempoRand/ 1000
            ));
            wrt.append(LinhaSeparacao());
            wrt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private int n2(int n)
    {
        return n * n;
    }

    private int nLog2N(int n)
    {
        if (n <= 1)
            return 0;

        return (int)Math.round(n * (Math.log(n) / Math.log(2)));
    }

    public int calculaCompInsDir(int n)
    {
        return n2(n);
    }

    public int calculaMovInsDir(int n)
    {
        return n2(n);
    }

    public int calculaCompInsBin(int n)
    {
        return nLog2N(n);
    }

    public int calculaMovInsBin(int n)
    {
        return n2(n);
    }

    public int calculaCompSelecao(int n)
    {
        return n2(n);
    }

    public int calculaMovSelecao(int n)
    {
        return n2(n);
    }

    public int calculaCompBolha(int n)
    {
        return n2(n);
    }

    public int calculaMovBolha(int n)
    {
        return n2(n);
    }

    public int calculaCompShake(int n)
    {
        return n2(n);
    }

    public int calculaMovShake(int n)
    {
        return n2(n);
    }

    public static void main(String args[])
    {
        PrincipalArquivo p = new PrincipalArquivo();
        p.geraTabela();
    }
}