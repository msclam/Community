package com.ljw;

import com.ljw.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author lanjuwen
 * @create 2022-04-06  17:16
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityLearnApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Test
    public void testTextMail() {
        mailClient.sendMail("1938181753@qq.com", "TEST", "welcome");
    }
}
