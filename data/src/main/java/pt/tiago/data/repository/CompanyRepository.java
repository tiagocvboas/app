package pt.tiago.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tiago.data.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}