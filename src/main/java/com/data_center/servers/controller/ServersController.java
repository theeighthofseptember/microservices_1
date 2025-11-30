package com.data_center.servers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.data_center.servers.model.Servers;
import com.data_center.servers.service.ServersService;
import java.util.Locale;

@RestController
@RequestMapping(value="datacenters/{datacenterName}/servers")
public class ServersController {

    @Autowired
    private ServersService serversService;

    // GET - получить информацию о сервере
    @GetMapping(value="/{serverName}")
    public ResponseEntity<Servers> getServer(
            @PathVariable("datacenterName") String datacenterName,
            @PathVariable("serverName") String serverName) {
        Servers server = serversService.getServer(datacenterName, serverName);
        return ResponseEntity.ok(server);
    }

    // POST - создать новый сервер
    @PostMapping
    public ResponseEntity<String> createServer(
            @PathVariable("datacenterName") String datacenterName,
            @RequestBody Servers request,
            @RequestHeader(value = "Accept-Language", required = false)
            Locale locale) {
        return ResponseEntity.ok(serversService.createServer(request, datacenterName, locale));
    }

    // PUT - обновить данные сервера
    @PutMapping
    public ResponseEntity<String> updateServer(
            @PathVariable("datacenterName") String datacenterName,
            @RequestBody Servers request) {
        return ResponseEntity.ok(serversService.updateServer(request, datacenterName));
    }

    // DELETE - удалить сервер
    @DeleteMapping(value="/{serverName}")
    public ResponseEntity<String> deleteServer(
            @PathVariable("datacenterName") String datacenterName,
            @PathVariable("serverName") String serverName) {
        return ResponseEntity.ok(serversService.deleteServer(datacenterName, serverName));
    }
}