package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 完整的Paragraph提示词，内部含有可以填空的miniPrompt
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

    @OneToMany
    @Column(name = "tags")
    private List<Field> tags;//包含的领域（领域的tag）

    @Column(name = "content")
    private String content;

    @Column(name = "collect_count")
    private Integer collectCount;//收藏数目，收藏数多的排序靠前

}
