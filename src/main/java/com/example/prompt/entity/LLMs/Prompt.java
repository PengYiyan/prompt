package com.example.prompt.entity.LLMs;

import com.example.prompt.enums.PromptType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @date 2023/12/22
 * 提示词（单词or单句）
 */
@Entity
@Data
@Table(name = "prompt")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Prompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prompt_id")
    private Integer promptId;

    @Column(name = "content")
    private String content; //提示词内容

    @Column(name = "type")
    private PromptType type; //提示词维度类型,根据维度类型进行推荐

}
