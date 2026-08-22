package com.thor.agent.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LLMConstants {
    public static final String LLM_TABLE_NAME = "consumo-ia";
    public static final String LLM_FIELD_CREATION_DATETIME = "data-hora-criacao";
    public static final String LLM_FIELD_REQUEST = "requisicao";
    public static final String LLM_FIELD_RESPONSE = "resposta";
    public static final String LLM_FIELD_REQUEST_TOKENS = "tokens-requisicao";
    public static final String LLM_FIELD_RESPONSE_TOKENS = "tokens-resposta";
    public static final String LLM_FIELD_TOTAL_TOKENS = "tokens-totais-gastos";
}
