package ordenacoes.arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Arquivo
{
    private int TF = 64;
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

    public RandomAccessFile getFile()
    {
        return this.arquivo;
    }

    public void copiaArquivo(RandomAccessFile origem)
    {
        Registro reg = new Registro();

        try
        {
            origem.seek(0);
            this.truncate(0);

            while (origem.getFilePointer() < origem.length())
            {
                reg.leDoArq(origem);
                reg.gravaNoArq(this.arquivo);
            }
        }
        catch (IOException e)
        {
        }
    }

    public int getComp()
    {
        return this.comp;
    }
    public int getMov()
    {
        return this.mov;
    }

    public void initComp()
    {
        comp = 0;
    }

    public void initMov()
    {
        mov = 0;
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
        for (int i = 0; i < TF; i++) //1024
        {
            Registro registro = new Registro(i);
            inserirRegNoFinal(registro);
        }
    }
    public void geraArqInverso()
    {
        this.truncate(0);
        for (int i = TF; i >= 0; i--) //1024
        {
            Registro registro = new Registro(i);
            inserirRegNoFinal(registro);
        }
    }

    public void geraArqRandom()
    {
        this.truncate(0);
        Random random = new Random();
        for (int i = 0; i < TF; i++) //1024
        {
            int rand = random.nextInt(9999);
            Registro registro = new Registro(rand);
            inserirRegNoFinal(registro);
        }
    }

    //ordenação mendes:

    public void insercaoDireta()
    {
        int pos;
        boolean flag;
        Registro auxReg = new Registro();
        Registro auxReg2 = new Registro();

        for (int i = 1; i < this.filesize(); i++)
        {
            this.comp++;

            this.seekArq(i);
            auxReg.leDoArq(this.arquivo);
            pos = i;
            flag = true;

            while (pos > 0 && flag)
            {
                this.comp++;

                this.seekArq(pos - 1);
                auxReg2.leDoArq(this.arquivo);

                if (auxReg.getNumero() < auxReg2.getNumero())
                {
                    this.comp++;

                    this.seekArq(pos);
                    auxReg2.gravaNoArq(this.arquivo);
                    pos--;
                }
                else
                    flag = false;
            }

            this.seekArq(pos);
            auxReg.gravaNoArq(this.arquivo);
        }
    }

    private int buscaBi(int fim, int valor)
    {
        int esquerda = 0;
        int direita = fim-1;
        int meio;
        Registro regAux = new Registro();

        while (esquerda <= direita)
        {
            meio = (esquerda+direita)/2;

            this.seekArq(meio);
            regAux.leDoArq(this.arquivo);
            if(valor < regAux.getNumero())
                direita = meio-1;
            else
                esquerda=meio+1;
        }
        return esquerda;
    }
    // Inserção Binária
    public void insercaoBinaria()
    {
        int valor, pos;
        int TL = this.filesize();
        Registro regAux = new Registro();
        Registro reg1 = new Registro();


        for (int i = 1; i < TL; i++)
        {
            this.seekArq(i);
            regAux.leDoArq(this.arquivo);
            valor = regAux.getNumero();

            pos = buscaBi(i, valor);

            for (int j = i; j > pos ; j--)
            {
                this.seekArq(j-1);
                reg1.leDoArq(this.arquivo);
                reg1.gravaNoArq(this.arquivo);
            }
            Registro regPos = new Registro(valor);
            this.seekArq(pos);
            regPos.gravaNoArq(this.arquivo);
        }
    }

    // Seleção Direta
    public void selecaoDireta()
    {
        Registro regmenor = new Registro();
        Registro regi = new Registro();
        Registro regj = new Registro();
        int posmenor, TL = filesize(), menor;

        for (int i = 0; i < TL - 1; i++)
        {
            seekArq(i);
            regi.leDoArq(arquivo);
            menor = regi.getNumero();
            posmenor = i;

            for (int j = i + 1; j < TL; j++)
            {
                seekArq(j);
                regj.leDoArq(arquivo);

                if (regj.getNumero() < menor)
                {
                    menor = regj.getNumero();
                    posmenor = j;
                }
            }

            seekArq(posmenor);
            regmenor.leDoArq(arquivo);

            seekArq(i);
            regmenor.gravaNoArq(arquivo);

            seekArq(posmenor);
            regi.gravaNoArq(arquivo);

        }
    }

    // Bolha
    public void bolha()
    {
        int TL2 = this.filesize();
        boolean flag = true;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();

        while (TL2 > 1 && flag)
        {
            flag = false;

            for (int i = 0; i < TL2 - 1; i++)
            {
                this.seekArq(i);
                reg1.leDoArq(this.arquivo);
                reg2.leDoArq(this.arquivo);

                if (reg1.getNumero() > reg2.getNumero())
                {
                    this.seekArq(i);
                    reg2.gravaNoArq(this.arquivo);
                    this.seekArq(i + 1);
                    reg1.gravaNoArq(this.arquivo);

                    flag = true;
                }
            }
            TL2--;
        }
    }

    // Shake
    public void shake()
    {
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        Registro regAux = new Registro();

        int ini=0, fim = this.filesize()-1;
        boolean flag = true;

        while (ini<fim && flag)
        {
            flag = false;
            for (int i = ini; i < fim; i++)
            {
                this.seekArq(i);
                reg1.leDoArq(this.arquivo);
                reg2.leDoArq(this.arquivo);

                if (reg1.getNumero() > reg2.getNumero())
                {
                    this.seekArq(i);
                    reg2.gravaNoArq(this.arquivo);
                    this.seekArq(i+1);
                    regAux.gravaNoArq(this.arquivo);

                    flag = true;
                }
            }
            fim--;

            if(flag)
            {
                flag=false;

                for (int i = fim; i > ini ; i--)
                {
                    this.seekArq(i-1);
                    reg1.leDoArq(this.arquivo);
                    reg2.leDoArq(this.arquivo);

                    if(reg1.getNumero() > reg2.getNumero())
                    {
                        this.seekArq(i-1);
                        reg2.gravaNoArq(this.arquivo);
                        this.seekArq(i);
                        reg1.gravaNoArq(this.arquivo);

                        flag=true;
                    }
                }
                ini++;
            }
        }
    }

    // Comb
    public void comb()
    {
        double dG = 1.247330950103979;
        int iGap = this.filesize();
        boolean bDone;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();

        do
        {
            iGap = (int)((double)iGap / dG);

            if (iGap < 1)
                iGap = 1;

            bDone = false;

            for (int i = 0; (i + iGap) < this.filesize(); i++)
            {
                this.seekArq(i);
                reg1.leDoArq(this.arquivo);

                this.seekArq(i + iGap);
                reg2.leDoArq(this.arquivo);

                if (reg1.getNumero() > reg2.getNumero())
                {
                    this.seekArq(i);
                    reg2.gravaNoArq(this.arquivo);

                    this.seekArq(i + iGap);
                    reg1.gravaNoArq(this.arquivo);

                    bDone = true;
                }
            }
        }
        while (!((iGap == 1) && (!bDone)));
    }

    // Gnome
    public void gnome()
    {
        int i = 0;
        int tl = this.filesize();
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();

        while (i < tl)
        {
            if (i == 0)
                i++;
            else
            {
                this.seekArq(i - 1);
                reg1.leDoArq(this.arquivo);
                reg2.leDoArq(this.arquivo);

                if (reg1.getNumero() <= reg2.getNumero())
                    i++;
                else
                {
                    this.seekArq(i - 1);
                    reg2.gravaNoArq(this.arquivo);
                    this.seekArq(i);
                    reg1.gravaNoArq(this.arquivo);
                    i--;
                }
            }
        }
    }

    // Tim
    public void tim() //pqp senhor cinema
    {

    }


// ========================= FIORI =========================

    // Shell
    public void shell()
    {
    }

    // Heap
    public void heap()
    {
    }

    // Quick sem pivô
    public void quickSemPivo()
    {
    }

    // Quick com pivô
    public void quickComPivo()
    {
    }

    // Fusão Direta (Merge) - 1ª implementação
    public void merge1()
    {
    }

    // Fusão Direta (Merge) - 2ª implementação
    public void merge2()
    {
    }

    // Counting
    public void counting()
    {
    }

    // Bucket
    public void bucket()
    {
    }

    // Radix
    public void radix()
    {
    }
}

