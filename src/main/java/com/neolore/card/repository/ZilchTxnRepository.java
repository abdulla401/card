package com.neolore.card.repository;

import com.neolore.card.modal.ZilchTxn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZilchTxnRepository extends JpaRepository<ZilchTxn, Long> {
}
