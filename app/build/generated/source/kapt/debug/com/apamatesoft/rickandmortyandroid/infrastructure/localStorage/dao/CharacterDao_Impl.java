package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel;
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
public final class CharacterDao_Impl implements CharacterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CharacterModel> __insertionAdapterOfCharacterModel;

  private final SharedSQLiteStatement __preparedStmtOfTruncate;

  public CharacterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCharacterModel = new EntityInsertionAdapter<CharacterModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `characters` (`id`,`name`,`imageUrl`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CharacterModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageUrl());
        }
      }
    };
    this.__preparedStmtOfTruncate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM characters";
        return _query;
      }
    };
  }

  @Override
  public void insert(final CharacterModel character) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCharacterModel.insert(character);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void truncate() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfTruncate.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfTruncate.release(_stmt);
    }
  }

  @Override
  public List<CharacterModel> getAll() {
    final String _sql = "SELECT * FROM characters";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
      final List<CharacterModel> _result = new ArrayList<CharacterModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CharacterModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        _item = new CharacterModel(_tmpId,_tmpName,_tmpImageUrl);
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
