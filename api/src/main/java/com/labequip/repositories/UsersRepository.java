package com.labequip.repositories;

import com.labequip.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 19/08/2016.
 */
public interface UsersRepository extends JpaRepository<User,Long>{
}
