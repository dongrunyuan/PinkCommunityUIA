package com.testdemo.pinktestdemo1;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.test.ApplicationTestCase;

import android.R.anim;
import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect ;
import android.os.Environment;
import android.os.SystemClock;

import android.test.InstrumentationTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.view.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutomatorDemo extends InstrumentationTestCase{

    //进程控制
    public static void excuteCommand(String command) {
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inline;
            while ((inline = br.readLine()) != null) {
                System.out.println(inline);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //启动
    @Before
    public void test001StartApp(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            excuteCommand("am force-stop pinkdiary.xiaoxiaotu.com");
            SystemClock.sleep(1000);
            excuteCommand("am start -n pinkdiary.xiaoxiaotu.com/pinkdiary.xiaoxiaotu.com.MainActivity");
        } catch (Exception e) {
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/startApp.png"));
            fail(e.toString());
        }
    }

    @Test
    //主页
    public void test002Index(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            index();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testIndex.png"));
            fail(e.toString());
        }
    }

    //发现--搜索
    public void test003Search(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_search();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testSearch.png"));
            fail(e.toString());
        }
    }

    //发现--粉粉圈
    public void test004Circle(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_circle();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testCircle.png"));
            fail(e.toString());
        }
    }

    //群组
    public void test005GroupChat(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_groupChat();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testGroupChat.png"));
            fail(e.toString());
        }
    }

    //旧版聊天室
    public void test005_5DyingChatRoom(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_dyingChatRoom();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testDyingChatRoom.png"));
            fail(e.toString());
        }
    }

    //申请达人认证
    public void test006Ablilty(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_ability();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testAblilty.png"));
            fail(e.toString());
        }
    }

    //找找
    public void test007Find(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_find();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testFind.png"));
            fail(e.toString());
        }
    }

    //排行榜
    public void test008Ranking(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_ranking();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testRanking.png"));
            fail(e.toString());
        }
    }

    //消息
    public void test009Notification(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            notification();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/testNotification.png"));
            fail(e.toString());
        }
    }

    @After
    public void testzzzTestFinished(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            excuteCommand("am force-stop pinkdiary.xiaoxiaotu.com");
            SystemClock.sleep(1000);
            excuteCommand("logcat -f /sdcard/AutomatorDemo.log");
            System.out.println("All testcases have been checked.Logs have been saved in /sdcard/AutomatorDemo.log");
        }catch (Exception e){
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/AutomatorDemo/TestFinished.png"));
            fail(e.toString());
        }
    }



    private void index() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        //首页scrollable
        UiScrollable home_scroll = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_scroll")).setAsVerticalList();
        //换肤
        UiObject skinShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/mine_skin_img"));
        //签到
        UiObject checkIn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_checkin"));
        //天气
        UiObject weather = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/weather_layout"));
        //个人头像，点击并确认登录
        UiObject portrait = mDevice.findObject (new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_portrait_lay"));
        UiObject login_btn = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(4));
        UiObject account = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_account_edt").index(1));
        UiObject pwd = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_pwd_edt").index(1));
        //我的日记
        UiObject home_mydiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_mydiary_lay"));
        //记一记
        UiObject home_write = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_write_lay"));
        //首页banner
        UiObject home_banner = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_banner_lay"));
        //每日一语
        UiObject dialy_word = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/dialy_word_lay"));
        //每日一语分享(首页)
        UiObject dialy_word_home_share = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/daily_word_share"));
        //每日一语分享(内部)
        UiObject dialy_word_detail_share = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_btn"));
        UiObject share_cancel = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/cancel").index(4));
        //为你推荐-列表
        UiObject hot_diary_list = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_diary_layout"));
        //为你推荐-刷新
        UiObject hot_diary_refresh = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_diary_refresh"));
        //为你推荐-第一条
        UiObject home_hotdiary_item0 = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0).clickable(true));
        //为你推荐-第二条
        UiObject home_hotdiary_item1 = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1).clickable(true));
        //为你推荐-更多
        UiObject home_lv_more = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_lv_more"));
        //为你推荐列表scrollable
        UiScrollable more_list = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()).clickable(true)).setAsVerticalList();
        UiObject more_portrait = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_portrait"));
        //日记主体
        UiObject more_diary_main = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_diary_list_mainlay"));
        //转发按钮
        UiObject more_diary_transpond = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_transpond_lay"));
        //评论按钮
        UiObject more_diary_review = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_review_lay"));
        //喜欢按钮
        UiObject more_diary_like = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_like_lay"));
        //分享按钮
        UiObject more_diary_share = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_share_lay"));
        //管理卡片
        UiObject card_manage = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/card_manage_btn"));
        //管理卡片开关
        UiObject weather_switch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/weather_lay").index(1));
        UiObject daily_word_switch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/daily_word_lay").index(3));
        UiObject rec_foryou_switch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/rec_foryou_lay").index(5));
        @SuppressWarnings("unused")
        //首页tab
                UiObject index = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0).clickable(true))
                .getFromParent(new UiSelector().className(android.widget.TabWidget.class.getName()));

        //动作
        //首页皮肤商店入口
        skinShop.clickAndWaitForNewWindow();
        SystemClock.sleep(1500);
        mDevice.pressBack();
        //首页签到入口
        checkIn.clickAndWaitForNewWindow();
        SystemClock.sleep(1500);
        mDevice.pressBack();
        //首页天气入口
        weather.clickAndWaitForNewWindow(5000);
        SystemClock.sleep(3000);
        mDevice.pressBack();
        //点击首页头像确认登录
        portrait.clickAndWaitForNewWindow();
        if (login_btn.exists()) {
            account.setText("test6789");
            pwd.setText("q");
            login_btn.click();
            SystemClock.sleep(3000);
        }else {
            mDevice.pressBack();
        }
        //首页我的日记入口
        home_mydiary.clickAndWaitForNewWindow();
        mDevice.pressBack();
        //首页记一记入口
        home_write.clickAndWaitForNewWindow();
        mDevice.pressBack();
        //首页banner入口
        if (home_banner.exists()){
            home_scroll.scrollIntoView(home_banner);
            home_banner.clickAndWaitForNewWindow();
            mDevice.pressBack();
        }
        //每日一语入口
        home_scroll.scrollForward(50);
        dialy_word_home_share.click();
        share_cancel.click();
        dialy_word.clickAndWaitForNewWindow();
        SystemClock.sleep(500);
        dialy_word_detail_share.click();
        share_cancel.click();
        mDevice.pressBack();
        //为你推荐入口
        home_scroll.scrollIntoView(hot_diary_list);
        home_hotdiary_item0.clickAndWaitForNewWindow();
        SystemClock.sleep(1500);
        mDevice.pressBack();
        hot_diary_refresh.click();
        SystemClock.sleep(1500);
        home_hotdiary_item1.clickAndWaitForNewWindow();
        SystemClock.sleep(1500);
        mDevice.pressBack();
        home_scroll.scrollIntoView(home_lv_more);
        home_lv_more.clickAndWaitForNewWindow(1500);
        more_list.flingToEnd(5);
        more_list.scrollForward(55);
        SystemClock.sleep(1000);
        more_list.scrollForward(55);
        more_portrait.clickAndWaitForNewWindow();
        mDevice.pressBack();
        more_diary_main.clickAndWaitForNewWindow();
        mDevice.pressBack();
        more_diary_transpond.click();
        mDevice.pressBack();
        mDevice.pressBack();
        more_diary_review.click();
        mDevice.pressBack();
        mDevice.pressBack();
        more_diary_like.click();
        more_diary_like.click();
        more_diary_share.click();
        mDevice.pressBack();
        mDevice.pressBack();
        //管理卡片
        for (int i = 0; i < 2; i++) {
            home_scroll.scrollIntoView(card_manage);
            card_manage.clickAndWaitForNewWindow();
            weather_switch.click();
            daily_word_switch.click();
            rec_foryou_switch.click();
            mDevice.pressBack();
        }
        home_scroll.scrollIntoView(skinShop);
    }

    private void discover_search() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //搜索入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject startSearch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_discover_search_btn"));
        UiObject keywords = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject search = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_btn"));
        UiObject IDResult = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_item_people_follow_lay").index(1));
        UiObject DiaryResult = mDevice.findObject(new UiSelector().resourceId("android:id/list")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        UiObject TopicResult = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_item_rl").index(1));
        UiObject GroupResult = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/groupchat_item_lay").index(1));
        //搜索粉粉id
        UiObject searchID = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_type_btn_uid"));
        //搜索日记
        UiObject searchDiary = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_type_btn_title"));
        //搜索话题
        UiObject searchTopic = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_type_btn_topic"));
        //搜索群组
        UiObject searchGroup = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_btn_gc"));

        //动作
        discover.click();
        SystemClock.sleep(1500);
        startSearch.click();
        SystemClock.sleep(1500);
        //search by ID
        keywords.setText("1111111");
        search.clickAndWaitForNewWindow();
        SystemClock.sleep(2500);
        keywords.clearTextField();
        keywords.setText("5399027");
        search.click();
        SystemClock.sleep(2500);
        IDResult.clickAndWaitForNewWindow(2500);
        mDevice.pressBack();
        SystemClock.sleep(1000);
        //search by diary
        searchDiary.click();
        SystemClock.sleep(500);
        keywords.clearTextField();
        keywords.setText("图");
        search.click();
        SystemClock.sleep(2500);
        DiaryResult.clickAndWaitForNewWindow(2500);
        mDevice.pressBack();
        SystemClock.sleep(1000);
        //search by topic
        searchTopic.click();
        SystemClock.sleep(500);
        keywords.clearTextField();
        keywords.setText("图");
        search.click();
        SystemClock.sleep(2500);
        TopicResult.clickAndWaitForNewWindow(2500);
        mDevice.pressBack();
        SystemClock.sleep(1000);
        //search by group
        searchGroup.click();
        SystemClock.sleep(500);
        keywords.clearTextField();
        keywords.setText("图");
        search.click();
        SystemClock.sleep(2500);
        GroupResult.clickAndWaitForNewWindow(2500);
        mDevice.pressBack();
        searchID.click();
        mDevice.pressBack();
        index.click();
        SystemClock.sleep(500);
    }

    private void discover_circle() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //粉粉圈入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject topicCenter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(1));
        //推荐话题&我的圈子&评论我的
        UiObject top_recommend_topic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_item_rl").index(1));
        UiObject recommend_topic_button = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_radio_recommend_topics"));
        UiObject myCircle = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_radio_my_group"));
        UiObject commentMe = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_radio_comment_me"));
        //添加圈子
        UiObject addCircle = mDevice.findObject(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0)
                .resourceId("pinkdiary.xiaoxiaotu.com:id/lay2"));
        UiObject switchClassification = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/circle_list_lay").index(4));
        UiObject switchCircle = mDevice.findObject(new UiSelector().className(android.widget.ListView.class.getName()).index(2)
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(6)));
        //UiObject enterCircle = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
        // .resourceId("pinkdiary.xiaoxiaotu.com:id/group_level_item_rl01"));
        //加入&退出圈子
        UiObject joinCircle = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_group_add_exit"));
        UiObject joinTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_item_rl").index(9));
        UiScrollable topicListScroll = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())
                .resourceId("android:id/list")).setAsVerticalList();
        //话题功能
        UiScrollable floorList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())
                .clickable(true).longClickable(true)).setAsVerticalList();
        UiObject floorPraise = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_like_lay"));
        UiObject floorReply = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_comment"));
        UiObject topicFunction = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_btn_right"));
        UiObject jump = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(2));
        UiObject accuse = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1));
        UiObject popularize = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(3));
        UiObject floor999 = mDevice.findObject(new UiSelector().className(android.widget.TextView.class.getName()).text("9")
                .resourceId("pinkdiary.xiaoxiaotu.com:id/num_9"));
        UiObject backspace = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName()).index(4)
                .resourceId("pinkdiary.xiaoxiaotu.com:id/num_c"));
        UiObject jumpConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/ok"));
        UiObject accuseType = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/snsinform_radio10"));
        UiObject accuseDesc = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/snsinform_input"));
        UiObject accuseConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/snsinform_btn_send").index(2));
        //楼主
        UiObject floorHost = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ti_master"));
        //最新
        UiObject topicNewest = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ti_new"));
        //评论操作
        UiObject comment = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_comment_btn"));
        UiObject inputBox = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/edit_text"));
        UiObject expression = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject heart = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_grid")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject inputBackspace = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/delete_emotion"));
        UiObject commentConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/btn_send"));
        UiObject back = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_btn_back"));
        //喜欢&分享
        UiObject topicLike = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_like_btn"));
        UiObject topicShare = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_share"));
        //精华
        UiObject cirlceBest = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gi_essence"));
        //最新
        UiObject cirlceNewest = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gi_new"));
        //发布话题
        UiObject publish = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_keep_topic_lay"));
        UiObject publishGuide = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/guide_once_emotion_main_bg_layout"));
        UiObject title = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_title"));
        UiObject topicContent = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_content"));
        //话题表情
        UiObject topicIcon = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        //话题图片
        UiObject topicImg = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_add_images"));
        UiObject chooseImg = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(2)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject imgConfirm = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/commit"));
        //录音
        UiObject startRecord = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/add_audio").clickable(true));
        UiObject endRecord = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).text("结束录音"));
        UiObject reRecord = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).text("重录"));
        UiObject deleteRecord = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).text("删除"));
        UiObject completeRecord = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).text("完成"));
        //投票功能
        UiObject startvote = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_release_bottom_lay")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        UiObject addOption = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/add_vote_lay"));
        UiObject option1 = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/vote_edit_1"));
        UiObject option2 = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/vote_edit_2"));
        UiObject option3 = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/vote_edit_3"));
        UiObject setFinishButton = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/set_finish_btn"));
        UiObject setFinishTime = mDevice.findObject(new UiSelector().className(android.widget.TextView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/set_finish_time"));
        UiObject chooseFinishTime = mDevice.findObject(new UiSelector().className(android.view.View.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/number_wv"));
        UiObject confirmFinishTime = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/dialog_ok"));
        UiObject confirmVote = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_vote_post"));
        //发送
        UiObject sendTopic = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_btn_release"));
        //回到圈子主界面
        UiObject home = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_my_group"));
        //我的话题
        UiObject topicSubFunction = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_btn_right"));
        UiObject myTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1));
        UiObject top_myTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_item_rl").index(1));
        //评论的话题
        UiObject commend = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(2));
        UiObject top_commented = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_comment_lay").index(1));
        //喜欢的话题
        UiObject likeTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(3));
        UiObject top_likeTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_item_rl").index(1));
        //取消
        UiObject cancel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(4));

        //动作
        //开始
        discover.click();
        SystemClock.sleep(1500);
        topicCenter.clickAndWaitForNewWindow(2000);
        //进入圈子
        myCircle.click();
        addCircle.clickAndWaitForNewWindow(2000);
        switchClassification.click();
        SystemClock.sleep(500);
        switchCircle.click();
        //加入&退出圈子
        joinCircle.click();
        SystemClock.sleep(1500);
        joinCircle.click();
        SystemClock.sleep(1500);
        joinTopic.click();
        SystemClock.sleep(1000);
        topicListScroll.flingToEnd(2);
        topicListScroll.scrollForward(50);
        SystemClock.sleep(1000);
        topicListScroll.scrollForward(50);
        SystemClock.sleep(500);
        //跳到999楼（或最后一楼）
        topicFunction.click();
        SystemClock.sleep(500);
        jump.click();
        SystemClock.sleep(1000);
        floor999.click();
        backspace.click();
        floor999.click();
        floor999.click();
        floor999.click();
        jumpConfirm.click();
        SystemClock.sleep(1500);
        //向上滑动
        topicListScroll.scrollBackward();
        SystemClock.sleep(2500);
        //楼主 & 最新
        floorHost.click();
        SystemClock.sleep(1000);
        topicNewest.click();
        SystemClock.sleep(1000);
        //举报&推广
        topicFunction.click();
        SystemClock.sleep(500);
        accuse.clickAndWaitForNewWindow();
        accuseType.click();
        accuseDesc.setText("测试姬测试举报功能中，请勿删除话题，谢谢~");
        accuseConfirm.click();
        SystemClock.sleep(1000);
        topicFunction.click();
        SystemClock.sleep(500);
        if (popularize.exists()){
            popularize.click();
            SystemClock.sleep(500);
        }else{
            jump.click();
        }
        //评论&喜欢&分享弹出
        comment.click();
        SystemClock.sleep(1000);
        inputBox.setText("楼主好顶赞~");
        expression.click();
        SystemClock.sleep(1000);
        heart.click();
        inputBackspace.click();
        heart.click();
        heart.click();
        heart.click();
        commentConfirm.click();
        SystemClock.sleep(5000);
        topicLike.click();
        SystemClock.sleep(1000);
        topicShare.click();
        mDevice.pressBack();
        back.click();
        SystemClock.sleep(1000);
        //精华 & 最新
        cirlceBest.click();
        SystemClock.sleep(1000);
        cirlceNewest.click();
        SystemClock.sleep(1000);
        //发布话题
        publish.clickAndWaitForNewWindow(2000);
        if (publishGuide.exists()) {
            publishGuide.click();
            SystemClock.sleep(1000);
        }
        title.setText("测试姬话题试验场~");
        SystemClock.sleep(500);
        topicContent.setText("测试姬话题试验中，这个话题马上就要炸上天了哦~boom~！");
        topicIcon.click();
        SystemClock.sleep(500);
        heart.click();
        heart.click();
        heart.click();
        SystemClock.sleep(500);
        topicImg.clickAndWaitForNewWindow(1000);
        chooseImg.click();
        imgConfirm.click();
        SystemClock.sleep(500);
        startvote.clickAndWaitForNewWindow(500);
        option1.setText("AAAAAAAAAA");
        option2.setText("BBBBBBBBBB");
        setFinishButton.click();
        setFinishTime.click();
        chooseFinishTime.swipeUp(50);
        confirmFinishTime.click();
        addOption.click();
        option3.setText("CCCCCCCCCC");
        confirmVote.click();
        //录音
        try {
            startRecord.click();
            SystemClock.sleep(5000);
            endRecord.click();
            SystemClock.sleep(500);
            reRecord.click();
            SystemClock.sleep(5000);
            endRecord.click();
            SystemClock.sleep(500);
            deleteRecord.click();
            SystemClock.sleep(1000);
            startRecord.click();
            SystemClock.sleep(5000);
            endRecord.click();
            SystemClock.sleep(500);
            completeRecord.click();
            SystemClock.sleep(1000);
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/EndRecordNotExist.png"));
            fail(e.toString());
        }
        //发送
        sendTopic.click();
        SystemClock.sleep(5000);
        //回到圈子主界面
        home.click();
        SystemClock.sleep(1000);
        //评论我的
        commentMe.click();
        SystemClock.sleep(1000);
        //推荐话题
        recommend_topic_button.click();
        SystemClock.sleep(1500);
        top_recommend_topic.clickAndWaitForNewWindow(1500);
        floorList.flingToEnd(5);
        if (floorPraise.exists()) {
            floorPraise.click();
            SystemClock.sleep(1000);
        }
        if (floorReply.exists()) {
            floorReply.click();
            inputBox.setText("楼主好顶赞~");
            commentConfirm.click();
            SystemClock.sleep(5000);
            mDevice.pressBack();
        }else{
            mDevice.pressBack();
        }
        //我的话题
        topicSubFunction.click();
        SystemClock.sleep(800);
        myTopic.clickAndWaitForNewWindow(2000);
        top_myTopic.clickAndWaitForNewWindow(2000);
        mDevice.pressBack();
        mDevice.pressBack();
        //评论的话题
        topicSubFunction.click();
        SystemClock.sleep(800);
        commend.clickAndWaitForNewWindow(2000);
        top_commented.clickAndWaitForNewWindow(2000);
        mDevice.pressBack();
        mDevice.pressBack();
        //喜欢的话题
        topicSubFunction.click();
        SystemClock.sleep(800);
        likeTopic.clickAndWaitForNewWindow(2000);
        top_likeTopic.clickAndWaitForNewWindow(2000);
        mDevice.pressBack();
        mDevice.pressBack();
        //取消
        topicSubFunction.click();
        cancel.click();
        //回到主页
        mDevice.pressBack();
        index.click();
        SystemClock.sleep(500);
    }

    private void discover_groupChat() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //群组入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject groupChat = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(2));
        /*旧功能键
		UiObject back = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName()).clickable(true).index(0))
				.getFromParent(new UiSelector().className(android.widget.RelativeLayout.class.getName()));
		UiObject confirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName()).index(2).clickable(true))
				.getFromParent(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0));
		*/
        //我的群
        UiObject myGroup = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_my_group"));
        //进入官方群群资料页面查看群详细信息
        UiObject officialGroupList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))));
        UiObject officialGroup1 = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/groupchat_item_lay").index(1));
        //详细信息
        UiObject groupCover = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/user_album_img"));
        UiObject groupLevel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_level_lay"));
        UiObject levelRefresh = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_btn"));
        UiObject groupMaster = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_owner_lay"));
        UiObject groupMember = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_member_lay"));
        UiScrollable groupMemberList = new UiScrollable(new UiSelector().resourceId("android:id/list")).setAsVerticalList();
        UiObject groupMemberDetail = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_item_people_follow_lay").index(1));
        UiObject apply = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_chat_lay"));
        UiObject applyReason = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject applyConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/apply_content_sure"));
        UiObject applyWaiting = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));
        //查找、创建、解散
        //查找群
        UiObject groupSubFunction = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/group_chat_more"));
        UiObject findGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1));
        UiObject inputNumber = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_edittext"));
        UiObject searchConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_btn"));
        UiObject searchResult = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/groupchat_item_lay").index(1));
        //创建群组
        UiObject createGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(2));
        UiObject create = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/create_groupchat_btn"));
        UiObject createTag = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/groupchat_settag_lay").index(5));
        UiObject tagNext = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/select_grouptag_next"));
        UiObject createGroupName = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/group_info_et"));
        UiObject createGroupCover = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_mygroup_cover_lay"));
        UiObject chooseImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/grid")
                .childSelector(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(1)));
        UiObject imgConfirm = mDevice.findObject(new UiSelector().className(android.widget.TextView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_completeButton"));
        UiObject groupInfoNext = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/write_groupinfo_next"));
        UiObject createGroupIntro = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/group_intro_et"));
        UiObject introConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/groupintro_next"));
        UiObject createSuccess = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));
        //群资料菜单
        UiScrollable groupDataScroll = new UiScrollable(new UiSelector().className(android.widget.ScrollView.class.getName())).setAsVerticalList();
        //更改群资料
        UiObject editGroupInfoEntrance = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/edit_gcinfo"));
        UiObject editGroupCover = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/gcimg_edit_lay"));
        UiObject addGroupCover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/gc_cover_item_jiahao"));
        UiObject editGroupName = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_edit_name_lay"));
        UiObject editNameText = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/group_info_et"));
        UiObject editNameNext = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/write_groupinfo_next"));
        UiObject editTag = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_edit_category_lay"));
        UiObject editGroupIntro= mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_edit_intro_lay"));
        UiObject changeTagTo = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/groupchat_settag_lay").index(7));
        //消息提醒
        UiObject enterGroupNotification = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_msg_notice_lay"));
        UiObject switchNotice = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/close_notice_lay"));
        UiObject switchSound = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/no_sound_mode_lay"));
        //新成员
        UiObject enterInvite = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_invite_lay"));
        UiObject invite = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gcinvite_btn"));
        //群聊
        UiObject enterGroupChat = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_chat_lay"));
        UiObject inputText = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject expression = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject heart = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_grid")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject inputBackspace = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/delete_emotion"));
        UiObject asciiArt = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName())
                        .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(2))));
        UiScrollable expressionPage = new UiScrollable(new UiSelector().className(android.widget.GridView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_grid")).setAsHorizontalList();
        UiObject chooseExpression = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_grid")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject downloadExpression = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_lay"));
        UiObject expressionItem = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_emotion_list_item_lay").index(4));
        UiObject buyExpression = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_detail_buy_lay"));
        UiObject dialogNext = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(2));
        UiObject purchasedExpression = mDevice.findObject(new UiSelector().className(android.widget.GridView.class.getName())
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        UiObject expressionDetail = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/myimg").clickable(true));
        UiObject detailToStore = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_detail_lay").clickable(true));
        UiObject textConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_send"));
        UiObject addAttachment = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/add"));
        UiObject addImg = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_add_images"));
        UiObject chooseChatImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/grid")
                .childSelector(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(1).
                        childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark"))));
        UiObject chatImgConfirm = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/commit"));
        UiObject addTopic = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/add_share_topic"));
        UiObject myTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0))));
        UiObject topicLike = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))));
        UiObject topicToShare = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_item_rl").index(1));
        UiObject shareRemarks = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/id_share_topic_edittext"));
        UiObject shareConfirm = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));
        UiObject enterTopic = mDevice.findObject(new UiSelector().className(android.widget.LinearLayout.class.getName()).clickable(true)
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_chat_share_lay"));
        UiObject addRecording = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/audio_btn"));
        UiObject startRecording = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/audio_start_btn"));
        UiObject playRecording = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/play_audio_lay")
                .clickable(true));
        //群聊界面功能入口
        UiObject chatSubFunction = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sq_gc_chat_morebtn"));
        UiObject groupData = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1));
        UiObject chatHistory = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(2));
        UiObject notif = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(3));
        //解散
        UiObject dissolve = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_dismiss_lay"));
        UiObject dissolveConfirm = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));

        //动作
        //进群组
        discover.click();
        SystemClock.sleep(1000);
        groupChat.clickAndWaitForNewWindow(2500);
        //浏览群详细
        officialGroupList.click();
        SystemClock.sleep(1000);
        officialGroup1.clickAndWaitForNewWindow(1500);
        groupCover.clickAndWaitForNewWindow(1000);
        mDevice.pressBack();
        groupLevel.clickAndWaitForNewWindow(1500);
        levelRefresh.click();
        SystemClock.sleep(1000);
        mDevice.pressBack();
        groupMaster.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        groupMember.clickAndWaitForNewWindow(1500);
        groupMemberDetail.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        groupMemberList.scrollForward(30);
        mDevice.pressBack();
        //加入群组
        apply.clickAndWaitForNewWindow(500);
        applyReason.setText("群申请测试中，请拒绝，谢谢~");
        SystemClock.sleep(500);
        applyConfirm.click();
        SystemClock.sleep(2500);
        if(applyWaiting.exists()){
            applyWaiting.click();
        }else{
            mDevice.pressBack();
        }
        SystemClock.sleep(1500);
        mDevice.pressBack();
        //搜索群组
        groupSubFunction.click();
        findGroup.clickAndWaitForNewWindow(1000);
        inputNumber.setText("300227");
        searchConfirm.click();
        SystemClock.sleep(500);
        searchResult.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        mDevice.pressBack();
        //创建群组

        groupSubFunction.click();
        createGroup.clickAndWaitForNewWindow(1000);
        create.click();
        SystemClock.sleep(500);
        if(createTag.exists()){
            createTag.click();
            tagNext.clickAndWaitForNewWindow(1000);
            createGroupName.clearTextField();
            createGroupName.setText("测试姬の里屋");
            createGroupCover.clickAndWaitForNewWindow(1500);
            chooseImg.click();
            imgConfirm.click();
            groupInfoNext.clickAndWaitForNewWindow(1500);
            createGroupIntro.clearTextField();
            createGroupIntro.setText("测试姬的小黑屋呐～不要过来呐～！");
            introConfirm.clickAndWaitForNewWindow(2500);
            createSuccess.click();
        }
        //更改群资料
        editGroupInfoEntrance.clickAndWaitForNewWindow(1500);
        editGroupCover.clickAndWaitForNewWindow(1000);
        mDevice.pressBack();
        addGroupCover.clickAndWaitForNewWindow(1500);
        chooseImg.click();
        imgConfirm.click();
        editGroupName.clickAndWaitForNewWindow(500);
        editNameText.clearTextField();
        editNameText.setText("测试姬の里屋~");
        editNameNext.clickAndWaitForNewWindow();
        SystemClock.sleep(500);
        editTag.clickAndWaitForNewWindow(500);
        changeTagTo.click();
        tagNext.click();
        SystemClock.sleep(500);
        editGroupIntro.clickAndWaitForNewWindow(500);
        createGroupIntro.clearTextField();
        createGroupIntro.setText("测试姬的小黑屋呐～不要过来呐～！！");
        introConfirm.click();
        mDevice.pressBack();
        //消息提醒
        enterGroupNotification.clickAndWaitForNewWindow(500);
        switchNotice.click();
        switchSound.click();
        mDevice.pressBack();
        //邀请新成员
        enterInvite.clickAndWaitForNewWindow(1000);
        invite.click();
        SystemClock.sleep(500);
        invite.click();
        SystemClock.sleep(500);
        mDevice.pressBack();
        //群聊
        enterGroupChat.clickAndWaitForNewWindow(1500);
        inputText.setText("Hello World");
        expression.click();
        heart.click();
        heart.click();
        heart.click();
        heart.click();
        inputBackspace.click();
        asciiArt.click();
        expressionPage.scrollForward(55);
        chooseExpression.click();
        textConfirm.click();
        SystemClock.sleep(2500);
        downloadExpression.clickAndWaitForNewWindow(1000);
        expressionItem.clickAndWaitForNewWindow(1500);
        buyExpression.click();
        if (dialogNext.exists()){
            dialogNext.click();
        }
        SystemClock.sleep(5000);
        mDevice.pressBack();
        mDevice.pressBack();
        purchasedExpression.click();
        chooseExpression.click();
        SystemClock.sleep(2500);
        expressionDetail.clickAndWaitForNewWindow(1500);
        detailToStore.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        mDevice.pressBack();
        addAttachment.click();
        addImg.clickAndWaitForNewWindow();
        chooseChatImg.click();
        chatImgConfirm.click();
        SystemClock.sleep(2500);
        addTopic.clickAndWaitForNewWindow();
        topicLike.click();
        myTopic.click();
        if (topicToShare.exists()) {
            topicToShare.click();
            shareRemarks.clearTextField();
            shareRemarks.setText("Hello World");
            shareConfirm.click();
            SystemClock.sleep(2500);
        }
        else {
            mDevice.pressBack();
        }
        if (enterTopic.exists()) {
            enterTopic.clickAndWaitForNewWindow(1500);
            mDevice.pressBack();
        }
        //录音
        addRecording.click();
        startRecording.longClick();
        if (playRecording.exists()) {
            playRecording.click();
            SystemClock.sleep(2500);
        }
        //群聊界面功能
        chatSubFunction.click();
        groupData.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        chatSubFunction.click();
        chatHistory.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        chatSubFunction.click();
        notif.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        //解散
        mDevice.pressBack();
        try {
            groupDataScroll.scrollIntoView(dissolve);
            dissolve.click();
            SystemClock.sleep(500);
            dissolveConfirm.click();
            myGroup.click();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath()+"/DissolveNotExist.png"));
            fail(e.toString());
        }
        for (int i = 0; i < 5; i++) {
            if (!index.exists()) {
                mDevice.pressBack();
            }
            else {
                break;
            }
        }
    }

    private void discover_dyingChatRoom() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //聊天室入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject chatRoomEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(3));
        //聊天记录
        UiScrollable chatList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()));
        //输入内容
        UiObject input = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject expression = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject asciiArt = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName())
                        .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1))));
        UiScrollable expressionList = new UiScrollable(new UiSelector().className(android.widget.GridView.class.getName())).setAsHorizontalList();
        UiObject chooseExpression = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_grid")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(3)));
        UiObject confirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/btn_send"));

        //动作
        //进入聊天室
        discover.click();
        SystemClock.sleep(1500);
        chatRoomEntrance.clickAndWaitForNewWindow(2000);
        chatList.flingToBeginning(4);
        SystemClock.sleep(1500);
        input.click();
        input.setText("新人报道");
        expression.click();
        expressionList.scrollForward(2);
        if (chooseExpression.exists()) {
            chooseExpression.click();
        }
        asciiArt.click();
        expressionList.scrollForward(2);
        if (chooseExpression.exists()) {
            chooseExpression.click();
        }
        confirm.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        mDevice.pressBack();
        index.click();
    }

    private void discover_ability() throws UiObjectNotFoundException{
        //控件
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //入口
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject ability = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(5));
        //达人分享
        UiObject ability_share = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(2));
        //分享到群和粉丝
        UiObject groupAndFans = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lay0").index(1)
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0)));
        UiObject myFans = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator").index(0)
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))));
        UiObject GNFItem = mDevice.findObject(new UiSelector().resourceId("android:id/list").index(0)
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        UiObject shareText = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()).index(1));
        UiObject shareSend = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(2));
        //分享到我的点滴
        UiObject myDrip = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lay0").index(1)
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        //达人申请
        UiObject regist_ability = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(7));
        UiObject category = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_class_radio3").index(2));
        UiObject registText = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()).index(0));
        UiObject registSubmit = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/ability_submit_btn").index(4));

        //动作
        index.click();
        discover.click();
        ability.click();
        //分享
        if(ability_share.exists()){
            ability_share.click();
            groupAndFans.click();
            myFans.click();
            GNFItem.click();
            shareText.clearTextField();
            shareText.setText("测试中~~请忽视QAQ");
            shareSend.clickAndWaitForNewWindow(5000);
            mDevice.pressBack();
            ability_share.click();
            groupAndFans.click();
            GNFItem.click();
            shareText.clearTextField();
            shareText.setText("测试中~~请忽视QAQ");
            shareSend.clickAndWaitForNewWindow(5000);
            mDevice.pressBack();
            ability_share.click();
            myDrip.click();
            shareText.clearTextField();
            shareText.setText("测试中~~请忽视QAQ");
            shareSend.clickAndWaitForNewWindow(5000);
            SystemClock.sleep(500);
            mDevice.pressBack();
        }else if(regist_ability.exists()){
            //申请
            if(regist_ability.isClickable()) {
                regist_ability.click();
                category.click();
                registText.clearTextField();
                registText.setText("测试中~~请不要忽视QAQ");
                registSubmit.click();
                mDevice.pressBack();
                mDevice.pressBack();
            }
        }else{
            mDevice.pressBack();
        }
    }

    private void discover_find() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //找找入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject findEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(6));
        //搜索
        UiObject startSearch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_rec_search_btn"));
        UiObject keywords = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject search = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_btn"));
        //搜索粉粉id
        UiObject searchID = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_type_btn_uid"));
        //搜索日记
        UiObject searchDiary = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_type_btn_title"));
        //搜索话题
        UiObject searchTopic = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_type_btn_topic"));
        //搜索群组
        UiObject searchGroup = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_search_btn_gc"));
        //邀请好友
        UiObject inviteFromSina = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_invite_sinaweibo_friend_layout"));
        UiObject inviteFromWechat = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_invite_weixin_friend_layout"));
        UiObject inviteFromTencent = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_invite_qq_friend_layout"));
        UiObject weChatExit = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(1));
        //推荐列表
        UiScrollable recommendList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())).setAsVerticalList();
        //列表项详情
        UiObject recommendObjectInfo = mDevice.findObject(new UiSelector().className(android.widget.ListView.class.getName())
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        //推荐个人详情-查看头像相册
        UiObject recommendUserPortrait = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_portrait"));
        UiObject userAlbum = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_album_lay").index(0));
        //不同位置-关注
        UiObject followInInfo = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsherinfo_followed_lay"));
        UiObject followInList = mDevice.findObject(new UiSelector().resourceId("android:id/list")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)
                        .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recommend_lay")
                                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recommend_list_lay")
                                        .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_myfans_userinfo_lay")
                                                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsfeed_recomuser_item_follow").index(2)))))));
        //列表切换
        UiObject recommendCircle = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))));
        UiObject recommendGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2))));
        //不同位置-加圈子
        UiObject joinGroupInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recgroup_join"));
        UiObject joinGroupInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_group_add_exit"));
        //查看群组详情
        UiObject groupCover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_album_lay").index(0));
        UiObject groupLevel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_level_lay"));
        UiObject levelRefresh = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_btn"));
        UiObject groupMaster = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_owner_lay"));
        UiObject groupMember = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_member_lay"));
        UiScrollable groupMemberList = new UiScrollable(new UiSelector().resourceId("android:id/list")).setAsVerticalList();
        UiObject groupMemberDetail = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_item_people_follow_lay").index(1));
        UiObject apply = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_chat_lay"));
        UiObject applyReason = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject applyConfirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/apply_content_sure"));
        UiObject applyWaiting = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));

        //动作
        index.click();
        discover.click();
        findEntrance.click();
        startSearch.click();
        //search by ID
        keywords.setText("1111111");
        search.clickAndWaitForNewWindow();
        SystemClock.sleep(2500);
        keywords.clearTextField();
        keywords.setText("5399027");
        search.click();
        //search by diary
        searchDiary.click();
        SystemClock.sleep(500);
        keywords.clearTextField();
        keywords.setText("图");
        search.click();
        //search by topic
        searchTopic.click();
        SystemClock.sleep(500);
        keywords.clearTextField();
        keywords.setText("图");
        search.click();
        //search by group
        searchGroup.click();
        SystemClock.sleep(500);
        keywords.clearTextField();
        keywords.setText("图");
        search.click();
        searchID.click();
        mDevice.pressBack();
        //邀请好友
        inviteFromSina.clickAndWaitForNewWindow();
        SystemClock.sleep(3000);
        mDevice.pressBack();
        inviteFromWechat.click();
        SystemClock.sleep(5000);
        mDevice.pressBack();
        weChatExit.clickAndWaitForNewWindow();
        inviteFromTencent.clickAndWaitForNewWindow(5000);
        mDevice.pressBack();
        //感兴趣的人
        recommendList.flingToEnd(3);
        recommendList.scrollForward(50);
        recommendList.scrollForward(50);
        followInList.click();
        recommendObjectInfo.click();
        recommendUserPortrait.click();
        userAlbum.click();
        mDevice.pressBack();
        SystemClock.sleep(500);
        mDevice.pressBack();
        followInInfo.click();
        mDevice.pressBack();
        //推荐圈子
        recommendCircle.click();
        recommendList.flingToEnd(3);
        recommendList.scrollForward(50);
        recommendList.scrollForward(50);
        joinGroupInList.click();
        recommendObjectInfo.click();
        SystemClock.sleep(5000);
        joinGroupInDetail.click();
        mDevice.pressBack();
        //推荐群组
        recommendGroup.click();
        recommendList.flingToEnd(3);
        recommendList.scrollForward(50);
        recommendList.scrollForward(50);
        recommendObjectInfo.click();
        groupCover.clickAndWaitForNewWindow(1000);
        mDevice.pressBack();
        groupLevel.clickAndWaitForNewWindow(1500);
        levelRefresh.click();
        SystemClock.sleep(1000);
        mDevice.pressBack();
        groupMaster.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        groupMember.clickAndWaitForNewWindow(1500);
        groupMemberDetail.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        groupMemberList.scrollForward(30);
        mDevice.pressBack();
        //加入群组
        apply.clickAndWaitForNewWindow(500);
        if(applyReason.exists()){
            applyReason.setText("群申请测试中，请拒绝，谢谢~");
            SystemClock.sleep(500);
            applyConfirm.click();
            SystemClock.sleep(2500);
            if(applyWaiting.exists()){
                applyWaiting.click();
            }else{
                mDevice.pressBack();
            }
        }
        SystemClock.sleep(1500);
        mDevice.pressBack();
        SystemClock.sleep(500);
        mDevice.pressBack();
    }

    private void discover_ranking() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //排行榜入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject rankingEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(7));
        UiObject refresh = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_btn"));
        UiObject back = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_browser_btn_back"));

        //动作
        discover.click();
        rankingEntrance.clickAndWaitForNewWindow(3000);
        mDevice.takeScreenshot(new File(Environment.getExternalStorageDirectory().getPath() + "/AutomatorDemo/rankingDisplay.png"));
        refresh.click();
        SystemClock.sleep(3500);
        back.click();
        index.click();
    }

    private void notification() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(0));
        //消息入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(1));
        UiObject noticeEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/tabsLayout").index(3));
        //动态&通知&聊天
        UiScrollable list = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())).setAsVerticalList();
        UiObject listItem = mDevice.findObject(new UiSelector().resourceId("android:id/list")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        UiObject dynamic = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_rb_me_attention"));
        UiObject notice = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_rb_relation_me"));
        UiObject privateMessage = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_rb_private_letter"));
        //返回
        UiObject back = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .childSelector(new UiSelector().className(android.widget.ImageView.class.getName()).index(0)));
        //动作
        //分别获取3个列表，如果列表中有数据的话，进入第一条数据的详情界面再返回
        discover.click();
        noticeEntrance.click();
        dynamic.click();
        if (listItem.exists()) {
            listItem.clickAndWaitForNewWindow(1500);
        }
        back.click();
        list.scrollForward(100);
        notice.click();
        if (listItem.exists()) {
            listItem.clickAndWaitForNewWindow(1500);
        }
        back.click();
        list.scrollForward(100);
        privateMessage.click();
        if (listItem.exists()) {
            listItem.clickAndWaitForNewWindow(1500);
        }
        back.click();
        list.scrollForward(100);
        //回到主页
        index.click();
    }

}