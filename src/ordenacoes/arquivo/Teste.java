package ordenacoes.arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class Teste
{
    private static final String ARQUIVO_DADOS = "arquivo.dat";
    private static final String ARQUIVO_TEMPOS = "tempos_teste.csv";

    @FunctionalInterface
    private interface OperacaoArquivo
    {
        void executar(Arquivo arquivo);
    }

    public static void main(String[] args)
    {
        Teste teste = new Teste();
        teste.executar();
    }

    private void executar()
    {
        try (PrintWriter saida = new PrintWriter(new FileWriter(ARQUIVO_TEMPOS)))
        {
            saida.println("algoritmo;ordem;tempo_s");

            testaOrdenacao("Insercao Direta", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.insercaoDireta();
                }
            }, saida);

            testaOrdenacao("Insercao Binaria", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.insercaoBinaria();
                }
            }, saida);

            testaOrdenacao("Selecao Direta", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.selecaoDireta();
                }
            }, saida);

            testaOrdenacao("Bolha", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.bolha();
                }
            }, saida);

            testaOrdenacao("Shake", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.shake();
                }
            }, saida);

            testaOrdenacao("ShellSort", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.ShellSort();
                }
            }, saida);

            testaOrdenacao("Comb", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.comb();
                }
            }, saida);

            testaOrdenacao("Gnome", new OperacaoArquivo()
            {
                @Override
                public void executar(Arquivo arquivo)
                {
                    arquivo.gnome();
                }
            }, saida);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void testaOrdenacao(String nomeAlgoritmo, OperacaoArquivo operacao, PrintWriter saida)
    {
        testaCenario(nomeAlgoritmo, "EM ORDEM", 0, operacao, saida);
        testaCenario(nomeAlgoritmo, "INVERSO", 1, operacao, saida);
        testaCenario(nomeAlgoritmo, "RANDOMICO", 2, operacao, saida);
        System.out.println();
    }

    private void testaCenario(String nomeAlgoritmo, String nomeOrdem, int tipoOrdem,
                              OperacaoArquivo operacao, PrintWriter saida)
    {
        Arquivo arq = new Arquivo(ARQUIVO_DADOS);
        try
        {
            geraArquivo(arq, tipoOrdem);

            System.out.println("========== " + nomeAlgoritmo + " - " + nomeOrdem + " ==========");
            System.out.println("Antes:");
            arq.exibirArq();

            long inicio = System.currentTimeMillis();
            operacao.executar(arq);
            long tempoMs = System.currentTimeMillis() - inicio;
            double tempoSegundos = tempoMs / 1000.0;

            System.out.println("Depois:");
            arq.exibirArq();
            System.out.printf(Locale.US, "Tempo: %.3f s%n", tempoSegundos);
            System.out.println();

            String linha = nomeAlgoritmo + ";" + nomeOrdem + ";" +
                    String.format(Locale.US, "%.3f", tempoSegundos);
            saida.println(linha);
            saida.flush();
        }
        finally
        {
            arq.fechar();
        }
    }

    private void geraArquivo(Arquivo arq, int tipoOrdem)
    {
        if (tipoOrdem == 0)
            arq.geraArqEmOrdem();
        else if (tipoOrdem == 1)
            arq.geraArqInverso();
        else
            arq.geraArqRandomico();
    }
}
