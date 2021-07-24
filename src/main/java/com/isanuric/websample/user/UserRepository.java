package com.isanuric.websample.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Project: web-sample
 * @author Ehsan Salmani
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
