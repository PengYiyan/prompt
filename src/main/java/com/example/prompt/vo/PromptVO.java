package com.example.prompt.vo;

import com.example.prompt.entity.Prompt.Field;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * promptVO类
 */
@Data
@Accessors(chain = true)
public class PromptVO {

    private Integer promptId;

    private String field;//包含的领域（领域的tag）

    private String content;

    private String title;

    private Integer userId;

    private Integer collectCount=0;//收藏数目，收藏数多的排序靠前

    private Boolean hasUpload;//询问用户是否同时上传
}
