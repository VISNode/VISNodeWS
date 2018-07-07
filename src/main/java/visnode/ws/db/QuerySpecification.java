package visnode.ws.db;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 * Query parser
 *
 * @param <T>
 */
public class QuerySpecification<T> implements Specification<T> {

    /** Query string */
    private final String query;

    /**
     * Query parser
     *
     * @param query
     */
    public QuerySpecification(String query) {
        this.query = query;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        return cb.and(
                (Predicate[]) Stream.of(query.split(" and ")).
                        map((instruction) -> {
                            String[] values = instruction.split(" eq ");
                            String key = values[0];
                            String value = values[1];
                            try {
                                if (!key.contains(".")) {
                                    return cb.equal(root.get(key), value);
                                }
                                String[] keys = key.split("\\.");
                                Object obj = Class.
                                        forName("visnode.ws.db." + capitalize(keys[0])
                                        ).newInstance();
                                obj.getClass().
                                        getDeclaredMethod("set" + capitalize(keys[1]), Long.class).
                                        invoke(obj, Long.parseLong(value));
                                return cb.equal(root.get("user"), obj);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return cb.equal(root.get(key), value);
                        }).
                        collect(Collectors.toList()).
                        toArray(new Predicate[]{})
        );
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}
