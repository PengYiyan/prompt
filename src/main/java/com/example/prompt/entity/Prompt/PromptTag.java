package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @date 2023/12/23
 * 提示词维度类型（大段提示词中的填空部分）
 * 例如 TIME,//年龄,时间维度
 *     ROLE,//角色,身份维度
 *     MAJOR,//专业,职业维度
 *     RULE,//规范维度
 *
 *     举例是，promptTag的type是 专业课程
 *     llm会根据name的内容，生成若干promptTag
 *     他们的content分别是，计算机，软件工程，工商管理等等
 */


@Entity
@Data
@Table(name = "promptTag")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PromptTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_type")
    private String tagType;//tag的名字/纬度

    @Column(name = "content")
    private String content;//tag的内容，具体的内容
}
