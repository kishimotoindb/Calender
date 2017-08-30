package com.example;

import java.util.Calendar;
import java.util.TimeZone;

/*
         * getInstance()这个方法，TimeZone和Locale不论设置成什么，c1和c23共同的只有timeInMillis.
         * 在这个方法中，调用了setTimesInMills(System.getTimeInMills()),所以所有通过getInstance()方
         * 法获得的Calendar实例（假设这些实例是在同一个时间点获得），他们内部的timeInMills是完全相同的。
         *
         * 1.getInstance()方法给Calendar设置的默认时间戳（TimeInMills）是系统当前的时间
         * System.getTimeInMills()和时区无关，应该是绝对的，应该是以格林尼治时间或者其他标准时间为基准。
         * 就是说在不同的时区，同一个"时刻"，所有时区的时间不同，但是System.getTimeInMills()得到的时间
         * 是相同的。
         * 2.但是因为时区不同，所以通过get(DayOfYear等)方法获得展示时间是不同的。
         *
         *
         */
public class MyClass {
    public static void main(String[] args) {

        Calendar cc = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        Calendar c23 = Calendar.getInstance(TimeZone.getTimeZone("GMT+23:00"));
        System.out.println(
                "cc=" + cc.getTimeInMillis()
                        + ", c1=" + c1.getTimeInMillis()
                        + ", c23=" + c23.getTimeInMillis());
        System.out.println("cc year=" + cc.get(Calendar.YEAR)
                + " month=" + cc.get(Calendar.MONTH)
                + " day=" + cc.get(Calendar.DAY_OF_YEAR)
                + " hour is" + cc.get(Calendar.HOUR));
        System.out.println("c1 year=" + c1.get(Calendar.YEAR)
                + " month=" + c1.get(Calendar.MONTH)
                + " day=" + c1.get(Calendar.DAY_OF_YEAR)
                + " hour is" + c1.get(Calendar.HOUR));
        System.out.println("c23 year=" + c23.get(Calendar.YEAR)
                + " month=" + c23.get(Calendar.MONTH)
                + " day=" + c23.get(Calendar.DAY_OF_YEAR)
                + " hour is" + c23.get(Calendar.HOUR));
        /*
         * getInstance()这个方法，TimeZone和Locale不论设置成什么，c1和c23共同的只有timeInMillis.
         * 在这个方法中，调用了setTimesInMills(System.getTimeInMills()),所以所有通过getInstance()方
         * 法获得的Calendar实例（假设这些实例是在同一个时间点获得），他们内部的timeInMills是完全相同的。
         *
         * 1.getInstance()方法给Calendar设置的默认时间戳（TimeInMills）是系统当前的时间
         * System.getTimeInMills()和时区无关，应该是绝对的，应该是以格林尼治时间或者其他标准时间为基准。
         * 就是说在不同的时区，同一个"时刻"，所有时区的时间不同，但是System.getTimeInMills()得到的时间
         * 是相同的。
         * 2.但是因为时区不同，所以通过get(DayOfYear等)方法获得展示时间是不同的。
         *
            上面代码的运行结果：
            cc =1504100022643
            c1 =1504100022650
            c23=1504100022650

            cc  year=2017 month=7 day=242 hour is9
            c1  year=2017 month=7 day=242 hour is2
            c23 year=2017 month=7 day=243 hour is0

            以上数据佐证了上面的观点，
            1.System.getTimeInMills()和时区无关，是绝对的
            2.同一个TimeInMills放到不同时区的Calendar中，Calender所表示的日期和时间是不同的。

                所以如果手机上的格林尼治时间不改变，只是通过改变时区造成手机上显示的日期不同，那么并不会
            改变Calendar中的TimesInMills；
                但是如果直接改变手机上的日期（实质上是改变格林尼治时间），那么Calender实例中的TimesInMills
            是会发生改变的。
                所以在创建Calender实例的时候，只与格林尼治时间有关。

         */

    }
}
