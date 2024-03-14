package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.Collect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectRepository extends JpaRepository<Collect,Integer> {

    List<Collect> findCollectByUserId(Integer userId);//返回某用户的全部收藏

    //根据用户id和promptId来查找一个Collect
    //如果两个id都相同，说明这是同一条collect，不会重复保存
    List<Collect> findCollectByUserIdAndPromptId(Integer userId,Integer promptId);


}
