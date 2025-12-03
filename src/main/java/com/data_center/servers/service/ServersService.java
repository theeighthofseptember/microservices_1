package com.data_center.servers.service;

import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import com.data_center.servers.model.Servers;

@Service
public class ServersService {

    @Autowired
    @Qualifier("messageSource")
    MessageSource messages;

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
    public String createServer(Servers server, String datacenterName, Locale locale) {
        String responseMessage = null;
        if(server != null) {
            server.setDatacenterName(datacenterName);
            responseMessage = String.format(messages.getMessage("servers.create.message", null,locale),
                    server.toString());
        }
        return responseMessage;
    }

    // PUT - обновление данных сервера
    public String updateServer(Servers server, String datacenterName, Locale locale) {
        String responseMessage = null;
        if(server != null) {
            server.setDatacenterName(datacenterName);
            responseMessage = String.format(messages.getMessage("servers.update.message", null,locale),
                    server.toString());
        }
        return responseMessage;
    }

    // DELETE - удаление сервера
    public String deleteServer(String datacenterName, String serverName, int maxPowerW,  Locale locale) {
        return String.format(messages.getMessage("servers.delete.message", null, locale),
                serverName,
                maxPowerW,
                datacenterName);
    }

    public String getLinkName(String action, Locale locale) {
        return messages.getMessage("servers.link." + action, null, locale);
    }
}
