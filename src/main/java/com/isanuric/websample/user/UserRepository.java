package com.isanuric.websample.user;

import org.springframework.data.repository.CrudRepository;

/*
 * ----------------------------------------------
 * (c) 2018 Copyright iC Consult GmbH
 * <p/>
 * Project: web-sample
 * @author ehsan.salmani@ic-consult.de on 23/12/2018.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
