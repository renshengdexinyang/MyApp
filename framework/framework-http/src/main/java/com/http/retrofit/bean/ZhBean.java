package com.http.retrofit.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * date :           2020/12/31 14:07
 * author :         鹏
 * description ：   TODO:类的作用
 */

@NoArgsConstructor
@Data
public class ZhBean {


    /**
     * updated : 1599124983
     * description : 知乎社区管理团队官方专栏，不定期更新社区管理工作相关的最新消息。
     * column_type : normal
     * topics : [{"url":"https://www.zhihu.com/api/v4/topics/19552112","type":"topic","id":"19552112","name":"知乎建议反馈"},{"url":"https://www.zhihu.com/api/v4/topics/19550887","type":"topic","id":"19550887","name":"知乎社区"},{"url":"https://www.zhihu.com/api/v4/topics/19550228","type":"topic","id":"19550228","name":"知乎"}]
     * can_manage : false
     * intro : 知乎社区管理团队官方专栏，不定期更新社区管理工作…
     * is_following : false
     * url_token : zhihuadmin
     * id : zhihuadmin
     * articles_count : 240
     * accept_submission : true
     * items_count : 240
     * title : 知乎小管家说
     * url : https://zhuanlan.zhihu.com/zhihuadmin
     * comment_permission : all
     * created : 1445250846
     * videos_count : 0
     * image_url : https://pic2.zhimg.com/5a1ec50171767c4fc856f430e46297db_b.jpg
     * author : {"is_followed":false,"avatar_url_template":"https://pic4.zhimg.com/v2-85b5868ae1ee114c5818d29201aef708_{size}.jpg","uid":"53253479858176","user_type":"people","is_following":false,"url_token":"zhihuadmin","id":"3d198a56310c02c4a83efb9f4a4c027e","description":"帮助中心 ：https://www.zhihu.com/help-center。你想问的，这里可能都有答案哦~","name":"知乎小管家","is_advertiser":false,"headline":"超厉害！知乎百事通，氛围守护者和专业背锅侠","gender":1,"url":"/people/3d198a56310c02c4a83efb9f4a4c027e","avatar_url":"https://pic4.zhimg.com/v2-85b5868ae1ee114c5818d29201aef708_l.jpg","is_org":false,"type":"people"}
     * followers : 17146
     * voteup_count : 143899
     * type : column
     */

    @JsonProperty("updated")
    private Integer updated;
    @JsonProperty("description")
    private String description;
    @JsonProperty("column_type")
    private String columnType;
    @JsonProperty("can_manage")
    private Boolean canManage;
    @JsonProperty("intro")
    private String intro;
    @JsonProperty("is_following")
    private Boolean isFollowing;
    @JsonProperty("url_token")
    private String urlToken;
    @JsonProperty("id")
    private String id;
    @JsonProperty("articles_count")
    private Integer articlesCount;
    @JsonProperty("accept_submission")
    private Boolean acceptSubmission;
    @JsonProperty("items_count")
    private Integer itemsCount;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("comment_permission")
    private String commentPermission;
    @JsonProperty("created")
    private Integer created;
    @JsonProperty("videos_count")
    private Integer videosCount;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("author")
    private AuthorDTO author;
    @JsonProperty("followers")
    private Integer followers;
    @JsonProperty("voteup_count")
    private Integer voteupCount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("topics")
    private List<TopicsDTO> topics;

    @NoArgsConstructor
    @Data
    public static class AuthorDTO {
        /**
         * is_followed : false
         * avatar_url_template : https://pic4.zhimg.com/v2-85b5868ae1ee114c5818d29201aef708_{size}.jpg
         * uid : 53253479858176
         * user_type : people
         * is_following : false
         * url_token : zhihuadmin
         * id : 3d198a56310c02c4a83efb9f4a4c027e
         * description : 帮助中心 ：https://www.zhihu.com/help-center。你想问的，这里可能都有答案哦~
         * name : 知乎小管家
         * is_advertiser : false
         * headline : 超厉害！知乎百事通，氛围守护者和专业背锅侠
         * gender : 1
         * url : /people/3d198a56310c02c4a83efb9f4a4c027e
         * avatar_url : https://pic4.zhimg.com/v2-85b5868ae1ee114c5818d29201aef708_l.jpg
         * is_org : false
         * type : people
         */

        @JsonProperty("is_followed")
        private Boolean isFollowed;
        @JsonProperty("avatar_url_template")
        private String avatarUrlTemplate;
        @JsonProperty("uid")
        private String uid;
        @JsonProperty("user_type")
        private String userType;
        @JsonProperty("is_following")
        private Boolean isFollowing;
        @JsonProperty("url_token")
        private String urlToken;
        @JsonProperty("id")
        private String id;
        @JsonProperty("description")
        private String description;
        @JsonProperty("name")
        private String name;
        @JsonProperty("is_advertiser")
        private Boolean isAdvertiser;
        @JsonProperty("headline")
        private String headline;
        @JsonProperty("gender")
        private Integer gender;
        @JsonProperty("url")
        private String url;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("is_org")
        private Boolean isOrg;
        @JsonProperty("type")
        private String type;
    }

    @NoArgsConstructor
    @Data
    public static class TopicsDTO {
        /**
         * url : https://www.zhihu.com/api/v4/topics/19552112
         * type : topic
         * id : 19552112
         * name : 知乎建议反馈
         */

        @JsonProperty("url")
        private String url;
        @JsonProperty("type")
        private String type;
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }
}
