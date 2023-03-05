package com.kronae.khojpaper1_19_2.yaml.error;

public class YamlNotFileException extends YamlException {
    public YamlNotFileException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
