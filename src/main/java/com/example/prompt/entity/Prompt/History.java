package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户提示词的历史记录
 */
@Entity
@Data
@Table(name = "history")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @Column(name = "user_id")
    private Integer userId;//属于哪个用户的历史记录

    @Column(name = "prompt_id")
    private Integer promptId;//该历史记录对应的提示词内容

}
