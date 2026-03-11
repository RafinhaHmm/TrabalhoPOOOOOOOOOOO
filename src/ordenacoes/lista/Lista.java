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

}
