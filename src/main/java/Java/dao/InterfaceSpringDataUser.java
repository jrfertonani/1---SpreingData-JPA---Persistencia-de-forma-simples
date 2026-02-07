package Java.dao;

import Java.model.UsuarioSpringData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {


    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    public List<UsuarioSpringData> buscaPorNome(String nome);

    @Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
    public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);


    @Modifying
    @Transactional()
    @Query(value = "delete from UsuarioSpringData u where u.nome = ?52")
    public void deletePorNome(String nome);

    @Modifying
    @Transactional
    @Query("update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
    public void updateEmailPorNome(String email, String nome);

}
