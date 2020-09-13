package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResult {
    private String message;
    private Detail detail;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {
        private String name;
    }
}
