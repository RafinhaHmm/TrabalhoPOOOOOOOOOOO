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

    public No NoIndice(int indice)
    {
        No aux = inicio;
        while (aux != null && indice > 0)
        {
            aux = aux.getProx();
            indice--;
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
        int i,pos;
        No aux1, aux2;
        int auxNum;
        while(dist < tl)
            dist = 3 * dist + 1;
        dist = dist/3;
        while(dist > 0)
        {
            i = dist;
            pos = i;
            while(i < tl)
            {
                aux1 = NoIndice(i);
                auxNum = aux1.getNum();
                aux2 = NoIndice(pos-dist);
                while(pos > 0 && aux2 != null && auxNum < aux2.getNum())
                {
                    aux1.setNum(aux2.getNum());
                    aux1 = aux2;
                    pos = pos-dist;
                    aux2 = NoIndice(pos);
                }
                aux1.setNum(auxNum);
                i++;
            }
            dist = dist/3;
        }
    }

    public void HeapSort(){}

    public void QuickSemPivo(){}

    public void QuickComPivo(){}

    public void FusaoDiretaImp1(){}

    public void FusaoDiretaImp2(){}

    public void Counting(){}

    public void Bucket(){}

    public void Radix(){}
}
