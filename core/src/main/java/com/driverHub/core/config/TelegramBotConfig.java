package com.driverHub.core.config;

import com.pengrad.telegrambot.TelegramBot;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class TelegramBotConfig {
    @Value("${botToken}")
    private String BOT_TOKEN;

    @Bean
    TelegramBot createTelegramBot(OkHttpClient okHttpClient){
        return new TelegramBot.Builder(BOT_TOKEN).okHttpClient(okHttpClient).build();
    }

    @Bean
    OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }
}
