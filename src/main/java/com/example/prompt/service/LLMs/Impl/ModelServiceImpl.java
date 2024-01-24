package com.example.prompt.service.LLMs.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.prompt.entity.LLMs.Prompt;
import com.example.prompt.service.LLMs.ModelService;
import com.example.prompt.vo.ResponseVO;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ModelServiceImpl implements ModelService {


    @Override
    public ResponseVO usePrompt(Prompt prompt){
        return ResponseVO.buildSuccess();
    }

    @Override
    public String getAnswer(Prompt prompt){
        String jsonStr = "\"{\\\"model\\\": \\\"baichuan2-13b-chat\\\", \\\"messages\\\": [{\\\"role\\\": \\\"user\\\", \\\"content\\\": \\\"Say this is a test\\\"}], \\\"temperature\\\": 0.95}\"";

        String[] cmds={"curl","http://10.58.0.2:6678/v1/chat/completions",
                "-H",  "\"Content-Type: application/json\"",
                "-H",  "\"Authorization: Bearer $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\"",
                "-d",  jsonStr};
        String res = execCurl(cmds);
        System.out.println(execCurl(cmds));
        return res;
    }

    private static String execCurl(String[] cmds){
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
//            System.out.println(builder);
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }
}
