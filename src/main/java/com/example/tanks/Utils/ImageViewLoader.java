package com.example.tanks.Utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageViewLoader {
    private static Map<String, File> allLoadedFiles = new HashMap<>();

    public static ImageView loadImageViewByURL(String url, double width, double height) {
        File file = allLoadedFiles.get(url);
        if (file == null) {
            URL resource = ImageViewLoader.class.getClassLoader().getResource(url);
            if (resource == null) {
                System.err.println("Cant load resource " + url);
                return null;
            }

            String path = resource.getPath();
            file = new File(path);

            if (!file.exists() || !file.isFile()) {
                System.err.println("Cant load resource " + url + ". Full path: " + path);
                return null;
            }

            allLoadedFiles.put(url, file);
        }

        try {
            String localUrl = file.toURI().toURL().toString();

            Image image = new Image(
                    localUrl, width, height, true, true
            );

            return new ImageView(image);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ImageView loadImageView(File file, double width, double height) {

        try {
            String localUrl = file.toURI().toURL().toString();

            Image image = new Image(
                    localUrl, width, height, true, true
            );

            return new ImageView(image);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
