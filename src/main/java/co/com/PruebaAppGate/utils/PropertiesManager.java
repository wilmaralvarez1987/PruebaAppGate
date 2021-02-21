package co.com.PruebaAppGate.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import co.com.PruebaAppGate.exceptions.ConexionExcepcions;


public class PropertiesManager {

    private PropertiesManager() {
        throw new IllegalStateException("Clase de lectura de propiedades");
    }
    public static Properties getDbProperties(String path) {
        Properties bdProperties = new Properties();
        try {
            FileInputStream file = new FileInputStream(path);
            Throwable var3 = null;
            try {
                bdProperties.load(file);
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (file != null) {
                    if (var3 != null) {
                        try {
                            file.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        file.close();
                    }
                }
            }
            return bdProperties;
        } catch (IOException var15) {
            throw new ConexionExcepcions(var15.getMessage(), var15);
        }
    }
}
