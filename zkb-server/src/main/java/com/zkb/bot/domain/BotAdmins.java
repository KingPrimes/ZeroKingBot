package com.zkb.bot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "bot_admins",uniqueConstraints = @UniqueConstraint(name = "botAdmins",columnNames = {"botUid","botAdminUid"}))
public class BotAdmins {
    @GeneratedValue
    @Id
    Long uid;
    Long botUid;
    Long botAdminUid;
    Long botPrivilege;

    public BotAdmins() {
    }

    public BotAdmins(Long botUid, Long botAdminUid) {
        this.botUid = botUid;
        this.botAdminUid = botAdminUid;
    }

    public BotAdmins(Long botUid, Long botAdminUid, Long botPrivilege) {
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

    public Long getBotPrivilege() {
        return botPrivilege;
    }

    public void setBotPrivilege(Long botPrivilege) {
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
