package ru.kokovin.callreg.service;

import ru.kokovin.callreg.exception.ResourceNotFoundException;
import ru.kokovin.callreg.model.Operator;

import java.util.List;

public interface OperatorService {
    Operator get(int id) throws ResourceNotFoundException;
    List<Operator> list();
    void delete(int id);
    Operator save(Operator operator);
}
