package br.gov.mctic.sgbs.automacao.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropriedadeUtils {

    public static String get(String chave) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("automacao.properties");
            prop.load(input);
            return prop.getProperty(chave);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
