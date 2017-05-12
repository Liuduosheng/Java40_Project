package com.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.model.User;
import com.demo.service.IDictService;
import com.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
     
    @Resource
    private IUserService userService;
    @Autowired
    private IDictService dictService;
     
    /*
     * 用户列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=5;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",userService.queryUserCount());
        model.addAttribute("userList", userService.queryUserPager(pageNO, size));
        return "user/list";
    }
    
    
    /**
     * 用于完成添加页面展示
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model){
        // 与form绑定的模型
        model.addAttribute("user",new User());
        // 用于生成“性别”下拉列表
        model.addAttribute("sexList",dictService.getDictByField("SEX"));
        // 用于生成“学历”下拉列表
        model.addAttribute("eduList",dictService.getDictByField("EDU"));
        
        return "user/add";
    }

     /**
      * 用于完成添加用户保存处理
      * 
      * @Valid注解用于激活校验，否则页面将不会有错误展示。
      * @param model
      * @param entity
      * @param bindingResult
      * @return
      */
     @RequestMapping("/addSave")
     public String addSave(Model model,@ModelAttribute("user") @Valid User user,BindingResult bindingResult){
        //如果模型中存在错误
        if(!bindingResult.hasErrors()){
            if(userService.insertUser(user)>0){
                return "redirect:/user/list";
            }
        }
        model.addAttribute("user", user);
        // 用于生成“性别”下拉列表
        model.addAttribute("sexList",dictService.getDictByField("SEX"));
        // 用于生成“学历”下拉列表
        model.addAttribute("eduList",dictService.getDictByField("EDU"));
        return "user/add";
     }
     
     
     /**
      * 用于展示编辑用户页面
      * @param model
      * @param user_id
      * @return
      */
     @RequestMapping("/edit/{user_id}")
     public String edit(Model model,@PathVariable int user_id){
     
        model.addAttribute("user", userService.queryUserById(user_id));
        // 用于生成“性别”下拉列表
        model.addAttribute("sexList",dictService.getDictByField("SEX"));
        // 用于生成“学历”下拉列表
        model.addAttribute("eduList",dictService.getDictByField("EDU"));
        return "user/edit";
    }

    /**
     * 用于执行编辑后保存
     * @param model
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("user") @Valid User user,BindingResult bindingResult){
        //如果模型中存在错误
        if(!bindingResult.hasErrors()){
            if(userService.updateUser(user)>0)
            {
                return "redirect:list";    
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("sexList",dictService.getDictByField("SEX"));
        model.addAttribute("eduList",dictService.getDictByField("EDU"));
        return "/user/edit";
    }
    
    
    /**
     * 根据用户id删除用户
     * @param model
     * @param user_id
     * @param pageNO
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/deleteUserById/{user_id}")
    public String deleteUserById(Model model,@PathVariable int user_id,@RequestParam(required=false,defaultValue="1") int pageNO,
            RedirectAttributes redirectAttributes){

        if(userService.deleteUserById(user_id)>0){
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/user/list?pageNO="+pageNO;
    }

    /**
     * 删除多个用户
     * @param model
     * @param userIds
     * @param pageNO
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/deleteUsers")
    public String deleteUsers(Model model,@RequestParam int[] user_id,@RequestParam(required=false,defaultValue="1") int pageNO,
            RedirectAttributes redirectAttributes){

        if(userService.deleteUsers(user_id)>0){
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/user/list?pageNO="+pageNO;
    }
}