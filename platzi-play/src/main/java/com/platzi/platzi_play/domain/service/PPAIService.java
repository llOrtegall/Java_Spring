package com.platzi.platzi_play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PPAIService {

    @UserMessage("""
            Genera un saludo de bievenida a API Rest Realizada con Java - JDK 21 y spring-boot, el mensaje no debe ser tan largo
            y debe ser amable y profesional el anuncio de bienvenida
            """)
    String generateString();
}
