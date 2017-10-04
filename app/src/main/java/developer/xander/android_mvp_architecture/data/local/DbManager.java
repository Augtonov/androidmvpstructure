package developer.xander.android_mvp_architecture.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import developer.xander.android_mvp_architecture.data.ResponseCallback;
import developer.xander.android_mvp_architecture.data.model.Feed.FeedRequest;
import developer.xander.android_mvp_architecture.data.model.SampleModel;

/**
 * Created by tony on 3/10/17.
 */

public class DbManager implements DbHelper {

    private static DbManager ourInstance;

    private DbSqLiteHelper mDbSqLiteHelper;

    public static DbManager getInstance(@NonNull Context context) {

        if (ourInstance == null) {
            ourInstance = new DbManager(context);
        }
        return ourInstance;
    }

    private DbManager(@NonNull Context context) {
        mDbSqLiteHelper = new DbSqLiteHelper(context);
    }


    @Override
    public void getFeed(FeedRequest feedRequest, ResponseCallback responseCallback) {
        List<SampleModel> sampleModels = new ArrayList<SampleModel>();
        SQLiteDatabase db = mDbSqLiteHelper.getReadableDatabase();

        String[] projection = {
                DbColumnsHelper.Sample.COLUMN_NAME_ENTRY_ID,
                DbColumnsHelper.Sample.COLUMN_NAME_TITLE,
                DbColumnsHelper.Sample.COLUMN_NAME_DESCRIPTION,
        };

        Cursor c = db.query(
                DbColumnsHelper.Sample.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String itemId = c.getString(c.getColumnIndexOrThrow(DbColumnsHelper.Sample.COLUMN_NAME_ENTRY_ID));
                String title = c.getString(c.getColumnIndexOrThrow(DbColumnsHelper.Sample.COLUMN_NAME_TITLE));
                String description =
                        c.getString(c.getColumnIndexOrThrow(DbColumnsHelper.Sample.COLUMN_NAME_DESCRIPTION));
                SampleModel sampleModel = new SampleModel();
                sampleModel.setItemId(itemId);
                sampleModel.setName(title);
                sampleModel.setDesc(description);
                sampleModels.add(sampleModel);
            }
        }

        if (c != null) {
            c.close();
        }

        db.close();

        if (sampleModels.isEmpty()) {
            // This will be called if the table is new or just empty.
            responseCallback.onDataNotAvailable();
        } else {
            try {
                responseCallback.onSuccess(sampleModels);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
