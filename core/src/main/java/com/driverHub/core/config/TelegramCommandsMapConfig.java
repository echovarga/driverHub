package com.driverHub.core.config;

import com.driverHub.core.telegram.commands.TelegramCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class TelegramCommandsMapConfig {
    List<TelegramCommand> telegramCommandList;

    @Bean(name = "telegramCommandMap")
    Map<String, TelegramCommand> createTelegramCommandMap(){
        return telegramCommandList.stream()
                .collect(Collectors.toMap(TelegramCommand::getCommandText, Function.identity()));
    }
}
