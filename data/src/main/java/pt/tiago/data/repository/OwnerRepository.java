package pt.tiago.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tiago.data.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}