package com.example.user.austgroove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.user.austgroove.Const.COL_CREATED_AT;
import static com.example.user.austgroove.Const.COL_ID;
import static com.example.user.austgroove.Const.COL_IS_COLPLETED;
import static com.example.user.austgroove.Const.COL_ITEM_NAME;
import static com.example.user.austgroove.Const.COL_NAME;
import static com.example.user.austgroove.Const.COL_TODO_ID;
import static com.example.user.austgroove.Const.DB_NAME;
import static com.example.user.austgroove.Const.DB_VERSION;
import static com.example.user.austgroove.Const.TABLE_TODO;
import static com.example.user.austgroove.Const.TABLE_TODO_ITEM;

class ToDo {
    private long id = -1;
    private String name = "";
    private String createdAt = "";
    private List items = (List)(new ArrayList());

    public final long getId() {
        return this.id;
    }

    public final void setId(long var1) {
        this.id = var1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName( String name) {
        this.name = name;
    }

    public final List getItems() {
        return this.items;
    }

    public final void setItems( List items) {
        this.items = items;
    }
}

class Const {
    public static final String DB_NAME = "ToDoList";
    public static final int DB_VERSION = 1;
    public static final String TABLE_TODO = "ToDo";
    public static final String COL_ID = "id";
    public static final String COL_CREATED_AT = "createdAt";
    public static final String COL_NAME = "name";
    public static final String TABLE_TODO_ITEM = "ToDoItem";
    public static final String COL_TODO_ID = "toDoId";
    public static final String COL_ITEM_NAME = "itemName";
    public static final String COL_IS_COLPLETED = "isCompleted";
    public static final String INTENT_TODO_ID = "TodoId";
    public static final String INTENT_TODO_NAME = "TodoName";
}

class ToDoItem {

    private long id = -1L;
    private long toDoId = -1L;
    private String itemName = "";
    private boolean isCompleted;

    public final long getId() {
        return this.id;
    }

    public final void setId(long var1) {
        this.id = var1;
    }

    public final long getToDoId() {
        return this.toDoId;
    }

    public final void setToDoId(long var1) {
        this.toDoId = var1;
    }


    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName( String itemName) {
        this.itemName = itemName;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final void setCompleted(boolean var1) {
        this.isCompleted = var1;
    }
}


public class DBHandler extends SQLiteOpenHelper {


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createToDoTable = "CREATE TABLE " + TABLE_TODO + " (" +
                COL_ID + " integer PRIMARY KEY AUTOINCREMENT," +
                COL_CREATED_AT + " datetime DEFAULT CURRENT_TIMESTAMP," +
                COL_NAME + " varchar)";
        String createToDoItemTable =
                "CREATE TABLE " + TABLE_TODO_ITEM + " (" +
                        COL_ID + " integer PRIMARY KEY AUTOINCREMENT," +
                        COL_CREATED_AT + " datetime DEFAULT CURRENT_TIMESTAMP," +
                        COL_TODO_ID + " integer," +
                        COL_ITEM_NAME + " varchar," +
                        COL_IS_COLPLETED + " integer)";

        db.execSQL(createToDoTable);
        db.execSQL(createToDoItemTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    boolean addToDo(ToDo todo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, todo.getName());
        long result = db.insert(TABLE_TODO, null, cv);
        return result != -1;
    }


    void updateToDo(ToDo todo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, todo.getName());
        db.update(TABLE_TODO, cv, COL_ID + "=?", new String[]{String.valueOf(todo.getId())});
    }

    void deleteToDo(Long todoId) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_TODO_ITEM, COL_TODO_ID + "=?", new String[]{String.valueOf(todoId)});
        db.delete(TABLE_TODO, COL_ID + "=?", new String[]{String.valueOf(todoId)});
    }

    void updateToDoItemCompletedStatus(Long todoId, Boolean isCompleted) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor queryResult = db.rawQuery("SELECT * FROM " + TABLE_TODO_ITEM + " WHERE " + COL_TODO_ID + "=" + todoId, null);
        if (queryResult.moveToFirst()) {
            do {
                ToDoItem item = new ToDoItem();
                item.setId(queryResult.getLong(queryResult.getColumnIndex(COL_ID)));
                item.setToDoId(queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID)));
                item.setItemName(queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME)));
                item.setCompleted(isCompleted);
                updateToDoItem(item);
            } while (queryResult.moveToNext());
        }
        queryResult.close();
    }

    public void updateToDoItem(ToDoItem item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ITEM_NAME, item.getItemName());
        cv.put(COL_TODO_ID, item.getToDoId());
        cv.put(COL_IS_COLPLETED, item.isCompleted());
        db.update(TABLE_TODO_ITEM, cv, COL_ID + "=?", new String[]{String.valueOf(item.getId())});
    }

    ArrayList<ToDo> getToDos() {
        ArrayList<ToDo> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor queryResult = db.rawQuery("SELECT * from " + TABLE_TODO, null);
        if (queryResult.moveToFirst()) {
            do {
                ToDo todo = new ToDo();
                todo.setId(queryResult.getLong(queryResult.getColumnIndex(COL_ID)));
                todo.setName(queryResult.getString(queryResult.getColumnIndex(COL_NAME)));
                result.add(todo);
            } while (queryResult.moveToNext());
        }
        queryResult.close();
        return result;
    }

    public boolean addToDoItem(ToDoItem item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ITEM_NAME, item.getItemName());
        cv.put(COL_TODO_ID, item.getToDoId());
        cv.put(COL_IS_COLPLETED, item.isCompleted());

        long result = db.insert(TABLE_TODO_ITEM, null, cv);
        return result != -1;
    }

    public void deleteToDoItem(long itemId) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_TODO_ITEM, COL_ID + "=?", new String[]{String.valueOf(itemId)});

    }

    public ArrayList<ToDoItem> getToDoItems(long todoId) {
        ArrayList<ToDoItem> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor queryResult = db.rawQuery("SELECT * FROM " + TABLE_TODO_ITEM + " WHERE " + COL_TODO_ID + "=" + todoId, null);
        if (queryResult.moveToFirst()) {
            do {
                ToDoItem item = new ToDoItem();
                item.setId(queryResult.getLong(queryResult.getColumnIndex(COL_ID)));
                item.setToDoId(queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID)));
                item.setItemName(queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME)));
                item.setCompleted(queryResult.getInt(queryResult.getColumnIndex(COL_IS_COLPLETED)) == 1);
                result.add(item);
            } while (queryResult.moveToNext());
        }

        queryResult.close();
        return result;
    }
}
