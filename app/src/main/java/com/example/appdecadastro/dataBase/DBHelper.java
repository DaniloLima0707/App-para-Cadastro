package com.example.appdecadastro.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "AppCadastro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String querySQL =
                "CREATE TABLE PRODUTOS(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NOME VARCHAR(256)," +
                        "MARCA VARCHAR(256)," +
                        "QUANTIDADE INTEGER," +
                        "DATAVALIDADE VARCHAR(12)," +
                        "PRECO REAL);" +

                        "CREATE TABLE CLIENTES(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NOME VARCHAR(256)," +
                        "CPF VARCHAR(15)," +
                        "TELEFONE VARCHAR(20)," +
                        "EMAIL VARCHAR(256));" +

                        "CREATE TABLE FORNECEDORES(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NOMEFANTASIA VARCHAR(256)," +
                        "CNPJ VARCHAR(30)," +
                        "TELEFONE VARCHAR(20)," +
                        "EMAIL VARCHAR(256));";

        sqLiteDatabase.execSQL(querySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
