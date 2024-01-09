package com.example.prompt.entity.LLMs;

import com.example.prompt.enums.ModelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 2024/1/4
 * 大模型标签
 */
@Entity
@Data
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "model_id")
    private String modelId;//tag对应的提示词

    @Column(name = "model_type")
    private ModelType modelType;//tag对应的模型类型
    
}
