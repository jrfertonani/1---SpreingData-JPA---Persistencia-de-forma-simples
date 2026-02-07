package Java.model;

import jakarta.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefone;

    @Column(nullable = false)
    private String numero;

    @ManyToOne(optional = false)
    private UsuarioSpringData usuarioSpringData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UsuarioSpringData getUsuarioSpringData() {
        return usuarioSpringData;
    }

    public void setUsuarioSpringData(UsuarioSpringData usuarioSpringData) {
        this.usuarioSpringData = usuarioSpringData;
    }
}
