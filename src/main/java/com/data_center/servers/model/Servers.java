package com.data_center.servers.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
public class Servers extends RepresentationModel<Servers> {
    private int id;
    private String datacenterName;
    private String serverName;
    private boolean activeUse;
    private int powerConsumption;
    private int cost;
    private String serialNumber;
    private String cpu;
    private String ram;
    private String storage;
    private String os;
}