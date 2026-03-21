package ordenacoes.arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Arquivo
{
    private String nomearquivo;
    private RandomAccessFile arquivo;
    private int comp, mov;

    public Arquivo(String nomearquivo)
    {
        try
        {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e)
        { }
    }

    public void truncate(long pos) //desloca eof
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc)
        { }
    }

    //semelhante ao feof() da linguagem C
    //verifica se o ponteiro esta no <EOF> do arquivo
    public boolean eof()
    {
        boolean retorno = false;
        try
        {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        } catch (IOException e)
        { }
        return (retorno);
    }

    //insere um Registro no final do arquivo, passado por par metro
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }

    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof())
        {
            System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e)
        { }
    }

    public void leArq()
    {
        int numero;
        numero = Entrada.leInteger("Digite o numero");
        while (numero != 0)
        {
            inserirRegNoFinal(new Registro(numero));
            numero = Entrada.leInteger("Digite o numero");
        }
    }

    //.............................................................................

    /// Ordenações:

    public void ShellSort()
    {

        int dist = 1;
        int i, pos;
        int tl = filesize();
        Registro auxReg = null;
        Registro posReg = null;
        while(dist < tl)
            dist = 3 * dist + 1;
        dist = dist/3;
        while(dist > 0)
        {
            i = dist;
            pos = i;
            while(i < tl)
            {
                seekArq(i);
                auxReg.leDoArq(arquivo);
                if (pos-dist > 0)
                {
                    seekArq(pos - dist);
                    posReg.leDoArq(arquivo);
                }
                //while(pos > 0 && auxReg.getNumero().compareToIgnoreCase(posReg.getNumero()) < 0)
                {
                    seekArq(pos);
                    posReg.gravaNoArq(arquivo);
                    pos = pos-dist;
                    if (pos-dist > 0)
                    {
                        seekArq(pos - dist);
                        posReg.leDoArq(arquivo);
                    }
                }
                seekArq(pos);
                auxReg.gravaNoArq(arquivo);
                i++;
            }
            dist = dist/3;
        }
    }


    public void executa()
    {
        leArq();
        exibirArq();
    }

    //m todo principal
    public static void main(String args[])
    {
        Arquivo a = new Arquivo("c:\\arquivo.dat");
        a.executa();
    }

    public int filesize()
    {
        try {
            return (int)arquivo.length()/Registro.length();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void geraArqOrdenado()
    {
        this.truncate(0);
        for (int i = 0; i < 1024; i++)
        {
            Registro registro = new Registro(i);
            inserirRegNoFinal(registro);
        }
    }
    public void geraArqInverso()
    {
        this.truncate(0);
        for (int i = 1023; i > 0; i--)
        {
            Registro registro = new Registro(i);
            inserirRegNoFinal(registro);
        }
    }

    public void geraArqRandom()
    {
        this.truncate(0);
        Random random = new Random();
        for (int i = 0; i < 1024; i++)
        {
            int rand = random.nextInt(9999);
            Registro registro = new Registro(rand);
            inserirRegNoFinal(registro);
        }
    }

    //ordenação mendes:

    public void insercaoDireta()
    {

    }



}

