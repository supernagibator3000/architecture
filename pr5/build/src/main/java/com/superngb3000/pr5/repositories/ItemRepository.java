package com.superngb3000.pr5.repositories;

import com.superngb3000.pr5.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public Item findItemByName(String name);
}
