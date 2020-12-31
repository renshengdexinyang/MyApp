package com.http.retrofit.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Weather {

    @NoArgsConstructor
    @Data
    public static class ResultDTO {
        /**
         * data : {"realtime":{"city_code":"101280601","city_name":"深圳","date":"2020-12-31","time":"14:00:00","week":"4","moon":"十一月十七","dataUptime":1609393779,"weather":{"temperature":"11","humidity":"23","info":"晴","img":"00"},"wind":{"direct":"北风","power":"2级","offset":"","windspeed":""}},"life":{"date":"2020-12-31","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，可放心外出，享受生活。"],"shushidu":["较舒适","白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"],"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"],"diaoyu":["不宜","较前一天有较大降温，不适合垂钓。"],"ganmao":["易发","相对于今天将会出现大幅度降温，易发生感冒，注意增加衣服，加强自我防护避免感冒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"],"daisan":["不带伞","天气较好，不会降水，因此您可放心出门，无须带雨伞。"]}},"weather":[{"date":"2020-12-31","info":{"dawn":["0","晴","5","北风","4-5级","17:49"],"day":["1","多云","14","持续无风向","微风","07:03"],"night":["0","晴","5","持续无风向","微风","17:50"]},"week":"四","nongli":"十一月十七"},{"date":"2021-01-01","info":{"dawn":["0","晴","5","持续无风向","微风","17:50"],"day":["0","晴","16","持续无风向","微风","07:04"],"night":["0","晴","8","持续无风向","微风","17:50"]},"week":"五","nongli":"十一月十八"},{"date":"2021-01-02","info":{"dawn":["0","晴","8","持续无风向","微风","17:50"],"day":["1","多云","19","持续无风向","微风","07:04"],"night":["2","阴","11","持续无风向","微风","17:51"]},"week":"六","nongli":"十一月十九"},{"date":"2021-01-03","info":{"dawn":["2","阴","11","持续无风向","微风","17:51"],"day":["1","多云","19","持续无风向","微风","07:04"],"night":["1","多云","15","持续无风向","微风","17:52"]},"week":"日","nongli":"十一月二十"},{"date":"2021-01-04","info":{"dawn":["1","多云","15","持续无风向","微风","17:52"],"day":["1","多云","21","持续无风向","微风","07:05"],"night":["1","多云","16","持续无风向","微风","17:52"]},"week":"一","nongli":"十一月廿一"}],"f3h":{"temperature":[{"jg":"20201231140000","jb":"11"},{"jg":"20201231170000","jb":"14"},{"jg":"20201231200000","jb":"12"},{"jg":"20201231230000","jb":"9"},{"jg":"20210101020000","jb":"7"},{"jg":"20210101050000","jb":"6"},{"jg":"20210101080000","jb":"5"},{"jg":"20210101110000","jb":"11"},{"jg":"20210101140000","jb":"16"}],"precipitation":[{"jg":"20201231140000","jf":"0"},{"jg":"20201231170000","jf":"0"},{"jg":"20201231200000","jf":"0"},{"jg":"20201231230000","jf":"0"},{"jg":"20210101020000","jf":"0"},{"jg":"20210101050000","jf":"0"},{"jg":"20210101080000","jf":"0"},{"jg":"20210101110000","jf":"0"},{"jg":"20210101140000","jf":"0"}]},"pm25":{"pm25":{"level":1,"quality":"优","des":"空气很棒，快出门呼吸新鲜空气吧。","curPm":"47","pm25":"13","pm10":"47","pub_time":1609390800,"city_code":"101280601"},"cityName":"深圳","key":"深圳","dateTime":"2020年12月31日13时"},"jingqu":"","jingqutq":"","date":"","isForeign":"0","partner":{"title_word":"全国","show_url":"tianqi.so.com","base_url":"http://tianqi.so.com/weather/101280601"}}
         */

        @JsonProperty("data")
        private DataDTO data;

        @NoArgsConstructor
        @Data
        public static class DataDTO {
            /**
             * realtime : {"city_code":"101280601","city_name":"深圳","date":"2020-12-31","time":"14:00:00","week":"4","moon":"十一月十七","dataUptime":1609393779,"weather":{"temperature":"11","humidity":"23","info":"晴","img":"00"},"wind":{"direct":"北风","power":"2级","offset":"","windspeed":""}}
             * life : {"date":"2020-12-31","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，可放心外出，享受生活。"],"shushidu":["较舒适","白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"],"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"],"diaoyu":["不宜","较前一天有较大降温，不适合垂钓。"],"ganmao":["易发","相对于今天将会出现大幅度降温，易发生感冒，注意增加衣服，加强自我防护避免感冒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"],"daisan":["不带伞","天气较好，不会降水，因此您可放心出门，无须带雨伞。"]}}
             * weather : [{"date":"2020-12-31","info":{"dawn":["0","晴","5","北风","4-5级","17:49"],"day":["1","多云","14","持续无风向","微风","07:03"],"night":["0","晴","5","持续无风向","微风","17:50"]},"week":"四","nongli":"十一月十七"},{"date":"2021-01-01","info":{"dawn":["0","晴","5","持续无风向","微风","17:50"],"day":["0","晴","16","持续无风向","微风","07:04"],"night":["0","晴","8","持续无风向","微风","17:50"]},"week":"五","nongli":"十一月十八"},{"date":"2021-01-02","info":{"dawn":["0","晴","8","持续无风向","微风","17:50"],"day":["1","多云","19","持续无风向","微风","07:04"],"night":["2","阴","11","持续无风向","微风","17:51"]},"week":"六","nongli":"十一月十九"},{"date":"2021-01-03","info":{"dawn":["2","阴","11","持续无风向","微风","17:51"],"day":["1","多云","19","持续无风向","微风","07:04"],"night":["1","多云","15","持续无风向","微风","17:52"]},"week":"日","nongli":"十一月二十"},{"date":"2021-01-04","info":{"dawn":["1","多云","15","持续无风向","微风","17:52"],"day":["1","多云","21","持续无风向","微风","07:05"],"night":["1","多云","16","持续无风向","微风","17:52"]},"week":"一","nongli":"十一月廿一"}]
             * f3h : {"temperature":[{"jg":"20201231140000","jb":"11"},{"jg":"20201231170000","jb":"14"},{"jg":"20201231200000","jb":"12"},{"jg":"20201231230000","jb":"9"},{"jg":"20210101020000","jb":"7"},{"jg":"20210101050000","jb":"6"},{"jg":"20210101080000","jb":"5"},{"jg":"20210101110000","jb":"11"},{"jg":"20210101140000","jb":"16"}],"precipitation":[{"jg":"20201231140000","jf":"0"},{"jg":"20201231170000","jf":"0"},{"jg":"20201231200000","jf":"0"},{"jg":"20201231230000","jf":"0"},{"jg":"20210101020000","jf":"0"},{"jg":"20210101050000","jf":"0"},{"jg":"20210101080000","jf":"0"},{"jg":"20210101110000","jf":"0"},{"jg":"20210101140000","jf":"0"}]}
             * pm25 : {"pm25":{"level":1,"quality":"优","des":"空气很棒，快出门呼吸新鲜空气吧。","curPm":"47","pm25":"13","pm10":"47","pub_time":1609390800,"city_code":"101280601"},"cityName":"深圳","key":"深圳","dateTime":"2020年12月31日13时"}
             * jingqu :
             * jingqutq :
             * date :
             * isForeign : 0
             * partner : {"title_word":"全国","show_url":"tianqi.so.com","base_url":"http://tianqi.so.com/weather/101280601"}
             */

            @JsonProperty("realtime")
            private RealtimeDTO realtime;
            @JsonProperty("life")
            private LifeDTO life;
            @JsonProperty("f3h")
            private F3hDTO f3h;
            @JsonProperty("pm25")
            private Pm25DTO pm25;
            @JsonProperty("jingqu")
            private String jingqu;
            @JsonProperty("jingqutq")
            private String jingqutq;
            @JsonProperty("date")
            private String date;
            @JsonProperty("isForeign")
            private String isForeign;
            @JsonProperty("partner")
            private PartnerDTO partner;
            @JsonProperty("weather")
            private List<WeatherDTO> weather;

            @NoArgsConstructor
            @Data
            public static class RealtimeDTO {
                /**
                 * city_code : 101280601
                 * city_name : 深圳
                 * date : 2020-12-31
                 * time : 14:00:00
                 * week : 4
                 * moon : 十一月十七
                 * dataUptime : 1609393779
                 * weather : {"temperature":"11","humidity":"23","info":"晴","img":"00"}
                 * wind : {"direct":"北风","power":"2级","offset":"","windspeed":""}
                 */

                @JsonProperty("city_code")
                private String cityCode;
                @JsonProperty("city_name")
                private String cityName;
                @JsonProperty("date")
                private String date;
                @JsonProperty("time")
                private String time;
                @JsonProperty("week")
                private String week;
                @JsonProperty("moon")
                private String moon;
                @JsonProperty("dataUptime")
                private Integer dataUptime;
                @JsonProperty("weather")
                private WeatherDTO weather;
                @JsonProperty("wind")
                private WindDTO wind;

                @NoArgsConstructor
                @Data
                public static class WeatherDTO {
                    /**
                     * temperature : 11
                     * humidity : 23
                     * info : 晴
                     * img : 00
                     */

                    @JsonProperty("temperature")
                    private String temperature;
                    @JsonProperty("humidity")
                    private String humidity;
                    @JsonProperty("info")
                    private String info;
                    @JsonProperty("img")
                    private String img;
                }

                @NoArgsConstructor
                @Data
                public static class WindDTO {
                    /**
                     * direct : 北风
                     * power : 2级
                     * offset :
                     * windspeed :
                     */

                    @JsonProperty("direct")
                    private String direct;
                    @JsonProperty("power")
                    private String power;
                    @JsonProperty("offset")
                    private String offset;
                    @JsonProperty("windspeed")
                    private String windspeed;
                }
            }

            @NoArgsConstructor
            @Data
            public static class LifeDTO {
                /**
                 * date : 2020-12-31
                 * info : {"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，可放心外出，享受生活。"],"shushidu":["较舒适","白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"],"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"],"diaoyu":["不宜","较前一天有较大降温，不适合垂钓。"],"ganmao":["易发","相对于今天将会出现大幅度降温，易发生感冒，注意增加衣服，加强自我防护避免感冒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"],"daisan":["不带伞","天气较好，不会降水，因此您可放心出门，无须带雨伞。"]}
                 */

                @JsonProperty("date")
                private String date;
                @JsonProperty("info")
                private InfoDTO info;

                @NoArgsConstructor
                @Data
                public static class InfoDTO {
                    @JsonProperty("kongtiao")
                    private List<String> kongtiao;
                    @JsonProperty("guomin")
                    private List<String> guomin;
                    @JsonProperty("shushidu")
                    private List<String> shushidu;
                    @JsonProperty("chuanyi")
                    private List<String> chuanyi;
                    @JsonProperty("diaoyu")
                    private List<String> diaoyu;
                    @JsonProperty("ganmao")
                    private List<String> ganmao;
                    @JsonProperty("ziwaixian")
                    private List<String> ziwaixian;
                    @JsonProperty("xiche")
                    private List<String> xiche;
                    @JsonProperty("yundong")
                    private List<String> yundong;
                    @JsonProperty("daisan")
                    private List<String> daisan;
                }
            }

            @NoArgsConstructor
            @Data
            public static class F3hDTO {
                @JsonProperty("temperature")
                private List<TemperatureDTO> temperature;
                @JsonProperty("precipitation")
                private List<PrecipitationDTO> precipitation;

                @NoArgsConstructor
                @Data
                public static class TemperatureDTO {
                    /**
                     * jg : 20201231140000
                     * jb : 11
                     */

                    @JsonProperty("jg")
                    private String jg;
                    @JsonProperty("jb")
                    private String jb;
                }

                @NoArgsConstructor
                @Data
                public static class PrecipitationDTO {
                    /**
                     * jg : 20201231140000
                     * jf : 0
                     */

                    @JsonProperty("jg")
                    private String jg;
                    @JsonProperty("jf")
                    private String jf;
                }
            }

            @NoArgsConstructor
            @Data
            public static class Pm25DTO {
                /**
                 * pm25 : {"level":1,"quality":"优","des":"空气很棒，快出门呼吸新鲜空气吧。","curPm":"47","pm25":"13","pm10":"47","pub_time":1609390800,"city_code":"101280601"}
                 * cityName : 深圳
                 * key : 深圳
                 * dateTime : 2020年12月31日13时
                 */

                @JsonProperty("pm25")
                private Pm25DTO2 pm25;
                @JsonProperty("cityName")
                private String cityName;
                @JsonProperty("key")
                private String key;
                @JsonProperty("dateTime")
                private String dateTime;

                @NoArgsConstructor
                @Data
                public static class Pm25DTO2 {
                    /**
                     * level : 1
                     * quality : 优
                     * des : 空气很棒，快出门呼吸新鲜空气吧。
                     * curPm : 47
                     * pm25 : 13
                     * pm10 : 47
                     * pub_time : 1609390800
                     * city_code : 101280601
                     */

                    @JsonProperty("level")
                    private Integer level;
                    @JsonProperty("quality")
                    private String quality;
                    @JsonProperty("des")
                    private String des;
                    @JsonProperty("curPm")
                    private String curPm;
                    @JsonProperty("pm25")
                    private String pm25;
                    @JsonProperty("pm10")
                    private String pm10;
                    @JsonProperty("pub_time")
                    private Integer pubTime;
                    @JsonProperty("city_code")
                    private String cityCode;
                }
            }

            @NoArgsConstructor
            @Data
            public static class PartnerDTO {
                /**
                 * title_word : 全国
                 * show_url : tianqi.so.com
                 * base_url : http://tianqi.so.com/weather/101280601
                 */

                @JsonProperty("title_word")
                private String titleWord;
                @JsonProperty("show_url")
                private String showUrl;
                @JsonProperty("base_url")
                private String baseUrl;
            }

            @NoArgsConstructor
            @Data
            public static class WeatherDTO {
                /**
                 * date : 2020-12-31
                 * info : {"dawn":["0","晴","5","北风","4-5级","17:49"],"day":["1","多云","14","持续无风向","微风","07:03"],"night":["0","晴","5","持续无风向","微风","17:50"]}
                 * week : 四
                 * nongli : 十一月十七
                 */

                @JsonProperty("date")
                private String date;
                @JsonProperty("info")
                private InfoDTO info;
                @JsonProperty("week")
                private String week;
                @JsonProperty("nongli")
                private String nongli;

                @NoArgsConstructor
                @Data
                public static class InfoDTO {
                    @JsonProperty("dawn")
                    private List<String> dawn;
                    @JsonProperty("day")
                    private List<String> day;
                    @JsonProperty("night")
                    private List<String> night;
                }
            }
        }
    }
}