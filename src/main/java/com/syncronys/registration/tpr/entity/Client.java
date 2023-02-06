package com.syncronys.registration.tpr.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class Client {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String info;

    @Column
    private String appName;

    @Column
    private String appDesc;

    @Column
    private String userAuthDesc;

    @Column
    private String dataDesc;

    @Column
    private String appLink;

    @Column
    private String appContact;

    @Column
    private String status;
}
