package ordenacoes.lista;

public class No {
    private No prox;
    private No ant;
    int num;

    public No(int num)
    {
        this.prox = null;
        this.ant = null;
        setNum(num);
    }

    public int getNum()
    {
        return this.num;
    }
    public void setNum(int num)
    {
        if (num > 0)
            this.num = num;
        else
            this.num = num*(-1);
    }

    public No getAnt()
    {
        return this.ant;
    }
    public No getProx()
    {
        return this.prox;
    }
    public void setProx(No no)
    {
        this.prox = no;
    }
    public void setAnt(No no)
    {
        this.ant = no;
    }

}
