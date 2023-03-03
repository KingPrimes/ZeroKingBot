package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class RivenAnaiyseTrendModel {
    String weaponName;
    String rivenName;
    String newDot;
    String newNum;
    String oldDot;
    String oldNum;
    String weaponType;
    List<Attribute> attributes;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("weaponName", weaponName)
                .append("rivenName", rivenName)
                .append("newDot", newDot)
                .append("newNum", newNum)
                .append("oldDot", oldDot)
                .append("oldNum", oldNum)
                .append("weaponType", weaponType)
                .append("attributes", attributes)
                .toString();
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getRivenName() {
        return rivenName;
    }

    public void setRivenName(String rivenName) {
        this.rivenName = rivenName;
    }

    public String getNewDot() {
        return newDot;
    }

    public void setNewDot(String newDot) {
        this.newDot = newDot;
    }

    public String getNewNum() {
        return newNum;
    }

    public void setNewNum(String newNum) {
        this.newNum = newNum;
    }

    public String getOldDot() {
        return oldDot;
    }

    public void setOldDot(String oldDot) {
        this.oldDot = oldDot;
    }

    public String getOldNum() {
        return oldNum;
    }

    public void setOldNum(String oldNum) {
        this.oldNum = oldNum;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public static class Attribute {
        String name;
        String attr;
        String lowAttr;
        String highAttr;

        String lowAttrDiff;

        String highAttrDiff;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("name", name)
                    .append("attr", attr)
                    .append("lowAttr", lowAttr)
                    .append("highAttr", highAttr)
                    .append("lowAttrDiff", lowAttrDiff)
                    .append("highAttrDiff", highAttrDiff)
                    .toString();
        }

        public String getLowAttrDiff() {
            return lowAttrDiff;
        }

        public void setLowAttrDiff(String lowAttrDiff) {
            this.lowAttrDiff = lowAttrDiff;
        }

        public String getHighAttrDiff() {
            return highAttrDiff;
        }

        public void setHighAttrDiff(String highAttrDiff) {
            this.highAttrDiff = highAttrDiff;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAttr() {
            return attr;
        }

        public void setAttr(String attr) {
            this.attr = attr;
        }

        public String getLowAttr() {
            return lowAttr;
        }

        public void setLowAttr(String lowAttr) {
            this.lowAttr = lowAttr;
        }

        public String getHighAttr() {
            return highAttr;
        }

        public void setHighAttr(String highAttr) {
            this.highAttr = highAttr;
        }
    }
}
