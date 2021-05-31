package myzhong.com.newsletter.repositories;

import myzhong.com.newsletter.models.Subscriber;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {
    Subscriber findById(int id);
    List<Subscriber> findAll();
    void deleteById(int id);

    @Transactional
    @Modifying
    @Query("delete from Subscriber n where (n.email=:email and n.name=:name and n.id <> 0) ")
    void deleteSubscriber(@Param("email") String email, @Param("name") String name);
}