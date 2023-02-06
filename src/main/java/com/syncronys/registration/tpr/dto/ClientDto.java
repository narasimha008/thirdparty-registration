package com.syncronys.registration.tpr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;

    private String name;

    private String info;

    private String appName;

    private String appDesc;

    private String userAuthDesc;

    private String dataDesc;

    private String appLink;

    private String appContact;

    private String status;

    private String btnName;
}
