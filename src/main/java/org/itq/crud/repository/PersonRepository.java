package org.itq.crud.repository;

import org.itq.crud.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by a212359654 on 9/7/17.
 */

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person,Long> {


}
