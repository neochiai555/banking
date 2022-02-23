package com.ochiai.banking.mensageria.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import com.ochiai.banking.mensageria.service.MensageriaServico;

@Configuration
public class KafkaTopicConfig {
    
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
    @Bean
    public NewTopic topicCardTransactionInvocation() {
         return new NewTopic(MensageriaServico.TOPICO_INVOCACAO_TRANSACAO_CARTAO, 1, (short) 1);
    }
    
    @Bean
    public NewTopic topicCardTransactionReturn() {
         return new NewTopic(MensageriaServico.TOPICO_RETORNO_TRANSACAO_CARTAO, 1, (short) 1);
    }

    @Bean
    public NewTopic topicAccountTransactionInvocation() {
         return new NewTopic(MensageriaServico.TOPICO_INVOCACAO_TRANSACAO_CONTA, 1, (short) 1);
    }
    
    @Bean
    public NewTopic topicAccountTransactionReturn() {
         return new NewTopic(MensageriaServico.TOPICO_RETORNO_TRANSACAO_CONTA, 1, (short) 1);
    }
}