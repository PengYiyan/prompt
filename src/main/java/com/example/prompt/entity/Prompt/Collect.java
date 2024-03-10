package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 记录用户收藏的提示词
 */
@Entity
@Data
@Table(name = "collect")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Collect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collect_id")
    private Integer collectId;

    @Column(name = "user_id")
    private Integer userId;//属于哪个用户的收藏记录

    @Column(name = "prompt_id")
    private Integer promptId;//收藏的提示词id
}
