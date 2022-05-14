package com.jmu.XPathDemo.controller;

import com.jmu.XPathDemo.domain.*;
import com.jmu.XPathDemo.domain.ResultNodeList;
import com.jmu.XPathDemo.service.MyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class MyController {

    @Resource
    public MyServiceImpl myServiceImpl;

    @RequestMapping({"/toMyTest","/"})
    public String toMyTest(Model model){
        model.addAttribute("msg","Hello! XPath in DBLP!");
        return "myTest";
    }


    @RequestMapping("/toFunctionOne")
    public String toFunctionOne(){
        return "functionOne";
    }

    @RequestMapping("/toFunctionTwo")
    public String toFunctionTwo(){
        return "functionTwo";
    }

    @RequestMapping("/toFunctionThree")
    public String toFunctionThree(){
        return "functionThree";
    }

    @RequestMapping("/toFunctionFour")
    public String toFunctionFour(){
        return "functionFour";
    }


    @RequestMapping("/toFunctionFive")
    public String toFunctionFive(){
        return "functionFive";
    }


    @ResponseBody
    @PostMapping("/function")
    public Response functionOne(@RequestParam String xpathAdd){
        Response response = new Response();
        String xpath = "//*[contains(author, '"+xpathAdd+"')]/title";
        try {
            ResultNodeList nodeList = myServiceImpl.xPathTest(xpath);
            response.setData(nodeList);
            response.setResponseBySuccessMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            response.setResponseByErrorMsg(e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @PostMapping("/functionTwo")
    public Response functionTwo(@RequestParam String xpathAdd){
        Response response = new Response();
        String xpath = "//*[contains(title, '"+xpathAdd+"')]/*";
        System.out.println(xpath);
        try {
            ResultNodeList nodeList = myServiceImpl.xPathTest(xpath);
            response.setData(nodeList);
            response.setResponseBySuccessMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            response.setResponseByErrorMsg(e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @PostMapping("/functionThree")
    public Response functionThree(@RequestParam String xpathAdd){
        Response response = new Response();
        //String xpath = "//inproceedings[author='"+xpathAdd+"']/author";
        String xpath = "//*[*='"+xpathAdd+"']/author/preceding-sibling::* | //*[*='"+xpathAdd+"']/editor | //*[*='"+xpathAdd+"']/title";

        System.out.println();

        System.out.println(xpath);
        try {
            ResultNodeList nodeList = myServiceImpl.xPathTest(xpath);
            response.setData(nodeList);
            response.setResponseBySuccessMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            response.setResponseByErrorMsg(e.getMessage());
        }
        return response;
    }


    @ResponseBody
    @PostMapping("/functionFour")
    public Response inquire(@RequestParam String xpath){
        Response response = new Response();
        log.info(xpath);
        try {
            //phdthesis[./note/@type][.//url][./year>2000]//author[contains(text(),'Michael')]
            ResultNodeList nodeList = myServiceImpl.xPathTest(xpath);
            response.setData(nodeList);
            response.setResponseBySuccessMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            response.setResponseByErrorMsg(e.getMessage());
        }
        return response;
    }


    @ResponseBody
    @PostMapping("/functionFive")
    public Response functionFive(@RequestParam String xpathAdd){
        Response response = new Response();
//        String xpath = "//*[contains(title, '"+xpathAdd+"')]/*";

//        String xpath = "//*[*='" + xpathAdd + "']/title";
        String xpath = "//*[contains(title, '"+xpathAdd+"')]/editor | //*[contains(title, '"+xpathAdd+"')]/title | //*[contains(title, '"+xpathAdd+"')]/year | //*[contains(title, '"+xpathAdd+"')]/school | //*[contains(title, '"+xpathAdd+"')]";
//         | //input[contains(title, '"+xpathAdd+"')]
        System.out.println(xpath);
        try {
            ResultNodeList nodeList = myServiceImpl.xPathTest(xpath);
            response.setData(nodeList);
            response.setResponseBySuccessMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            response.setResponseByErrorMsg(e.getMessage());
        }
        return response;
    }



    @ResponseBody
    @PostMapping("/inquireLiterature")
    public Response inquireLiterature(@RequestParam String xpath){
        Response response = new Response();

        return response;
    }

}


