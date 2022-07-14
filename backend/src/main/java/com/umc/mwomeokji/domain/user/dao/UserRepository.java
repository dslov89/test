package com.umc.mwomeokji.domain.user.dao;

import com.umc.mwomeokji.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
