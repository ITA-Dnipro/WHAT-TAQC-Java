package secretarys;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SecretarysName {

    private String secretarysName;

    public String getName() {
        return secretarysName;
    }

    public void setName(String name) {
        this.secretarysName = name;
    }

    public static SecretarysName[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), SecretarysName[].class);
}

   }
