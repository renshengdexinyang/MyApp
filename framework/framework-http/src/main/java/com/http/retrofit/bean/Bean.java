package com.http.retrofit.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * date :           2020/12/30 09:49
 * author :         鹏
 * description ：   TODO:类的作用
 */
@NoArgsConstructor
@Data
public class Bean {


    /**
     * reason : Success
     * result : {"data":[{"content":"&nbsp; &nbsp; 小区门口修车师傅生意特好。人实在,只要不换零件，常常不收钱或只收个块把钱辛苦钱。最近发现他心黑了，价钱明显上调,就连充个气也收1块钱。旁边书报亭大妈是知情人，: 唉，多担待一下吧！他家上个月二胎,一窝生了四个带把的。。。。","hashId":"2e010657b420dcee335c870bf9a18301","unixtime":1559789702,"updatetime":"2019-06-06 10:55:02"},{"content":"前天和同事去逛超市，说好久没买肉吃了，于是去看猪肉，结果看到的最便宜的猪肉都要十八块多，同事当场惊呼：\u201c猪怎么了，这是！\u201d卖肉的师傅笑着说：\u201c猪没事，就是涨价了。\u201d","hashId":"d261d1f0d76bdc665d80f104cf7a7d65","unixtime":1556845202,"updatetime":"2019-05-03 09:00:02"}]}
     * error_code : 0
     */

    @JsonProperty("reason")
    private String reason;
    @JsonProperty("result")
    private ResultDTO result;
    @JsonProperty("error_code")
    private Integer errorCode;

    @NoArgsConstructor
    @Data
    public static class ResultDTO {
        @JsonProperty("data")
        private List<DataDTO> data;

        @NoArgsConstructor
        @Data
        public static class DataDTO {
            /**
             * content : &nbsp; &nbsp; 小区门口修车师傅生意特好。人实在,只要不换零件，常常不收钱或只收个块把钱辛苦钱。最近发现他心黑了，价钱明显上调,就连充个气也收1块钱。旁边书报亭大妈是知情人，: 唉，多担待一下吧！他家上个月二胎,一窝生了四个带把的。。。。
             * hashId : 2e010657b420dcee335c870bf9a18301
             * unixtime : 1559789702
             * updatetime : 2019-06-06 10:55:02
             */

            @JsonProperty("content")
            private String content;
            @JsonProperty("hashId")
            private String hashId;
            @JsonProperty("unixtime")
            private Integer unixtime;
            @JsonProperty("updatetime")
            private String updatetime;
        }
    }
}
