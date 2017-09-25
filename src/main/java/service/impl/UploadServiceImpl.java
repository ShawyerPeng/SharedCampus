package service.impl;

import mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Image;
import service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private ImageMapper imageMapper;

    public void insertFile(String filename, String url) {
        Image image = new Image(filename, url);
        imageMapper.insert(image);
    }

    public void insertFileWithDescription(String filename, String url, String description) {
        Image image = new Image(filename, url, description);
        imageMapper.insert(image);
    }
}
