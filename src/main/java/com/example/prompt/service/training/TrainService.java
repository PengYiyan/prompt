package com.example.prompt.service.training;

import com.example.prompt.vo.ResponseVO;

/**
 * @date 2023/12/15
 * 用于进行模型训练
 * 单句上传Or选择提示词训练
 */
public interface TrainService {

    /**
     * 单句训练模式
     * @param sentence
     * @return
     */
    ResponseVO trainBySentence(String sentence);

    /**
     * 上传文件训练模式（暂定上传json文件）
     * @param jsonString
     * @return
     */
    ResponseVO trainByFile(String jsonString);

}
