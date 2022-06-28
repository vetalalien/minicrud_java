package com.vetalalien.miniservice.metrics;

import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.spring.autoconfigure.MeterRegistryCustomizer;

/**
 * Configuration bean for metrics.
 *
 * @author vv.tarasov
 *
 */
public class MetricsConfiguration {

    /**
     * Register common tags application instead of job.
     * This application tag is needed for Grafana dashboard.
     *
     * @return registry with registered tags.
     */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> {
            registry.config().commonTags("application", "vi_minicrud_metrics_service");
        };
    }

}