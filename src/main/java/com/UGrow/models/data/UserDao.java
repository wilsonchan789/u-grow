package com.UGrow.models.data;

import javax.transaction.Transactional;

import com.UGrow.models.User;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
