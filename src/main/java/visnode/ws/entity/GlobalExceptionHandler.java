package visnode.ws.entity;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import visnode.ws.db.DatabaseException;

/**
 * Exception handler
 */
@ControllerAdvice()
public class GlobalExceptionHandler {
    
    /**
     * Database rollback handler
     * 
     * @param e
     * @return {@code ResponseEntity<Map>}
     */
    @ExceptionHandler({RollbackException.class})
    public ResponseEntity<Map> rollbackExceptionHandler(RollbackException e) {
        ConstraintViolationException ex = (ConstraintViolationException) e.getCause();
        StringBuilder sb = new StringBuilder();
        ex.getConstraintViolations().forEach((it) -> {
            sb.append(it.getPropertyPath()).
                    append(" ").
                    append(it.getMessage()).
                    append("\n");
        });
        Map<String, String> response = new HashMap<>();
        response.put("message", sb.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Database handler
     * 
     * @param e
     * @return {@code ResponseEntity<Map>}
     */
    @ExceptionHandler({DatabaseException.class})
    public ResponseEntity<Map> databaseExceptionHandler(DatabaseException e) {
        Map<String, String> response = new HashMap<>();
        response.put("message", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
  
}
