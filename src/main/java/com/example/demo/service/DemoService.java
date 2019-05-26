package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

@Component
public class DemoService {

    public String demo() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = "Test";
        String fileName;
        Integer num = 0;
        // TestX 找到最大的X
        while (true) {
            fileName = name + (++num);
            File file=new File(fileName);
            if(!file.exists()){
                fileName=name+(--num);
                break;
            }
        }
        // try-with-resource写法，不用close
        try (FileInputStream fin = new FileInputStream(fileName)){
            FileChannel fc = fin.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
            while(fc.read(buffer) != -1){
                buffer.flip();
                // 支持中文
                stringBuilder.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
