package ru.izimin.jpaspecificationsdemo.dao.specification;

import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;
import ru.izimin.jpaspecificationsdemo.dao.entity.User;

import java.time.LocalDate;

@Builder
public class UserSpecification {

    private LocalDate birthDate;
    private String phone;
    private String name;

    public Specification<User> buildSpecification() {
        return Specification.where(specificationByBirthDate())
                .and(specificationByName())
                .and(specificationByPhone());
    }

    public Specification<User> specificationByBirthDate() {
        return (root, query, cb) -> birthDate == null ? null
                : cb.greaterThanOrEqualTo(root.get("birthDate"), birthDate);
    }

    public Specification<User> specificationByName() {
        return (root, query, cb) -> name == null ? null
                : cb.like(cb.lower(root.get("name")), name.toLowerCase() + "%");
    }

    // Это если есть отдельная таблица с номерами телефонов
    public Specification<User> specificationByPhone() {
        return (root, query, cb) -> phone == null ? null
                : cb.equal(root.join("phones").get("phone"), phone);
    }
}
