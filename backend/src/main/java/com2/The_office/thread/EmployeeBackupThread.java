package com2.The_office.thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class EmployeeBackupThread extends Thread {

    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                // Background log every 10 seconds
                BufferedWriter writer = new BufferedWriter(new FileWriter("thread_log.txt", true));
                writer.write("Thread alive at: " + LocalDateTime.now());
                writer.newLine();
                writer.close();

                Thread.sleep(10000); // 10 seconds

            } catch (Exception e) {
                System.err.println("Thread Error: " + e.getMessage());
            }
        }
    }

    public void stopThread() {
        running = false;
    }
}
