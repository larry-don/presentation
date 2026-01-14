package com.example.presentation.config;


import com.example.presentation.enums.MetaInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "my")
public class MyProperties {

    private List<NestedConfig> nestedConfigs;


    // Getter and setter methods
    public List<NestedConfig> getNestedConfigs() {
        return nestedConfigs;
    }

    public void setNestedConfigs(List<NestedConfig> nestedConfigs) {
        this.nestedConfigs = nestedConfigs;
    }

    private Map<String, NestedConfig> nestedConfigMap;

    // Getter and setter methods
    public Map<String, NestedConfig> getNestedConfigMap() {
        return nestedConfigMap;
    }

    public void setNestedConfigMap(Map<String, NestedConfig> nestedConfigMap) {
        this.nestedConfigMap = nestedConfigMap;
    }


//    @NestedConfigurationProperty
    private Map<MetaInfo, NestedConfig> metaInfoNestedConfigMap = initConfig();

    public Map<MetaInfo, NestedConfig> getMetaInfoNestedConfigMap() {
        return metaInfoNestedConfigMap;
    }

    public void setMetaInfoNestedConfigMap(Map<MetaInfo, NestedConfig> metaInfoNestedConfigMap) {
        this.metaInfoNestedConfigMap = metaInfoNestedConfigMap;
    }

    public Map<MetaInfo, NestedConfig> initConfig() {
        Map<MetaInfo, NestedConfig> map = new HashMap<>();
        for (MetaInfo value : MetaInfo.values()) {
            NestedConfig config = value.getConfig();
            map.put(value, config);
        }
        return map;
    }

    public static class NestedConfig {

        public NestedConfig() {
        }

        public NestedConfig(String property) {
            this.propertyName = property;
        }

        public NestedConfig(String property, String property2) {
            this.propertyName = property;
            this.property2 = property2;
        }

        private String propertyName;
        private String property2;

        public String getProperty2() {
            return property2;
        }

        public void setProperty2(String property2) {
            this.property2 = property2;
        }

        // Getter and setter methods
        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        @Override
        public String toString() {
            return "NestedConfig{" +
                    "property='" + propertyName + '\'' +
                    '}';
        }
    }
}
