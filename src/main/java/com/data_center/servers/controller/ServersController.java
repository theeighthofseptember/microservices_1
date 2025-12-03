package com.data_center.servers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.data_center.servers.model.Servers;
import com.data_center.servers.service.ServersService;

import java.util.Locale;

@RestController
@RequestMapping(value="datacenters/{datacenterName}/servers")
public class ServersController {

    @Autowired
    private ServersService serversService;

    // GET - получить информацию о сервере
    @GetMapping(value="/{serverName}/{maxPowerW}")
    public ResponseEntity<Servers> getServer(
            @PathVariable("datacenterName") String datacenterName,
            @PathVariable("serverName") String serverName,
            @PathVariable("maxPowerW") int maxPowerW,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {

        Servers server = serversService.getServer(datacenterName, serverName);

        server.add(
                linkTo(methodOn(ServersController.class)
                        .getServer(datacenterName, serverName, maxPowerW, locale))
                        .withSelfRel(),
                linkTo(methodOn(ServersController.class)
                        .createServer(datacenterName, server, locale))
                        .withRel(serversService.getLinkName("create", locale)),
                linkTo(methodOn(ServersController.class)
                        .updateServer(datacenterName, server, locale))
                        .withRel(serversService.getLinkName("update", locale)),
                linkTo(methodOn(ServersController.class)
                        .deleteServer(datacenterName, serverName, maxPowerW, locale))
                        .withRel(serversService.getLinkName("delete", locale))
        );

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
            @RequestBody Servers request,
            @RequestHeader(value = "Accept-Language",  required = false)
            Locale locale) {
        return ResponseEntity.ok(serversService.updateServer(request, datacenterName, locale));
    }

    // DELETE - удалить сервер
    @DeleteMapping(value="/{serverName}/{maxPowerW}")
    public ResponseEntity<String> deleteServer(
            @PathVariable("datacenterName") String datacenterName,
            @PathVariable("serverName") String serverName,
            @PathVariable("maxPowerW") int maxPowerW,
            @RequestHeader(value = "Accept-Language",  required = false)
            Locale locale) {
        return ResponseEntity.ok(serversService.deleteServer(datacenterName, serverName, maxPowerW, locale));
    }

}