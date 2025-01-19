package test.rtc.dto;


import test.rtc.domain.MessageType;

public record ChatMessageRequest(MessageType messageType, String text, Long memberId, Long chatRoomId) {
}
