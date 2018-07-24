package visnode.ws.db;

import org.springframework.stereotype.Service;

/**
 * Image service
 */
@Service
public class ImageService extends AbsDBService<Image> {

    public ImageService(ImageRepository repository) {
        super(repository);
    }

}
