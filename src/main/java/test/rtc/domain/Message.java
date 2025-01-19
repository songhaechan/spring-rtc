package test.rtc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MessageType messageType;
    private Long memberId;
    private Long chatRoomId;
    private String text;

    @Builder
    public Message(final MessageType messageType, final Long memberId, final Long chatRoomId, final String text) {
        this.messageType = messageType;
        this.memberId = memberId;
        this.chatRoomId = chatRoomId;
        this.text = text;
    }
}
