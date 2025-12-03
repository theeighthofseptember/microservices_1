package com.data_center.servers.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@Entity
@Table(name="servers")
public class Servers extends RepresentationModel<Servers> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "datacenter_name")
    private String datacenterName;

    @Column(name = "server_name")
    private String serverName;

    @Column(name = "cpu_model")
    private String cpuModel;

    @Column(name = "cpu_cores")
    private int cpuCores;

    @Column(name = "ram_gb")
    private int ramGB;

    @Column(name = "storage_type")
    private String storageType;

    @Column(name = "storage_gb")
    private int storageGB;

    @Column(name = "idle_power_w")
    private double idlePowerW;

    @Column(name = "max_power_w")
    private double maxPowerW;

    @Column(name = "psu_efficiency")
    private double psuEfficiency;

    @Column(name = "cooling_type")
    private String coolingType;

    @Column(name = "cooling_system_type")
    private String coolingSystemType;

    @Column(name = "airflow_layout")
    private String airflowLayout;

    @Column(name = "environment_region")
    private String environmentRegion;

    @Column(name = "rack_density_kw")
    private double rackDensityKW;

    @Column(name = "network_topology")
    private String networkTopology;

    @Column(name = "pue")
    private Double pue;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "virtualization_type")
    private String virtualizationType;

    @Column(name = "workload_type")
    private String workloadType;
}