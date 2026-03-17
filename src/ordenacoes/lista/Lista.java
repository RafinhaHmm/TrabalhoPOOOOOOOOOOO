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

        for (int i = 1; i < 31; i++)
        {
            this.insereInicio(i);
        }
    }

    public void emOrdem()
    {
        this.inicializa();

        for (int i = 30; i > 0; i--)
        {
            this.insereInicio(i);
        }
    }

    public void Randomico()
    {
        Random rand = new Random();
        this.inicializa();

        for (int i = 1; i < 31; i++)
        {
            int num = rand.nextInt(99);
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

    /** Método para andar uma quantidade de nodulos na lista começando de "aux"
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

    }

    public void Shake()
    {

    }

    public void Comb(){}
    public void Gnome(){}
    public void Tim(){}

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
                filho2 = null;
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

    public void FusaoDiretaImp1(){}

    public void FusaoDiretaImp2(){}

    public void Counting(){}

    public void Bucket(){}

    public void Radix(){}
}
