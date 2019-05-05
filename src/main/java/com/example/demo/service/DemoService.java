package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Component
public class DemoService {

    public String demo() {
        StringBuffer stringBuffer = new StringBuffer();
        String name = "Test";
        String fileName = "";
        Integer num = 1;
        while (num < 100) {
            try (FileInputStream fin = new FileInputStream(fileName)) {
                FileChannel fc = fin.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
                fc.read(buffer);
                buffer.flip();

                while (buffer.remaining() > 0) {
                    byte b = buffer.get();
                    stringBuffer.append((char) b);
                }
                break;
            } catch (IOException e) {
                fileName = name + num++;
            }
        }
        return stringBuffer.toString();
    }
}
