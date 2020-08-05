package com.example.inhome;

import android.provider.BaseColumns;

public class AlarmContract {

    public static final class AlarmEntry implements BaseColumns {

        public static final String TABLE_NAME = "weeklyAlarms";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_HOUR = "hour";
        public static final String COLUMN_MINUTE = "minute";
        public static final String COLUMN_DAYS = "days";
        public static final String COLUMN_TIMESTAMP = "timestamp";

        private AlarmEntry() {}

    }
}
