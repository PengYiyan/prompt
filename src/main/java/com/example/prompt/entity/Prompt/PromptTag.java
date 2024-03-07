package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 提示词维度类型（大段提示词中的填空部分）
 * 例如 TIME,//年龄,时间维度
 *     ROLE,//角色,身份维度
 *     MAJOR,//专业,职业维度
 *     RULE,//规范维度
 */


@Entity
@Data
public class PromptTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    private String tagName;//tag的名字/纬度
}
