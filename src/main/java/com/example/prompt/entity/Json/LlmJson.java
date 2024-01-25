package com.example.prompt.entity.Json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 调用大语言模型要使用的json数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LlmJson {

    private String model;

    private Message message;

    private Double temperature;

    public void setMessage(String role,String content) {
        Message message = new Message();
        message.setRole(role);
        message.setContent(content);
        this.message = message;
    }

//            String jsonStr = "\"{\\\"model\\\": \\\"baichuan2-13b-chat\\\", \\\"messages\\\": [{\\\"role\\\": \\\"user\\\", \\\"content\\\": \\\"Say this is a test\\\"}], \\\"temperature\\\": 0.95}\"";

    @Override
    public String toString(){
        return "\"{\\\"model\\\": \\\"" + model + "\\\", " + this.message.toString() +
                ", \\\"temperature\\\":" + temperature + "}\"";
    }

}

@Data
class Message {

    private String role;

    private String content;

    @Override
    public String toString(){
        return "\\\"messages\\\": [{\\\"role\\\": \\\"" + role +"\\\", " +
                "\\\"content\\\": \\\"" + content + "\\\"}]";

    }
}