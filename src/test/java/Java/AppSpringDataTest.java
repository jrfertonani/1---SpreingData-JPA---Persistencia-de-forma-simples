package Java;

import Java.dao.InterfaceSpringDataUser;
import Java.model.UsuarioSpringData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.Optional;


@SpringBootTest
public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Test
    @Commit
    public void testInsert(){
        UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
        usuarioSpringData.setEmail("jave@email.com");
        usuarioSpringData.setIdade(18);
        usuarioSpringData.setLogin("123");
        usuarioSpringData.setSenha("123");
        usuarioSpringData.setNome("Ademir");

        interfaceSpringDataUser.save(usuarioSpringData);


        System.out.println("Gravado com sucesso -> "+ interfaceSpringDataUser.count());
    }

    @Test
    @Commit
    public void testInsert2(){

        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

        System.out.println(usuarioSpringData.get().getId());
        System.out.println(usuarioSpringData.get().getNome());
        System.out.println(usuarioSpringData.get().getIdade());
        System.out.println(usuarioSpringData.get().getEmail());
        System.out.println(usuarioSpringData.get().getLogin());
        System.out.println(usuarioSpringData.get().getSenha());
    }

    @Test
    public void testConsultaTodos(){

        Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

        for(UsuarioSpringData usuarioSpringData : lista){
            System.out.println(usuarioSpringData.getId());
            System.out.println(usuarioSpringData.getNome());
            System.out.println(usuarioSpringData.getIdade());
            System.out.println(usuarioSpringData.getEmail());
            System.out.println(usuarioSpringData.getLogin());
            System.out.println(usuarioSpringData.getSenha());
        }

    }

    @Test
    @Commit
    public void testeUpdate(){

        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        UsuarioSpringData data = usuarioSpringData.get();

        data.setNome("SpreingData");

        interfaceSpringDataUser.save(data);
    }





}