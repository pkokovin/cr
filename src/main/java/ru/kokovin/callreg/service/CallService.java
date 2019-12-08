package ru.kokovin.callreg.service;

import org.springframework.lang.Nullable;
import ru.kokovin.callreg.exception.ResourceNotFoundException;
import ru.kokovin.callreg.model.Call;

import java.time.LocalDateTime;
import java.util.List;

public interface CallService {
    List<Call> listAll();
    void save(Call call);
//    void update(Call call);
    Call getById(int id) throws ResourceNotFoundException;
    List<Call> getBetween(@Nullable LocalDateTime start,@Nullable LocalDateTime end);
}
