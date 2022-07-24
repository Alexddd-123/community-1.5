package com.nowcoder.community.service;

import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<Message> findConversation(int uerId, int offSet, int limit) {
        return messageMapper.selectConversation(uerId, offSet, limit);
    }

    public int findConversationCount (int userId) {
        return messageMapper.selectConversationCount(userId);
    }

    public List<Message> findLetters(String conversationId, int offSet, int limit) {
        return messageMapper.selectLetters(conversationId, offSet, limit);
    }

    public int findLetterCount(String conversationId) {
        return messageMapper.selectLetterCount(conversationId);
    }

    public int findLetterUnreadLetter(int userId, String conversationId) {
        return messageMapper.selectLetterUnreadCount(userId, conversationId);
    }
}
