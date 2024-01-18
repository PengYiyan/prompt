package com.example.prompt.entity.LLMs;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @date 2023/12/22
 * 大模型的实体类
 */
@Entity
@Data
@Table(name = "Model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelId;

    @Column(name = "address")
    private String address; //大模型的部署地址

}
