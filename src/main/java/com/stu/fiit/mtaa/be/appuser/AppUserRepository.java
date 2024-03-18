package com.stu.fiit.mtaa.be.appuser;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
    @Transactional
    @Modifying
    @Query("DELETE FROM AppUser user WHERE user.username = ?1")
    void deleteAppUserByName(String username);
}

