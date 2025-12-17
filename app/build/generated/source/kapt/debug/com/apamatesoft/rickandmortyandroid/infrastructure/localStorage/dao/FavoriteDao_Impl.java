package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavoriteModel> __insertionAdapterOfFavoriteModel;

  private final EntityDeletionOrUpdateAdapter<FavoriteModel> __deletionAdapterOfFavoriteModel;

  public FavoriteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteModel = new EntityInsertionAdapter<FavoriteModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `favorites` (`id`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavoriteModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfFavoriteModel = new EntityDeletionOrUpdateAdapter<FavoriteModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favorites` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavoriteModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final FavoriteModel favoriteModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavoriteModel.insert(favoriteModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final FavoriteModel favoriteModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFavoriteModel.handle(favoriteModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<FavoriteModel> getAll() {
    final String _sql = "SELECT * FROM favorites";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<FavoriteModel> _result = new ArrayList<FavoriteModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FavoriteModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item = new FavoriteModel(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
