package com.zkb.bilibili.dao;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkb.bilibili.enums.BiliBliTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class BiliBili {
    int code;
    String message;
    int ttl;
    //数据
    BDataDao data;

    /**
     * 获取
     *
     * @return code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     *
     * @return ttl
     */
    public int getTtl() {
        return this.ttl;
    }

    /**
     * 设置
     *
     * @param ttl
     */
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    /**
     * 获取 数据
     *
     * @return data 数据
     */
    public BDataDao getData() {
        return this.data;
    }

    /**
     * 设置 数据
     *
     * @param data 数据
     */
    public void setData(BDataDao data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("code", code)
                .append("message", message)
                .append("ttl", ttl)
                .append("data", data)
                .toString();
    }

    public static class BDataDao {
        boolean hasMore;
        String offset;
        String updateBaseline;
        int updateNum;
        //内容列表
        List<Items> items;

        /**
         * 获取
         *
         * @return hasMore
         */
        public boolean isHasMore() {
            return this.hasMore;
        }

        /**
         * 设置
         *
         * @param hasMore
         */
        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        /**
         * 获取
         *
         * @return offset
         */
        public String getOffset() {
            return this.offset;
        }

        /**
         * 设置
         *
         * @param offset
         */
        public void setOffset(String offset) {
            this.offset = offset;
        }

        /**
         * 获取
         *
         * @return updateBaseline
         */
        public String getUpdateBaseline() {
            return this.updateBaseline;
        }

        /**
         * 设置
         *
         * @param updateBaseline
         */
        public void setUpdateBaseline(String updateBaseline) {
            this.updateBaseline = updateBaseline;
        }

        /**
         * 获取
         *
         * @return updateNum
         */
        public int getUpdateNum() {
            return this.updateNum;
        }

        /**
         * 设置
         *
         * @param updateNum
         */
        public void setUpdateNum(int updateNum) {
            this.updateNum = updateNum;
        }

        /**
         * 获取 内容列表
         *
         * @return items 内容列表
         */
        public List<Items> getItems() {
            return this.items;
        }

        /**
         * 设置 内容列表
         *
         * @param items 内容列表
         */
        public void setItems(List<Items> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("hasMore", hasMore)
                    .append("offset", offset)
                    .append("updateBaseline", updateBaseline)
                    .append("updateNum", updateNum)
                    .append("items", items)
                    .toString();
        }

        public static class Items {
            //详细内容
            Modules modules;
            //类型
            BiliBliTypeEnum type;

            /**
             * 获取 详细内容
             *
             * @return modules 详细内容
             */
            public Modules getModules() {
                return this.modules;
            }

            /**
             * 设置 详细内容
             *
             * @param modules 详细内容
             */
            public void setModules(Modules modules) {
                this.modules = modules;
            }

            /**
             * 获取 类型
             *
             * @return type 类型
             */
            public BiliBliTypeEnum getType() {
                return this.type;
            }

            /**
             * 设置 类型
             *
             * @param type 类型
             */
            public void setType(BiliBliTypeEnum type) {
                this.type = type;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("modules", modules)
                        .append("type", type)
                        .toString();
            }

            public static class Modules {
                //详细信息
                @JsonProperty("module_author")
                ModuleAuthor moduleAuthor;
                //内容
                @JsonProperty("module_dynamic")
                ModuleDynamic moduleDynamic;

                /**
                 * 获取 详细信息
                 *
                 * @return moduleAuthor 详细信息
                 */
                public ModuleAuthor getModuleAuthor() {
                    return this.moduleAuthor;
                }

                /**
                 * 设置 详细信息
                 *
                 * @param moduleAuthor 详细信息
                 */
                public void setModuleAuthor(ModuleAuthor moduleAuthor) {
                    this.moduleAuthor = moduleAuthor;
                }

                /**
                 * 获取 内容
                 *
                 * @return moduleDynamic 内容
                 */
                public ModuleDynamic getModuleDynamic() {
                    return this.moduleDynamic;
                }

                /**
                 * 设置 内容
                 *
                 * @param moduleDynamic 内容
                 */
                public void setModuleDynamic(ModuleDynamic moduleDynamic) {
                    this.moduleDynamic = moduleDynamic;
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                            .append("moduleAuthor", moduleAuthor)
                            .append("moduleDynamic", moduleDynamic)
                            .toString();
                }

                public static class ModuleAuthor {
                    //UUID
                    long mid;
                    //Up Name
                    String name;
                    //发布时间戳
                    @JsonProperty("pub_ts")
                    long pubTs;

                    /**
                     * 获取 UUID
                     *
                     * @return mid UUID
                     */
                    public long getMid() {
                        return this.mid;
                    }

                    /**
                     * 设置 UUID
                     *
                     * @param mid UUID
                     */
                    public void setMid(long mid) {
                        this.mid = mid;
                    }

                    /**
                     * 获取 Up Name
                     *
                     * @return name Up Name
                     */
                    public String getName() {
                        return this.name;
                    }

                    /**
                     * 设置 Up Name
                     *
                     * @param name Up Name
                     */
                    public void setName(String name) {
                        this.name = name;
                    }

                    /**
                     * 获取 发布时间戳
                     *
                     * @return pubTs 发布时间戳
                     */
                    public long getPubTs() {
                        return this.pubTs;
                    }

                    /**
                     * 设置 发布时间戳
                     *
                     * @param pubTs 发布时间戳
                     */
                    public void setPubTs(long pubTs) {
                        this.pubTs = pubTs;
                    }

                    @Override
                    public String toString() {
                        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                                .append("mid", mid)
                                .append("name", name)
                                .append("pubTs", pubTs)
                                .toString();
                    }
                }

                public static class ModuleDynamic {
                    //内容文本
                    Desc desc;

                    /**
                     * 获取 内容文本
                     *
                     * @return desc 内容文本
                     */
                    public Desc getDesc() {
                        return this.desc;
                    }

                    /**
                     * 设置 内容文本
                     *
                     * @param desc 内容文本
                     */
                    public void setDesc(Desc desc) {
                        this.desc = desc;
                    }

                    @Override
                    public String toString() {
                        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                                .append("desc", desc)
                                .toString();
                    }

                    public static class Desc{
                        //文本内容
                        @JsonAlias
                        String text;

                        @Override
                        public String toString() {
                            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                                    .append("text", text)
                                    .toString();
                        }

                        /**
                         * 获取 文本内容
                         *
                         * @return text 文本内容
                         */
                        public String getText() {
                            return this.text;
                        }

                        /**
                         * 设置 文本内容
                         *
                         * @param text 文本内容
                         */
                        public void setText(String text) {
                            this.text = text;
                        }
                    }
                }
            }
        }
    }

}
