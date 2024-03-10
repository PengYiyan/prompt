package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 2024/1/4
 * 提示词的领域（学术类别等等）
 * 用于最上层的分类
 * 先预设几个最简单的完成demo闭环
 */

@Entity
@Data
@Table(name = "field")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "field_name")
    private String fieldName;//领域的名字

//    @OneToMany
//    @Column(name = "have_prompt")
//    private List<Prompt> havePrompt;//该领域下有哪些提示词

    @Override
    public boolean equals(Object o){
        if (o instanceof Field) {
            Field field = (Field) o;
            return this.fieldName.equals(field.fieldName);
        }
        return super.equals(o);
    }

}
