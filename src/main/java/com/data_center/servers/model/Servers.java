package com.data_center.servers.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Servers {
    private int id;

    // -------------------------
    // Общая информация о сервере
    // -------------------------
    private String datacenterName;
    private String serverName;

    // -------------------------
    // Аппаратная конфигурация
    // -------------------------
    private String cpuModel;            // модель CPU (один или несколько)
    private int cpuCores;               // количество физических ядер
    private int ramGB;                  // оперативная память
    private String storageType;         // HDD / SSD / NVMe / mSATA
    private int storageGB;              // объем хранилища

    // -------------------------
    // Энергопотребление
    // -------------------------
    private double idlePowerW;          // потребление в простое
    private double maxPowerW;           // потребление под нагрузкой
    private double psuEfficiency;       // КПД блока питания (0.90–0.98)

    // -------------------------
    // Характеристики эксплуатации в ЦОД
    // -------------------------
    private String coolingType;         // air / liquid
    private String coolingSystemType;   // free-cooling / chiller
    private String airflowLayout;       // hot/cold aisle containment
    private String environmentRegion;   // Умеренный / Север / Арктика и т.п.
    private double rackDensityKW;       // плотность мощности стойки
    private String networkTopology;     // fat-tree / spine-leaf / 2-tier
    private Double pue;                 // показатель энергоэффективности

    // -------------------------
    // Программная среда
    // -------------------------
    private String operatingSystem;     // Linux / Windows / кластерная ОС
    private String virtualizationType;  // container / VM / bare metal
    private String workloadType;        // web search / HPC / business app / etc.
}