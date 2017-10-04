package developer.xander.android_mvp_architecture.data.local;

import android.provider.BaseColumns;

/**
 * Created by tony on 4/10/17.
 */

public final class DbColumnsHelper {

    private DbColumnsHelper() {
    }

    static abstract class Sample implements BaseColumns{
        static final String TABLE_NAME = "sample_table";
        static final String COLUMN_NAME_ENTRY_ID = "entryid";
        static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
