package com.coupon.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.coupon.common.TimePeriod;

public class TimePeriodHelper {

    public static TimePeriod toTimeZone(TimePeriod tp, TimeZone tz) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		long startOffset = tz.getOffset(tp.getStartDateTime().getTime())
				- df.getTimeZone().getOffset(tp.getStartDateTime().getTime());
		long endOffset = tz.getOffset(tp.getEndDateTime().getTime())
				- df.getTimeZone().getOffset(tp.getEndDateTime().getTime());
		tp.getStartDateTime().setTime(tp.getStartDateTime().getTime() + startOffset);
		tp.getEndDateTime().setTime(tp.getEndDateTime().getTime() + endOffset);

		return tp;
    }

    public static TimePeriod toDefault(TimePeriod tp, TimeZone tz) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		long startOffset = df.getTimeZone().getOffset(tp.getStartDateTime().getTime())
				- tz.getOffset(tp.getStartDateTime().getTime());
		long endOffset = df.getTimeZone().getOffset(tp.getEndDateTime().getTime())
				- tz.getOffset(tp.getEndDateTime().getTime());
		tp.getStartDateTime().setTime(tp.getStartDateTime().getTime() + startOffset);
		tp.getEndDateTime().setTime(tp.getEndDateTime().getTime() + endOffset);

		return tp;
    }

}