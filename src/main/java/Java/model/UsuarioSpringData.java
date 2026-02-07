package Java.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UsuarioSpringData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private Integer idade;
    private String login;
    private String nome;
    private String senha;


    @OneToMany(mappedBy = "usuarioSpringData", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Telefone> telefone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
}
