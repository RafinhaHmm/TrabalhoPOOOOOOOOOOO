package ordenacoes.arquivo;

import ordenacoes.lista.Lista;
import ordenacoes.lista.No;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Arquivo
{
    private String nomearquivo;
    private RandomAccessFile arquivo;
    private int comp, mov;
    private static int tl = 32;

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
//            System.out.println("Posicao " + i);
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

    public int Maior()
    {
        int maior = 0;
        Registro reg = new Registro();
        seekArq(0);
        while (!eof()) {
            reg.leDoArq(arquivo);
            if (reg.getNumero() > maior)
                maior = reg.getNumero();
        }
        return maior;
    }

    //.............................................................................

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
        for (int i = 0; i < tl; i++) //1024
        {
            Registro registro = new Registro(i);
            inserirRegNoFinal(registro);
        }
    }
    public void geraArqInverso()
    {
        this.truncate(0);
        for (int i = tl-1; i >= 0; i--) //1023
        {
            Registro registro = new Registro(i);
            inserirRegNoFinal(registro);
        }
    }

    public void geraArqRandom()
    {
        this.truncate(0);
        Random random = new Random();
        for (int i = 0; i < tl; i++) //1024
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
        mov = 0; comp = 0;
        int dist = 1;
        int i, pos;
        int tl = filesize();
        Registro auxReg = new Registro();
        Registro posReg = new Registro();
        while(dist < tl)
            dist = 3 * dist + 1;
        dist = dist/3;
        while(dist > 0)
        {
            i = dist;
            while(i < tl)
            {
                pos = i;
                seekArq(i);
                auxReg.leDoArq(arquivo);
                if (pos-dist >= 0) {
                    seekArq(pos - dist);
                    posReg.leDoArq(arquivo);
                }
                comp++;
                while(pos-dist >= 0 && auxReg.getNumero() < posReg.getNumero())
                {
                    seekArq(pos);
                    posReg.gravaNoArq(arquivo);
                    mov++;
                    pos = pos-dist;
                    if (pos-dist >= 0) {
                        seekArq(pos - dist);
                        posReg.leDoArq(arquivo);
                    }
                    comp++;
                }
                seekArq(pos);
                auxReg.gravaNoArq(arquivo);
                mov++;
                i++;
            }
            dist = dist/3;
        }
    }


    // Heap
    public void heap()
    {
        mov = 0; comp = 0;
        int tlAux = filesize();
        int pai;
        int filho1;
        int filho2;
        int maiorFilho;
        Registro regMaior = new Registro();
        Registro regPai = new Registro();
        Registro regF1 = new Registro();
        Registro regF2 = new Registro();
        while(tlAux > 1)
        {
            pai = tlAux / 2 - 1;
            while(pai >= 0)
            {
                filho1 = 2 * pai + 1;
                filho2 = filho1 + 1;
                seekArq(pai);
                regPai.leDoArq(arquivo);
                seekArq(filho1);
                regF1.leDoArq(arquivo);
                maiorFilho = filho1;
                if (filho2 < tlAux)
                {
                    seekArq(filho2);
                    regF2.leDoArq(arquivo);
                    if(regF1.getNumero() < regF2.getNumero()) {
                        maiorFilho = filho2;
                        comp++;
                    }
                }
                seekArq(maiorFilho);
                regMaior.leDoArq(arquivo);
                comp++;
                if(regMaior.getNumero() > regPai.getNumero())
                {
                    mov+=2;
                    seekArq(maiorFilho);
                    regPai.gravaNoArq(arquivo);
                    seekArq(pai);
                    regMaior.gravaNoArq(arquivo);
                }
                pai--;
            }
            tlAux--;
            seekArq(0);
            regF1.leDoArq(arquivo);
            seekArq(tlAux);
            regF2.leDoArq(arquivo);
            seekArq(0);
            regF2.gravaNoArq(arquivo);
            seekArq(tlAux);
            regF1.gravaNoArq(arquivo);
            mov+=2;
        }
    }

    // Quick sem pivô
    public void quickSemPivo()
    {
        mov = 0; comp = 0;

        QuickSemPivo(0,filesize()-1);
    }

    private void QuickSemPivo(int ini, int fim)
    {
        int i = ini;
        int j = fim;
        Registro regI = new Registro();
        Registro regJ = new Registro();
        boolean flag = true;
        while(i < j)
        {
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);
            comp++;
            if(regI.getNumero() > regJ.getNumero())
            {
                mov+=2;
                seekArq(i);
                regJ.gravaNoArq(arquivo);
                seekArq(j);
                regI.gravaNoArq(arquivo);
                flag = !flag;
            }
            if(flag)
                i++;
            else
                j--;
        }
        if(ini < i-1)
            QuickSemPivo(ini, i-1);
        if(i+1 < fim)
            QuickSemPivo(i+1, fim);
    }

    // Quick com pivô
    public void quickComPivo()
    {
        mov = 0; comp = 0;
        QuickComPivo(0,filesize()-1);
    }

    private void QuickComPivo(int ini, int fim)
    {
        int i = ini;
        int j = fim;
        Registro regI = new Registro();
        Registro regJ = new Registro();
        seekArq((ini+fim)/2);
        regI.leDoArq(arquivo);
        int pivo = regI.getNumero();
        while(i < j)
        {
            seekArq(i);
            regI.leDoArq(arquivo);
            comp++;
            while(regI.getNumero() < pivo) {
                seekArq(++i);
                regI.leDoArq(arquivo);
                comp++;
            }
            seekArq(j);
            regJ.leDoArq(arquivo);
            comp++;
            while(regJ.getNumero() > pivo) {
                seekArq(--j);
                regJ.leDoArq(arquivo);
                comp++;
            }
            if(i <= j)
            {
                mov+=2;
                seekArq(i++);
                regJ.gravaNoArq(arquivo);
                seekArq(j--);
                regI.gravaNoArq(arquivo);
            }
        }
        if(ini < j)
            QuickComPivo(ini,j);
        if(i < fim)
            QuickComPivo(i,fim);
    }

    // Fusão Direta (Merge) - 1ª implementação
    public void merge1()
    {
        mov = 0; comp = 0;
        int tl = filesize();
        Registro[] vet1 = new Registro[tl/2];
        Registro[] vet2 = new Registro[tl/2];
        for (int i = 0; i < tl/2; i++) {
            vet1[i] = new Registro();
            vet2[i] = new Registro();
        }
        int seq = 1;
        while(seq < tl)
        {
            particaoImp1(vet1,vet2);
            fusaoImp1(vet1,vet2,seq);
            seq = seq * 2;
        }
    }

    private void particaoImp1(Registro[] vet1, Registro[] vet2)
    {
        int meio = filesize()/2;
        for(int i=0; i < meio; i++)
        {
            seekArq(i);
            vet1[i].leDoArq(arquivo);
            seekArq(i+meio);
            vet2[i].leDoArq(arquivo);
        }
    }

    private void fusaoImp1(Registro[] vet1, Registro[] vet2, int seq)
    {
        int k = 0;
        int i = 0;
        int j = 0;
        int tamSeq = seq;
        while(k < filesize()-1)
        {
            comp++;
            while(i < seq && j < seq)
            {
                if(vet1[i].getNumero() < vet2[j].getNumero()) {
                    seekArq(k++);
                    vet1[i++].gravaNoArq(arquivo);
                }
                else {
                    seekArq(k++);
                    vet2[j++].gravaNoArq(arquivo);
                }
                mov++;
                comp++;
            }
            while(i < seq) {
                seekArq(k++);
                vet1[i++].gravaNoArq(arquivo);
                mov++;
            }
            while(j < seq){
                seekArq(k++);
                vet2[j++].gravaNoArq(arquivo);
                mov++;
            }
            seq += tamSeq;
        }
    }

    // Fusão Direta (Merge) - 2ª implementação
    public void merge2()
    {
        mov = 0; comp = 0;
        int tl = filesize();
        Registro[] vet = new Registro[tl];
        for (int i = 0; i < tl; i++)
            vet[i] = new Registro();
        merge2(0,tl-1,vet);
    }
    private void merge2(int esq, int dir, Registro[] aux)
    {
        if (esq != dir)
        {
            int meio = (esq + dir)/2;
            merge2(esq,meio, aux);
            merge2(meio+1,dir, aux);
            mergeImp2(esq, meio, meio+1, dir,aux);
        }
    }

    private void mergeImp2(int ini1, int fim1, int ini2, int fim2, Registro[] aux) {
        int i = ini1;
        int j = ini2;
        int k = 0;
        Registro regI = new Registro();
        Registro regJ = new Registro();
        while(i <= fim1 && j <= fim2)
        {
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);
            comp++;
            if (regI.getNumero() < regJ.getNumero()) {
                seekArq(i++);
                aux[k++].leDoArq(arquivo);
            }
            else {
                seekArq(j++);
                aux[k++].leDoArq(arquivo);
            }
        }
        while (i <= fim1) {
            seekArq(i++);
            aux[k++].leDoArq(arquivo);
        }
        while (j <= fim2) {
            seekArq(j++);
            aux[k++].leDoArq(arquivo);
        }
        for (i = 0; i < k; i++) {
            seekArq(ini1+i);
            aux[i].gravaNoArq(arquivo);
            mov++;
        }
    }

    // Counting
    public void counting()
    {
        mov = 0; comp = 0;
        int tl = Maior()+1;
        int i;
        int[] contV = new int[tl];
        Registro regAux = new Registro();
        seekArq(0);
        while (!eof()) {
            regAux.leDoArq(arquivo);
            contV[regAux.getNumero()]++;
        }
        for (i = 1; i < tl; i++)
            contV[i] += contV[i-1];
        Registro[] resp = new Registro[filesize()];
        for (i = filesize()-1; i >= 0; i--) {
            seekArq(i);
            regAux.leDoArq(arquivo);
            int pos = --contV[regAux.getNumero()];
            resp[pos] = new Registro();
            seekArq(i);
            resp[pos].leDoArq(arquivo);
        }
        for (i = 0; i < filesize(); i++) {
            seekArq(i);
            resp[i].gravaNoArq(arquivo);
            mov++;
        }
    }

    // Bucket
    public void bucket()
    {
        mov = 0; comp = 0;
        int n = 10;
        int maior = Maior();
        Lista[] hash = new Lista[filesize()];
        Registro regAux = new Registro();
        seekArq(0);
        while (!eof())
        {
            regAux.leDoArq(arquivo);
            int posHash = regAux.getNumero() * n / (maior+1);
            if (hash[posHash] == null) {
                hash[posHash] = new Lista();
                hash[posHash].inicializa();
            }
            hash[posHash].insereInicio(regAux.getNumero());
        }
        for (int i = 0; i < n; i++) {
            if (hash[i] != null && hash[i].inicio != null)
                hash[i].QuickSemPivo();
        }
        int i = 0;
        int pos = 0;
        while (i < 10)
        {
            if (hash[i] != null) {
                No auxBucket = hash[i].inicio;
                while (auxBucket != null) {
                    seekArq(pos++);
                    regAux.setNumero(auxBucket.getNum());
                    regAux.gravaNoArq(arquivo);
                    mov++;
                    auxBucket = auxBucket.getProx();
                }
            }
            i++;
        }
    }

    // Radix
    public void radix()
    {
        mov = 0; comp = 0;
        int m = Maior();
        Registro[] resp = new Registro[filesize()];
        for (int i = 0; i < filesize(); i++)
            resp[i] = new Registro();
        for (int exp = 1; m/exp > 0; exp *= 10)
            countRadix(exp,resp);
    }

    private void countRadix(int exp, Registro[] resp)
    {
        int[] contV = new int[10];
        int i;
        Registro regAux = new Registro();
        seekArq(0);
        regAux.leDoArq(arquivo);
        while (!eof()) {
            contV[(regAux.getNumero() / exp) % 10]++;
            regAux.leDoArq(arquivo);
        }
        contV[(regAux.getNumero() / exp) % 10]++;
        for (i = 1; i < 10; i++)
            contV[i] += contV[i-1];
        for (i = filesize()-1; i >= 0; i--) {
            seekArq(i);
            regAux.leDoArq(arquivo);
            int pos = (regAux.getNumero() / exp) % 10;
            seekArq(i);
            contV[pos]--;
            resp[contV[pos]].leDoArq(arquivo);
        }
        for (i = 0; i < filesize(); i++) {
            seekArq(i);
            resp[i].gravaNoArq(arquivo);
            mov++;
        }
    }
}

