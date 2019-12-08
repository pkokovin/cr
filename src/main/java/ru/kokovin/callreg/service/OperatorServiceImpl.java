package ru.kokovin.callreg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kokovin.callreg.exception.ResourceNotFoundException;
import ru.kokovin.callreg.model.Operator;
import ru.kokovin.callreg.repository.OperatorRepository;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository repository;

    @Autowired
    public OperatorServiceImpl(@Qualifier("operatorRepository") OperatorRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public Operator get(int id) throws ResourceNotFoundException{
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Transactional
    public List<Operator> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public Operator save(Operator operator) {return repository.save(operator);}
}
