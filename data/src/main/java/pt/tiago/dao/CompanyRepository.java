package pt.tiago.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tiago.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}