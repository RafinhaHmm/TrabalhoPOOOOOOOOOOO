public class No {
    private No prox;
    private No ant;
    private Registro reg;

    public No(Registro reg)
    {
        this.prox = null;
        this.ant = null;
        this.reg = reg;
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

    public Registro getReg() {
        return this.reg;
    }

    public void setReg(Registro reg) {
        this.reg = reg;
    }
}
