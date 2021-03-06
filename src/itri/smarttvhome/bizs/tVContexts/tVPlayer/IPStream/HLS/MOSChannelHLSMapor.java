package itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.HLS;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.IChannelIPStreamMapor;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.IPStreamInfo;

/**
 * Created by mimi on 15/3/16.
 */
public class MOSChannelHLSMapor implements IChannelIPStreamMapor {
    private Map<String, IPStreamInfo> hlsInfos = new HashMap();
    private int minChannel = 5;
    private int maxChannel = 605;
    private int currentChnnelNumber = 5;

    public MOSChannelHLSMapor() {
        Log.e("MOSChannelHLSMapor", "constructor");
        //請照頻道數排列,為了算出按上下鍵算出上一個頻道,下一個頻道
        this.hlsInfos.put("005", new IPStreamInfo("005", "民視", "http://58.99.33.2:1935/liveedge/live_5_1.stream/playlist.m3u8?"));
        this.hlsInfos.put("006", new IPStreamInfo("006", "CNN", "http://58.99.33.2:1935/liveedge2/live_6_1.stream/playlist.m3u8?"));
        this.hlsInfos.put("007", new IPStreamInfo("007", "台視", "http://58.99.33.2:1935/liveedge/live_7_1.stream/playlist.m3u8?"));
        this.hlsInfos.put("008", new IPStreamInfo("008", "人間衛視", "http://58.99.33.2:1935/liveedge2/live_8_1.stream/playlist.m3u8?"));
        this.hlsInfos.put("009", new IPStreamInfo("009", "中視", "http://58.99.33.2:1935/liveedge/live_9_1.stream/playlist.m3u8?"));

        this.hlsInfos.put("010", new IPStreamInfo("010", "大愛", "http://58.99.33.2:1935/liveedge/live_10_1.stream/playlist.m3u8?"));
        this.hlsInfos.put("011", new IPStreamInfo("011", "華視", "http://58.99.33.2:1935/liveedge/live_11_1.stream/playlist.m3u8?"));
        this.hlsInfos.put("012", new IPStreamInfo("012", "動物星球", "http://58.99.33.2:1935/liveedge/live_12_1.stream/playlist.m3u8"));
        this.hlsInfos.put("013", new IPStreamInfo("013", "公視", "http://58.99.33.2:1935/liveedge/live_13_1.stream/playlist.m3u8"));
        this.hlsInfos.put("015", new IPStreamInfo("015", "好消息", "http://58.99.33.2:1935/liveedge2/live_15_1.stream/playlist.m3u8"));
        this.hlsInfos.put("016", new IPStreamInfo("016", "原住民頻道", "http://58.99.33.2:1935/liveedge/live_16_1.stream/playlist.m3u8"));
        this.hlsInfos.put("017", new IPStreamInfo("017", "客家頻道", "http://58.99.33.2:1935/liveedge2/live_17_1.stream/playlist.m3u8"));
        this.hlsInfos.put("018", new IPStreamInfo("018", "國家地理頻道", "http://58.99.33.2:1935/liveedge/live_18_1.stream/playlist.m3u8"));
        this.hlsInfos.put("019", new IPStreamInfo("019", "Discovery", "http://58.99.33.2:1935/liveedge/live_19_1.stream/playlist.m3u8"));

        this.hlsInfos.put("020", new IPStreamInfo("020", "中台灣生活網", "http://58.99.33.2:1935/liveedge/live_20_1.stream/playlist.m3u8"));
        this.hlsInfos.put("021", new IPStreamInfo("021", "旅遊生活", "http://58.99.33.2:1935/liveedge2/live_21_1.stream/playlist.m3u8"));
        this.hlsInfos.put("022", new IPStreamInfo("022", "Cartoon Network", "http://58.99.33.2:1935/liveedge2/live_22_1.stream/playlist.m3u8"));
        this.hlsInfos.put("023", new IPStreamInfo("023", "迪士尼", "http://58.99.33.2:1935/liveedge2/live_23_1.stream/playlist.m3u8"));
        this.hlsInfos.put("024", new IPStreamInfo("024", "MOMO親子台", "http://58.99.33.2:1935/liveedge/live_24_1.stream/playlist.m3u8"));
        this.hlsInfos.put("025", new IPStreamInfo("025", "東森幼幼台", "http://58.99.33.2:1935/liveedge/live_25_1.stream/playlist.m3u8"));
        this.hlsInfos.put("026", new IPStreamInfo("026", "緯來綜合台", "http://58.99.33.2:1935/liveedge/live_26_1.stream/playlist.m3u8"));
        this.hlsInfos.put("027", new IPStreamInfo("027", "八大第一台", "http://58.99.33.2:1935/liveedge/live_27_1.stream/playlist.m3u8"));
        this.hlsInfos.put("028", new IPStreamInfo("028", "八大綜合台", "http://58.99.33.2:1935/liveedge/live_28_1.stream/playlist.m3u8"));
        this.hlsInfos.put("029", new IPStreamInfo("029", "三立台灣台", "http://58.99.33.2:1935/liveedge/live_29_1.stream/playlist.m3u8"));

        this.hlsInfos.put("030", new IPStreamInfo("030", "三立都會台", "http://58.99.33.2:1935/liveedge/live_30_1.stream/playlist.m3u8"));
        this.hlsInfos.put("031", new IPStreamInfo("031", "衛視中文台", "http://58.99.33.2:1935/liveedge/live_31_1.stream/playlist.m3u8"));
        this.hlsInfos.put("032", new IPStreamInfo("032", "東森綜合台", "http://58.99.33.2:1935/liveedge/live_32_1.stream/playlist.m3u8"));
        this.hlsInfos.put("033", new IPStreamInfo("033", "超視", "http://58.99.33.2:1935/liveedge2/live_33_1.stream/playlist.m3u8"));
        this.hlsInfos.put("034", new IPStreamInfo("034", "中天娛樂台", "http://58.99.33.2:1935/liveedge/live_34_1.stream/playlist.m3u8"));
        this.hlsInfos.put("035", new IPStreamInfo("035", "東森購物2台 立即下單現折100", "http://58.99.33.1:1935/liveedge/live_35_1.stream/playlist.m3u8"));
        this.hlsInfos.put("036", new IPStreamInfo("036", "MOMO 2台", "http://58.99.33.2:1935/liveedge2/live_36_1.stream/playlist.m3u8"));
        this.hlsInfos.put("037", new IPStreamInfo("037", "東風衛視", "http://58.99.33.2:1935/liveedge/live_37_1.stream/playlist.m3u8"));
        this.hlsInfos.put("038", new IPStreamInfo("038", "MUCH TV", "http://58.99.33.2:1935/liveedge/live_38_1.stream/playlist.m3u8"));
        this.hlsInfos.put("039", new IPStreamInfo("039", "地方采風", "http://58.99.33.2:1935/liveedge2/live_39_1.stream/playlist.m3u8"));

        this.hlsInfos.put("040", new IPStreamInfo("040", "東森戲劇台", "http://58.99.33.2:1935/liveedge/live_40_1.stream/playlist.m3u8"));
        this.hlsInfos.put("041", new IPStreamInfo("041", "八大戲劇", "http://58.99.33.2:1935/liveedge/live_41_1.stream/playlist.m3u8"));
        this.hlsInfos.put("042", new IPStreamInfo("042", "TVBS-G", "http://58.99.33.2:1935/liveedge2/live_42_1.stream/playlist.m3u8"));
        this.hlsInfos.put("043", new IPStreamInfo("043", "緯來戲劇台", "http://58.99.33.2:1935/liveedge/live_43_1.stream/playlist.m3u8"));
        this.hlsInfos.put("044", new IPStreamInfo("044", "高點", "http://58.99.33.2:1935/liveedge/live_44_1.stream/playlist.m3u8"));
        this.hlsInfos.put("045", new IPStreamInfo("045", "JET TV", "http://58.99.33.2:1935/liveedge/live_45_1.stream/playlist.m3u8"));
        this.hlsInfos.put("046", new IPStreamInfo("046", "森森百貨1台 立即下單現折100", "http://58.99.33.1:1935/liveedge/live_46_1.stream/playlist.m3u8"));
        this.hlsInfos.put("047", new IPStreamInfo("047", "東森購物1台 立即下單現折100", "http://58.99.33.1:1935/liveedge/live_47_1.stream/playlist.m3u8"));
        this.hlsInfos.put("049", new IPStreamInfo("049", "壹電視新聞台", "http://58.99.33.2:1935/liveedge/live_49_1.stream/playlist.m3u8"));

        this.hlsInfos.put("050", new IPStreamInfo("050", "年代新聞台", "http://58.99.33.2:1935/liveedge/live_50_1.stream/playlist.m3u8"));
        this.hlsInfos.put("051", new IPStreamInfo("051", "東森新聞台", "http://58.99.33.2:1935/liveedge/live_51_1.stream/playlist.m3u8"));
        this.hlsInfos.put("052", new IPStreamInfo("052", "中天新聞台", "http://58.99.33.2:1935/liveedge/live_52_1.stream/playlist.m3u8"));
        this.hlsInfos.put("053", new IPStreamInfo("053", "民視新聞台", "http://58.99.33.2:1935/liveedge/live_53_1.stream/playlist.m3u8"));
        this.hlsInfos.put("054", new IPStreamInfo("054", "三立新聞台", "http://58.99.33.2:1935/liveedge/live_54_1.stream/playlist.m3u8"));
        this.hlsInfos.put("055", new IPStreamInfo("055", "TVBS-N", "http://58.99.33.2:1935/liveedge2/live_55_1.stream/playlist.m3u8"));
        this.hlsInfos.put("056", new IPStreamInfo("056", "TVBS", "http://58.99.33.2:1935/liveedge/live_56_1.stream/playlist.m3u8"));
        this.hlsInfos.put("057", new IPStreamInfo("057", "東森財經新聞", "http://58.99.33.2:1935/liveedge/live_57_1.stream/playlist.m3u8"));
        this.hlsInfos.put("058", new IPStreamInfo("058", "非凡新聞", "http://58.99.33.2:1935/liveedge/live_58_1.stream/playlist.m3u8"));
        this.hlsInfos.put("059", new IPStreamInfo("059", "VIVA1台", "http://58.99.33.2:1935/liveedge2/live_59_1.stream/playlist.m3u8"));

        this.hlsInfos.put("060", new IPStreamInfo("060", "森森百貨2台 立即下單現折100", "http://58.99.33.1:1935/liveedge/live_47_1.stream/playlist.m3u8"));
        this.hlsInfos.put("061", new IPStreamInfo("061", "衛視電影台", "http://58.99.33.2:1935/liveedge/live_61_1.stream/playlist.m3u8"));
        this.hlsInfos.put("062", new IPStreamInfo("062", "東森電影台", "http://58.99.33.2:1935/liveedge/live_62_1.stream/playlist.m3u8"));
        this.hlsInfos.put("063", new IPStreamInfo("063", "緯來育樂台", "http://58.99.33.2:1935/liveedge2/live_63_1.stream/playlist.m3u8"));
        this.hlsInfos.put("064", new IPStreamInfo("064", "冠軍", "http://58.99.33.2:1935/liveedge/live_64_1.stream/playlist.m3u8"));
        this.hlsInfos.put("065", new IPStreamInfo("065", "HBO", "http://58.99.33.2:1935/liveedge/live_65_1.stream/playlist.m3u8"));
        this.hlsInfos.put("066", new IPStreamInfo("066", "東森洋片台", "http://58.99.33.2:1935/liveedge/live_66_1.stream/playlist.m3u8"));
        this.hlsInfos.put("067", new IPStreamInfo("067", "中天綜合台", "http://58.99.33.2:1935/liveedge/live_67_1.stream/playlist.m3u8"));
        this.hlsInfos.put("068", new IPStreamInfo("068", "好萊塢電影台", "http://58.99.33.2:1935/liveedge/live_68_1.stream/playlist.m3u8"));
        this.hlsInfos.put("069", new IPStreamInfo("069", "衛視西片台", "http://58.99.33.2:1935/liveedge/live_69_1.stream/playlist.m3u8"));

        this.hlsInfos.put("070", new IPStreamInfo("070", "冠軍HD", "http://58.99.33.2:1935/liveedge2/live_70_1.stream/playlist.m3u8"));
        this.hlsInfos.put("071", new IPStreamInfo("071", "CINEMAX", "http://58.99.33.2:1935/liveedge/live_71_1.stream/playlist.m3u8"));
        this.hlsInfos.put("072", new IPStreamInfo("072", "緯來體育台", "http://58.99.33.2:1935/liveedge/live_72_1.stream/playlist.m3u8"));
        this.hlsInfos.put("073", new IPStreamInfo("073", "FOX SPORTS", "http://58.99.33.2:1935/liveedge/live_73_1.stream/playlist.m3u8"));
        this.hlsInfos.put("074", new IPStreamInfo("074", "FOX SPORTS 2", "http://58.99.33.2:1935/liveedge4/live_74_1.stream/playlist.m3u8"));
        this.hlsInfos.put("075", new IPStreamInfo("075", "緯來日本台", "http://58.99.33.2:1935/liveedge/live_75_2.stream/playlist.m3u8"));
        this.hlsInfos.put("076", new IPStreamInfo("076", "國興衛視", "http://58.99.33.2:1935/liveedge4/live_76_1.stream/playlist.m3u8"));
        this.hlsInfos.put("077", new IPStreamInfo("077", "海豚綜合台", "http://58.99.33.2:1935/liveedge4/live_77_1.stream/playlist.m3u8"));
        this.hlsInfos.put("078", new IPStreamInfo("078", "民俗才藝", "http://58.99.33.2:1935/liveedge4/live_78_1.stream/playlist.m3u8"));
        this.hlsInfos.put("079", new IPStreamInfo("079", "MTV", "http://58.99.33.2:1935/liveedge4/live_79_1.stream/playlist.m3u8"));
        //this.hlsInfos.put("79",new HLSInfo("MTV","rtsp://58.99.33.2:1935/liveedge4/live_101_1.stream/playlist.m3u8"));

        this.hlsInfos.put("080", new IPStreamInfo("080", "森森百貨3台 立即下單現折100", "http://58.99.33.1:1935/liveedge/live_80_1.stream/playlist.m3u8"));
        this.hlsInfos.put("081", new IPStreamInfo("081", "VIVA 2台", "http://58.99.33.2:1935/liveedge4/live_81_1.stream/playlist.m3u8"));
        this.hlsInfos.put("082", new IPStreamInfo("082", "信吉", "http://58.99.33.2:1935/liveedge4/live_82_1.stream/playlist.m3u8"));
        this.hlsInfos.put("083", new IPStreamInfo("083", "生活資訊", "http://58.99.33.2:1935/liveedge4/live_83_1.stream/playlist.m3u8"));
        this.hlsInfos.put("084", new IPStreamInfo("084", "AXN", "http://58.99.33.2:1935/liveedge/live_84_1.stream/playlist.m3u8"));
        this.hlsInfos.put("085", new IPStreamInfo("085", "台灣綜合台", "http://58.99.33.2:1935/liveedge4/live_85_1.stream/playlist.m3u8"));
        this.hlsInfos.put("086", new IPStreamInfo("086", "信大電視台", "http://‰58.99.33.2:1935/liveedge4/live_86_1.stream/playlist.m3u8"));
        this.hlsInfos.put("087", new IPStreamInfo("087", "緯來電影台", "http://58.99.33.2:1935/liveedge/live_87_1.stream/playlist.m3u8"));
        this.hlsInfos.put("088", new IPStreamInfo("088", "三立財經", "http://58.99.33.2:1935/liveedge/live_88_1.stream/playlist.m3u8"));
        this.hlsInfos.put("089", new IPStreamInfo("089", "凱亞綜合台", "http://58.99.33.2:1935/liveedge4/live_89_1.stream/playlist.m3u8"));

        this.hlsInfos.put("090", new IPStreamInfo("090", "台藝", "http://58.99.33.2:1935/liveedge4/live_90_1.stream/playlist.m3u8"));
        this.hlsInfos.put("091", new IPStreamInfo("091", "LS TIME 電影台", "http://58.99.33.2:1935/liveedge4/live_91_1.stream/playlist.m3u8"));
        this.hlsInfos.put("092", new IPStreamInfo("092", "台灣番薯電視台", "http://58.99.33.2:1935/liveedge4/live_92_1.stream/playlist.m3u8"));
        this.hlsInfos.put("093", new IPStreamInfo("093", "財經", "http://58.99.33.2:1935/liveedge4/live_93_1.stream/playlist.m3u8"));
        this.hlsInfos.put("094", new IPStreamInfo("094", "財訊", "http://58.99.33.2:1935/liveedge4/live_94_1.stream/playlist.m3u8"));
        this.hlsInfos.put("095", new IPStreamInfo("095", "非凡商業台", "http://58.99.33.2:1935/liveedge4/live_95_1.stream/playlist.m3u8"));
        this.hlsInfos.put("096", new IPStreamInfo("096", "霹靂台灣台", "http://58.99.33.2:1935/liveedge4/live_96_1.stream/playlist.m3u8"));
        this.hlsInfos.put("097", new IPStreamInfo("097", "Z", "http://58.99.33.2:1935/liveedge/live_97_1.stream/playlist.m3u8"));
        this.hlsInfos.put("098", new IPStreamInfo("098", "NHK", "http://58.99.33.2:1935/liveedge4/live_98_1.stream/playlist.m3u8"));

        this.hlsInfos.put("101", new IPStreamInfo("101", "FOX頻道", "http://58.99.33.2:1935/liveedge4/live_100_1.stream/playlist.m3u8"));
        this.hlsInfos.put("107", new IPStreamInfo("107", "唯心電視台", "http://58.99.33.2:1935/liveedge4/live_107_1.stream/playlist.m3u8"));
        this.hlsInfos.put("108", new IPStreamInfo("108", "華視新聞資訊", "http://58.99.33.2:1935/liveedge4/live_108_1.stream/playlist.m3u8"));

        this.hlsInfos.put("110", new IPStreamInfo("110", "華視教育頻道", "http://58.99.33.2:1935/liveedge4/live_110_1.stream/playlist.m3u8"));
        this.hlsInfos.put("112", new IPStreamInfo("112", "Discovery HD World", "http://58.99.33.2:1935/liveedge4/live_112_1.stream/playlist.m3u8"));
        this.hlsInfos.put("113", new IPStreamInfo("113", "國家地理高畫質頻道", "http://58.99.33.2:1935/liveedge4/live_113_2.stream/playlist.m3u8"));
        this.hlsInfos.put("114", new IPStreamInfo("114", "國家地理高畫質野生頻道", "http://58.99.33.2:1935/liveedge4/live_114_1.stream/playlist.m3u8"));
        this.hlsInfos.put("115", new IPStreamInfo("115", "福斯家庭電影台", "http://58.99.33.2:1935/liveedge4/live_115_1.stream/playlist.m3u8"));
        this.hlsInfos.put("116", new IPStreamInfo("116", "FOX HD", "http://58.99.33.2:1935/liveedge4/live_116_1.stream/playlist.m3u8"));
        this.hlsInfos.put("117", new IPStreamInfo("117", "Channel M", "http://58.99.33.2:1935/liveedge4/live_117_1.stream/playlist.m3u8"));
        this.hlsInfos.put("118", new IPStreamInfo("118", "公共電視高畫質頻道", "http://58.99.33.2:1935/liveedge4/live_118_1.stream/playlist.m3u8"));
        this.hlsInfos.put("119", new IPStreamInfo("119", "udn新聞台", "http://58.99.33.2:1935/liveedge4/live_119_1.stream/playlist.m3u8"));

        this.hlsInfos.put("123", new IPStreamInfo("123", "華視HD", "http://58.99.33.2:1935/liveedge4/live_123_1.stream/playlist.m3u8"));

        this.hlsInfos.put("130", new IPStreamInfo("130", "Discovery 科學頻道", "http://58.99.33.2:1935/liveedge4/live_130_1.stream/playlist.m3u8"));
        this.hlsInfos.put("131", new IPStreamInfo("131", "DMAX", "http://58.99.33.2:1935/liveedge4/live_131_1.stream/playlist.m3u8"));
        this.hlsInfos.put("132", new IPStreamInfo("132", "eve", "http://58.99.33.2:1935/liveedge4/live_132_1.stream/playlist.m3u8"));

        this.hlsInfos.put("201", new IPStreamInfo("201", "大愛二台", "http://58.99.33.2:1935/liveedge4/live_201_1.stream/playlist.m3u8"));
        this.hlsInfos.put("202", new IPStreamInfo("202", "衛視合家歡", "http://58.99.33.2:1935/liveedge4/live_202_1.stream/playlist.m3u8"));
        this.hlsInfos.put("205", new IPStreamInfo("205", "Channel NEWS ASIA", "http://58.99.33.2:1935/liveedge4/live_205_1.stream/playlist.m3u8"));
        this.hlsInfos.put("207", new IPStreamInfo("207", "BBC World News", "http://58.99.33.2:1935/liveedge4/live_207_1.stream/playlist.m3u8"));

        this.hlsInfos.put("210", new IPStreamInfo("210", "國家地理音樂頻道", "http://58.99.33.2:1935/liveedge4/live_210_1.stream/playlist.m3u8"));

        this.hlsInfos.put("222", new IPStreamInfo("222", "股市資訊", "http://58.99.33.2:1935/liveedge4/live_222_1.stream/playlist.m3u8"));

        this.hlsInfos.put("301", new IPStreamInfo("301", "HBO HD", "http://58.99.33.2:1935/liveedge4/live_301_1.stream/playlist.m3u8"));
        this.hlsInfos.put("302", new IPStreamInfo("302", "HBO Signature", "http://58.99.33.2:1935/liveedge4/live_302_1.stream/playlist.m3u8"));
        this.hlsInfos.put("303", new IPStreamInfo("303", "HBO Family", "http://58.99.33.2:1935/liveedge4/live_303_1.stream/playlist.m3u8"));
        this.hlsInfos.put("304", new IPStreamInfo("304", "HBO Hits", "http://58.99.33.2:1935/liveedge4/live_304_1.stream/playlist.m3u8"));

        this.hlsInfos.put("401", new IPStreamInfo("401", "玩家頻道", "http://58.99.33.2:1935/liveedge4/live_401_1.stream/playlist.m3u8"));
        this.hlsInfos.put("402", new IPStreamInfo("402", "Happy 頻道", "http://58.99.33.2:1935/liveedge4/live_402_1.stream/playlist.m3u8"));
        this.hlsInfos.put("403", new IPStreamInfo("403", "Hot 頻道", "http://58.99.33.2:1935/liveedge4/live_403_1.stream/playlist.m3u8"));
        this.hlsInfos.put("404", new IPStreamInfo("404", "松視4台", "http://58.99.33.2:1935/liveedge4/live_404_1.stream/playlist.m3u8"));
        this.hlsInfos.put("405", new IPStreamInfo("405", "松視1台", "http://58.99.33.2:1935/liveedge4/live_405_1.stream/playlist.m3u8"));
        this.hlsInfos.put("406", new IPStreamInfo("406", "松視2台", "http://58.99.33.2:1935/liveedge4/live_406_1.stream/playlist.m3u8"));
        this.hlsInfos.put("407", new IPStreamInfo("407", "松視3台", "http://58.99.33.2:1935/liveedge4/live_407_1.stream/playlist.m3u8"));
        this.hlsInfos.put("408", new IPStreamInfo("408", "彩虹頻道", "http://58.99.33.2:1935/liveedge4/live_408_1.stream/playlist.m3u8"));

        this.hlsInfos.put("411", new IPStreamInfo("411", "潘朵啦高畫質玩美台", "http://58.99.33.2:1935/liveedge4/live_411_1.stream/playlist.m3u8"));
        this.hlsInfos.put("412", new IPStreamInfo("412", "潘朵啦高畫質粉紅台", "http://58.99.33.2:1935/liveedge4/live_412_1.stream/playlist.m3u8"));

        this.hlsInfos.put("601", new IPStreamInfo("601", "Golf Channel", "http://58.99.33.2:1935/liveedge4/live_601_1.stream/playlist.m3u8"));
        this.hlsInfos.put("602", new IPStreamInfo("602", "博斯網球網", "http://58.99.33.2:1935/liveedge4/live_602_1.stream/playlist.m3u8"));
        this.hlsInfos.put("603", new IPStreamInfo("603", "博斯足球台", "http://58.99.33.2:1935/liveedge4/live_603_1.stream/playlist.m3u8"));
        this.hlsInfos.put("604", new IPStreamInfo("604", "博斯魅力網", "http://58.99.33.2:1935/liveedge4/live_604_1.stream/playlist.m3u8"));
        this.hlsInfos.put("605", new IPStreamInfo("605", "Golf Plus", "http://58.99.33.2:1935/liveedge4/live_605_1.stream/playlist.m3u8"));
    }


    @Override
    public IPStreamInfo getIPStreamByChannel(int channelNumber) {
        IPStreamInfo result;
        String channel = ("000" + channelNumber);
        int sublength = channel.length() - 3;
        String searchKey = channel.substring(sublength);
        Log.e("MOSChannelHLSMapor", "getHLSByChannel_SearchKey:" + searchKey);
        result = this.hlsInfos.get(searchKey);
        if (result != null) {
            this.currentChnnelNumber = channelNumber;
        }
        return result;
    }

    @Override
    public IPStreamInfo getPreChannel() {
        IPStreamInfo result = null;
        while (result == null && this.currentChnnelNumber > this.minChannel) {
            this.currentChnnelNumber--;
//            if (this.currentChnnelNumber == this.minChannel)
//                this.currentChnnelNumber = this.minChannel;
            result = this.getIPStreamByChannel(this.currentChnnelNumber);
        }
        return result;
    }

    @Override
    public IPStreamInfo getNextChannel() {
        IPStreamInfo result = null;
        while (result == null && this.currentChnnelNumber < this.maxChannel) {
            this.currentChnnelNumber++;
//            if (this.currentChnnelNumber == this.maxChannel)
//                this.currentChnnelNumber = this.maxChannel;
            result = this.getIPStreamByChannel(this.currentChnnelNumber);
        }
        return result;
    }
}
