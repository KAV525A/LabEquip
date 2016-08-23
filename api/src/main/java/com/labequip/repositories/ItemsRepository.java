package com.labequip.repositories;

import com.labequip.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 19/08/2016.
 */
public interface ItemsRepository extends JpaRepository<Item,Long>{
}
