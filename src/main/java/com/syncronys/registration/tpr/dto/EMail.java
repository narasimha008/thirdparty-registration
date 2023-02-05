package com.syncronys.registration.tpr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class EMail {

    String to;
    String from;
    String subject;
    String content;
    private Map<String, Object> props;
}
