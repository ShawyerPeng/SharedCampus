package service;

public interface UploadService {
    void insertFile(String filename, String url);
    void insertFileWithDescription(String filename, String url, String description);
}
