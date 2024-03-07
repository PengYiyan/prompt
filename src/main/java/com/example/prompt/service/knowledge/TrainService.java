package com.example.prompt.service.knowledge;

import com.example.prompt.vo.ResponseVO;

/**
 * @date 2023/12/15
 * 用于知识库生成
 * 单句上传or文件上传
 */
public interface TrainService {

    /**
     * 单句训练模式
     * @param sentence
     * @return
     */
    ResponseVO trainBySentence(String sentence);

    /**
     * 上传文件训练模式
     * @param path 文件路径
     * @return
     */
    ResponseVO trainByFile(String path);

}
