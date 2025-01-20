package test.rtc.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import test.rtc.dto.ChatMessageRequest;
import test.rtc.ropository.MemoryChatRoomRepository;
import test.rtc.ropository.MessageRepository;
import test.rtc.service.ChatRoom;
import test.rtc.service.mapper.MessageMapper;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final MessageMapper messageMapper;
    private final MemoryChatRoomRepository memoryChatRoomRepository;
    private final MessageRepository messageRepository;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        final String payload = message.getPayload();
        final ChatMessageRequest chatMessageRequest = objectMapper.readValue(payload, ChatMessageRequest.class);
//        final ChatRoom chatRoom = memoryChatRoomRepository.getChatRoom(chatMessageRequest.chatRoomId());
//        chatRoom.handleMessage(session, chatMessageRequest, objectMapper);
        messageRepository.save(messageMapper.toMessage(chatMessageRequest));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        log.info("Connection Close : {} , Status : {}",session.getId(),status.toString());
    }
}
