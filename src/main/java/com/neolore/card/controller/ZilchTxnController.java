package com.neolore.card.controller;

import com.neolore.card.modal.ZilchTxn;
import com.neolore.card.service.ZilchTxnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ZilchTxnController {
    private final ZilchTxnService zilchTxnService;

    @PostMapping("save")
    public ZilchTxn save(@RequestBody ZilchTxn zilchTxn) {
        return zilchTxnService.save(zilchTxn);
    }

    @GetMapping(path = "/list")
    public List<ZilchTxn> findAll() {
        return zilchTxnService.finalAll();
    }
}