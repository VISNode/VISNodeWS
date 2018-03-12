package visnode.ws.db;

import com.google.gson.Gson;
import java.util.List;
import java.util.Optional;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Service responsible for the entity manipulation
 *
 * @param <O> Entity
 */
public abstract class AbsDBService<O> implements DBService<O> {

    /** Data repository */
    private final JpaRepository<O, Long> repository;
    /** The entity class */
    private final Class classEntity;
    /** Json parser */
    private final Gson gson;

    public AbsDBService(JpaRepository<O, Long> repository) {
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
     * Find by id
     *
     * @param id
     * @return {@code Optional<O>}
     */
    @Override
    public Optional<O> findById(long id) {
        return repository.findById(id);
    }

    /**
     * Save
     *
     * @param json Data String
     * @return O
     */
    @Override
    public O save(String json) {
        return repository.save((O) gson.fromJson(json, classEntity));
    }

}
