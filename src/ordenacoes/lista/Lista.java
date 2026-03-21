package ordenacoes.lista;

import java.util.Random;

public class Lista {
    No inicio, fim;

    public void inicializa()
    {
        this.inicio = null;
        this.fim = null;
    }
    public No criaNo(int num)
    {
        No no = new No(num);
        no.setProx(null);
        no.setAnt(null);
        return no;
    }
    public void insereInicio(int num)
    {
        No no = criaNo(num);
        if (inicio == null) //lista vazia
        {
            fim = no;
            inicio = no;
        }
        else
        {
            inicio.setAnt(no);
            no.setProx(inicio);
            inicio = no;
        }
    }

    public void Inversa()
    {
        this.inicializa();

        for (int i = 1; i < 33; i++)
        {
            this.insereInicio(i);
        }
    }

    public void emOrdem()
    {
        this.inicializa();

        for (int i = 32; i > 0; i--)
        {
            this.insereInicio(i);
        }
    }

    public void Randomico()
    {
        Random rand = new Random();
        this.inicializa();

        for (int i = 1; i < 33; i++)
        {
            int num = rand.nextInt(32);
            this.insereInicio(num);
        }
    }

    public void exibe(String texto)
    {
        No i = this.inicio;
        System.out.println(texto);

        while (i != null)
        {
            System.out.printf(i.getNum() + ", ");
            i = i.getProx();
        }
        System.out.println(" ");
    }

    public int Total()
    {
        No aux = inicio;
        int i = 0;
        while (aux != null)
        {
            aux = aux.getProx();
            i++;
        }
        return i;
    }

    private int Maior()
    {
        No aux = inicio;
        int maior = 0;
        while (aux != null)
        {
            if (aux.getNum() > maior)
                maior = aux.getNum();
            aux = aux.getProx();
        }
        return maior;
    }

    /** Metodo para andar uma quantidade de nodulos na lista começando de "aux"
     *<pre>
    *Se qtd > 0 retornará o nodulo a qtd de distancia depois de "aux"
    *Se qtd < 0 retornará o nodulo a qtd de distancia antes de "aux"
     *</pre>
     */
    public No AndaNo(No aux, int qtd)
    {
        while (aux != null && qtd != 0)
        {
            if (qtd > 0)
            {
                aux = aux.getProx();
                qtd--;
            }
            else
            {
                aux = aux.getAnt();
                qtd++;
            }
        }
        return aux;
    }

    public No getNo(int pos)
    {
        No aux = inicio;
        int i = 0;

        while (aux != null && i < pos)
        {
            aux = aux.getProx();
            i++;
        }

        return aux;
    }

    public int tl()
    {
        int cont = 0;
        No aux = inicio;

        while (aux != null)
        {
            cont++;
            aux = aux.getProx();
        }

        return cont;
    }

    ///ordenações Mendes
    public void insercao_direta()
    {
        No pi = inicio.getProx(), ppos;
        int aux;
        while(pi != null)
        {
            aux = pi.getNum();
            ppos = pi;
            while(ppos != inicio && aux < ppos.getAnt().getNum())
            {
                ppos.setNum(ppos.getAnt().getNum());
                ppos = ppos.getAnt();
            }
            ppos.setNum(aux);
            pi=pi.getProx();
        }
    }

    public void InsercaoBinaria()
    {

    }

    public void selecaoDireta()
    {
        No i = inicio, PosMenor;
        int menor, aux;
        while (i != null)
        {
            PosMenor = i;
            menor = i.getNum();
            No j = i.getProx();

            while (j != null)
            {
                if(j.getNum() < menor)
                {
                    menor = j.getNum();
                    PosMenor = j;
                }
                j = j.getProx();
            }

            aux = i.getNum();
            i.setNum(PosMenor.getNum());
            PosMenor.setNum(aux);

            i = i.getProx();
        }

    }

    public void Bolha()
    {
        boolean flag = true;
        No i = fim, j;
        int aux;
        while (i != inicio && flag)
        {
            flag = false;
            j = inicio;
            while (j != i)
            {
                if(j.getNum() > j.getProx().getNum())
                {
                    aux = j.getNum();
                    j.setNum(j.getProx().getNum());
                    j.getProx().setNum(aux);
                    flag = true;
                }
                j = j.getProx();
            }
            i = i.getAnt();
        }
    }

    public void Shake()
    {

    }

    public void troca(No a, No b)
    {
        int aux = a.getNum();
        a.setNum(b.getNum());
        b.setNum(aux);
    }

    public void Comb() //Algoritmo do livro: C++ PROGRAMMING FROM BASICS de Alytis Gruodis Sergejus Ivanikovas | https://books.vvk.lt/p12/Gruodis_Ivanikovas_C%2B%2Bprogramming_2012.pdf
    {
        double dG = 1.247330950103979;
        int iGap = tl();
        boolean bDone = false;
        No no1, no2;

        do
        {
            iGap = (int) ((double) iGap / dG);

            if (iGap < 1)
                iGap = 1;

            bDone = false;

            for (int i = 0; (i + iGap) < tl(); i++)
            {
                no1 = getNo(i);
                no2 = getNo(i + iGap);

                if (no1.getNum() > no2.getNum())
                {
                    troca(no1, no2);
                    bDone = true;
                }
            }
        }
        while (!((iGap == 1) && (!bDone)));
    }

    public void Gnome() //Algoritmo do livro: Python Algorithms Mastering Basic Algorithms in the Python Language de Magnus Lie Hetland
    {
        No i = inicio;

        while (i != null)
        {
            if (i == inicio || i.getAnt().getNum() <= i.getNum())
                i = i.getProx();
            else
            {
                int aux = i.getNum();
                i.setNum(i.getAnt().getNum());
                i.getAnt().setNum(aux);
                i = i.getAnt();
            }
        }
    }

    public void Tim(){} // puta q pariu

    /// Ordenacoes Fiori
    public void ShellSort()
    {
        int dist = 1;
        int tl = Total();
        int auxNum;
        No aux_I, aux_Pos, aux_dist;
        while(dist < tl)
            dist = 3 * dist + 1;
        dist = dist/3;
        while (dist > 0)
        {
            aux_I = AndaNo(inicio,dist);
            while(aux_I != null)
            {
                auxNum = aux_I.getNum();
                aux_Pos = aux_I;
                aux_dist = AndaNo(aux_I,-dist);
                while(aux_dist != null && auxNum < aux_dist.getNum())
                {
                    aux_Pos.setNum(aux_dist.getNum());
                    aux_Pos = aux_dist;
                    aux_dist = AndaNo(aux_dist,-dist);
                }
                aux_Pos.setNum(auxNum);
                aux_I = aux_I.getProx();
            }
            dist = dist/3;
        }
    }

    public void HeapSort()
    {
        int tlAux = Total();
        int SubTree;
        No pai;
        No filho1;
        No filho2;
        No maiorFilho;
        int valorAux;
        while(tlAux > 1)
        {
            pai = AndaNo(inicio,tlAux / 2 - 1);
            SubTree = tlAux / 2 - 1;
            while(pai != null)
            {
                filho1 = AndaNo(pai,SubTree);
                if (filho1 != null)
                {
                    maiorFilho = filho1;
                    filho2 = filho1.getProx();
                    if (filho2 != null && filho1.getNum() < filho2.getNum())
                        maiorFilho = filho2;
                    if (pai.getNum() < maiorFilho.getNum()) {
                        valorAux = pai.getNum();
                        pai.setNum(maiorFilho.getNum());
                        maiorFilho.setNum(valorAux);
                    }
                }
                SubTree--;
                pai = pai.getAnt();
            }
            tlAux--;
            pai = AndaNo(inicio,tlAux);
            valorAux = inicio.getNum();
            inicio.setNum(pai.getNum());
            pai.setNum(valorAux);
        }
    }

    public void QuickSemPivo()
    {
        QuickSemPivo(inicio,fim);
    }

    private void QuickSemPivo(No inicio, No fim)
    {
        int auxNum;
        No i = inicio, j = fim;
        boolean flag = true;
        if (i != null)
        {
            while (i != j) {
                if (i.getNum() > j.getNum())
                {
                    auxNum = i.getNum();
                    i.setNum(j.getNum());
                    j.setNum(auxNum);
                    flag = !flag;
                }
                if (flag)
                    i = i.getProx();
                else
                    j = j.getAnt();
            }
            if(inicio != i && inicio != i.getAnt())
                QuickSemPivo(inicio,i.getAnt());
            if (fim != j && fim != j.getProx())
                QuickSemPivo(j.getProx(),fim);
        }
    }

    private void QuickComPivo(No inicio, No fim)
    {
        No i = inicio;
        No j = fim;
        int pivo = fim.getNum();
        int aux;
        while(i != j && i.getAnt() != j)
        {
            while(i.getNum() < pivo)
                i = i.getProx();
            while(j.getNum() > pivo)
                j = j.getAnt();
            if(i.getAnt() != j)
            {
                aux = i.getNum();
                i.setNum(j.getNum());
                j.setNum(aux);
                i = i.getProx();
                j = j.getAnt();
            }
        }
        if(inicio != j)
            QuickComPivo(inicio,j);
        if(fim != i)
            QuickComPivo(i,fim);
    }

    public void QuickComPivo()
    {
        QuickComPivo(inicio,fim);
    }

    public void FusaoDiretaImp1()
    {
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        int seq = 1;
        while(seq < Total())
        {
            particaoImp1(l1,l2);
            this.exibe("lista");
            fusaoImp1(l1,l2,seq);
            l1.exibe("lista1");
            l2.exibe("lista2");
            seq = seq * 2;
        }
    }

    private void particaoImp1(Lista l1, Lista l2)
    {
        int meio = Total()/2;
        l1.inicializa();
        l2.inicializa();
        No aux = fim;
        for (int i = 0; i < meio; i++) {
            l2.insereInicio(aux.getNum());
            aux = aux.getAnt();
        }
        for (int i = 0; i < meio; i++) {
            l1.insereInicio(aux.getNum());
            aux = aux.getAnt();
        }
    }

    private void fusaoImp1(Lista l1, Lista l2, int seq)
    {
        No i = l1.inicio;
        No j = l2.inicio;
        No k = this.inicio;
        while (k != null)
        {
            int conti = 0;
            int contj = 0;
            while(i != null && j != null && conti < seq && contj < seq)
            {
                if (i.getNum() < j.getNum())
                {
                    k.setNum(i.getNum());
                    conti++;
                    i = i.getProx();
                }
                else
                {
                    k.setNum(j.getNum());
                    contj++;
                    j = j.getProx();
                }
                k = k.getProx();
            }
            while(i != null && conti < seq)
            {
                k.setNum(i.getNum());
                i = i.getProx();
                k = k.getProx();
                conti++;
            }
            while(j != null && contj < seq)
            {
                k.setNum(j.getNum());
                j = j.getProx();
                k = k.getProx();
                contj++;
            }
        }
    }

    public void FusaoDiretaImp2()
    {

    }

    public void Counting()
    {
        No aux = inicio;
        int tl = Maior();
        int[] contV = new int[tl+1];
        while (aux != null)
        {
            contV[aux.getNum()]++;
            aux = aux.getProx();
        }
        for (int i = 1; i < tl+1; i++)
            contV[i] += contV[i - 1];
        tl = Total();
        Lista respList = new Lista();
        for (int i = 0; i < tl; i++)
            respList.insereInicio(0);
        aux = fim;
        No auxResp = respList.inicio;
        System.out.println(contV[aux.getNum()]);
        contV[aux.getNum()]--;
        auxResp = AndaNo(auxResp,contV[aux.getNum()]);
        auxResp.setNum(aux.getNum());
        aux = aux.getAnt();
        while (aux != null)
        {
            contV[aux.getNum()]--;
            auxResp = AndaNo(auxResp,contV[aux.getNum()] - contV[aux.getProx().getNum()]);
            auxResp.setNum(aux.getNum());
            System.out.println(auxResp.getNum());
            aux = aux.getAnt();
        }
        respList.exibe("FDS");
        this.inicio = respList.inicio;
        this.fim = respList.fim;
    }

    public void Bucket()
    {
        int n = 10;
        Lista[] hash = new Lista[n];
        No aux = inicio;
        int maior = Maior();
        while (aux != null)
        {
            int posHash = aux.getNum() * n / (maior+1);
            if (hash[posHash] == null) {
                hash[posHash] = new Lista();
                hash[posHash].inicializa();
            }
            hash[posHash].insereInicio(aux.getNum());
            aux = aux.getProx();
        }
        for (int i = 0; i < n; i++) {
            if (hash[i].inicio != null)
                hash[i].QuickSemPivo();
        }
        aux = inicio;
        int i = 0;
        while (aux != null)
        {
            if (hash[i] != null) {
                No auxBucket = hash[i++].inicio;
                while (auxBucket != null) {
                    aux.setNum(auxBucket.getNum());
                    aux = aux.getProx();
                    auxBucket = auxBucket.getProx();
                }
            }
            else
                i++;
        }
    }

    public void Radix(){}
}
