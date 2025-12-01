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
    public String deleteServer(String datacenterName, String serverName, int powerConsumption,  Locale locale) {
        return String.format(messages.getMessage("servers.delete.message", null, locale),
                serverName,
                powerConsumption,
                datacenterName);
    }

    public String getLinkName(String action, Locale locale) {
        return messages.getMessage("servers.link." + action, null, locale);
    }
}
