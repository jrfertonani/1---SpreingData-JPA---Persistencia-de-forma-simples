package Java;

import Java.dao.InterfaceSpringDataUser;
import Java.dao.InterfaceTelefone;
import Java.model.Telefone;
import Java.model.UsuarioSpringData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Autowired
    private InterfaceTelefone interfaceTelefone;

    @Test
    @Commit
    public void testInsert(){
        UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
        usuarioSpringData.setEmail("jave@email.com");
        usuarioSpringData.setIdade(18);
        usuarioSpringData.setLogin("123");
        usuarioSpringData.setSenha("123");
        usuarioSpringData.setNome("Ademir telefone");

        interfaceSpringDataUser.save(usuarioSpringData);


        System.out.println("Gravado com sucesso -> "+ interfaceSpringDataUser.count());
    }

    @Test
    @Commit
    public void testConsulta(){

        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

        System.out.println(usuarioSpringData.get().getId());
        System.out.println(usuarioSpringData.get().getNome());
        System.out.println(usuarioSpringData.get().getIdade());
        System.out.println(usuarioSpringData.get().getEmail());
        System.out.println(usuarioSpringData.get().getLogin());
        System.out.println(usuarioSpringData.get().getSenha());

        for(Telefone telefone : usuarioSpringData.get().getTelefone()){
            System.out.println(telefone.getNumero());
            System.out.println(telefone.getTelefone());
        }

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


    @Test
    @Commit
    public void testeDelete(){

        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

     interfaceSpringDataUser.delete(usuarioSpringData.get());
    }

    @Test
    @Commit
    public void testeConsultaNome(){

     List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Ademir");

     for(UsuarioSpringData usuarioSpringData : list){
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
    public void testeConsultaNomeParam(){

        UsuarioSpringData list = (UsuarioSpringData) interfaceSpringDataUser.buscaPorNome("Ademir");

            System.out.println(list.getNome());

    }

    @Test
    @Commit
    public void testeDeletePorNome(){
        interfaceSpringDataUser.deletePorNome("SpringData");
    }

    @Test
    @Commit
    public void testeUpdateEmailPorNome(){
        interfaceSpringDataUser.updateEmailPorNome("jave@email.com", "Ademir");
    }

    @Test
    @Commit
    public void testeTelefone(){

        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);

        Telefone telefone = new Telefone();
        telefone.setTelefone("Celular");
        telefone.setNumero("999999999");
        telefone.setUsuarioSpringData(usuarioSpringData.get());

       // interfaceTelefone.save(telefone);

    }




}