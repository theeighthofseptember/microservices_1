package com.data_center.servers.service;

import java.util.Locale;

import com.data_center.servers.config.ServiceConfig;
import com.data_center.servers.repository.ServersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.data_center.servers.model.Servers;

@Service
public class ServersService {

    @Autowired
    @Qualifier("messageSource")
    MessageSource messages;
    @Autowired
    private ServersRepository serversRepository;
    @Autowired
    ServiceConfig config;

    // GET - получение данных о сервере
    public Servers getServer(String datacenterName, String serverName) {
        Servers servers = serversRepository.findByDatacenterNameAndServerName(datacenterName, serverName);
        if (null == servers) {
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("servers.search.error.message", null, null),
                            serverName, datacenterName));
        }
        return servers;
    }

    // POST - создание нового сервера
    public String createServer(Servers server, String datacenterName, Locale locale) {
        server.setDatacenterName(datacenterName);
        serversRepository.save(server);
        return String.format(messages.getMessage("servers.create.message", null, locale),
                server.getServerName(), datacenterName);
    }

    // PUT - обновление данных сервера
    public String updateServer(Servers server, String datacenterName, String serverName, Locale locale) {
        // Находим существующий сервер
        Servers existingServer = serversRepository.findByDatacenterNameAndServerName(datacenterName, serverName);

        if (existingServer == null) {
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("servers.search.error.message", null, locale),
                            serverName, datacenterName));
        }

        // Копируем все свойства, кроме id, datacenterName и serverName
        BeanUtils.copyProperties(server, existingServer, "id", "datacenterName", "serverName");

        // Сохраняем (теперь будет UPDATE, т.к. id есть)
        serversRepository.save(existingServer);

        return String.format(messages.getMessage("servers.update.message", null, locale),
                serverName, datacenterName);
    }

    // DELETE - удаление сервера
    public String deleteServer(String datacenterName, String serverName, int maxPowerW, Locale locale) {
        Servers server = serversRepository.findByDatacenterNameAndServerName(datacenterName, serverName);
        if (server != null) {
            serversRepository.delete(server);
        }
        return String.format(messages.getMessage("servers.delete.message", null, locale),
                serverName, maxPowerW, datacenterName);
    }

    public String getLinkName(String action, Locale locale) {
        return messages.getMessage("servers.link." + action, null, locale);
    }
}
