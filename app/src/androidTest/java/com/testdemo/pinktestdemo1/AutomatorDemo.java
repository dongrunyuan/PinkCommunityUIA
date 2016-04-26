package com.testdemo.pinktestdemo1;

import android.graphics.Rect;
import android.os.Environment;
import android.os.SystemClock;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.test.InstrumentationTestCase;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutomatorDemo extends InstrumentationTestCase{

    //获取手机api版本
    public static int currentApiVersion = android.os.Build.VERSION.SDK_INT;

    //连续点击方法
    public void doubleClick(int num,UiObject mObject) throws UiObjectNotFoundException{
        if(currentApiVersion >= 18){
            long timeout = Configurator.getInstance().getActionAcknowledgmentTimeout();
            Configurator.getInstance().setActionAcknowledgmentTimeout(50);
            for(int i = 0;i < num; i++){
                mObject.click();
            }
            Configurator.getInstance().setActionAcknowledgmentTimeout(timeout);
        }
    }

    //长按方法
    public void longClick(UiObject mObject, int steps) throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        Rect coordinates = mObject.getBounds();
        mDevice.swipe(coordinates.centerX(), coordinates.centerY(), coordinates.centerX(), coordinates.centerY(), steps);
    }

    //启动命令
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
            excuteCommand("am start -n pinkdiary.xiaoxiaotu.com/pinkdiary.xiaoxiaotu.com.LogoScreen");
            SystemClock.sleep(4000);
        } catch (Exception e) {
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/startApp.png"));
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
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testIndex.png"));
            fail(e.toString());
        }
    }

    //发现--搜索
    public void test003Search(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_search();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testSearch.png"));
            fail(e.toString());
        }
    }

    //发现--粉粉圈
    public void test004Circle(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_circle();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testCircle.png"));
            fail(e.toString());
        }
    }

    //群组
    public void test005GroupChat(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_groupChat();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testGroupChat.png"));
            fail(e.toString());
        }
    }

    //旧版聊天室
    public void test005P_DyingChatRoom(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_dyingChatRoom();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testDyingChatRoom.png"));
            fail(e.toString());
        }
    }

    //申请达人认证
    public void test006Ablilty(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_ability();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testAblilty.png"));
            fail(e.toString());
        }
    }

    //找找
    public void test007Find(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            discover_find();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testFind.png"));
            fail(e.toString());
        }
    }

    //排行榜
    public void test008Ranking(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        try {
            discover_ranking();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testRanking.png"));
            fail(e.toString());
        }
    }

    //社区浏览
    public void test009VisitCommunity(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            visitCommunity();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testVisitCommunity.png"));
            fail(e.toString());
        }
    }

    //写社区点滴
    public void test010PublishCommunityDiary(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            publishCommunityDiary();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/publishCommunityDiary.png"));
            fail(e.toString());
        }
    }

    //消息
    public void test011Notification(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            notification();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testNotification.png"));
            fail(e.toString());
        }
    }

    //我的
    public void test012Mine(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            mine();
        } catch (UiObjectNotFoundException e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/testMine.png"));
            fail(e.toString());
        }
    }

    @After
    public void testzzzTestFinished(){
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        try {
            excuteCommand("am force-stop pinkdiary.xiaoxiaotu.com");
            SystemClock.sleep(1000);
            excuteCommand("logcat -f /sdcard.log");
            System.out.println("All testcases have been checked.Logs have been saved in /sdcard.log");
        }catch (Exception e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/TestFinished.png"));
            fail(e.toString());
        }
    }

    private void index() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        //授权允许
        final UiObject permit1 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(1));
        final UiObject permit2 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).resourceId("android:id/button1"));
        UiWatcher watcher = new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                try {
                    if (permit1.exists()){
                        permit1.click();
                        return true;
                    }
                    else if (permit2.exists()){
                        permit1.click();
                        return true;
                    }
                }catch (UiObjectNotFoundException e){
                    fail(e.toString());
                }
                return false;
            }
        };
        //新功能引导
        UiObject upgradeImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/upgrade_version_item_image"));
        UiObject start = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/upgrade_version_sure"));
        UiObject passIntro = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/close_guide"));
        //首页tab
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //首页scrollable
        UiScrollable home_scroll = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_scroll")).setAsVerticalList();
        //换肤
        UiObject skinShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/mine_skin_img"));
        UiScrollable generalList = new UiScrollable(new UiSelector().resourceId("android:id/list"));
        UiObject defaultGreen_Use = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_font_list_item_lay").index(2)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_skin_list_item_lay"))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/skin_detail_buy_lay")));
        UiObject defaultPurple_Detail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_font_list_item_lay").index(3)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_skin_list_item_lay")));
        UiObject detailImgList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/skin_preview_image_hs"));
        UiObject designer = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/designer_cover"));
        UiObject detailUse = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/skin_detail_use_lay"));
        UiObject skinSettings = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/skin_setting"));
        //签到
        UiObject checkIn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_checkin"));
        //天气
        UiObject weather = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/weather_layout"));
        //个人头像，点击并确认登录
        UiObject portrait = mDevice.findObject (new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home_portrait_lay"));
        UiObject login_btn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_login_btn").index(5));
        UiObject account = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_account_edt").index(0));
        UiObject pwd = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_pwd_edt").index(0));
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
        UiObject dialy_word_detail_share = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_refresh_btn"));
        UiObject share_cancel = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/cancel"));
        //为你推荐-列表
        UiObject hot_diary_list = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_diary_layout"));
        //为你推荐-刷新
        UiObject hot_diary_refresh = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_diary_refresh"));
        //为你推荐-第一条
        UiObject home_hotdiary_item0 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_diary_layout")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0)));
        //为你推荐-第二条
        UiObject home_hotdiary_item1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_diary_layout")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
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
        //密码锁解锁
        UiObject unlockPwd = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/pwd_input_splash_edt"));
        UiObject unlock = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/pwd_unlock"));
        //版本更新提示-跳过
        UiObject skipUpdate = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_update_id_cancel"));
        //广告进入/跳过
        UiObject jumpAd = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/splash_step_tv"));
        @SuppressWarnings("unused")
        UiObject enterAd = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/cnt_splash_lay"));

        //动作
        //注册uiwatcher
        mDevice.registerWatcher("warnings", watcher);
        //启动时是否第一次判断
//        if (permit1.exists())
//            permit1.click();
//        else if (permit2.exists())
//            permit2.click();
//        SystemClock.sleep(500);
        while (upgradeImg.exists()){
            if (!start.exists()){
                upgradeImg.swipeLeft(6);
            }
            else {
                start.click();
                SystemClock.sleep(500);
                break;
            }
        }
        if (unlockPwd.exists()){
            unlockPwd.setText("1");
            unlock.click();
            SystemClock.sleep(1000);
        }
        if (jumpAd.exists()){
            jumpAd.click();
            SystemClock.sleep(1500);
        }
        if (passIntro.exists()){
            passIntro.click();
            SystemClock.sleep(500);
        }
        if (skipUpdate.exists())
            skipUpdate.click();
        index.click();
        home_scroll.flingToBeginning(3);
        //首页皮肤商店入口
        skinShop.clickAndWaitForNewWindow(2500);
        SystemClock.sleep(3500);
        defaultGreen_Use.click();
        SystemClock.sleep(3500);
        defaultPurple_Detail.clickAndWaitForNewWindow(2500);
        detailImgList.swipeLeft(50);
        designer.clickAndWaitForNewWindow(2500);
        mDevice.pressBack();
        detailUse.click();
        SystemClock.sleep(3500);
        mDevice.pressBack();
        generalList.flingToEnd(8);
        generalList.swipeUp(50);
        generalList.flingToEnd(3);
        skinSettings.click();
        generalList.flingToEnd(5);
        mDevice.pressBack();
        mDevice.pressBack();
        //首页签到入口
        checkIn.clickAndWaitForNewWindow(2500);
        SystemClock.sleep(1500);
        mDevice.pressBack();
        //首页天气入口
        weather.clickAndWaitForNewWindow(5000);
        SystemClock.sleep(3000);
        mDevice.pressBack();
        //点击首页头像确认登录
        portrait.clickAndWaitForNewWindow(1000);
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
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //搜索入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
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
        //授权允许
        final UiObject permit1 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(1));
        final UiObject permit2 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).resourceId("android:id/button1"));
        UiWatcher watcher = new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                try {
                    if (permit1.exists()){
                        permit1.click();
                        return true;
                    }
                    else if (permit2.exists()){
                        permit1.click();
                        return true;
                    }
                }catch (UiObjectNotFoundException e){
                    fail(e.toString());
                }
                return false;
            }
        };
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //粉粉圈入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
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
        UiScrollable topicListScroll = new UiScrollable(new UiSelector().resourceId("android:id/list")).setAsVerticalList();
        //话题功能
        UiScrollable floorList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())).setAsVerticalList();
        UiObject floorPraise = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_like_lay"));
        UiObject floorReply = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_comment"));
        UiObject topicFunction = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_btn_right"));
        UiObject jump = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(2)
                .childSelector(new UiSelector().text("楼层跳转")));
        UiObject accuse = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1)
                .childSelector(new UiSelector().text("举报")));
        UiObject popularize = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(3)
                .childSelector(new UiSelector().text("推广")));
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
        UiObject accuseConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsinform_btn_send").index(2));
        //楼主
        UiObject floorHost = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ti_master"));
        //最新
        UiObject topicNewest = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ti_new"));
        //评论操作
        UiObject comment = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_comment_btn"));
        UiObject inputBox = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/edit_text"));
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
        UiObject publishGuide = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_keepdiary_guide_layout"));
        UiObject title = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_title"));
        UiObject topicContent = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_content"));
        //话题表情
        UiObject addEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject enterEmotionShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0)));
        UiObject generalList = mDevice.findObject(new UiSelector().resourceId("android:id/list"));
        UiObject hotlist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject newlist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0))
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject freelist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2))
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject emotionItem1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_emotion_list_item_lay").index(2));
        UiObject emotionItem2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_emotion_list_item_lay").index(3));
        UiObject buyEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_detail_buy_lay"));
        UiObject emotionColumn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_hs"));
        UiObject emotionColumnItem1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        UiObject emotionColumnItem2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(2)));
        UiObject emotionColumnItem3 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        UiObject columDetailList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_panel_pager_vp"));
        UiObject chooseEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/item_emotion_pager_lay").index(1));
        UiObject deleteEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/delete_emotion"));
        //话题图片
        UiObject topicImg = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_add_images"));
        UiObject chooseImg = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(2)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject imgConfirm = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/commit"));
        //录音
        UiObject enterRecord = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/add_audio").clickable(true));
        UiObject startRecord = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/audio_view_img_bg"));
        UiObject reRecord = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/audio_view_remake"));
        UiObject deleteRecord = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/audio_view_delete"));
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
        //修改圈子
        UiObject changeCircle = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/changGroup"));
        UiObject confirmChange = mDevice.findObject(new UiSelector().className(android.widget.ListView.class.getName()).index(2)
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0)));
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
        //注册uiwatcher
        mDevice.registerWatcher("warnings", watcher);
        //开始
        discover.click();
        SystemClock.sleep(1500);
        topicCenter.clickAndWaitForNewWindow(2000);
        //进入圈子
        myCircle.click();
        topicListScroll.scrollIntoView(addCircle);
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
        topicListScroll.flingToBeginning(3);
        topicListScroll.swipeDown(5);
        SystemClock.sleep(2500);
        //楼主 & 最新
        floorHost.click();
        SystemClock.sleep(1000);
        topicNewest.click();
        SystemClock.sleep(1000);
        //举报
        topicFunction.click();
        SystemClock.sleep(500);
        if(accuse.exists()){
            accuse.clickAndWaitForNewWindow();
            accuseType.click();
            accuseDesc.setText("测试姬测试举报功能中，请勿删除话题，谢谢~");
            accuseConfirm.click();
        }else{
            mDevice.pressBack();
        }
        SystemClock.sleep(1000);
        //推广
        topicFunction.click();
        SystemClock.sleep(500);
        if (popularize.exists()){
            popularize.click();
            SystemClock.sleep(500);
        }else{
            mDevice.pressBack();
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
        Random ne = new Random();
        int i = ne.nextInt(10000);
        topicContent.setText("测试姬话题试验中，这个话题马上就要炸上天了哦~boom~！" + i);
        addEmotion.click();
        SystemClock.sleep(500);
        enterEmotionShop.clickAndWaitForNewWindow(1500);
        hotlist.click();
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        newlist.click();
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        freelist.click();
        emotionItem1.clickAndWaitForNewWindow(1500);
        buyEmotion.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        emotionItem2.clickAndWaitForNewWindow(1500);
        buyEmotion.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        mDevice.pressBack();
        emotionColumn.swipeLeft(3);
        emotionColumn.swipeLeft(5);
        emotionColumnItem1.click();
        heart.click();
        heart.click();
        heart.click();
        SystemClock.sleep(500);
        emotionColumnItem2.click();
        chooseEmotion.click();
        chooseEmotion.click();
        SystemClock.sleep(500);
        emotionColumnItem3.click();
        columDetailList.swipeLeft(3);
        chooseEmotion.click();
        chooseEmotion.click();
        chooseEmotion.click();
        chooseEmotion.click();
        chooseEmotion.click();
        deleteEmotion.click();
        deleteEmotion.click();
        SystemClock.sleep(500);
        topicImg.clickAndWaitForNewWindow(1000);
        if(chooseImg.exists()){
            chooseImg.click();
            imgConfirm.click();
            SystemClock.sleep(500);
        }
        startvote.clickAndWaitForNewWindow(500);
        option1.setText("AAAAAAAAAA");
        option2.setText("BBBBBBBBBB");
        setFinishButton.click();
        if(setFinishTime.exists()){
            setFinishTime.click();
            chooseFinishTime.swipeUp(50);
            confirmFinishTime.click();
        }
        addOption.click();
        option3.setText("CCCCCCCCCC");
        confirmVote.click();
        //录音
        try {
            enterRecord.click();
            SystemClock.sleep(1000);
//            //如果出现录音授权需要确认
//            if(permit1.exists())
//                permit1.click();
//            else if (permit2.exists())
//                permit2.click();
            //停止录音按钮坐标
            int recordButtonX = startRecord.getBounds().centerX();
            int recordButtonY = startRecord.getBounds().centerY();
            //开始录音
            startRecord.click();
            SystemClock.sleep(5000);
            mDevice.click(recordButtonX,recordButtonY);
            SystemClock.sleep(500);
            reRecord.click();
            SystemClock.sleep(5000);
            mDevice.click(recordButtonX,recordButtonY);
            SystemClock.sleep(500);
            deleteRecord.click();
            SystemClock.sleep(1000);
            startRecord.click();
            SystemClock.sleep(15000);
            mDevice.click(recordButtonX,recordButtonY);
            SystemClock.sleep(500);
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/EndRecordNotExist.png"));
            fail(e.toString());
        }
        //更改发布的圈子
        changeCircle.clickAndWaitForNewWindow(1500);
        confirmChange.click();
        SystemClock.sleep(1500);
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
        floorList.scrollForward(100);
        floorList.scrollIntoView(floorReply);
        if (floorPraise.exists()) {
            floorList.scrollIntoView(floorPraise);
            floorPraise.click();
            SystemClock.sleep(1000);
        }
        SystemClock.sleep(500);
        if (floorReply.exists()) {
            floorReply.click();
            inputBox.setText("楼主好顶赞~");
            commentConfirm.click();
            SystemClock.sleep(5000);
            back.click();
        }else{
            back.click();
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
        //授权允许
        final UiObject permit1 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(1));
        final UiObject permit2 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).resourceId("android:id/button1"));
        UiWatcher watcher = new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                try {
                    if (permit1.exists()){
                        permit1.click();
                        return true;
                    }
                    else if (permit2.exists()){
                        permit1.click();
                        return true;
                    }
                }catch (UiObjectNotFoundException e){
                    fail(e.toString());
                }
                return false;
            }
        };
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //群组入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
        UiObject groupChat = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(2));
        /*旧功能键
		UiObject back = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName()).clickable(true).index(0))
				.getFromParent(new UiSelector().className(android.widget.RelativeLayout.class.getName()));
		UiObject confirm = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName()).index(2).clickable(true))
				.getFromParent(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0));
		*/
        //我的群
        UiObject myGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_my_group").index(2));
        //推荐群&最新群
        UiObject recommendGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))));
        UiObject newestGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0))));
        //进入官方群群资料页面查看群详细信息
        UiObject officialGroupList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2))));
        UiObject officialGroup1 = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/groupchat_item_lay").index(1));
        UiScrollable groupList = new UiScrollable(new UiSelector().resourceId("android:id/list")).setAsVerticalList();
        //详细信息
        UiObject groupCover = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/user_album_img"));
        UiObject groupLevel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_level_lay"));
        UiObject levelRefresh = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_refresh_btn"));
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
        UiObject createSuccess = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));
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
        UiObject guideImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/guide_once_emotion_main_bg_layout"));
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
        UiObject buyExpression = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_detail_buy_lay"));
        UiObject dialogNext = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(2));
        UiObject purchasedExpression = mDevice.findObject(new UiSelector().className(android.widget.GridView.class.getName())
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        UiObject expressionDetail = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/gif_img").clickable(true));
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
        //注册uiwatcher
        mDevice.registerWatcher("warnings", watcher);
        //进群组
        discover.click();
        SystemClock.sleep(1000);
        groupChat.clickAndWaitForNewWindow(2500);
        //浏览官方群详细
        officialGroupList.click();
        SystemClock.sleep(1000);
        officialGroup1.clickAndWaitForNewWindow(1500);
        if(groupCover.exists()){
            groupCover.clickAndWaitForNewWindow(1000);
        }
        mDevice.pressBack();
        groupLevel.clickAndWaitForNewWindow(1500);
        levelRefresh.click();
        SystemClock.sleep(1000);
        mDevice.pressBack();
        groupMaster.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        groupMember.clickAndWaitForNewWindow(1500);
        if(groupMemberDetail.exists()){
            groupMemberDetail.clickAndWaitForNewWindow(1500);
            mDevice.pressBack();
        }
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
        //推荐群列表
        recommendGroup.click();
        groupList.flingToEnd(3);
        groupList.scrollForward();
        groupList.flingToEnd(3);
        //最新群列表
        newestGroup.click();
        groupList.flingToEnd(3);
        groupList.scrollForward();
        groupList.flingToEnd(3);
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
        if (create.isEnabled()) {
            create.click();
            SystemClock.sleep(500);
            if (createTag.exists()) {
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
            mDevice.pressBack();
            myGroup.click();
            officialGroup1.click();
            chatSubFunction.click();
            groupData.clickAndWaitForNewWindow(1500);
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
            if (guideImg.exists()){
                guideImg.click();
            }
            mDevice.pressBack();
            if (enterGroupChat.exists()) {
                enterGroupChat.click();
            }
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
            if (dialogNext.exists()) {
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
            } else {
                mDevice.pressBack();
            }
            if (enterTopic.exists()) {
                enterTopic.clickAndWaitForNewWindow(1500);
                mDevice.pressBack();
            }
            //录音
            addRecording.click();
//            if (permit1.exists())
//                permit1.click();
//            else if (permit2.exists())
//                permit2.click();
            startRecording.click();
            SystemClock.sleep(1500);
            longClick(startRecording,2400);
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
                mDevice.pressBack();
                myGroup.click();
            } catch (UiObjectNotFoundException e) {
                mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo" + "/DissolveNotExist.png"));
                fail(e.toString());
            }
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

    @SuppressWarnings("unused")
    private void discover_dyingChatRoom() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //聊天室入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
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
        UiScrollable generalList = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/scroll_lay"));
        //入口
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
        UiObject ability = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(5));
        //标识详情
        UiObject ability_help = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/ability_apply_help"));
        UiObject help_out = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/ability_detail_back"));
        //达人分享
        UiObject ability_share = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/ability_share_btn"));
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
        //日记特权
        UiObject privilege1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_1"));
        //群组特权
        UiObject privilege2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_2"));
        //专属表情信纸
        UiObject privilege3 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_3"));
        //达人任务
        UiObject privilege4 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_4"));
        //人气关注
        UiObject privilege5 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_5"));
        //活动特权
        UiObject privilege6 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_6"));
        //达人申请
        UiObject regist_ability = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(7));
        UiObject category = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_class_radio3").index(2));
        UiObject registText = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()).index(0));
        UiObject registSubmit = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/ability_submit_btn").index(4));

        //动作
        index.click();
        discover.click();
        ability.click();
        //标识详情
        ability_help.clickAndWaitForNewWindow(500);
        help_out.click();
        SystemClock.sleep(300);
        //特权1
        generalList.scrollIntoView(privilege1);
        privilege1.clickAndWaitForNewWindow(300);
        mDevice.pressBack();
        //特权2
        privilege2.clickAndWaitForNewWindow(300);
        mDevice.pressBack();
        //特权3
        privilege3.clickAndWaitForNewWindow(300);
        mDevice.pressBack();
        //特权4
        generalList.scrollIntoView(privilege4);
        privilege4.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        //特权5
        privilege5.clickAndWaitForNewWindow(300);
        mDevice.pressBack();
        //特权6
        privilege6.clickAndWaitForNewWindow(300);
        mDevice.pressBack();
        //分享
        generalList.scrollIntoView(ability_share);
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
        }else if (regist_ability.exists()){
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
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //找找入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
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
        UiObject weChatBack = mDevice.findObject(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0).clickable(true));
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
        UiObject joinCircleInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recgroup_join"));
        UiObject joinCircleInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_group_add_exit"));
        //查看群组详情
        UiObject groupCover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_album_lay").index(0));
        UiObject groupLevel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gc_level_lay"));
        UiObject levelRefresh = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_refresh_btn"));
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
        SystemClock.sleep(5000);
        mDevice.pressBack();
        inviteFromWechat.click();
        SystemClock.sleep(5000);
        if(weChatBack.exists()){
            weChatBack.click();
            weChatExit.clickAndWaitForNewWindow();
        }
        inviteFromTencent.clickAndWaitForNewWindow();
        SystemClock.sleep(5000);
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
        //推荐圈子-列表和详情加圈退圈
        recommendCircle.click();
        SystemClock.sleep(1500);
        if (recommendObjectInfo.exists()) {
            recommendObjectInfo.click();
            SystemClock.sleep(3000);
            joinCircleInDetail.click();
            mDevice.pressBack();
            joinCircleInList.click();
            recommendObjectInfo.click();
            SystemClock.sleep(3000);
            joinCircleInDetail.click();
            mDevice.pressBack();
            joinCircleInList.click();
        }
        recommendList.flingToEnd(3);
        recommendList.scrollForward(50);
        recommendList.scrollForward(50);
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
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //排行榜入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
        UiObject rankingEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover_item_lay").index(7));
        UiObject refresh = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_refresh_btn"));
        UiObject back = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_browser_btn_back"));

        //动作
        discover.click();
        rankingEntrance.clickAndWaitForNewWindow(3000);
        mDevice.takeScreenshot(new File("//storage//sdcard0//AutomatorDemo" + "//rankingDisplay.png"));
        refresh.click();
        SystemClock.sleep(3500);
        back.click();
        index.click();
    }

    private void visitCommunity() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        Random rand = new Random();
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        UiScrollable generalList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())).setAsVerticalList();
        //社区入口
        UiObject community = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns"));
        UiObject labelUI = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hava_tags_lay"));
        //列表切换
        UiObject focusList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_follow_btn"));
        UiObject hotList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_essence_btn"));
        UiObject newList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_newest_btn"));
        //banner
        UiObject banner = mDevice.findObject(new UiSelector().className(android.support.v4.view.ViewPager.class.getName()).index(0)
                .childSelector(new UiSelector().className(android.widget.ImageView.class.getName())));
        //话题banner
        UiScrollable topicScroll = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_dtopic_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))).setAsHorizontalList();
        UiObject tbanner1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_timeline_backlay").index(0));
        UiObject tbannermore = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/hot_timeline_backlay").index(5));
        UiObject moreTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dtopic_lay").index(rand.nextInt(5)));
        //社区列表中头像
        UiObject portraitInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_portrait_lay"));
        //列表中图片
        UiObject imageInContent = mDevice.findObject(new UiSelector().resourceIdMatches("pinkdiary.xiaoxiaotu.com:id/sns_list_item_imageatt")
                .childSelector(new UiSelector().className(android.widget.ImageView.class.getName()).index(0)));
        UiObject swipeImage = mDevice.findObject(new UiSelector().className(android.support.v4.view.ViewPager.class.getName()));
        UiObject zoomImage = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_viewatt_image"));
        UiObject saveImage = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/save_btn"));
        //列表--转发/评论
        UiObject transpondInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_transpond_lay"));
        UiObject reviewInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_review_lay"));
        UiObject transpondEditText = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject transpondTansfer = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject transpondIcon = mDevice.findObject(new UiSelector().className(android.widget.GridView.class.getName())
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject transpondConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_send"));
        //列表--喜欢
        UiObject likeInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_like_lay"));
        //列表--分享
        UiObject shareInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_share_lay"));
        //列表--话题
        UiObject topicInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/timeline_square_dtopic"));
        //列表--LBS
        UiObject locationInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/timeline_square_location"));
        //热门列表--精选话题1
        UiObject hotTopicInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_essence_url_struct1"));
        UiScrollable DetailList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()));
        UiObject jumpToCircle = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_essence_url_group_name1"));
        //点滴详情
        UiObject diaryDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_diary_list_mainlay"));
        UiScrollable diaryCommentList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()));
        UiObject followInDiaryDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_follow_btn"));
        UiObject enterUserInfo = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_user_brief_info_lay"));
        UiObject followInUserInfo = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsherinfo_followed_lay"));
        UiObject diaryImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_viewatt_image"));
        UiObject topicInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_topic_name"));
        UiObject locationInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_diary_detail_location"));
        UiObject commentSummary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsdiarydetail_comment_layout"));
        // 历史版本回复按钮
        // UiObject replyInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsdiarydetail_commentlist_reply_img"));
        UiObject likeComment = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/diary_detail_like_lay"));
        UiObject replyComment = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/diary_detail_comment"));
        UiObject transpondInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsdiarydetail_transpond_btn"));
        UiObject reviewInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsdiarydetail_comment_btn"));
        UiObject likeInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsdiarydetail_like_btn"));
        UiObject shareInDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/diary_detail_share"));
        UiObject moreFunction = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsdiarydetail_more_btn"));
        UiObject accuse = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1)
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiScrollable floorList = new UiScrollable(new UiSelector().resourceId("android:id/list"));
        //话题、位置详情列表
        UiObject detailFromAdditionalList = new UiObject(new UiSelector().className(android.widget.TextView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/txt_plazatimeline_content"));
        UiObject createDiaryFromBannerDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/dtopic_list_add"));
        UiObject createDiaryGuide = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_keepdiary_guide_layout"));
        //社区用户推荐
        UiObject userRecommend = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_list_message_add_attention_btn"));
        UiScrollable recommendTabPage = new UiScrollable(new UiSelector().className(android.support.v4.view.ViewPager.class.getName()));
        UiObject recommendTabButton = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))));
        UiObject officalUser1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/official_gc_ly1"));
        UiObject officalUserDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_portrait"));
        UiObject portaitAlbum = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_album_img"));
        UiObject recommendUserInfo = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recommend_lay"))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recommend_list_lay")));
        UiObject recommendFollowInList = mDevice.findObject(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(5)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recommend_lay"))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_recommend_list_lay"))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_myfans_userinfo_lay"))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsfeed_recomuser_item_follow")));
        UiObject addLabel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/comment_add_attention_btn"));

        //动作
        //进入社区
        index.click();
        community.click();
        SystemClock.sleep(1000);
        if (labelUI.exists())
            mDevice.pressBack();
        //进banner
        hotList.click();
        generalList.flingToBeginning(1);
        banner.clickAndWaitForNewWindow(2500);
        SystemClock.sleep(1500);
        mDevice.pressBack();
        //话题banner
        tbanner1.clickAndWaitForNewWindow(1500);
        generalList.flingToEnd(5);
        generalList.swipeUp(30);
        generalList.flingToEnd(1);
        mDevice.pressBack();
        topicScroll.flingToEnd(2);
        if (tbannermore.exists()){
            tbannermore.clickAndWaitForNewWindow(1500);
            generalList.flingToEnd(5);
            moreTopic.clickAndWaitForNewWindow(1500);
            mDevice.pressBack();
            moreTopic.clickAndWaitForNewWindow(1500);
            mDevice.pressBack();
            mDevice.pressBack();
        }
        //社区列表翻页
        generalList.flingToEnd(8);
        generalList.scrollForward(70);
        generalList.flingToEnd(1);
        //点击个人头像
        if (portraitInList.exists()){
            portraitInList.clickAndWaitForNewWindow(1500);
            mDevice.pressBack();
        }
        //点击列表中图片
        generalList.scrollIntoView(imageInContent);
        imageInContent.clickAndWaitForNewWindow(1500);
        swipeImage.swipeLeft(50);
        swipeImage.swipeLeft(50);
        if (currentApiVersion>=18) {
            doubleClick(2, zoomImage);
            SystemClock.sleep(2500);
            doubleClick(2, zoomImage);
        }
        saveImage.click();
        mDevice.pressBack();
        //列表中转发、评论
        generalList.scrollIntoView(transpondInList);
        transpondInList.click();
        transpondEditText.setText("赞~！");
        transpondTansfer.click();
        transpondIcon.click();
        transpondIcon.click();
        transpondIcon.click();
        transpondConfirm.click();
        SystemClock.sleep(2500);
        reviewInList.click();
        transpondEditText.setText("好评~！");
        transpondConfirm.click();
        SystemClock.sleep(2500);
        //列表-喜欢,分享
        likeInList.click();
        likeInList.click();
        shareInList.click();
        mDevice.pressBack();
        //热门-话题
        generalList.flingToBeginning(6);
        generalList.scrollIntoView(hotTopicInList);
        hotTopicInList.clickAndWaitForNewWindow(2500);
        DetailList.flingToEnd(3);
        DetailList.swipeUp(70);
        SystemClock.sleep(500);
        mDevice.pressBack();
        generalList.scrollIntoView(jumpToCircle);
        jumpToCircle.clickAndWaitForNewWindow(2500);
        mDevice.pressBack();
        //热门-日记详情
        generalList.scrollIntoView(diaryDetail);
        diaryDetail.clickTopLeft();
        //日记详情关注
        if(followInDiaryDetail.exists()){
            followInDiaryDetail.click();
        }
        enterUserInfo.clickAndWaitForNewWindow(2500);
        followInUserInfo.click();
        mDevice.pressBack();
        //图片详情
        diaryCommentList.scrollIntoView(commentSummary);
        if (imageInContent.exists()){
            imageInContent.click();
            diaryImg.swipeLeft(50);
            diaryImg.swipeLeft(50);
            mDevice.pressBack();
        }
        //日记评论列表翻页
        diaryCommentList.flingToEnd(6);
        diaryCommentList.swipeDown(50);
        //转发、评论
        transpondInDetail.click();
        transpondEditText.setText("赞~！");
        transpondConfirm.click();
        SystemClock.sleep(2500);
        reviewInDetail.click();
        transpondEditText.setText("好评~！");
        transpondConfirm.click();
        SystemClock.sleep(2500);
        //点赞楼层
        floorList.scrollIntoView(likeComment);
        likeComment.click();
        likeComment.click();
        //回复楼层
        replyComment.click();
        transpondEditText.setText("nice~!");
        SystemClock.sleep(3000);
        transpondConfirm.click();
        SystemClock.sleep(2500);
        //喜欢
        likeInDetail.click();
        likeInDetail.click();
        //分享
        shareInDetail.click();
        mDevice.pressBack();
        moreFunction.click();
        //举报
        accuse.clickAndWaitForNewWindow(1000);
        mDevice.pressBack();
        //回到社区列表
        mDevice.pressBack();
        //关注列表-翻页
        focusList.click();
        generalList.flingToEnd(8);
        generalList.scrollForward(70);
        generalList.flingToEnd(1);
        //最新列表-翻页
        newList.click();
        generalList.flingToEnd(8);
        generalList.scrollForward(70);
        generalList.flingToEnd(1);
        //最新列表--找到并进入话题列表
        try{
            generalList.scrollIntoView(topicInList);
            topicInList.clickAndWaitForNewWindow(1500);
            //新建点滴快捷入口
            createDiaryFromBannerDetail.clickAndWaitForNewWindow(300);
            if (createDiaryGuide.exists()){
                createDiaryGuide.click();
            }
            mDevice.pressBack();
            //话题列表翻页
            generalList.flingToEnd(3);
            generalList.swipeUp(50);
            generalList.flingToEnd(1);
            //进详情
            generalList.scrollIntoView(detailFromAdditionalList);
            detailFromAdditionalList.click();
            //日记详情再跳一次话题列表(增加if判断加快运行效率)
            if (topicInDetail.exists()){
                topicInDetail.clickAndWaitForNewWindow(1500);
            }else{
                diaryCommentList.scrollIntoView(topicInDetail);
                topicInDetail.clickAndWaitForNewWindow(1500);
            }
            generalList.flingToEnd(3);
            //返回最新列表
            mDevice.pressBack();
            mDevice.pressBack();
            mDevice.pressBack();
        }catch (Exception e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/NoTopicInList.png"));
            fail(e.toString());
        }
        //最新列表--找到并进入LBS列表
        try{
            generalList.scrollIntoView(locationInList);
            locationInList.clickAndWaitForNewWindow(1500);
            //话题列表翻页
            generalList.flingToEnd(5);
            generalList.swipeUp(50);
            generalList.flingToEnd(1);
            //进详情
            generalList.scrollIntoView(detailFromAdditionalList);
            detailFromAdditionalList.click();
            //日记详情再跳一次话题列表(增加if判断加快运行效率)
            if (locationInDetail.exists()){
                locationInDetail.clickAndWaitForNewWindow(1500);
            }else {
                diaryCommentList.scrollIntoView(locationInDetail);
                locationInDetail.clickAndWaitForNewWindow(1500);
            }
            generalList.flingToEnd(3);
            //返回最新列表
            mDevice.pressBack();
            mDevice.pressBack();
            mDevice.pressBack();
        }catch (Exception e){
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/NoLocationInList.png"));
            fail(e.toString());
        }
        //社区-用户推荐
        userRecommend.clickAndWaitForNewWindow(2500);
        //推荐-翻页
        recommendTabPage.flingToEnd(3);
        recommendTabPage.swipeUp(50);
        recommendTabPage.flingToBeginning(3);
        //查看官方账号详情
        officalUser1.clickAndWaitForNewWindow(1500);
        officalUserDetail.clickAndWaitForNewWindow(1500);
        portaitAlbum.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        mDevice.pressBack();
        mDevice.pressBack();
        //切换至相同属性列表
        recommendTabButton.click();
        recommendTabPage.flingToEnd(3);
        recommendTabPage.swipeUp(50);
        recommendTabPage.flingToBeginning(3);
        if (recommendFollowInList.exists()){
            recommendFollowInList.click();
            recommendUserInfo.clickAndWaitForNewWindow(1500);
            followInUserInfo.click();
            mDevice.pressBack();
        }else if (addLabel.exists()){
            addLabel.clickAndWaitForNewWindow(1000);
            mDevice.pressBack();
        }
        //返回主界面
        mDevice.pressBack();
        index.click();
    }

    @SuppressWarnings("unused")
    private void publishCommunityDiary() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        Random rand = new Random();
        //授权允许
        final UiObject permit1 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).index(1));
        final UiObject permit2 = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName()).resourceId("android:id/button1"));
        UiWatcher watcher = new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                try {
                    if (permit1.exists()){
                        permit1.click();
                        return true;
                    }
                    else if (permit2.exists()){
                        permit1.click();
                        return true;
                    }
                }catch (UiObjectNotFoundException e){
                    fail(e.toString());
                }
                return false;
            }
        };
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //社区入口
        UiObject community = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns"));
        //进入写日记
        UiObject editAccount = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_account_edt"));
        UiObject editPassword = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_pwd_edt"));
        UiObject loginButton = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/login_login_btn"));
        UiObject createWordDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_word_lay"));
        UiObject createPhotoDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_photo_lay"));
        UiObject createRecordDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_audio_lay"));
        UiObject createTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_group_lay"));
        UiObject cancelCreate = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_button_cross"));
        //日记内容
        UiObject title = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_title_input"));
        UiObject context = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_body_input"));
        //天气心情详情
        UiObject chooseWeather = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/viewdiary_weather_imgbtn"));
        UiObject chooseMood = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/view_diary_emotion_imgbtn"));
        UiObject changeWeather = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/select_tag_gridview_weather")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(rand.nextInt(16))));
        UiObject changeMood = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/select_tag_gridview_emotion")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(rand.nextInt(16))));
        UiObject confirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_iv_sure"));
        //字体字号颜色
        UiObject fontSettings = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_txt_style"));
        UiObject selectFontStyle = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/text_font_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(rand.nextInt(3))));
        UiObject addFontStyle = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/text_font_img"));
        UiObject fontItem1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_font_list_item_lay").index(rand.nextInt(5)));
        UiObject fontItem2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_font_list_item_lay").index(rand.nextInt(5)));
        UiObject downloadFont = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/font_detail_buy_lay"));
        UiObject fontSize = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/text_size_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(2)));
        UiObject fontColor = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/text_color_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        //信纸
        UiObject addPaper = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_paper"));
        UiObject enterPaperShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/add_more_paper"));
        UiObject generalList = mDevice.findObject(new UiSelector().resourceId("android:id/list"));
        UiObject hotlist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1))
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject newlist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0))
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject freelist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/indicator")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2))
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject paperItem1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/list_paper_item_rl").index(2));
        UiObject paperItem2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/list_paper_item_rl").index(3));
        UiObject buyPaper = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_detail_buy_lay"));
        UiObject paperColumn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_item_hs"));
        UiObject recentPaper = new UiObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0)));
        UiObject paperColumnItem1 = new UiObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        UiObject paperColumnItem2 = new UiObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(2)));
        UiObject paperList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/page_item_grid"));
        UiObject choosePaper = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/page_item_grid")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).clickable(true).index(3)));
        //录音
        UiObject enterRecord = mDevice.findObject(new UiSelector().className(android.widget.ImageView.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/add_audio").clickable(true));
        UiObject startRecord = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/audio_view_img_bg"));
        UiObject reRecord = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/audio_view_remake"));
        UiObject deleteRecord = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/audio_view_delete"));
        //照片
        UiObject addImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_attach_first_image_preview"));
        //选择照片
        UiObject chooseImg1 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(2)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg2 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(3)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg3 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(4)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg4 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(5)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg5 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(6)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg6 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(7)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg7 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(8)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg8 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(9)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        UiObject chooseImg9 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(10)
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/checkmark")));
        //编辑照片-裁剪照片
        UiObject Img9 = mDevice.findObject(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(10));
        UiObject cutImage = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_cutButton"));
        UiObject cutBy2_3 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_ratio_2_3_Button"));
        UiObject cutBy9_16 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_ratio_9_16_Button"));
        UiObject turnImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_trunButton"));
        UiObject mirrorImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_mirrorButton"));
        //编辑照片-添加滤镜
        UiObject filter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filterButton"));
        UiScrollable changeFilterGroup = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_group_list_view")).setAsHorizontalList();
        UiObject chooseFilterGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_group_list_view")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(4)));
        UiScrollable scanFilter = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filter_list_view")).setAsHorizontalList();
        UiObject chooseFilter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filter_list_view")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        UiObject dragPoint = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_seekDrag"));
        UiObject resetDragPoint = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_rest_button"));
        UiObject hueLabel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_params_view")
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName()).index(0)));
        UiObject rangeLabel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_params_view")
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName()).index(1)));
        //滤镜确认/返回
        UiObject filterConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_bar_completeButton"));
        UiObject backFromFilter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filter_back_button"));
        //编辑照片-确认编辑
        UiObject editImgConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_completeButton"));
        //预览图片
        UiObject preview = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/preview"));
        UiObject previewDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/viewpagerLayout"));
        //切换相册
        UiObject categoryColumn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/category_btn"));
        UiObject category = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/multi_image_list")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        //确认选择图片
        UiObject imgConfirm = mDevice.findObject(new UiSelector().className(android.widget.Button.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/commit"));
        //滑动-删除-重新添加图片
        UiScrollable scrollImgList = new UiScrollable(new UiSelector().className(android.widget.GridView.class.getName())).setAsHorizontalList();
        UiObject deleteImg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/delete_image"));
        UiObject addImgInList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/thumbnail_image"));
        //表情
        UiObject addEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject enterEmotionShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(0)));
        UiObject emotionItem1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_emotion_list_item_lay").index(2));
        UiObject emotionItem2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_emotion_list_item_lay").index(3));
        UiObject buyEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_detail_buy_lay"));
        UiObject emotionColumn = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_hs"));
        UiObject emotionColumnItem1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        UiObject emotionColumnItem2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(2)));
        UiObject emotionColumnItem3 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_lay")
                .childSelector(new UiSelector().className(android.widget.GridView.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(3)));
        UiObject columDetailList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_panel_pager_vp"));
        UiObject heart = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_item_grid")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject chooseEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/item_emotion_pager_lay").index(1));
        UiObject deleteEmotion = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/delete_emotion"));
        //添加话题
        UiObject topicEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/create_dtopic_txt"));
        UiScrollable topicList = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/scroll_lay"));
        UiObject editTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/topic_create_et"));
        UiObject confirmTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/diarytopic_create_sure"));
        UiObject historyTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/history_diary_topic_listview")
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_class_lay").index(1)));
        UiObject hotTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/diary_topic_listview")
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_ability_class_lay").index(1)));
        //选择位置
        UiObject location = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/location_layout"));
        //准备发布点滴
        UiObject cancelPublish = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_btn_back"));
        UiObject readyToPublish = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snskeepdiary_btn_save"));
        //日记公开
        UiObject isPublic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/is_public"));
        //添加,修改标签(功能已取消)
        //分享
        UiObject share_denied = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_dialog_bt_positiveButton"));
        UiObject share_qzone = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_qzone"));
        UiObject share_qq = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_qq"));
        UiObject share_sina = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_sina"));
        UiObject share_wechat = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_weixin"));
        UiObject share_wechat_circle = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_weixin_circle"));
        UiObject cancel_wechat_circle_share = mDevice.findObject(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1)
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName())
                        .childSelector(new UiSelector().className(android.widget.Button.class.getName()).index(1))));
        UiObject share_tencent = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_tencent"));
        UiObject share_renren = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_renren"));
        UiObject share_sms = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/umeng_share_sms"));
        //完成发布
        UiObject publish = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_diary_release"));
        //取消保存，（不）保存草稿
        UiObject saveDraft = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/content_list")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1)));
        UiObject abandonDraft = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/content_list")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject abandonCancel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/content_list")
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(3)));

        //动作
        //注册UiWatcher
        mDevice.registerWatcher("warnings", watcher);
        //检查3个写点滴入口
        community.click();
        SystemClock.sleep(500);
        community.click();
        SystemClock.sleep(500);
        if (editAccount.exists()){
            editAccount.setText("test6789");
            editPassword.setText("q");
            loginButton.click();
            SystemClock.sleep(1800);
        }
        if (!createWordDiary.exists()){
            community.click();
            SystemClock.sleep(500);
        }
        createWordDiary.clickAndWaitForNewWindow(1000);
        mDevice.pressBack();
        SystemClock.sleep(500);
        community.click();
        createRecordDiary.click();
        SystemClock.sleep(1500);
        //放弃编辑，录音存草稿
        mDevice.pressBack();
        SystemClock.sleep(300);
        for (int i = 0; i<5; i++) {
            if (saveDraft.exists()) {
                saveDraft.click();
                SystemClock.sleep(300);
                break;
            }
            else
                mDevice.pressBack();
        }
        //顺便测一下从+号进圈子的功能
        community.click();
        createTopic.clickAndWaitForNewWindow(500);
        mDevice.pressBack();
        //测试x号有效性
        community.click();
        cancelCreate.click();
        //从添加照片开始新建社区点滴
        community.click();
        createPhotoDiary.clickAndWaitForNewWindow(1000);
        chooseImg1.click();
        chooseImg2.click();
        chooseImg3.click();
        chooseImg4.click();
        chooseImg5.click();
        chooseImg6.click();
        chooseImg7.click();
        chooseImg8.click();
        chooseImg9.click();
        //裁剪照片9
        Img9.clickAndWaitForNewWindow(500);
        cutImage.clickAndWaitForNewWindow(500);
        cutBy2_3.click();
        cutBy9_16.click();
        turnImg.click();
        turnImg.click();
        mirrorImg.click();
        mirrorImg.click();
        editImgConfirm.click();
        //增加滤镜
        filter.click();
        changeFilterGroup.flingToEnd(2);
        chooseFilterGroup.click();
        scanFilter.flingToEnd(1);
        chooseFilter.click();
        chooseFilter.click();
        int dragX = dragPoint.getBounds().centerX();
        int dragY = dragPoint.getBounds().centerY();
        dragPoint.dragTo(dragX - 350, dragY, 2);
        resetDragPoint.click();
//        rangeLabel.click();
        dragPoint.dragTo(dragX + 500, dragY, 2);
//        hueLabel.click();
        dragPoint.dragTo(dragX - 300, dragY, 2);
        filterConfirm.click();
        editImgConfirm.click();
        editImgConfirm.click();
        //贴纸为混合h5，uiautomator跳过
        SystemClock.sleep(3000);
        //预览
        preview.clickAndWaitForNewWindow(500);
        previewDetail.swipeLeft(30);
        previewDetail.swipeLeft(30);
        previewDetail.swipeLeft(30);
        //双击放大&失效对策
        doubleClick(2,previewDetail);
        if (previewDetail.exists())
            doubleClick(2,previewDetail);
        if (previewDetail.exists())
            previewDetail.click();
        //切换相册
        categoryColumn.click();
        category.click();
        imgConfirm.click();
        SystemClock.sleep(500);
        //滑动-删除-重新添加图片
        for (int i=0;i<9;i++){
            if (deleteImg.exists())
                deleteImg.click();
        }
        addImgInList.clickAndWaitForNewWindow(500);
        chooseImg1.click();
        chooseImg2.click();
        chooseImg3.click();
        chooseImg4.click();
        chooseImg5.click();
        chooseImg6.click();
        chooseImg7.click();
        chooseImg8.click();
        chooseImg9.click();
        imgConfirm.click();
        SystemClock.sleep(500);
        scrollImgList.flingToEnd(3);
        addImg.click();
        //添加话题
        topicEntrance.clickAndWaitForNewWindow(1500);
        editTopic.clearTextField();
        editTopic.setText("啊哇哇哇哇");
        confirmTopic.click();
        SystemClock.sleep(500);
        topicEntrance.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        SystemClock.sleep(1500);
        topicList.scrollIntoView(hotTopic);
        hotTopic.click();
        SystemClock.sleep(500);
        topicEntrance.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        if (historyTopic.exists())
            historyTopic.click();
        else
            mDevice.pressBack();
        SystemClock.sleep(500);
        //天气心情
        chooseWeather.clickAndWaitForNewWindow(500);
        changeWeather.click();
        changeMood.click();
        confirm.click();
        SystemClock.sleep(500);
        chooseMood.clickAndWaitForNewWindow(500);
        mDevice.pressBack();
        SystemClock.sleep(500);
        //添加正文
        context.clearTextField();
        context.setText("野生的测试姬出现了！！！" + rand.nextInt(10000));
        //添加表情
        addEmotion.click();
        //购买免费表情
        enterEmotionShop.clickAndWaitForNewWindow(1500);
        hotlist.click();
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        newlist.click();
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        freelist.click();
        emotionItem1.clickAndWaitForNewWindow(1500);
        buyEmotion.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        emotionItem2.clickAndWaitForNewWindow(1500);
        buyEmotion.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        mDevice.pressBack();
        emotionColumn.swipeLeft(3);
        emotionColumn.swipeLeft(5);
        emotionColumnItem1.click();
        heart.click();
        heart.click();
        heart.click();
        SystemClock.sleep(500);
        emotionColumnItem2.click();
        chooseEmotion.click();
        chooseEmotion.click();
        SystemClock.sleep(500);
        emotionColumnItem3.click();
        columDetailList.swipeLeft(3);
        chooseEmotion.click();
        chooseEmotion.click();
        chooseEmotion.click();
        chooseEmotion.click();
        chooseEmotion.click();
        deleteEmotion.click();
        deleteEmotion.click();
        SystemClock.sleep(500);
        //信纸
        addPaper.click();
        enterPaperShop.clickAndWaitForNewWindow(1500);
        hotlist.click();
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        newlist.click();
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        generalList.swipeUp(3);
        freelist.click();
        paperItem1.clickAndWaitForNewWindow(1500);
        buyPaper.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        paperItem2.clickAndWaitForNewWindow(1500);
        buyPaper.click();
        SystemClock.sleep(2500);
        mDevice.pressBack();
        mDevice.pressBack();
        paperColumn.swipeLeft(3);
        paperColumn.swipeRight(5);
        paperColumnItem1.click();
        paperList.swipeLeft(2);
        paperList.swipeRight(3);
        choosePaper.click();
        paperColumnItem2.click();
        paperList.swipeLeft(2);
        if (choosePaper.exists())
            choosePaper.click();
        recentPaper.click();
        if (choosePaper.exists())
            choosePaper.click();
        addPaper.click();
        //字体
        fontSettings.click();
        addFontStyle.clickAndWaitForNewWindow(1500);
        fontItem1.clickAndWaitForNewWindow(500);
        downloadFont.click();
        mDevice.pressBack();
        fontItem2.clickAndWaitForNewWindow(500);
        downloadFont.click();
        mDevice.pressBack();
        mDevice.pressBack();
        selectFontStyle.click();
        selectFontStyle.click();
        fontSize.click();
        fontSize.click();
        fontColor.click();
        fontColor.click();
        fontSettings.click();
        //录音
        try {
            enterRecord.click();
            SystemClock.sleep(1000);
            //停止录音按钮坐标
            int recordButtonX = startRecord.getBounds().centerX();
            int recordButtonY = startRecord.getBounds().centerY();
            //开始录音
            mDevice.click(recordButtonX,recordButtonY);
            SystemClock.sleep(5000);
            mDevice.click(recordButtonX, recordButtonY);
            SystemClock.sleep(500);
            reRecord.click();
            SystemClock.sleep(5000);
            mDevice.click(recordButtonX, recordButtonY);
            SystemClock.sleep(500);
            deleteRecord.click();
            SystemClock.sleep(1000);
            mDevice.click(recordButtonX, recordButtonY);
            SystemClock.sleep(15000);
            mDevice.click(recordButtonX, recordButtonY);
            SystemClock.sleep(500);
            enterRecord.click();
        } catch (UiObjectNotFoundException e) {
            mDevice.takeScreenshot(new File("/storage/sdcard0/AutomatorDemo"+"/EndRecordNotExist.png"));
            fail(e.toString());
        }
        //位置（随机是否显示）
        for (int i = 0; i < rand.nextInt(2) + 1; i++)
            location.click();
        //公开/私密(随机)
        for (int i = 0; i < rand.nextInt(2) + 1; i++)
            isPublic.click();
        //发布/取消发布
        cancelPublish.click();
        abandonCancel.click();
        readyToPublish.clickAndWaitForNewWindow(5000);
        //发布后分享(容易乱跳，建议直接手动测试)
        /*
        share_qzone.click();
        SystemClock.sleep(500);
        if (share_denied.exists()){
            share_denied.click();
        } else {
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
            share_qq.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
            share_sina.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
            share_wechat.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
            share_wechat_circle.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                if (cancel_wechat_circle_share.exists())
                    cancel_wechat_circle_share.click();
                else
                    mDevice.pressBack();
            }
            share_tencent.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
            share_renren.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
            share_sms.click();
            SystemClock.sleep(500);
            while (!share_qzone.exists()){
                mDevice.pressBack();
            }
        }
        */
        //发布
        publish.click();
        SystemClock.sleep(3000);
        index.click();
    }

    private void notification() throws UiObjectNotFoundException{
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        //消息入口
        UiObject discover = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/discover"));
        UiObject noticeEntrance = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/dynamic"));
        //动态&通知&聊天
        UiScrollable list = new UiScrollable(new UiSelector().resourceId("android:id/list")).setAsVerticalList();
        UiObject listItem = mDevice.findObject(new UiSelector().resourceId("android:id/list")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(1)));
        //动态标签
        UiObject dynamic = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_rb_me_attention"));
        //通知标签
        UiObject notice = mDevice.findObject(new UiSelector().className(android.widget.RadioButton.class.getName())
                .resourceId("pinkdiary.xiaoxiaotu.com:id/sns_rb_relation_me"));
        //聊天标签
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
            back.click();
        }
        list.flingToEnd(2);
        notice.click();
        if (listItem.exists()) {
            listItem.clickAndWaitForNewWindow(1500);
            back.click();
        }
        list.flingToEnd(2);
        privateMessage.click();
        if (listItem.exists()) {
            listItem.clickAndWaitForNewWindow(1500);
            back.click();
        }
        list.flingToEnd(2);
        //回到主页
        index.click();
    }

    private void mine() throws UiObjectNotFoundException{
        final UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        Random rand = new Random();
        UiScrollable generalList = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName())).setAsVerticalList();
        //控件
        UiObject index = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/home"));
        UiObject mine = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/mine"));
        //入口
        UiObject account = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_acc_pink_lay"));
        UiObject follow = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/follow_lay"));
        UiObject fans = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/fan_lay"));
        UiObject myDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/my_diary_lay"));
        UiObject snsDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_diary_lay"));
        UiObject timeMachine = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/time_machine_lay").index(6)
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(0)));
        UiObject coinCenter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/time_machine_lay").index(6)
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(1)));
        UiObject dress = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/specific_dress_lay"));
        UiObject settings = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/setting_lay"));
        //个人主页
        UiObject editInfo = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/edit_info"));
        //标签
        UiObject tag1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_tag_tv_1"));
        UiObject tag5 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_tag_tv_5"));
        int tempA = rand.nextInt(5)+1;
        UiObject userOfSameInterest = mDevice.findObject(new UiSelector().className(android.widget.ListView.class.getName())
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(tempA)));
        UiObject followUserOfSameInterest = mDevice.findObject(new UiSelector().className(android.widget.ListView.class.getName())
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(tempA))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsfeed_recomuser_item_follow")));
        UiObject userRecommend = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_list_message_add_attention_btn"));
        //头像
        UiObject portrait = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_portrait"));
        //等级
        UiObject level = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/show_user_level_img"));
        UiScrollable levelScroll = new UiScrollable(new UiSelector().className(android.widget.ScrollView.class.getName())).setAsVerticalList();
        //关注
        UiObject follownum = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_follow_num_txt"));
        UiObject followUser = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_item_people_follow_lay").index(1));
        //粉丝
        UiObject fansnum = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_fans_num_txt"));
        UiObject fanUser = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_item_people_follow_lay").index(rand.nextInt(5)+1));
        //话题
        UiObject topicnum = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_topic_layout"));
        //喜欢
        UiObject likenum = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_like_layout"));
        //点滴列表
        UiObject diaryList = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/diary_item_lay"));

        UiObject deletePCDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_mydiary_list_delete"));
        UiObject review = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_review_lay"));
        UiObject transpond = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_transpond_lay"));
        UiObject like = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_like_lay"));
        UiObject share = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_plazatimeline_share_lay"));
        UiObject transpondEditText = mDevice.findObject(new UiSelector().className(android.widget.EditText.class.getName()));
        UiObject transpondTansfer = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/icon_btn"));
        UiObject transpondIcon = mDevice.findObject(new UiSelector().className(android.widget.GridView.class.getName())
                .childSelector(new UiSelector().className(android.widget.LinearLayout.class.getName()).index(2)));
        UiObject transpondConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/btn_send"));

        //个人资料
        //头像
        UiObject addPhoto = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/gc_cover_item_jiahao"));
        UiObject choosePhoto = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/grid")
                .childSelector(new UiSelector().className(android.widget.FrameLayout.class.getName()).index(rand.nextInt(10) + 1)));
        UiObject turnPhoto = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_trunButton"));
        UiObject mirrorPhoto = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_mirrorButton"));
        UiObject filter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filterButton"));
        UiScrollable groupList = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_group_list_view")).setAsHorizontalList();
        UiObject chooseGroup = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_group_list_view")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(rand.nextInt(5))));
        UiScrollable filterList = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filter_list_view")).setAsHorizontalList();
        UiObject chooseFilter = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_filter_list_view")
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()).index(rand.nextInt(4) + 1)));
        UiObject editComplete = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/lsq_completeButton"));
        UiObject avatar1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/gcimg_edit_lay").index(0));
        UiObject avatar2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/gcimg_edit_lay").index(1));
        UiObject avatarDetail = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_viewavatar_img"));
        UiObject avatarDelete = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_gcCover_delete"));
        UiObject confirmDelete = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(1)
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        UiObject cancelDelete = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/popup_layout").index(2)
                .childSelector(new UiSelector().className(android.widget.TextView.class.getName())));
        //昵称
        UiObject reviseNickname = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsmyprofile_edit_nickname_layout"));
        UiObject edit = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_edit_input_save"));
        UiObject nicknameConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_edit_input_btn_ok"));
        //性别
        UiObject reviseGender = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsmyprofile_edit_gender_layout"));
        UiObject woman = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_showsex_dialog_button1"));
        UiObject man = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_showsex_dialog_button2"));
        UiObject secret = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_showsex_dialog_button3"));
        //年龄
        UiObject reviseAge = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsmyprofile_edit_gender_layout"));
        UiScrollable birthYear = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/time_year")).setAsVerticalList();
        UiScrollable birthMonth = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/time_month")).setAsVerticalList();
        UiScrollable birthDay = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/time_day")).setAsVerticalList();
        UiObject ageCancel = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/dialog_cancel"));
        UiObject ageConfirm = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/dialog_ok"));
        //城市
        UiObject reviseCity = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/edit_city_layout"));
        UiObject editCity = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_location_item").index(rand.nextInt(10)));
        //签名
        UiObject reviseSign = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsmyprofile_edit_sign_layout"));
        //标签
        UiObject reviseTag = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsmyprofile_edit_tag_layout"));
        UiObject chosenTag1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_hava_tags_gv")
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(0)));
        UiObject chosenTag3 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_hava_tags_gv")
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(2)));
        UiObject chosenTag5 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/user_hava_tags_gv")
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(4)));
        UiScrollable tagColumn = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/fancyCoverFlow")).setAsHorizontalList();
        UiObject tagColumnItem = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/fancyCoverFlow")
                .childSelector(new UiSelector().className(android.view.View.class.getName()).index(rand.nextInt(4))));
        UiObject selectTag1 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(0));
        UiObject selectTag2 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(6));
        UiObject selectTag3 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(9));
        UiObject selectTag4 = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/all_tags_lay").index(15));
        UiObject confirmTag = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_edit_tags_btn_ok"));
        //关注详情
        //TODO
        UiObject editRemark = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_mask_her"));
        UiObject remarkText = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_edit_input_mask"));
        UiObject confirmRemark = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_maskset_ok"));
        UiObject sendMsg = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsherinfo_sendmsg_lay"));
        UiObject followState = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snsherinfo_followed_lay"));
        UiObject accuse = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/sns_her_more_lay"));

        //个性装扮
        UiObject skinShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/skin_lay"));
        UiObject paperShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/paper_lay"));
        UiObject fontShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/font_lay"));
        UiObject emotionShop = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/emotion_lay"));
        //社区点滴
        UiObject publicDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/public_diary_lay"));
        UiObject secretDiary = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/secret_diary_lay"));
        UiObject myTopic = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/my_topic_lay"));
        UiObject myLike = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/my_like_lay"));
        UiObject myComment = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/my_comments_lay"));
        UiObject draft = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/drafts_lay"));
        //设置
        //账号管理
        //TODO

        //密码锁
        //TODO

        //消息通知
        UiObject remindSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/news_remind_lay"));
        UiScrollable remindList = new UiScrollable(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/big_parm_body_lay"));
        UiObject messageSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_message_lay"));
        UiObject commentSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_comment_lay"));
        UiObject newFansSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_new_fans_lay"));
        UiObject activitySwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_activity_lay"));
        UiObject soundSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_sound_lay"));
        UiObject dailyRemind = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_daily_remind_lay"));
        UiObject dailyRemindSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/setup_daily_remind_if_lay"));
        UiObject dailyRemindTime = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/setup_daily_remind_time_lay"));
        UiObject disturbSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_night_prevent_disturb_lay"));
        UiObject pushContentSwitch = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_display_push_content_lay"));
        //同步管理
        //TODO

        //备份恢复
        //TODO

        //通用设置
        UiObject generalSettings = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/general_setting_lay"));
        UiObject noPicMode = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/no_pic_lay"));
        UiObject watermark = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/water_mark_lay"));
        UiObject randomPaper = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/pager_random_lay"));
        UiObject cleanCache = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_cache_clean"));
        //快捷图标
        UiObject shortcut = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_shortcut_lay"));
        //关于粉粉
        UiObject aboutPink = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_about_lay"));
        //社区公约
        UiObject convention = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_gongyue_lay"));
        //新版本检测
        UiObject versionCheck = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_version_check_lay"));
        //问题反馈
        UiObject feedback = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_feedback_lay"));
        UiObject webviewRefresh = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/web_right_refresh_btn"));
        //黑名单
        UiObject blacklist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/parm_black_lay"));
        UiObject inBlacklist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_activity_lay").index(1));
        UiObject removeFromBlacklist = mDevice.findObject(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/push_activity_lay").index(1)
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()))
                .childSelector(new UiSelector().className(android.widget.RelativeLayout.class.getName()))
                .childSelector(new UiSelector().resourceId("pinkdiary.xiaoxiaotu.com:id/snspeople_black_remove_btn")));

        //动作
        //进入个人主页
        mine.click();
        account.clickAndWaitForNewWindow(2500);
        //进入个人资料编辑界面
        editInfo.clickAndWaitForNewWindow(500);
        //修改头像
        if (addPhoto.exists()){
            choosePhoto.clickAndWaitForNewWindow(1500);
            turnPhoto.click();
            turnPhoto.click();
            mirrorPhoto.click();
            mirrorPhoto.click();
            filter.click();
            groupList.swipeLeft(3);
            chooseGroup.click();
            filterList.swipeLeft(2);
            filterList.flingToBeginning(1);
            chooseFilter.click();
            editComplete.click();
            SystemClock.sleep(3000);
        }
        avatar1.clickAndWaitForNewWindow(2500);
        avatarDetail.click();
        if (avatar2.exists()){
            avatar2.clickAndWaitForNewWindow(2500);
            avatarDelete.click();
            cancelDelete.click();
            avatarDelete.click();
            confirmDelete.click();
            SystemClock.sleep(1500);
        }else{
            avatar1.click();
            avatarDelete.click();
            confirmDelete.click();
        }
        //修改昵称
        reviseNickname.clickAndWaitForNewWindow(300);
        edit.clearTextField();
        edit.setText("测试姬的" + rand.nextInt(50) + "号鱼");
        nicknameConfirm.click();
        SystemClock.sleep(1500);
        //修改性别
        reviseGender.click();
        woman.click();
        SystemClock.sleep(1500);
        reviseGender.click();
        man.click();
        SystemClock.sleep(1500);
        reviseGender.click();
        secret.click();
        SystemClock.sleep(1500);
        //修改年龄
        reviseAge.click();
        ageCancel.click();
        reviseAge.click();
        birthYear.swipeDown(30);
        birthYear.swipeUp(50);
        birthMonth.flingToBeginning(1);
        birthDay.flingToEnd(1);
        ageConfirm.click();
        SystemClock.sleep(1500);
        //修改城市
        reviseCity.clickAndWaitForNewWindow(1500);
        generalList.flingToEnd(2);
        editCity.click();
        generalList.flingToEnd(1);
        editCity.click();
        SystemClock.sleep(1500);
        //修改签名
        reviseSign.clickAndWaitForNewWindow(500);
        edit.clearTextField();
        edit.setText("416c77617973206c696b6520746869732e");
        nicknameConfirm.click();
        SystemClock.sleep(1500);
        //修改个人标签
        reviseTag.clickAndWaitForNewWindow(500);
        for (int i = 0; i < 2; i++) {
            if (chosenTag5.exists()) {
                chosenTag5.click();
            } else if (chosenTag3.exists()) {
                chosenTag3.click();
            } else if (chosenTag1.exists()) {
                chosenTag1.click();
            } else {
                break;
            }
        }
        tagColumn.swipeLeft(3);
        tagColumn.swipeRight(5);
        tagColumnItem.click();
        selectTag1.click();
        selectTag2.click();
        selectTag3.click();
        selectTag4.click();
        confirmTag.click();
        SystemClock.sleep(1500);
        //返回个人主页
        mDevice.pressBack();
        //个人主页头像
        portrait.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        //个人主页标签
        if (tag5.exists()){
            tag5.clickAndWaitForNewWindow(1500);
            mDevice.pressBack();
        }
        tag1.clickAndWaitForNewWindow(1500);
        followUserOfSameInterest.click();
        SystemClock.sleep(1500);
        userOfSameInterest.clickAndWaitForNewWindow(1500);
        followState.click();
        SystemClock.sleep(1500);
        mDevice.pressBack();
        generalList.flingToEnd(3);
        generalList.swipeUp(50);
        generalList.flingToEnd(1);
        userRecommend.clickAndWaitForNewWindow(1500);
        mDevice.pressBack();
        mDevice.pressBack();
        //个人主页等级
        level.clickAndWaitForNewWindow(1000);
        levelScroll.flingToEnd(1);
        mDevice.pressBack();
        //关注、粉丝列表
        fansnum.clickAndWaitForNewWindow(2500);
        generalList.flingToEnd(2);
        generalList.swipeUp(50);
        generalList.flingToEnd(1);
        fanUser.clickAndWaitForNewWindow(1500);
        for (int i = 0; i < 1; i++){
            if (!editRemark.exists()){
                followState.click();
                mDevice.pressBack();
                mDevice.pressBack();
                break;
            }else{
                mDevice.pressBack();
                generalList.flingToEnd(1);
                fanUser.clickAndWaitForNewWindow(1500);
                i--;
            }
        }
        follownum.clickAndWaitForNewWindow(2500);
        generalList.flingToEnd(2);
        generalList.swipeUp(50);
        generalList.flingToEnd(1);
        followUser.clickAndWaitForNewWindow(1500);
        editRemark.clickAndWaitForNewWindow(500);
        remarkText.clearTextField();
        remarkText.setText("Ta是条死鱼" + rand.nextInt(10));
        confirmRemark.click();
        SystemClock.sleep(1500);
        follownum.clickAndWaitForNewWindow(1500);
        generalList.flingToEnd(2);
        generalList.swipeUp(50);
        mDevice.pressBack();
        fansnum.clickAndWaitForNewWindow(1500);
        generalList.flingToEnd(2);
        generalList.swipeUp(50);
        mDevice.pressBack();
        topicnum.clickAndWaitForNewWindow(1500);




        followState.click();
        mDevice.pressBack();
        mDevice.pressBack();




        follow.clickAndWaitForNewWindow(1500);
        generalList.flingToEnd(3);
        generalList.swipeUp(50);
        generalList.flingToEnd(3);
        mDevice.pressBack();
        fans.clickAndWaitForNewWindow(1500);


    }
}