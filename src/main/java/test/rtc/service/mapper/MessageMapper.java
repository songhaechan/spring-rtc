package test.rtc.service.mapper;

import org.springframework.stereotype.Component;
import test.rtc.domain.Message;
import test.rtc.dto.ChatMessageRequest;

@Component
public class MessageMapper {
    public Message toMessage(ChatMessageRequest request){
        return Message.builder()
                .messageType(request.messageType())
                .text(request.text())
                .chatRoomId(request.chatRoomId())
                .memberId(request.memberId())
                .build();
    }
}
