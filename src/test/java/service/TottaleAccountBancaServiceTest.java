package service;

import com.arca.poc.entity.ContoCorrente;
import com.arca.poc.repository.AccountRepository;
import com.arca.poc.service.TottaleAccountBancaService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TottaleAccountBancaServiceTest {

  @InjectMocks private TottaleAccountBancaService tottaleAccountBancaService;

  @Mock private AccountRepository accountRepository;

  @Test
  public void getTotaleBAncaArrotndatoDaDB() {

    ContoCorrente contoCorrente = ContoCorrente.builder().id("id").saldo(123).build();
    when(accountRepository.getTotaleContoPerAccount(anyString())).thenReturn(contoCorrente);
    ContoCorrente result = tottaleAccountBancaService.getTotaleBAncaArrotndatoDaDB("id");

    verify(accountRepository).getTotaleContoPerAccount("id");
    Assertions.assertEquals("id", result.getId());
    Assertions.assertEquals(123, result.getSaldo());
  }
}
