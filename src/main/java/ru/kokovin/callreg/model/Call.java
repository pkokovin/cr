package ru.kokovin.callreg.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "calls", uniqueConstraints = {@UniqueConstraint(columnNames = {"operator_id", "registered"}, name = "calls_unique_operator_registered_idx")})
public class Call extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "direction")
    private Direction direction;


    @Column(name = "registered", nullable = false)
    @NotNull
    private LocalDateTime registered;

    @Column(name = "phone_num", nullable = false)
    @NotBlank
    @Size(min = 7, max = 17)
    private String phone;

    @Column(name = "customer", nullable = false)
    @NotBlank
    @Size(min = 2, max = 70)
    private String customer;

    @Column(name = "comment", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Operator operator;


    public Call() {
    }

    public Call(Integer id, Direction direction, String phone, String comment, Operator operator) {
        this.id = id;
        this.direction = direction;
        this.registered = LocalDateTime.now();
        this.phone = phone;
        this.comment = comment;
        this.operator = operator;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Call{" +
                "direction=" + direction +
                ", registered=" + registered +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", operator=" + operator +
                '}';
    }
}
