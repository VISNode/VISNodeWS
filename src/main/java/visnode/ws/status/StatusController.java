package visnode.ws.status;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Status controller
 */
@RestController
public class StatusController {

    @RequestMapping("/status")
    public Map index() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        return map;
    }

}
