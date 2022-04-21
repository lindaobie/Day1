package com.ldb02.commonlyusedclasses.date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;



/**
 * @author LinDaobie
 * @date 2022-04-13 2:22
 */

public class Instance1 {
    /*

    Instant - 瞬时

        一、使用
            1.多用于返回 总毫秒数

        二、构造
            1.使用 static 的 now() 方法构造 -> now()：获取本初子午线 对应的 标准时间

     */

    public static void main(String[] args) {


        System.out.println("version1");

        System.out.println(" version 1 in branch 'hot_fix' ");


        // 一、now()：获取本初子午线 对应的 标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        // 2022-04-12T18:27:30.836Z
        // 注意！这个时间是按照 本初子午线来进行 划分的，也就是英国的时间！
        // 调整成中国时间，我们和英国时间差了8个小时，应该使用下面的方法：

        // instant.atOffSet(ZoneOffSet.ofXxx)
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        // 2022-04-13T02:29:43.247+08:00
        // 上面的才是现在的 中国的 时间，我们使用了 OffSetDateTime 创建了它的引用 来接收数据。

        // toEpochMilli()：
        // 返回 从格林威治标准时间（UTC）到现在的 毫秒数
        // == Date.getTime()
        long l1 = instant.toEpochMilli();
        System.out.println(l1);
        // 1649788343363

        // ofEpochMilli()：
        // 给定一个毫秒数，生成并返回一个 Instant 对象实例
        // == Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1649788343363L);
        System.out.println(instant1);
        // 2022-04-12T18:32:23.363Z -> 又是本初子午线的时间，还需要配置时间偏移量才行

    }
}
