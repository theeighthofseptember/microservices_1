package com.data_center.servers.service;

import java.util.Random;
import org.springframework.stereotype.Service;

import com.data_center.servers.model.Servers;

@Service
public class ServersService {

    // GET - получение данных о сервере
    public Servers getServer(String datacenterName, String serverName) {
        Servers server = new Servers();
        server.setId(new Random().nextInt(1000));

        // Общая информация
        server.setDatacenterName(datacenterName);
        server.setServerName(serverName);

        // Аппаратная конфигурация
        server.setCpuModel("Intel Xeon Gold 6248R");
        server.setCpuCores(24);
        server.setRamGB(128);
        server.setStorageType("NVMe SSD");
        server.setStorageGB(2000);

        // Энергопотребление
        server.setIdlePowerW(180.0);
        server.setMaxPowerW(450.0);
        server.setPsuEfficiency(0.92);

        // Характеристики ЦОД
        server.setCoolingType("air");
        server.setCoolingSystemType("direct free cooling");
        server.setAirflowLayout("cold/hot aisle containment");
        server.setEnvironmentRegion("Умеренный климат");
        server.setRackDensityKW(8.0);
        server.setNetworkTopology("spine-leaf");
        server.setPue(1.20);

        // Программная среда
        server.setOperatingSystem("Ubuntu Server 22.04");
        server.setVirtualizationType("container");
        server.setWorkloadType("web services");

        return server;
    }

    // POST - создание нового сервера
    public String createServer(Servers server, String datacenterName) {
        if(server != null) {
            server.setDatacenterName(datacenterName);  // Устанавливаем из URL
            return String.format("Server created in datacenter %s: %s",
                    datacenterName, server.toString());
        }
        return "Failed to create server";
    }

    // PUT - обновление данных сервера
    public String updateServer(Servers server, String datacenterName) {
        if(server != null) {
            server.setDatacenterName(datacenterName);  // Устанавливаем из URL
            return String.format("Server updated in datacenter %s: %s",
                    datacenterName, server.toString());
        }
        return "Failed to update server";
    }

    // DELETE - удаление сервера
    public String deleteServer(String datacenterName, String serverName) {
        return String.format("Server %s deleted from datacenter %s",
                serverName, datacenterName);
    }
}
