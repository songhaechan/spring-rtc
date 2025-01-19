package test.rtc.ropository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.rtc.domain.Message;

public interface MessageRepository extends JpaRepository<Message,String> {
}
