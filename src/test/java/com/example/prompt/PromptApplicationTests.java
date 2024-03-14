package com.example.prompt;

import com.example.prompt.Util.ConvertUtil;
import com.example.prompt.dao.CollectRepository;
import com.example.prompt.dao.PromptRepository;
import com.example.prompt.dao.UserRepository;
import com.example.prompt.entity.Prompt.Collect;
import com.example.prompt.entity.Prompt.Comment;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.entity.Prompt.Tag;
import com.example.prompt.entity.Role.User;
import com.example.prompt.enums.UserRole;
import com.example.prompt.service.LLMs.ModelService;
import com.example.prompt.service.prompt.ManagerService;
import com.example.prompt.service.prompt.PromptService;
import com.example.prompt.service.prompt.TagService;
import com.example.prompt.vo.PromptVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class PromptApplicationTests {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelService modelService;
    @Autowired
    private PromptService promptService;
    @Autowired
    private PromptRepository promptRepository;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CollectRepository collectRepository;
    @Autowired
    private TagService tagService;

    @Test
    void contextLoads() {
    }

    @Test
    public void selectAllUsers() {
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    @Test
    public void insertUser() {
        User user = new User()
                .setUserName("furina")
                .setPassword("123456")
                .setEmail("123@qq.com")
                .setRole(UserRole.STUDENT);
        userRepository.save(user);
    }

    @Test
    public void selectByRole() {
        List<User> userList = userRepository.findUserByRole(UserRole.ADMIN);
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    @Test
    public void getCurlMessage() {
        Prompt prompt = new Prompt().setContent("请给我一些求职建议");
        System.out.println(modelService.getAnswer(prompt));
    }

    @Test
    public void testSavePrompt() throws Exception {//测试保存prompt能否返回id
//        promptService.insertPrompt("请给我一些求职建议");
        PromptVO promptVO = new PromptVO();
        promptVO.setField("体育")
                .setContent("这是一条testVO")
                .setUserId(2)
                .setHasUpload(false);
        System.out.println(promptVO);
        Prompt prompt = managerService.uploadPrompt(3,promptVO);
        System.out.println(prompt);
    }

    @Test
    public void testConvertUtil1() throws Exception {//测试PO和VO转换能不能用
        PromptVO promptVO = new PromptVO();
        promptVO.setField("体育")
                .setContent("这是一条testVO")
                .setUserId(2)
                .setHasUpload(false);
        //从VO转换成PO
        Prompt prompt = ConvertUtil.convertOne(promptVO,new Prompt());
        System.out.println(prompt);
        promptRepository.save(prompt);
    }

    @Test
    public void testConvertUtil2() throws Exception {
        Prompt prompt = promptRepository.findById(5).get();
        prompt.setHasUpload(true);
        //从PO转换成VO
        PromptVO promptVO = ConvertUtil.convertOne(prompt,new PromptVO());
        System.out.println(promptVO);
    }

    @Test
    public void testFindCollect() {//测试多个条件的查询接口
//        List<Collect> collectList = collectRepository.findCollectByUserIdAndPromptId(3,1);
//        System.out.println(collectList.size());
        managerService.collectPrompt(3,1);
    }

    @Test
    public void testComment() {
        Comment comment = new Comment();
        System.out.println(comment);
    }

    @Test
    public void testStringChinese() {
        String str = "请看看这条字符串的长度";
        StringBuilder sb = new StringBuilder();
        System.out.println(str.length());
        for (int i=0;i<5;i++){
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testTagService() {
        String str = "请你描述参加{专业}的面试需要准备的{服装}";
        Prompt prompt = new Prompt();
        prompt.setContent(str);
        promptRepository.save(prompt);
        List<Tag> tagList = tagService.getTagsFromPrompt(4);
        for (Tag tag : tagList) {
            System.out.println(tag);
        }
    }

}
