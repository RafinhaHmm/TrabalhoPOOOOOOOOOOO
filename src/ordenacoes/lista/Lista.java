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

    //ordenações
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

    //rafa fez isso
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

}
