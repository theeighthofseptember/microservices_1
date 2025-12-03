package com.data_center.servers.repository;

import com.data_center.servers.model.Servers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServersRepository extends CrudRepository<Servers, Integer> {
    // Поиск всех записей по имени ЦОД
    public List<Servers> findByDatacenterName(String datacenterName);

    // Поиск конкретной записи по имени ЦОД и Сервера
    public Servers findByDatacenterNameAndServerName(String datacenterName, String serverName);
}