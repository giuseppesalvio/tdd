package repository;

import com.arca.poc.PocApplication;
import com.arca.poc.dominio.TotaleBancaResponse;
import com.arca.poc.entity.ContoCorrente;
import com.arca.poc.repository.AccountRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PocApplication.class)

public class AccountRepositoryTest {

    @Autowired private AccountRepository accountRepository ;


    @Test
    public void estraiSaldoContoPerId (){

        ContoCorrente response = accountRepository.getTotaleContoPerAccount("1");

        Assertions.assertEquals("1", response.getId());
        Assertions.assertEquals(11111, response.getSaldo());

    }

}
