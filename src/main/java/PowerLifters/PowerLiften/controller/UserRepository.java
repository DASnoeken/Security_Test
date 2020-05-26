package PowerLifters.PowerLiften.controller;

import org.springframework.data.repository.CrudRepository;

import PowerLifters.PowerLiften.domein.User;

public interface UserRepository extends CrudRepository<User,Long>{

	User findByUsername(String username);
	
}
