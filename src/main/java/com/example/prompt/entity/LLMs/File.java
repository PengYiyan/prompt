package com.example.prompt.entity.LLMs;

import com.example.prompt.enums.FileType;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @date 2023/12/21
 * 上传的文件，用于构建知识库
 */
@Entity
@Data
@Table(name = "table")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer fileId;

    @Column(name = "content")
    private String content; //文件内容

    @Column(name = "type")
    private FileType fileType;//文件类型

}
