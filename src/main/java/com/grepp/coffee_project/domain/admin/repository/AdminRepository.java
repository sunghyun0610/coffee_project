package com.grepp.coffee_project.domain.admin.repository;

import com.grepp.coffee_project.domain.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    public Optional<Admin> findByemail(String email);
}
/*
* **Optional**은 null을 안전하게 처리하는 객체입니다.
Optional을 사용하면 null 값을 직접 사용하거나 체크하는 대신, 더 안전한 메서드를 통해 값을 처리할 수 있습니다.
* */