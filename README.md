пост с английской локализацией
<img width="966" height="467" alt="image" src="https://github.com/user-attachments/assets/30fd3d50-39aa-4779-9ed0-413f64954211" />

пост с русской локализацией
<img width="966" height="477" alt="image" src="https://github.com/user-attachments/assets/eaefdb9c-4944-4a61-96ab-fca05ee09ba9" />

пост со шведской реализацией + json
<img width="969" height="863" alt="image" src="https://github.com/user-attachments/assets/ed85d595-34e7-4c08-a50d-946c2b665ab9" />

пут рус
<img width="966" height="867" alt="image" src="https://github.com/user-attachments/assets/23349856-826f-40d6-8837-b930c39bf16d" />

пут швед
<img width="965" height="478" alt="image" src="https://github.com/user-attachments/assets/13747626-d7d9-47c1-8001-64c88b436445" />

делит швед
<img width="963" height="404" alt="image" src="https://github.com/user-attachments/assets/8686d5f1-af6c-4c14-b774-a87338b4e812" />

GET HATEOAS
<img width="959" height="935" alt="image" src="https://github.com/user-attachments/assets/9ec1a560-45fb-4fe9-bcde-8f22cd2f5de2" />

GET http://localhost:8080/actuator
```json {
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:8080/actuator/beans",
            "templated": false
        },
        "caches-cache": {
            "href": "http://localhost:8080/actuator/caches/{cache}",
            "templated": true
        },
        "caches": {
            "href": "http://localhost:8080/actuator/caches",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:8080/actuator/health/{*path}",
            "templated": true
        },
        "info": {
            "href": "http://localhost:8080/actuator/info",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:8080/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://localhost:8080/actuator/configprops",
            "templated": false
        },
        "configprops-prefix": {
            "href": "http://localhost:8080/actuator/configprops/{prefix}",
            "templated": true
        },
        "env": {
            "href": "http://localhost:8080/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://localhost:8080/actuator/env/{toMatch}",
            "templated": true
        },
        "loggers": {
            "href": "http://localhost:8080/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:8080/actuator/loggers/{name}",
            "templated": true
        },
        "threaddump": {
            "href": "http://localhost:8080/actuator/threaddump",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "metrics": {
            "href": "http://localhost:8080/actuator/metrics",
            "templated": false
        },
        "sbom": {
            "href": "http://localhost:8080/actuator/sbom",
            "templated": false
        },
        "sbom-id": {
            "href": "http://localhost:8080/actuator/sbom/{id}",
            "templated": true
        },
        "scheduledtasks": {
            "href": "http://localhost:8080/actuator/scheduledtasks",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:8080/actuator/mappings",
            "templated": false
        }
    }
}
```
<img width="956" height="612" alt="image" src="https://github.com/user-attachments/assets/206ec582-2f5a-45fe-ae90-a1df9b039adf" />

<img width="970" height="447" alt="image" src="https://github.com/user-attachments/assets/ee4f5842-69fa-427e-afbb-e68448b97a51" />

GET_acuator_metrics
```
{
    "names": [
        "application.ready.time",
        "application.started.time",
        "disk.free",
        "disk.total",
        "executor.active",
        "executor.completed",
        "executor.pool.core",
        "executor.pool.max",
        "executor.pool.size",
        "executor.queue.remaining",
        "executor.queued",
        "http.server.requests",
        "http.server.requests.active",
        "jvm.buffer.count",
        "jvm.buffer.memory.used",
        "jvm.buffer.total.capacity",
        "jvm.classes.loaded",
        "jvm.classes.unloaded",
        "jvm.compilation.time",
        "jvm.gc.concurrent.phase.time",
        "jvm.gc.live.data.size",
        "jvm.gc.max.data.size",
        "jvm.gc.memory.allocated",
        "jvm.gc.memory.promoted",
        "jvm.gc.overhead",
        "jvm.gc.pause",
        "jvm.info",
        "jvm.memory.committed",
        "jvm.memory.max",
        "jvm.memory.usage.after.gc",
        "jvm.memory.used",
        "jvm.threads.daemon",
        "jvm.threads.live",
        "jvm.threads.peak",
        "jvm.threads.started",
        "jvm.threads.states",
        "logback.events",
        "process.cpu.time",
        "process.cpu.usage",
        "process.start.time",
        "process.uptime",
        "system.cpu.count",
        "system.cpu.usage",
        "tomcat.sessions.active.current",
        "tomcat.sessions.active.max",
        "tomcat.sessions.alive.max",
        "tomcat.sessions.created",
        "tomcat.sessions.expired",
        "tomcat.sessions.rejected"
    ]
}
```

<img width="951" height="496" alt="image" src="https://github.com/user-attachments/assets/5bc2b6bb-a1e5-470a-9848-19859b3681ef" />

GET_acuator_http.server.requests
```
{
    "name": "http.server.requests",
    "baseUnit": "seconds",
    "measurements": [
        {
            "statistic": "COUNT",
            "value": 14.0
        },
        {
            "statistic": "TOTAL_TIME",
            "value": 0.42909669999999994
        },
        {
            "statistic": "MAX",
            "value": 0.0415296
        }
    ],
    "availableTags": [
        {
            "tag": "exception",
            "values": [
                "none"
            ]
        },
        {
            "tag": "method",
            "values": [
                "DELETE",
                "POST",
                "PUT",
                "GET"
            ]
        },
        {
            "tag": "error",
            "values": [
                "none"
            ]
        },
        {
            "tag": "uri",
            "values": [
                "/actuator/metrics/{requiredMetricName}",
                "/datacenters/{datacenterName}/servers/{serverName}/{MaxPowerW}",
                "/actuator",
                "/actuator/info",
                "/actuator/health",
                "/datacenters/{datacenterName}/servers/{serverName}/{powerConsumption}",
                "/datacenters/{datacenterName}/servers",
                "/actuator/metrics",
                "/**"
            ]
        },
        {
            "tag": "outcome",
            "values": [
                "CLIENT_ERROR",
                "SUCCESS"
            ]
        },
        {
            "tag": "status",
            "values": [
                "404",
                "200"
            ]
        }
    ]
}
```

<img width="950" height="365" alt="image" src="https://github.com/user-attachments/assets/71950364-436c-47b8-996e-7218916b93a7" />













