package com.utility;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class yamlReader {
    /** The YAML file name. */
    private String yamlFileName;

    /** The YAML object. */
    private Map<String, Object> yamlData;

    /**
     * @param yamlFile
     *            the YAML file
     */
    public yamlReader(final String yamlFile) {
        this.yamlFileName = yamlFile;
        loadYaml();
    }
    /**
     * @param role
     * @return
     */
    public String getEmailForRole(String role) {
        Map<String, Object> roleData = getRoleData(role);
        if (roleData != null) {
            return (String) roleData.get("email");
        }
        return null;
    }
    /**
     * @param role
     * @return
     */
    public String getPasswordForRole(String role) {
        Map<String, Object> roleData = getRoleData(role);
        if (roleData != null) {
            return (String) roleData.get("password");
        }
        return null;
    }
    public String getFirstBackupCode(String role) {
        List<Map<String, Object>> roles = (List<Map<String, Object>>) yamlData.get("Roles");
        for (Map<String, Object> r : roles) {
            String rRole = (String) r.get("role");
            if (role.equals(rRole)) {
                List<String> backupCodes = (List<String>) r.get("backupCodes");
                if (!backupCodes.isEmpty()) {
                    String firstBackupCode = backupCodes.get(0);
                    backupCodes.remove(0);
                    updateYamlFile();
                    return firstBackupCode;
                }
            }
        }
        return null;
    }
    private void updateYamlFile() {
        Yaml yaml = new Yaml();
        String osName = System.getProperty("os.name").toLowerCase();
        String filePath;
        if (osName.contains("mac") || osName.contains("linux")) {
            filePath = ".//properties//backupCode.yaml"; // Replace with the appropriate Linux/Mac file path
        } else {
            filePath = ".\\properties\\backupCode.yaml"; // Replace with the appropriate Windows file path
        }
        try (FileWriter writer = new FileWriter(filePath)) {
            yaml.dump(yamlData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param role
     * @return
     */
    public Map<String, Object> getRoleData(String role) {
        List<Map<String, Object>> roles = (List<Map<String, Object>>) yamlData.get("Roles");
        for (Map<String, Object> r : roles) {
            String rRole = (String) r.get("role");
            if (role.equals(rRole)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Load the YAML data
     */
    private void loadYaml() {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
