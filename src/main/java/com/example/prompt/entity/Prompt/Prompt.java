package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/*    @OneToMany
    @Column(name = "fields")
    private List<Field> fields = new ArrayList<>();//包含的领域（领域的tag）*/
    @Column(name = "field")
    private String field;//该提示词属于什么领域

    @Column(name = "collect_count")
    private Integer collectCount = 0;//收藏数目，收藏数多的排序靠前

    @Column(name = "user_id")
    private Integer userId;//上传者的id，内置提示词默认是管理员上传(管理员id为0)

    @Column(name = "title")
    private String title;//提示词的标题topic

    @Column(name = "content")
    private String content;//提示词主体内容

    @Column(name = "has_upload")
    private Boolean hasUpload = false;//记录提示词是否被上传
    //(上传的提示词才能被大家都看到，否则只在历史记录中)

    @Column(name = "upload_time")
    private String uploadTime;//上传该条提示词的时间

    private static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        return sdf.format(date);
    }
}
