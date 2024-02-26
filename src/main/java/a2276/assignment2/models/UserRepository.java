package a2276.assignment2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByHeight(int height);
    List<User> findByName(String name);
    List<User> findByUid(int uid);
}
