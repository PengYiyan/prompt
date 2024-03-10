package com.example.prompt.service.deployment;

import com.example.prompt.vo.ResponseVO;

/**
 * @date 2023/12/16
 * 平台功能，用于提供类似Paas的在线部署服务
 * 分为大模型部署和应用部署
 * 服务器资源不一定够，先不谈
 */
public interface DeployService {

    /**
     * 在线部署大模型
     * @param modelId
     * @return
     */
    ResponseVO deployLLM(int modelId);

//    /**
//     * 在线部署项目应用
//     * @param projectId
//     * @return
//     */
//    ResponseVO deployApplication(int projectId);

}
