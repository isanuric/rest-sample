package com.isanuric.websample.user;

import org.springframework.data.repository.CrudRepository;

/*
 * Project: web-sample
 * @author Ehsan Salmani
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
