package visnode.ws.entity;

import java.io.IOException;
import java.util.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import visnode.ws.db.Image;
import visnode.ws.db.ImageRepository;

/**
 * Image Controller
 */
@Controller
@RequestMapping("/v1")
public class EntityImageController {

    /** Image repository */
    private final ImageRepository imageRepository;

    @Autowired
    public EntityImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /**
     * Returns the image
     *
     * @param id
     * @return ResponseBody
     */
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getImageAsByteArray(@PathVariable("id") long id) {
        Image image = imageRepository.getOne(id);
        return Base64.getDecoder().decode(image.getData());
    }
}
