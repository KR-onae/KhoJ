package com.kronae.khojpaper1_19_2.yaml.error;

public class YamlNoValueAtPathException extends YamlException {
    public YamlNoValueAtPathException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
