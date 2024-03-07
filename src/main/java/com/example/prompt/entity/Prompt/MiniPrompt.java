package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @date 2023/12/22
 * 提示词（大段提示词中的填空部分）
 */
@Entity
@Data
@Table(name = "prompt")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MiniPrompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mini_Id")
    private Integer miniId;

    @Column(name = "content")
    private String content; //提示词内容

    @Column(name = "type")
    private String type; //提示词维度类型,根据维度类型进行推荐

//    @Column(name = "count")
//    private Integer count;//该提示词的使用次数

}
