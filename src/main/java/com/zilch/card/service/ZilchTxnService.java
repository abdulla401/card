package com.zilch.card.service;

import com.zilch.card.modal.ZilchTxn;
import com.zilch.card.repository.ZilchTxnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZilchTxnService {
    private final ZilchTxnRepository zilchTxnRepository;

    @Transactional
    public ZilchTxn save(ZilchTxn zilchTxn) {
        return zilchTxnRepository.save(zilchTxn);
    }

    public List<ZilchTxn> finalAll() {
        return zilchTxnRepository.findAll();
    }
}
