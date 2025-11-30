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
        server.setDatacenterName(datacenterName);
        server.setServerName(serverName);
        server.setActiveUse(true);
        server.setPowerConsumption(450);
        server.setCost(150000);
        server.setSerialNumber("SN-" + new Random().nextInt(99999));
        server.setCpu("Intel Xeon Gold 6248R");
        server.setRam("128GB DDR4");
        server.setStorage("2TB NVMe SSD");
        server.setOs("Ubuntu Server 22.04");
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
