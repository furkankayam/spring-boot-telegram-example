package com.furkankayam.config;/*
package com.furkankayam.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "bot")
public class TelegramConfig {

    private String name;
    private String token;
    // private String chatId;
}
*/

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bot")
public record TelegramConfig(
        String name,
        String token,
        String chatIdsFile
) {
}