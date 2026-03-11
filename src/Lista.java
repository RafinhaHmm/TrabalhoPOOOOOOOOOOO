import java.util.Random;

public class Lista {
    No inicio, fim;

    public void inicializa()
    {
        this.inicio = null;
        this.fim = null;
    }
    public No criaNo(Registro reg)
    {
        No no = new No(reg);
        no.setProx(null);
        no.setAnt(null);
        return no;
    }
    public void insereInicio(Registro reg)
    {
        No no = criaNo(reg);
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
            Registro regi = new Registro(i);
            this.insereInicio(regi);
        }
    }

    public void emOrdem()
    {
        this.inicializa();

        for (int i = 50; i > 0; i--)
        {
            Registro regi = new Registro(i);
            this.insereInicio(regi);
        }
    }

    public void Randomico()
    {
        Random rand = new Random();
        this.inicializa();

        for (int i = 1; i < 50; i++)
        {
            int num = rand.nextInt(99);
            Registro regi = new Registro(num);
            this.insereInicio(regi);
        }
    }

    public void insercao_direta()
    {
        No pi = inicio.getProx(), ppos;
        int aux;
        while(pi != null)
        {
            aux = pi.getReg().getNumero();
            ppos = pi;
            while(ppos != inicio && aux < ppos.getAnt().getReg().getNumero())
            {
                ppos.setReg(ppos.getAnt().getReg());
                ppos = ppos.getAnt();
            }
            Registro reg = new Registro(aux);
            ppos.setReg(reg);
            pi=pi.getProx();
        }
    }

}
