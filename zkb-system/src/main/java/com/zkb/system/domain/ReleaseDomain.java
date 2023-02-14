package com.zkb.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class ReleaseDomain {
    @JsonProperty("assets")
    // 资产
    Assets assets;
    @JsonProperty("assets_url")
    // 资产
    String assetsUrl;
    @JsonProperty("author")
    // 作者
    Uploader author;
    @JsonProperty("body")
    // 留言
    String body;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 创建于
    Date createdAt;
    @JsonProperty("draft")
    // 草案
    Boolean draft;
    @JsonProperty("html_url")
    //
    String htmlUrl;
    @JsonProperty("id")
    // ID
    Long id;
    @JsonProperty("name")
    // 名称
    String name;
    @JsonProperty("node_id")
    // nodeId
    String nodeId;
    @JsonProperty("prerelease")
    //
    Boolean prerelease;
    @JsonProperty("published_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 出版于
    Date publishedAt;
    @JsonProperty("tag_name")
    // TagName 版本
    String tagName;
    @JsonProperty("tarball_url")
    // 源文件压缩包网址
    String tarballUrl;
    @JsonProperty("target_commitish")
    // 提交目标
    String targetCommitish;
    @JsonProperty("upload_url")
    // 上传网址
    String uploadUrl;
    @JsonProperty("url")
    // 地址
    String url;
    @JsonProperty("zipball_url")
    // 源码压缩包 ZIP格式
    String zipballUrl;

    /**
     * get @JsonProperty("assets")     资产
     *
     * @return assets @JsonProperty("assets")     资产
     */
    public Assets getAssets() {
        return this.assets;
    }

    /**
     * set @JsonProperty("assets")     资产
     *
     * @param assets @JsonProperty("assets")     资产
     */
    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    /**
     * get @JsonProperty("assets_url")     资产
     *
     * @return assetsUrl @JsonProperty("assets_url")     资产
     */
    public String getAssetsUrl() {
        return this.assetsUrl;
    }

    /**
     * set @JsonProperty("assets_url")     资产
     *
     * @param assetsUrl @JsonProperty("assets_url")     资产
     */
    public void setAssetsUrl(String assetsUrl) {
        this.assetsUrl = assetsUrl;
    }

    /**
     * get @JsonProperty("author")     作者
     *
     * @return author @JsonProperty("author")     作者
     */
    public Uploader getAuthor() {
        return this.author;
    }

    /**
     * set @JsonProperty("author")     作者
     *
     * @param author @JsonProperty("author")     作者
     */
    public void setAuthor(Uploader author) {
        this.author = author;
    }

    /**
     * get @JsonProperty("body")     留言
     *
     * @return body @JsonProperty("body")     留言
     */
    public String getBody() {
        return this.body;
    }

    /**
     * set @JsonProperty("body")     留言
     *
     * @param body @JsonProperty("body")     留言
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * get @JsonProperty("created_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     创建于
     *
     * @return createdAt @JsonProperty("created_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     创建于
     */
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /**
     * set @JsonProperty("created_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     创建于
     *
     * @param createdAt @JsonProperty("created_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     创建于
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * get @JsonProperty("draft")     草案
     *
     * @return draft @JsonProperty("draft")     草案
     */
    public Boolean getDraft() {
        return this.draft;
    }

    /**
     * set @JsonProperty("draft")     草案
     *
     * @param draft @JsonProperty("draft")     草案
     */
    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    /**
     * get @JsonProperty("html_url")
     *
     * @return htmlUrl @JsonProperty("html_url")
     */
    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    /**
     * set @JsonProperty("html_url")
     *
     * @param htmlUrl @JsonProperty("html_url")
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * get @JsonProperty("id")     ID
     *
     * @return id @JsonProperty("id")     ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set @JsonProperty("id")     ID
     *
     * @param id @JsonProperty("id")     ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get @JsonProperty("name")     名称
     *
     * @return name @JsonProperty("name")     名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * set @JsonProperty("name")     名称
     *
     * @param name @JsonProperty("name")     名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get @JsonProperty("node_id")     nodeId
     *
     * @return nodeId @JsonProperty("node_id")     nodeId
     */
    public String getNodeId() {
        return this.nodeId;
    }

    /**
     * set @JsonProperty("node_id")     nodeId
     *
     * @param nodeId @JsonProperty("node_id")     nodeId
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * get @JsonProperty("prerelease")
     *
     * @return prerelease @JsonProperty("prerelease")
     */
    public Boolean getPrerelease() {
        return this.prerelease;
    }

    /**
     * set @JsonProperty("prerelease")
     *
     * @param prerelease @JsonProperty("prerelease")
     */
    public void setPrerelease(Boolean prerelease) {
        this.prerelease = prerelease;
    }

    /**
     * get @JsonProperty("published_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     出版于
     *
     * @return publishedAt @JsonProperty("published_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     出版于
     */
    public Date getPublishedAt() {
        return this.publishedAt;
    }

    /**
     * set @JsonProperty("published_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     出版于
     *
     * @param publishedAt @JsonProperty("published_at")    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")     出版于
     */
    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * get @JsonProperty("tag_name")     TagName 版本
     *
     * @return tagName @JsonProperty("tag_name")     TagName 版本
     */
    public String getTagName() {
        return this.tagName;
    }

    /**
     * set @JsonProperty("tag_name")     TagName 版本
     *
     * @param tagName @JsonProperty("tag_name")     TagName 版本
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * get @JsonProperty("tarball_url")     源文件压缩包网址
     *
     * @return tarballUrl @JsonProperty("tarball_url")     源文件压缩包网址
     */
    public String getTarballUrl() {
        return this.tarballUrl;
    }

    /**
     * set @JsonProperty("tarball_url")     源文件压缩包网址
     *
     * @param tarballUrl @JsonProperty("tarball_url")     源文件压缩包网址
     */
    public void setTarballUrl(String tarballUrl) {
        this.tarballUrl = tarballUrl;
    }

    /**
     * get @JsonProperty("target_commitish")     提交目标
     *
     * @return targetCommitish @JsonProperty("target_commitish")     提交目标
     */
    public String getTargetCommitish() {
        return this.targetCommitish;
    }

    /**
     * set @JsonProperty("target_commitish")     提交目标
     *
     * @param targetCommitish @JsonProperty("target_commitish")     提交目标
     */
    public void setTargetCommitish(String targetCommitish) {
        this.targetCommitish = targetCommitish;
    }

    /**
     * get @JsonProperty("upload_url")     上传网址
     *
     * @return uploadUrl @JsonProperty("upload_url")     上传网址
     */
    public String getUploadUrl() {
        return this.uploadUrl;
    }

    /**
     * set @JsonProperty("upload_url")     上传网址
     *
     * @param uploadUrl @JsonProperty("upload_url")     上传网址
     */
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    /**
     * get @JsonProperty("url")     地址
     *
     * @return url @JsonProperty("url")     地址
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * set @JsonProperty("url")     地址
     *
     * @param url @JsonProperty("url")     地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * get @JsonProperty("zipball_url")     源码压缩包 ZIP格式
     *
     * @return zipballUrl @JsonProperty("zipball_url")     源码压缩包 ZIP格式
     */
    public String getZipballUrl() {
        return this.zipballUrl;
    }

    /**
     * set @JsonProperty("zipball_url")     源码压缩包 ZIP格式
     *
     * @param zipballUrl @JsonProperty("zipball_url")     源码压缩包 ZIP格式
     */
    public void setZipballUrl(String zipballUrl) {
        this.zipballUrl = zipballUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("assets", assets)
                .append("assetsUrl", assetsUrl)
                .append("author", author)
                .append("body", body)
                .append("createdAt", createdAt)
                .append("draft", draft)
                .append("htmlUrl", htmlUrl)
                .append("id", id)
                .append("name", name)
                .append("nodeId", nodeId)
                .append("prerelease", prerelease)
                .append("publishedAt", publishedAt)
                .append("tagName", tagName)
                .append("tarballUrl", tarballUrl)
                .append("targetCommitish", targetCommitish)
                .append("uploadUrl", uploadUrl)
                .append("url", url)
                .append("zipballUrl", zipballUrl)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReleaseDomain)) return false;
        ReleaseDomain that = (ReleaseDomain) o;
        return new EqualsBuilder().append(getAssets(), that.getAssets())
                .append(getAssetsUrl(), that.getAssetsUrl())
                .append(getAuthor(), that.getAuthor())
                .append(getBody(), that.getBody())
                .append(getCreatedAt(), that.getCreatedAt())
                .append(getDraft(), that.getDraft())
                .append(getHtmlUrl(), that.getHtmlUrl())
                .append(getId(), that.getId())
                .append(getName(), that.getName())
                .append(getNodeId(), that.getNodeId())
                .append(getPrerelease(), that.getPrerelease())
                .append(getPublishedAt(), that.getPublishedAt())
                .append(getTagName(), that.getTagName())
                .append(getTarballUrl(), that.getTarballUrl())
                .append(getTargetCommitish(), that.getTargetCommitish())
                .append(getUploadUrl(), that.getUploadUrl())
                .append(getUrl(), that.getUrl())
                .append(getZipballUrl(), that.getZipballUrl())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getAssets())
                .append(getAssetsUrl())
                .append(getAuthor())
                .append(getBody())
                .append(getCreatedAt())
                .append(getDraft())
                .append(getHtmlUrl())
                .append(getId())
                .append(getName())
                .append(getNodeId())
                .append(getPrerelease())
                .append(getPublishedAt())
                .append(getTagName())
                .append(getTarballUrl())
                .append(getTargetCommitish())
                .append(getUploadUrl())
                .append(getUrl())
                .append(getZipballUrl())
                .toHashCode();
    }

    public static class Assets {
        @JsonProperty("id")
        // ID
        Long id;
        @JsonProperty("node_id")
        // nodeId
        String nodeId;
        @JsonProperty("url")
        // url
        String url;
        @JsonProperty("name")
        // 文件名称
        String name;
        @JsonProperty("label")
        // 标签
        String label;
        @JsonProperty("uploader")
        // 上传者
        Uploader uploader;
        @JsonProperty("content_type")
        //内容类型
        String contentType;
        @JsonProperty("state")
        // 类型
        String state;
        @JsonProperty("size")
        // 文件大小
        Long size;
        @JsonProperty("download_count")
        // 下载计数
        Long downloadCount;
        @JsonProperty("created_at")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        // 创建于
        Date createdAt;
        @JsonProperty("updated_at")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        // 更新在
        Date updateAt;
        @JsonProperty("browser_download_url")
        // 附件下载地址
        String browserDownloadUrl;


        /**
         * get @JsonProperty("id")         ID
         *
         * @return id @JsonProperty("id")         ID
         */
        public Long getId() {
            return this.id;
        }

        /**
         * set @JsonProperty("id")         ID
         *
         * @param id @JsonProperty("id")         ID
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * get @JsonProperty("node_id")         nodeId
         *
         * @return nodeId @JsonProperty("node_id")         nodeId
         */
        public String getNodeId() {
            return this.nodeId;
        }

        /**
         * set @JsonProperty("node_id")         nodeId
         *
         * @param nodeId @JsonProperty("node_id")         nodeId
         */
        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        /**
         * get @JsonProperty("url")         url
         *
         * @return url @JsonProperty("url")         url
         */
        public String getUrl() {
            return this.url;
        }

        /**
         * set @JsonProperty("url")         url
         *
         * @param url @JsonProperty("url")         url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * get @JsonProperty("name")         文件名称
         *
         * @return name @JsonProperty("name")         文件名称
         */
        public String getName() {
            return this.name;
        }

        /**
         * set @JsonProperty("name")         文件名称
         *
         * @param name @JsonProperty("name")         文件名称
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * get @JsonProperty("label")         标签
         *
         * @return label @JsonProperty("label")         标签
         */
        public String getLabel() {
            return this.label;
        }

        /**
         * set @JsonProperty("label")         标签
         *
         * @param label @JsonProperty("label")         标签
         */
        public void setLabel(String label) {
            this.label = label;
        }

        /**
         * get @JsonProperty("uploader")         上传者
         *
         * @return uploader @JsonProperty("uploader")         上传者
         */
        public Uploader getUploader() {
            return this.uploader;
        }

        /**
         * set @JsonProperty("uploader")         上传者
         *
         * @param uploader @JsonProperty("uploader")         上传者
         */
        public void setUploader(Uploader uploader) {
            this.uploader = uploader;
        }

        /**
         * get @JsonProperty("content_type")        内容类型
         *
         * @return contentType @JsonProperty("content_type")        内容类型
         */
        public String getContentType() {
            return this.contentType;
        }

        /**
         * set @JsonProperty("content_type")        内容类型
         *
         * @param contentType @JsonProperty("content_type")        内容类型
         */
        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        /**
         * get @JsonProperty("state")         类型
         *
         * @return state @JsonProperty("state")         类型
         */
        public String getState() {
            return this.state;
        }

        /**
         * set @JsonProperty("state")         类型
         *
         * @param state @JsonProperty("state")         类型
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         * get @JsonProperty("size")         文件大小
         *
         * @return size @JsonProperty("size")         文件大小
         */
        public Long getSize() {
            return this.size;
        }

        /**
         * set @JsonProperty("size")         文件大小
         *
         * @param size @JsonProperty("size")         文件大小
         */
        public void setSize(Long size) {
            this.size = size;
        }

        /**
         * get @JsonProperty("download_count")         下载计数
         *
         * @return downloadCount @JsonProperty("download_count")         下载计数
         */
        public Long getDownloadCount() {
            return this.downloadCount;
        }

        /**
         * set @JsonProperty("download_count")         下载计数
         *
         * @param downloadCount @JsonProperty("download_count")         下载计数
         */
        public void setDownloadCount(Long downloadCount) {
            this.downloadCount = downloadCount;
        }

        /**
         * get @JsonProperty("created_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         创建于
         *
         * @return createdAt @JsonProperty("created_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         创建于
         */
        public Date getCreatedAt() {
            return this.createdAt;
        }

        /**
         * set @JsonProperty("created_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         创建于
         *
         * @param createdAt @JsonProperty("created_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         创建于
         */
        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        /**
         * get @JsonProperty("updated_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         更新在
         *
         * @return updateAt @JsonProperty("updated_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         更新在
         */
        public Date getUpdateAt() {
            return this.updateAt;
        }

        /**
         * set @JsonProperty("updated_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         更新在
         *
         * @param updateAt @JsonProperty("updated_at")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")         更新在
         */
        public void setUpdateAt(Date updateAt) {
            this.updateAt = updateAt;
        }

        /**
         * get @JsonProperty("browser_download_url")         附件下载地址
         *
         * @return browserDownloadUrl @JsonProperty("browser_download_url")         附件下载地址
         */
        public String getBrowserDownloadUrl() {
            return this.browserDownloadUrl;
        }

        /**
         * set @JsonProperty("browser_download_url")         附件下载地址
         *
         * @param browserDownloadUrl @JsonProperty("browser_download_url")         附件下载地址
         */
        public void setBrowserDownloadUrl(String browserDownloadUrl) {
            this.browserDownloadUrl = browserDownloadUrl;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Assets)) return false;
            Assets assets = (Assets) o;
            return new EqualsBuilder().append(getId(), assets.getId())
                    .append(getNodeId(), assets.getNodeId())
                    .append(getUrl(), assets.getUrl())
                    .append(getName(), assets.getName())
                    .append(getLabel(), assets.getLabel())
                    .append(getUploader(), assets.getUploader())
                    .append(getContentType(), assets.getContentType())
                    .append(getState(), assets.getState())
                    .append(getSize(), assets.getSize())
                    .append(getDownloadCount(), assets.getDownloadCount())
                    .append(getCreatedAt(), assets.getCreatedAt())
                    .append(getUpdateAt(), assets.getUpdateAt())
                    .append(getBrowserDownloadUrl(), assets.getBrowserDownloadUrl())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(getId())
                    .append(getNodeId())
                    .append(getUrl())
                    .append(getName())
                    .append(getLabel())
                    .append(getUploader())
                    .append(getContentType())
                    .append(getState())
                    .append(getSize())
                    .append(getDownloadCount())
                    .append(getCreatedAt())
                    .append(getUpdateAt())
                    .append(getBrowserDownloadUrl())
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("nodeId", nodeId)
                    .append("url", url)
                    .append("name", name)
                    .append("label", label)
                    .append("uploader", uploader)
                    .append("contentType", contentType)
                    .append("state", state)
                    .append("size", size)
                    .append("downloadCount", downloadCount)
                    .append("createdAt", createdAt)
                    .append("updateAt", updateAt)
                    .append("browserDownloadUrl", browserDownloadUrl)
                    .toString();
        }
    }

    public static class Uploader {
        @JsonProperty("id")
        //id
        Long id;
        @JsonProperty("node_id")
        //nodeId
        String nodeId;
        @JsonProperty("url")
        //url
        String url;
        @JsonProperty("login")
        //登录用户
        String login;
        @JsonProperty("avatar_url")
        //头像网址
        String avatarUrl;
        @JsonProperty("gravatar_id")
        //gravatarId
        String gravatarId;
        @JsonProperty("html_url")
        //htmlUrl
        String htmlUrl;
        @JsonProperty("followers_url")
        //
        String followersUrl;
        @JsonProperty("following_url")
        //
        String followingUrl;
        @JsonProperty("gists_url")
        //
        String gistsUrl;
        @JsonProperty("starred_url")
        //
        String starredUrl;
        @JsonProperty("subscriptions_url")
        //
        String subscriptionsUrl;
        @JsonProperty("organizations_url")
        //
        String organizationsUrl;
        @JsonProperty("repos_url")
        //
        String reposUrl;
        @JsonProperty("events_url")
        //
        String eventsUrl;
        @JsonProperty("received_events_url")
        // 事件网址
        String receivedEventsUrl;
        @JsonProperty("type")
        // 上传者类型
        String type;
        @JsonProperty("site_admin")
        // 是否管理员
        Boolean siteAdmin;


        /**
         * get @JsonProperty("id")        id
         *
         * @return id @JsonProperty("id")        id
         */
        public Long getId() {
            return this.id;
        }

        /**
         * set @JsonProperty("id")        id
         *
         * @param id @JsonProperty("id")        id
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * get @JsonProperty("node_id")        nodeId
         *
         * @return nodeId @JsonProperty("node_id")        nodeId
         */
        public String getNodeId() {
            return this.nodeId;
        }

        /**
         * set @JsonProperty("node_id")        nodeId
         *
         * @param nodeId @JsonProperty("node_id")        nodeId
         */
        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        /**
         * get @JsonProperty("url")        url
         *
         * @return url @JsonProperty("url")        url
         */
        public String getUrl() {
            return this.url;
        }

        /**
         * set @JsonProperty("url")        url
         *
         * @param url @JsonProperty("url")        url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * get @JsonProperty("login")        登录用户
         *
         * @return login @JsonProperty("login")        登录用户
         */
        public String getLogin() {
            return this.login;
        }

        /**
         * set @JsonProperty("login")        登录用户
         *
         * @param login @JsonProperty("login")        登录用户
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * get @JsonProperty("avatar_url")        头像网址
         *
         * @return avatarUrl @JsonProperty("avatar_url")        头像网址
         */
        public String getAvatarUrl() {
            return this.avatarUrl;
        }

        /**
         * set @JsonProperty("avatar_url")        头像网址
         *
         * @param avatarUrl @JsonProperty("avatar_url")        头像网址
         */
        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        /**
         * get @JsonProperty("gravatar_id")        gravatarId
         *
         * @return gravatarId @JsonProperty("gravatar_id")        gravatarId
         */
        public String getGravatarId() {
            return this.gravatarId;
        }

        /**
         * set @JsonProperty("gravatar_id")        gravatarId
         *
         * @param gravatarId @JsonProperty("gravatar_id")        gravatarId
         */
        public void setGravatarId(String gravatarId) {
            this.gravatarId = gravatarId;
        }

        /**
         * get @JsonProperty("html_url")        htmlUrl
         *
         * @return htmlUrl @JsonProperty("html_url")        htmlUrl
         */
        public String getHtmlUrl() {
            return this.htmlUrl;
        }

        /**
         * set @JsonProperty("html_url")        htmlUrl
         *
         * @param htmlUrl @JsonProperty("html_url")        htmlUrl
         */
        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        /**
         * get @JsonProperty("followers_url")
         *
         * @return followersUrl @JsonProperty("followers_url")
         */
        public String getFollowersUrl() {
            return this.followersUrl;
        }

        /**
         * set @JsonProperty("followers_url")
         *
         * @param followersUrl @JsonProperty("followers_url")
         */
        public void setFollowersUrl(String followersUrl) {
            this.followersUrl = followersUrl;
        }

        /**
         * get @JsonProperty("following_url")
         *
         * @return followingUrl @JsonProperty("following_url")
         */
        public String getFollowingUrl() {
            return this.followingUrl;
        }

        /**
         * set @JsonProperty("following_url")
         *
         * @param followingUrl @JsonProperty("following_url")
         */
        public void setFollowingUrl(String followingUrl) {
            this.followingUrl = followingUrl;
        }

        /**
         * get @JsonProperty("gists_url")
         *
         * @return gistsUrl @JsonProperty("gists_url")
         */
        public String getGistsUrl() {
            return this.gistsUrl;
        }

        /**
         * set @JsonProperty("gists_url")
         *
         * @param gistsUrl @JsonProperty("gists_url")
         */
        public void setGistsUrl(String gistsUrl) {
            this.gistsUrl = gistsUrl;
        }

        /**
         * get @JsonProperty("starred_url")
         *
         * @return starredUrl @JsonProperty("starred_url")
         */
        public String getStarredUrl() {
            return this.starredUrl;
        }

        /**
         * set @JsonProperty("starred_url")
         *
         * @param starredUrl @JsonProperty("starred_url")
         */
        public void setStarredUrl(String starredUrl) {
            this.starredUrl = starredUrl;
        }

        /**
         * get @JsonProperty("subscriptions_url")
         *
         * @return subscriptionsUrl @JsonProperty("subscriptions_url")
         */
        public String getSubscriptionsUrl() {
            return this.subscriptionsUrl;
        }

        /**
         * set @JsonProperty("subscriptions_url")
         *
         * @param subscriptionsUrl @JsonProperty("subscriptions_url")
         */
        public void setSubscriptionsUrl(String subscriptionsUrl) {
            this.subscriptionsUrl = subscriptionsUrl;
        }

        /**
         * get @JsonProperty("organizations_url")
         *
         * @return organizationsUrl @JsonProperty("organizations_url")
         */
        public String getOrganizationsUrl() {
            return this.organizationsUrl;
        }

        /**
         * set @JsonProperty("organizations_url")
         *
         * @param organizationsUrl @JsonProperty("organizations_url")
         */
        public void setOrganizationsUrl(String organizationsUrl) {
            this.organizationsUrl = organizationsUrl;
        }

        /**
         * get @JsonProperty("repos_url")
         *
         * @return reposUrl @JsonProperty("repos_url")
         */
        public String getReposUrl() {
            return this.reposUrl;
        }

        /**
         * set @JsonProperty("repos_url")
         *
         * @param reposUrl @JsonProperty("repos_url")
         */
        public void setReposUrl(String reposUrl) {
            this.reposUrl = reposUrl;
        }

        /**
         * get @JsonProperty("events_url")
         *
         * @return eventsUrl @JsonProperty("events_url")
         */
        public String getEventsUrl() {
            return this.eventsUrl;
        }

        /**
         * set @JsonProperty("events_url")
         *
         * @param eventsUrl @JsonProperty("events_url")
         */
        public void setEventsUrl(String eventsUrl) {
            this.eventsUrl = eventsUrl;
        }

        /**
         * get @JsonProperty("received_events_url")         事件网址
         *
         * @return receivedEventsUrl @JsonProperty("received_events_url")         事件网址
         */
        public String getReceivedEventsUrl() {
            return this.receivedEventsUrl;
        }

        /**
         * set @JsonProperty("received_events_url")         事件网址
         *
         * @param receivedEventsUrl @JsonProperty("received_events_url")         事件网址
         */
        public void setReceivedEventsUrl(String receivedEventsUrl) {
            this.receivedEventsUrl = receivedEventsUrl;
        }

        /**
         * get @JsonProperty("type")         上传者类型
         *
         * @return type @JsonProperty("type")         上传者类型
         */
        public String getType() {
            return this.type;
        }

        /**
         * set @JsonProperty("type")         上传者类型
         *
         * @param type @JsonProperty("type")         上传者类型
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * get @JsonProperty("site_admin")         是否管理员
         *
         * @return siteAdmin @JsonProperty("site_admin")         是否管理员
         */
        public Boolean getSiteAdmin() {
            return this.siteAdmin;
        }

        /**
         * set @JsonProperty("site_admin")         是否管理员
         *
         * @param siteAdmin @JsonProperty("site_admin")         是否管理员
         */
        public void setSiteAdmin(Boolean siteAdmin) {
            this.siteAdmin = siteAdmin;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("nodeId", nodeId)
                    .append("url", url)
                    .append("login", login)
                    .append("avatarUrl", avatarUrl)
                    .append("gravatarId", gravatarId)
                    .append("htmlUrl", htmlUrl)
                    .append("followersUrl", followersUrl)
                    .append("followingUrl", followingUrl)
                    .append("gistsUrl", gistsUrl)
                    .append("starredUrl", starredUrl)
                    .append("subscriptionsUrl", subscriptionsUrl)
                    .append("organizationsUrl", organizationsUrl)
                    .append("reposUrl", reposUrl)
                    .append("eventsUrl", eventsUrl)
                    .append("receivedEventsUrl", receivedEventsUrl)
                    .append("type", type)
                    .append("siteAdmin", siteAdmin)
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Uploader)) return false;
            Uploader uploader = (Uploader) o;
            return new EqualsBuilder().append(getId(), uploader.getId())
                    .append(getNodeId(), uploader.getNodeId())
                    .append(getUrl(), uploader.getUrl())
                    .append(getLogin(), uploader.getLogin())
                    .append(getAvatarUrl(), uploader.getAvatarUrl())
                    .append(getGravatarId(), uploader.getGravatarId())
                    .append(getHtmlUrl(), uploader.getHtmlUrl())
                    .append(getFollowersUrl(), uploader.getFollowersUrl())
                    .append(getFollowingUrl(), uploader.getFollowingUrl())
                    .append(getGistsUrl(), uploader.getGistsUrl())
                    .append(getStarredUrl(), uploader.getStarredUrl())
                    .append(getSubscriptionsUrl(), uploader.getSubscriptionsUrl())
                    .append(getOrganizationsUrl(), uploader.getOrganizationsUrl())
                    .append(getReposUrl(), uploader.getReposUrl())
                    .append(getEventsUrl(), uploader.getEventsUrl())
                    .append(getReceivedEventsUrl(), uploader.getReceivedEventsUrl())
                    .append(getType(), uploader.getType())
                    .append(getSiteAdmin(), uploader.getSiteAdmin())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(getId())
                    .append(getNodeId())
                    .append(getUrl())
                    .append(getLogin())
                    .append(getAvatarUrl())
                    .append(getGravatarId())
                    .append(getHtmlUrl())
                    .append(getFollowersUrl())
                    .append(getFollowingUrl())
                    .append(getGistsUrl())
                    .append(getStarredUrl())
                    .append(getSubscriptionsUrl())
                    .append(getOrganizationsUrl())
                    .append(getReposUrl())
                    .append(getEventsUrl())
                    .append(getReceivedEventsUrl())
                    .append(getType())
                    .append(getSiteAdmin())
                    .toHashCode();
        }


    }
}
