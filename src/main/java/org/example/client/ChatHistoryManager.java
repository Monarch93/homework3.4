package org.example.client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChatHistoryManager {
    private static final String filename = "src/hw3/resources/chat_history.txt";
    private FileWriter fileWriter;
    private int msgCount = 0;

    public void startChatLogging() {
        try {
            fileWriter = new FileWriter(filename, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(String msg) {
        if (msgCount <= 100) {
            try {
                fileWriter.write(msg);
                fileWriter.flush();
                msgCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void restoreChat(JTextArea mainChat) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String str;
            while ((str = reader.readLine()) != null) {
                mainChat.append(str);
                mainChat.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
