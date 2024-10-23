package model;

 class Corretor extends Usuario{

    private String creci;

    Corretor(String nome_corretor, String email_corretor, String tel_corretor, String creci){
        
        super(nome_corretor,email_corretor, tel_corretor);
        this.creci = creci;
    }

    public String getCreci() {
        return creci;
    }
    public void setCreci(String creci) {
        this.creci = creci;
    }

    @Override
    public String toString() {
        return "" + getNome() + ", " + getCreci() + ", E-mail: " + getEmail() + ", Telefone: " + getTel();
    }
// SEM ALTERAÇÕES


}
