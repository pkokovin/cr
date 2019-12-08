package ru.kokovin.callreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kokovin.callreg.model.Operator;


@Repository("operatorRepository")
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

}