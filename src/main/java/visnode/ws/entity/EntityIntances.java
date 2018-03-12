package visnode.ws.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import visnode.ws.db.DBService;

@Service
@ApplicationScope
public class EntityIntances {

    /** Entity instances */
    private final Map<String, DBService> services;

    public EntityIntances(List<DBService> services) {
        this.services = new HashMap<>();
        services.forEach((service) -> {
            this.services.put(getName(service), service);
        });
    }

    /**
     * Returns the service name
     *
     * @param service Service instance
     * @return String
     */
    private String getName(DBService service) {
        return service.getClass().getSimpleName().replace("Service", "").toLowerCase();
    }

    /**
     * Returns the entity instance
     *
     * @param entity Entity name
     * @return DBService
     */
    public DBService get(String entity) {
        return services.get(entity);
    }

}
