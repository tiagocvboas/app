package pt.tiago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tiago.entity.Company;
import pt.tiago.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}