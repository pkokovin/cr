package ru.kokovin.callreg.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kokovin.callreg.model.Call;


import java.time.LocalDateTime;
import java.util.List;

@Repository("callRepository")
@Transactional(readOnly = true)
public interface CallRepository extends JpaRepository<Call, Integer> {

    @Query("SELECT c from Call c WHERE c.registered >=:start AND c.registered <=:end")
    List<Call> getBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
