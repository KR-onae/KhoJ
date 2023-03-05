package com.kronae.khojpaper1_19_2.yaml.error;

public class YamlException extends Exception {
    public YamlException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
