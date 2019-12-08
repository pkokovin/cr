package ru.kokovin.callreg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kokovin.callreg.exception.ResourceNotFoundException;
import ru.kokovin.callreg.model.Call;
import ru.kokovin.callreg.repository.CallRepository;
import ru.kokovin.callreg.util.DateTimeUtil;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CallServiceImpl implements CallService {

    private final CallRepository repository;

    @Autowired
    public CallServiceImpl(@Qualifier("callRepository") CallRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public List<Call> listAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(Call call)  {
        repository.save(call);
    }

    @Override
    @Transactional
    public Call getById(int id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Call> getBetween(LocalDateTime start, LocalDateTime end) {
        LocalDateTime startChecked = start == null ? DateTimeUtil.MIN_DATE : start;
        LocalDateTime endChecked = end == null ? DateTimeUtil.MAX_DATE : end;
        return repository.getBetween(startChecked, endChecked);
    }
}
