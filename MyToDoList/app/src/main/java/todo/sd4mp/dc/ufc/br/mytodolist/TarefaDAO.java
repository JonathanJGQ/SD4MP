package todo.sd4mp.dc.ufc.br.mytodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 0322850 on 11/05/15.
 */
public class TarefaDAO extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;

    public TarefaDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public TarefaDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer sql = new StringBuffer();
        sql.append("create table tarefas (");
        sql.append("id integer primary key autoincrement,");
        sql.append("titulo text,");
        sql.append("descricao text,");
        sql.append("dataCriacao text,");
        sql.append("status integer)");
        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tarefas");
        onCreate(db);
    }

    public void inserirTarefa(Tarefa tarefa) {

        String data;
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        data = formatar.format(d);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tarefa.getTitulo());
        contentValues.put("descricao", tarefa.getDescricao());
        contentValues.put("dataCriacao", data);
        contentValues.put("status", tarefa.getStatus());
        long id = db.insert("tarefas", null, contentValues);
        Log.v("SQLite", "create id = " + id);

    }

    public Tarefa consultarTarefa(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from tarefas where id = ?", new String[] { Integer.toString(id) });
        Tarefa tarefa = null;
        if (result != null && result.getCount() > 0) {
            tarefa = new Tarefa();
            result.moveToNext();
            tarefa.setId(result.getInt(0));
            tarefa.setTitulo(result.getString(1));
            tarefa.setDescricao(result.getString(2));
            tarefa.setDataCriacao(result.getString(3));
            tarefa.setStatus(result.getInt(4));
        }
        return tarefa;
    }

    public void alterarTarefa(Tarefa tarefa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tarefa.getTitulo());
        contentValues.put("descricao", tarefa.getDescricao());
        contentValues.put("dataCriacao", tarefa.getDataCriacao());
        contentValues.put("status", tarefa.getStatus());
        db.update("tarefas", contentValues, " id = ? ", new String[]{Integer.toString(tarefa.getId())});
    }

    public void deletarTarefa(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tarefas", " id = ? ", new String[] { Integer.toString(id) });
    }

    public List<Tarefa> listarTarefas(int status) {
        List<Tarefa> tarefas = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from tarefas where status = " + status + " order by id", null);
        if (result != null && result.getCount() > 0) {
            tarefas = new ArrayList<Tarefa>();
            result.moveToFirst();
            while (result.isAfterLast() == false) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(result.getInt(0));
                tarefa.setTitulo(result.getString(1));
                tarefa.setDescricao(result.getString(2));
                tarefa.setDataCriacao(result.getString(3));
                tarefa.setStatus(result.getInt(4));
                tarefas.add(tarefa);
                result.moveToNext();
            }
        }
        return tarefas;
    }

}






















