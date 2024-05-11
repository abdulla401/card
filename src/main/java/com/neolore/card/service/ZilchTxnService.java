package com.neolore.card.service;

import com.neolore.card.repository.ZilchTxnRepository;
import com.neolore.card.modal.ZilchTxn;
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
