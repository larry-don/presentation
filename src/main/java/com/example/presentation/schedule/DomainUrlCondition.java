package com.example.presentation.schedule;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DomainUrlCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String domainUrl = context.getEnvironment().getProperty("domain.url");
        return domainUrl != null && domainUrl.contains("test");
    }
}
