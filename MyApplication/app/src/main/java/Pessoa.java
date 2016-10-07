/**
 * Created by gabri on 06/10/2016.
 */
public class Pessoa {

    private String nome;

    private String email;

    private String endereco;

    private String cpf;


    public Pessoa(){}

    public Pessoa(String nome, String email, String endereco, String cpf){

        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
        setCpf(cpf);

    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    @Override
    public String toString() {
        return "Nome : "+this.getNome() + "\n Endereço: "+this.getEndereco() + "\n Cpf: "+
                this.getCpf() + "\n Email: " +this.getEmail();
    }

}
