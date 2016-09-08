package cn.studyjamscn.s1.sj30.liangyinghao.module;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/24 0024.
 * 游戏Item的对象
 */
public class GameItemDetail implements Serializable {
    int avatar;//头像
    int picture;//人物大图
    String name;//名字
    String type;//类型
    String background;//人物背景
    String skill;//技能
    String trick;//使用技巧

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTrick() {
        return trick;
    }

    public void setTrick(String trick) {
        this.trick = trick;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GameItemDetail{" +
                "avatar=" + avatar +
                ", picture=" + picture +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", background='" + background + '\'' +
                ", skill='" + skill + '\'' +
                ", trick='" + trick + '\'' +
                '}';
    }
}
