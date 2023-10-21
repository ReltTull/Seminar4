package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FIleLoader {
    private String url;
    /**
     * путь в директорию, куда надо сохранить
     */
    private String pathToSave;
    /**
     * имя файла, включая формат
     */
    private String name;
    /**
     * коллекция стримов для управления отдельными
     */
    private List<InputStream> streams = new ArrayList<>();

    public FIleLoader(String url, String path, String name) {
        this.url = url;
        this.pathToSave = path;
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public String getPathToSave() {
        return pathToSave;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setPathToSave(String pathToSave) {
        this.pathToSave = pathToSave;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     * метод скачивания одного файла
     * @throws MalformedURLException
     */
    public void downloadFile() throws MalformedURLException {
        try {
            URL link = new URL(getUrl());
            InputStream inputStream = link.openStream();
            Files.copy(inputStream, new File(getPathToSave()).toPath());
            System.out.println("File has been saved in " + getPathToSave());
        } catch (MalformedURLException exception) {
            exception.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * метод скачивания файла в несколько потоков InputStream, которые сохраняются в List<InputStream> streams.
     * @param streamCount
     * @throws MalformedURLException
     */
    public void downloadFile(int streamCount) throws MalformedURLException {
        try {
            URL link = new URL(getUrl());
            for (int i = 0; i < streamCount; i++) {
                setName(i + ".png");
                InputStream inputStream = link.openStream();
                streams.add(inputStream);
                Files.copy(inputStream, new File(getPathToSave() + getName()).toPath());
                System.out.println("File has been saved in " + getPathToSave());
            }
        } catch (MalformedURLException exception) {
            exception.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * метод остановки InputStream по индексу в List<InputStream> streams.
     * @param index
     * @throws IOException
     */
    public void stopStream(int index) throws IOException {
        try {
            streams.get(index).close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
