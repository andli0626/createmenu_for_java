package org.epoint.menu;


import org.epoint.menu.model.Button;
import org.epoint.menu.model.ClickButton;
import org.epoint.menu.model.ComplexButton;
import org.epoint.menu.model.Menu;
import org.epoint.menu.model.Token;
import org.epoint.menu.model.ViewButton;
import org.epoint.menu.util.CommonUtil;
import org.epoint.menu.util.MenuUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lilin
 * @date 2016年2月15日 上午11:26:12
 * @annotation 菜单管理器类 (通过代码来进行菜单的创建，删除,查询)
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    /**
     * 定义菜单结构
     *
     * @return
     */
    private static Menu getMenu() {

        /******************** 微信 政务服务 张家港 *******************/

        // 一级菜单1

        ViewButton btn11 = new ViewButton();
        btn11.setName("中心简介");
        btn11.setType("view");
        btn11.setUrl("http://w2.zjg.gov.cn/WebChat/html/watchnews/ZWFW_CenterInt.html");

        ViewButton btn12 = new ViewButton();
        btn12.setName("窗口分步");
        btn12.setType("view");
        btn12.setUrl("http://w2.zjg.gov.cn/WebChat/html/watchnews/ZWFW_WindowsDis.html");

        ViewButton btn13 = new ViewButton();
        btn13.setName("中心新闻");
        btn13.setType("view");
        btn13.setUrl("http://w2.zjg.gov.cn/WebChat/html/watchnews/ZWFW_CenterNews.html");

        ViewButton btn14 = new ViewButton();
        btn14.setName("取号信息");
        btn14.setType("view");
        btn14.setUrl("http://w2.zjg.gov.cn/WebChat/html/watchnews/ZWFW_GetNum.html");

        ViewButton btn15 = new ViewButton();
        btn15.setName("排队信息");
        btn15.setType("view");
        btn15.setUrl("http://w2.zjg.gov.cn/WebChat/html/watchnews/CDSL_ApartLine.html");

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("看信息");
        mainBtn1.setSub_button(new Button[]{btn11, btn12, btn13, btn14, btn15});


        // 一级菜单2
        ViewButton btn21 = new ViewButton();
        btn21.setName("事项分类");
        btn21.setType("view");
        btn21.setUrl("http://w2.zjg.gov.cn/WebChat/html/Service/ZWFW_PersonBusinessItems.html?UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid

        ViewButton btn22 = new ViewButton();
        btn22.setName("部门服务");
        btn22.setType("view");
        btn22.setUrl("http://w2.zjg.gov.cn/WebChat/html/Service/ZWFW_CommonService.html?type=department&UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid

        ViewButton btn23 = new ViewButton();
        btn23.setName("办件查询");
        btn23.setType("view");
        btn23.setUrl("http://w2.zjg.gov.cn/WebChat/html/Service/CDSL_IWSearch.html");

        ViewButton btn24 = new ViewButton();
        btn24.setName("三产联办");
        btn24.setType("view");
        btn24.setUrl("http://w2.zjg.gov.cn/WebChat/html/Service/ZWFW_SCLBlist.html?UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid

        ViewButton btn25 = new ViewButton();
        btn25.setName("便民服务");
        btn25.setType("view");
        btn25.setUrl("http://w2.zjg.gov.cn/WebChat/html/Service/ZWFW_BianMinFuWu.html");

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("享服务");
        mainBtn2.setSub_button(new Button[]{btn21, btn22, btn23, btn24, btn25});

        // 一级菜单3
        ViewButton btn31 = new ViewButton();
        btn31.setName("我的预约");
        btn31.setType("view");
        btn31.setUrl("http://w2.zjg.gov.cn/WebChat/html/Interaction/ZWFW_MyAppointment.html?UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid

        ViewButton btn32 = new ViewButton();
        btn32.setName("预约指南");
        btn32.setType("view");
        btn32.setUrl("http://w2.zjg.gov.cn/WebChat/html/watchnews/ZWFW_process.html");

        ViewButton btn33 = new ViewButton();
        btn33.setName("我的咨询");
        btn33.setType("view");
        btn33.setUrl("http://w2.zjg.gov.cn/WebChat/html/Interaction/ZWFW_Consult_Hot.html?UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid

        ViewButton btn34 = new ViewButton();
        btn34.setName("我的投诉");
        btn34.setType("view");
        btn34.setUrl("http://w2.zjg.gov.cn/WebChat/html/Interaction/ZWFW_Mycompliant.html?UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid

        ViewButton btn35 = new ViewButton();
        btn35.setName("账户绑定");
        btn35.setType("view");
        btn35.setUrl("http://w2.zjg.gov.cn/WebChat/html/Interaction/ZWFW_Binding.html?UserPK=oZvPKvss7RkuYDGVFnJwcuRedOik"); // 获取openid


        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("热互动");
        mainBtn3.setSub_button(new Button[]{btn31, btn32, btn33, btn34, btn35});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});

        return menu;
    }

    public static void main(String[] args) {
        // 微信测试帐号:就爱购
        String appId = "wxbb878801f06451f2";
        String appSecret = "be839559f4fffbcef9b565621176987f";

        // 调用接口获取凭证
        Token token = CommonUtil.getToken(appId, appSecret);

        if (null != token) {
            // 创建菜单
            boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

            // 判断菜单创建结果
            if (result)
                System.out.println("菜单创建成功！");
            else
                System.out.println("菜单创建失败！");
        }
    }
}
