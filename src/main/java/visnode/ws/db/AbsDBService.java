package visnode.ws.db;

import com.google.gson.Gson;
import java.util.List;
import java.util.Optional;
import org.springframework.core.GenericTypeResolver;

/**
 * Service responsible for the entity manipulation
 *
 * @param <O> Entity
 */
public abstract class AbsDBService<O> implements DBService<O> {

    /** Data repository */
    private final Repository<O, Long> repository;
    /** The entity class */
    private final Class classEntity;
    /** Json parser */
    private final Gson gson;

    public AbsDBService(Repository<O, Long> repository) {
        this.repository = repository;
        this.classEntity = getClassEntity();
        this.gson = new Gson();
    }

    /**
     * Returns the entity class
     *
     * @return Class
     */
    private Class getClassEntity() {
        getClass().getGenericInterfaces();
        Object[] types = GenericTypeResolver.getTypeVariableMap(getClass()).values().toArray();
        return (Class) types[0];
    }

    /**
     * Find all
     *
     * @return {@code List<O>}
     */
    @Override
    public List<O> findAll() {
        return repository.findAll();
    }

    /**
     * Find all
     *
     * @param query
     * @return {@code List<O>}
     */
    @Override
    public List<O> findAll(String query) {
        if (query == null) {
            return findAll();
        }
        return repository.findAll(new QuerySpecification(query));
    }
    
    /**
     * Find by id
     *
     * @param id
     * @return {@code Optional<O>}
     */
    @Override
    public Optional<O> findById(long id) {
        return Optional.of(repository.findOne(id));
    }

    /**
     * Save
     *
     * @param json Data String
     * @return O
     */
    @Override
    public O save(String json) {
        return save((O) gson.fromJson(json, classEntity));
    }
    
    /**
     * Save
     *
     * @param obj Object
     * @return O
     */
    @Override
    public O save(O obj) {
        return repository.save(obj);
    }
    
    /**
     * Save
     *
     * @param json Data String
     * @return O
     */
    @Override
    public O update(String json) {
        return update((O) gson.fromJson(json, classEntity));
    }
    
    /**
     * Save
     *
     * @param obj Object
     * @return O
     */
    @Override
    public O update(O obj) {
        return repository.save(obj);
    } 

}
