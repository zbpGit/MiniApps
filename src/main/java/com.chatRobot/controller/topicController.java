package com.chatRobot.controller;

import com.chatRobot.model.*;
import com.chatRobot.service.*;
import com.chatRobot.util.PayUtil;
import com.chatRobot.util.TimeUtil;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.*;

/**
 * Created by V on 2017/9/11.
 * 题目控制器
 */
@Controller
@RequestMapping("topic")
public class topicController {
    @Resource
    private topicService service;
    @Resource
    private pageService paService;
    @Resource
    private expendService exService;
    @Resource
    private selectTopicService seTopic;
    @Resource
    private userService usService;
    @Resource
    private privityService prService;
    @Resource
    private responseService reService;
    @Resource
    private incomeService inService;
    /***
     * 选题接口
     * @return
     */
    @RequestMapping(value="select",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String select(String paner){
        System.out.println(paner);
        Gson gson=new Gson();
        Integer number;
        List<topic> list2=new ArrayList<>();
        List<answer> answerlist=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("pid",0);
        map.put("type",paner);
        List<topic> list=service.select(map);
        for(int a=0;a<10;a++){
            number=fff(list.size()-1);
            list2.add(list.get(number));
            list.remove(list.get(number));
        }
        for (topic to:list2) {
            answerlist=service.selectAnswer(to.getId());
            to.setAnswerList(answerlist);
        }
        String str=gson.toJson(list2);
        return str.toString();
    }

    public int fff(int a){
        int max=a;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println("随机得到的数"+s);
        return s;
    }

 /*   @Test
    public void aaa(){
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        List list1=new ArrayList();
        for(int a=0;a<10;a++){
           Integer number=fff(list.size()-1);
            list1.add(list.get(number));
            System.out.println("要删除的数"+list.get(number));
            System.out.println("删除前"+list.toString());
            list.remove(list.get(number));
            System.out.println("删除后"+list.toString());
        }
        System.out.println(list1.toString());
    }


*/

/*    @RequestMapping(value="select1",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String select1(Integer id){
        Gson gson=new Gson();
        List<answer> answerlist=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("pid",id);
        List<topic> list=service.select(map);
        for (topic to:list) {
            answerlist=service.selectAnswer(to.getId());
            to.setAnswerList(answerlist);
        }
        String str=gson.toJson(list);
        return str.toString();
    }*/

    /***
     *  答题接口
     *  tid   项目id
     * @return  id   题目id
     * @return  topic_content  题目内容
     * @return  aid   答案id
     * @return  content  答案内容
     */
    @RequestMapping(value="answer",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectTopic(@RequestBody Map<String,Object> map1){
        String tid=(String)map1.get("tid");
        String uid=(String)map1.get("uid");
        if(tid!=null && !"".equals(tid)) {

            Gson gson = new Gson();
            List<answer> answerlist = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("pid", Integer.parseInt(tid));
            //查出项目所对应的问题
            List<topic> list = service.selectResponse(map);
            for (topic to : list) {
                //查出问题所对应的答案
                answerlist = service.selectAnswer(to.getId());
                to.setAnswerList(answerlist);
            }
            String str = gson.toJson(list);
            return str.toString();
        }else {
            return null;
        }
    }


    /***
     * 设置是否能查看答案
     * @param isCheck   设置是否可以查看答案(true/false)
     * @return  result   设置成功的返回值
     */
    @RequestMapping(value="look",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String look(String isCheck){
        Gson gson=new Gson();
        page page=new page();
        Map<String,Object> map=new HashMap<>();
        page.setView(isCheck);
        paService.update(page);
        map.put("result",isCheck);
        String str=gson.toJson(map);
        return str.toString();
    }

    /***
     * 红包生成接口
     * @return  tid   返回一个项目id
     */
    @RequestMapping(value="create",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String create(@RequestBody Map<String,Object> map1){
        String id=(String)map1.get("id");
        String page_money=(String)map1.get("page_money");
        String packet_number=(String)map1.get("packet_number");
        String total=(String)map1.get("total");
        String service=(String)map1.get("service");
        String tidlist=(String)map1.get("tid");
        List<String> topid=Arrays.asList(tidlist.split(","));
        String answerlist=(String)map1.get("answer");
        List<String> answer=Arrays.asList(answerlist.split(","));
        Gson gson=new Gson();

        //生成项目
        page pa=new page();
        pa.setUid(Integer.parseInt(id));
        pa.setPage_money(Integer.parseInt(page_money));
        pa.setPage_number(Integer.parseInt(packet_number));
        pa.setResidue(Integer.parseInt(packet_number));
        pa.setPage_time(TimeUtil.getTime());
        pa.setPage_condition("0");
        pa.setService(service);
        paService.add(pa);
        //生成支出
        expend ex=new expend();
        ex.setUid(Integer.parseInt(id));
        ex.setPid(pa.getId());
        //生成订单号
        String Str= PayUtil.create_RandomString(18);
        String time=TimeUtil.getTime();
        String out_trade_no=time+Str;
        ex.setIndent(out_trade_no);
        ex.setPage_money(total);
        ex.setExpend_conditon("0");
        exService.add(ex);
        //添加选题表题目
        List<selectTopic> li=new ArrayList<>();
        for(int a=0;a<topid.size();a++){
            selectTopic topic=new selectTopic();
            topic.setUid(Integer.parseInt(id));
            topic.setPid(pa.getId());
            topic.setAnswer(Integer.parseInt(answer.get(a)));
            topic.setTid(Integer.parseInt(topid.get(a)));
            li.add(topic);
        }
        seTopic.add(li);

        String str=gson.toJson(pa.getId());
        return str;
    }


    /***
     * 答题领红包
     * @param tid   项目id
     * @return  uhead  发红包用户头像
     * @return  uname  发红包用户名
     * @return  head   抢红包用户头像
     * @return  name   抢红包用户名
     * @return  percentum  默契度
     * @return  time   抢红包的时间
     * @return  money  抢到的金额
     */
    @RequestMapping(value="bag",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String bag(String tid){
        Gson gson=new Gson();
        Map<String,Object> map=new HashMap<>();
        user u=usService.select(Integer.parseInt(tid));
        map.put("user",u);
        List list=prService.select(Integer.parseInt(tid));
        map.put("list",list);
        String str=gson.toJson(map);
        return str;
    }



    /***
     * 提交题目
     * @param
     * @param
     * @return str  提示提交成功
     */
    /*@RequestMapping(value="submit",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String submit(String li,String id){

        Gson gson=new Gson();
        Map<String,Object> map=new HashMap<>();
        System.out.println("id是等于"+id);
        System.out.println(li);
        List<response> list=new ArrayList<>();
        JSONArray jsonArray=JSONArray.fromObject(li);
        list=(List)JSONArray.toCollection(jsonArray,response.class);
        for(response a:list){
            System.out.println(a.getResponse_answer());
            System.out.println(a.getSid());
        }
        map.put("测试成功",li);
        map.put("OK","yes");
       *//* for(response a:li){
            a.setUid(Integer.parseInt(id));
        }
        reService.add(li);*//*
        String str=gson.toJson(map);
        return str;
    }*/

    /***
     * 答完题提交题目
     * @param map
     */
    @RequestMapping(value="submit",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String aaa(@RequestBody Map<String,Object> map){

        System.out.println(map);
        String uid=(String)map.get("id");//用户id
        String sidlist=(String)map.get("sid");//
        List<String> sid=Arrays.asList(sidlist.split(","));
        System.out.println(sid.toString());

        response res=new response();
        System.out.println("111111111111");
        System.out.println(uid);
        res.setUid(Integer.parseInt(uid));
        System.out.println("11111111111122222");
        System.out.println(sid.get(0));
        res.setSid(Integer.parseInt(sid.get(0)));
        Integer count=reService.count(res);
        System.out.println("fffff");
        System.out.println(count);
        if(count==0) {
            System.out.println("竟然if判断");
            String anlist = (String) map.get("response_answer");//选择答案id
            List<String> answer = Arrays.asList(anlist.split(","));
            System.out.println(answer.toString());
            System.out.println("进入循环前");
            List<response> list = new ArrayList<>();
            for (int i = 0; i < sid.size(); i++) {
                System.out.println("进入循环");
                response re = new response();
                re.setUid(Integer.parseInt(uid));
                re.setSid(Integer.parseInt(sid.get(i)));
                re.setResponse_answer(Integer.parseInt(answer.get(i)));
                list.add(re);
                System.out.println("出循环");
            }
            System.out.println("添加reService");
            reService.add(list);

            //生成默契度
            String tid=(String)map.get("tid");
            int number=0;
            System.out.println("进入第二个循环前");
            for(String a:sid){
                System.out.println("进入第二个循环");
            Integer id=Integer.parseInt(a);
            Integer an=seTopic.answer(id);
            System.out.println(an);
            if(id==an){
                number=+1;
            }
            }
            System.out.println("生成默契度");
            System.out.println("默契度是"+number);
            Integer percent=number/10;
            String percentum=percent*100+"%";
            Map<String,Object> map2=new HashMap();
            System.out.println("tid="+tid);
            System.out.println("uid="+uid);
            System.out.println("percentum"+percentum);
            System.out.println("correct"+number);
            map2.put("pid",Integer.parseInt(tid));
            map2.put("uid",Integer.parseInt(uid));
            map2.put("percentum",percentum);
            map2.put("correct",number);
            prService.add(map2);
            //添加收入
            if(number>=8) {
                Integer money = paService.selectMoney(Integer.parseInt(tid));
                Map<String, Object> incomMap = new HashMap();
                incomMap.put("uid", Integer.parseInt(uid));
                incomMap.put("income_money", money);
                incomMap.put("pid", Integer.parseInt(tid));
                String time = TimeUtil.getTime();
                incomMap.put("time", time);
                inService.add(incomMap);
                Integer num=paService.number(Integer.parseInt(tid));
                num=num-1;
                page pa=new page();
                pa.setId(Integer.parseInt(tid));
                pa.setPage_number(num);
                paService.update(pa);
            }
            Gson gson = new Gson();
            String ok = gson.toJson("1");
            return ok;
        }else {
            return "重复提交了";
        }
    }

    /***
     * 答完结果
     * id   答题用户id
     * tid  项目id
     * @return  str  json字符串包含(correct 答对题数，percentum 默契度，income_money 抢红包抢到的钱)
     */
    @RequestMapping(value="result",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String result(@RequestBody Map<String,Object> map1){
        Map map=new HashMap();
        String uid=(String)map1.get("id");//用户id
        String xid=(String)map1.get("tid");//项目id
        map.put("uid",Integer.parseInt(uid));
        map.put("pid",Integer.parseInt(xid));
        privity pr=prService.selectPrivity(map);
        Integer income_money=inService.selectIncome(map);
        Map map2=new HashMap();
        map2.put("privity",pr);
        String view=paService.view(Integer.parseInt(xid));
        map2.put("money",income_money);
        map2.put("view",view);
        Gson gson=new Gson();
        String str=gson.toJson(map2);
        return str;
    }

    /***
     * 查看答案
     *  id  答题用户id
     *  tid  项目id
     * @return str  json字符串包含(id  题目id ，cid  正确答案id , sid  用户选择答案id , topic_content  题目内容 ，
     *  aid  答案id , content  答案内容)
     */
    @RequestMapping(value="LookAnswer",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String LookAnswer(@RequestBody Map<String,Object> map){
        String id=(String)map.get("id");//用户id
        String tid=(String)map.get("tid");//项目id

        List<answer> answerlist = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("pid", Integer.parseInt(tid));
        selectTopic setopic=new selectTopic();
        setopic.setUid(Integer.parseInt(id));
        //查出项目所对应的问题
        List<topic> list = service.selectResponse(map1);
        for (topic to : list) {
            //查出问题所对应的答案
            answerlist = service.selectAnswer(to.getId());
            to.setAnswerList(answerlist);
            System.out.println(to.getSid());
            setopic.setId(to.getSid());
            Integer answerId=reService.select(setopic);
            to.setSid(answerId);
        }
        List<question> listqusetion=new ArrayList<>();
        List<answer> listanswer=new ArrayList<>();
        for(topic to:list){
            question q=new question();
            q.setTopicId(to.getId());
            q.setTopic(to.getTopic_content());
            q.setAnswerId(to.getAnswer());
            q.setErrorId(to.getSid());
            listanswer=to.getAnswerList();
            for(answer an:listanswer){
                System.out.println("Aid="+an.getAid());
                System.out.println("内容是"+an.getContent());
                System.out.println("AnswerId="+q.getAnswerId());
                System.out.println("选择的答案id"+q.getErrorId());
                System.out.println("-----------------------------------------");
                if(an.getAid()==q.getAnswerId()){
                    q.setAnswer(an.getContent());
                }
                System.out.println("1-------------------------------------");
                if (an.getAid() == q.getErrorId()) {
                    q.setError(an.getContent());
                }
                System.out.println("2-----------------------------------------");
            }
           /* for(answer an:listanswer) {
                if (an.getAid() == q.getErrorId()) {
                    q.setError(an.getContent());
                }
            }*/
            listqusetion.add(q);
        }
        Gson gson=new Gson();
        String str=gson.toJson(listqusetion);

        return str;
    }
}
