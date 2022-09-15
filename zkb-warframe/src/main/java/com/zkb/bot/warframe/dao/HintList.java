package com.zkb.bot.warframe.dao;


import java.util.Random;

public class HintList {
    private static final String[] hints = {
            "小提示：B站搜索 <span style='color: #e77c8e; font-weight: bold;'>\"老王的冒险之旅\"</span> 这是作者哦！",
            "小提示：善用QQ的<span style=\"color: #ee3f4d; font-weight: bold;\">提取文字</span>功能哦！",
            "小提示：查询紫卡可以使用简写 <span style=\"color: #ee3f4d;\">/wr 紫卡名称</span>",
            "小提示：查询<span style=\"font-weight: bold;\"> 紫卡 </span>可以使用后缀 <br/>例如： <span style=\"color: #ee3f4d;\">/wr 紫卡名 -爆率,多重 -有|无</span>",
            "小提示：在使用/wm 命令时可以添加后缀<br/>例如：<span style=\"color: #ee3f4d;\">/wm 充沛 满级 买家</span>",
            "小提示：/wm 的后缀可以添加到任意位置<br/>例如：<span style=\"color: #ee3f4d;\">/wm 充<span style=\"color: #8a6913;\">满级买家</span>沛</span>",
            "小提示：在<span style=\"color: #5698c3;\">github.com</span> 网站中搜索<span style=\"color: #e77c8e;\">ZeroKingBot</span> <br/>就是这个项目哦！",
            "小提示：发送 核桃 a1 即可查询所有名为 a1 的核桃",
            "小提示：发送 核桃 守望者 即可查询包含“守望者”的所有遗物！",
            "小提示: 发送 开核桃|砸核桃 随机抽取遗物开启"

    };

    private static final Random R = new Random();

    public static String getHint() {
        int i = R.nextInt(hints.length - 1);
        return hints[i];
    }

}
