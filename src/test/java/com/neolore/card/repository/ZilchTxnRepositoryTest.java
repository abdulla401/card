package com.neolore.card.repository;

import com.neolore.card.modal.ZilchTxn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ZilchTxnRepositoryTest {
   @Autowired
   ZilchTxnRepository zilchTxnRepository;

   @Test
    public void testCreateReadDelete(){
       ZilchTxn zilchTxn = new ZilchTxn(1l, "tesco", new BigDecimal("11.22"), 14l);
       zilchTxnRepository.save(zilchTxn);
       List<ZilchTxn> txns = zilchTxnRepository.findAll();
       assertEquals(1, txns.size(), "More than one record saved");
       assertAll(
              () -> assertEquals("tesco", txns.get(0).getNote()),
              () -> assertEquals(new BigDecimal("11.22"), txns.get(0).getPrice()),
              () -> assertEquals(14l, txns.get(0).getCustomerId())
      );
   }

}