package com.zkb.bot.domain;

import com.zkb.bot.enums.BotAdminPrivilegeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BotAdmins {
    Long uid;
    Long botUid;
    Long botAdminUid;
    BotAdminPrivilegeEnum botPrivilege;

    public BotAdmins() {
    }

    public BotAdmins(Long botUid, Long botAdminUid) {
        this.botUid = botUid;
        this.botAdminUid = botAdminUid;
    }

    public BotAdmins(Long botUid, Long botAdminUid, BotAdminPrivilegeEnum botPrivilege) {
        this.botUid = botUid;
        this.botAdminUid = botAdminUid;
        this.botPrivilege = botPrivilege;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getBotUid() {
        return botUid;
    }

    public void setBotUid(Long botUid) {
        this.botUid = botUid;
    }

    public Long getBotAdminUid() {
        return botAdminUid;
    }

    public void setBotAdminUid(Long botAdminUid) {
        this.botAdminUid = botAdminUid;
    }

    public BotAdminPrivilegeEnum getBotPrivilege() {
        return botPrivilege;
    }

    public void setBotPrivilege(BotAdminPrivilegeEnum botPrivilege) {
        this.botPrivilege = botPrivilege;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("uid", uid)
                .append("botUid", botUid)
                .append("botAdminUid", botAdminUid)
                .append("botPrivilege", botPrivilege)
                .toString();
    }
}
