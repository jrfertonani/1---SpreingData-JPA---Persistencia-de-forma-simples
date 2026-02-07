package Java.dao;

import Java.model.UsuarioSpringData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {


    @Query(value = "select p from UsuarioSoringData p where p.nome like %?1%")
    public List<UsuarioSpringData> buscaPorNome(String nome);

}
