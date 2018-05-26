package visnode.ws.db;

import java.util.function.Function;
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
                            return cb.equal(root.get(values[0]), values[1]);
                        }).
                        collect(Collectors.toList()).
                        toArray(new Predicate[]{})
        );
    }
}
