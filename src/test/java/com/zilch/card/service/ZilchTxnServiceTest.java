package com.zilch.card.service;

import com.zilch.card.modal.ZilchTxn;
import com.zilch.card.repository.ZilchTxnRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZilchTxnServiceTest {

    @InjectMocks
    ZilchTxnService zilchTxnService;

    @Mock
    ZilchTxnRepository zilchTxnRepository;


    @Test
    public void testFindAll_returnsAllTxns(){
        List<ZilchTxn> list = new ArrayList<>();
        ZilchTxn zilchTxn1 = new ZilchTxn(1l, "tesco", new BigDecimal("11.22"), 14l);
        ZilchTxn zilchTxn2 = new ZilchTxn(2l, "pharmacy", new BigDecimal("5.50"), 14l);
        list.add(zilchTxn1);
        list.add(zilchTxn2);

        when(zilchTxnRepository.findAll()).thenReturn(list);
        List<ZilchTxn> zilchTxns = zilchTxnService.finalAll();
        assertEquals(2, list.size(), "More than two record saved");
        verify(zilchTxnRepository, times(1)).findAll();

    }

    @Test
    public void testSave_CallsRepositoryOnce(){
        ZilchTxn zilchTxn1 = new ZilchTxn(1l, "tesco", new BigDecimal("11.22"), 14l);
        zilchTxnService.save(zilchTxn1);
        verify(zilchTxnRepository, times(1)).save(zilchTxn1);
    }

}