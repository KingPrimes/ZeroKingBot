package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class DataHash {
    String hash;
    Long modified;
    Long timestamp;

    public DataHash() {
    }

    public DataHash(String hash, Long modified, Long timestamp) {
        this.hash = hash;
        this.modified = modified;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataHash)) return false;
        DataHash dataHash = (DataHash) o;
        return getHash().equals(dataHash.getHash()) && getModified().equals(dataHash.getModified()) && getTimestamp().equals(dataHash.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHash(), getModified(), getTimestamp());
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("hash", hash)
                .append("modified", modified)
                .append("timestamp", timestamp)
                .toString();
    }
}
