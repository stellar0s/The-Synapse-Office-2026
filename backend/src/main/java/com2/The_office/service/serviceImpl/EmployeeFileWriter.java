package com2.The_office.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFileWriter {

    private static final String BACKUP_FILE = "employee_backup.txt";

    // Thread-safe employee data write
    public static synchronized void writeEmployeeData(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BACKUP_FILE, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("❌ File I/O Error: " + e.getMessage());
        }
    }

    // Thread-safe error log write
    public static synchronized void writeErrorLog(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("error_log.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("❌ Error Log Failed → " + e.getMessage());
        }
    }
}
