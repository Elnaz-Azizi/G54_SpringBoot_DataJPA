package se.lexicon.springboot_datajpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springboot_datajpa.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
