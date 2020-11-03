package net.asianPay.springboot.repository;

import net.asianPay.springboot.entity.EmployeeAsiaPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAsiaPayRepository extends JpaRepository<EmployeeAsiaPay, Long> {
}
