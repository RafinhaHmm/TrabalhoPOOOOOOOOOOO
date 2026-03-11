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

        for (int i = 1; i < 50; i++)
        {
            this.insereInicio(i);
        }
    }

    public void emOrdem()
    {
        this.inicializa();

        for (int i = 50; i > 0; i--)
        {
            this.insereInicio(i);
        }
    }

    public void Randomico()
    {
        Random rand = new Random();
        this.inicializa();

        for (int i = 1; i < 50; i++)
        {
            int num = rand.nextInt(99);
            this.insereInicio(num);
        }
    }

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
}
