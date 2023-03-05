package com.kronae.khojpaper1_19_2.yaml.error;

public class YamlNoFileFoundException extends YamlException {
    public YamlNoFileFoundException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
