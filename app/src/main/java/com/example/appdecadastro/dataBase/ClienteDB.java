package com.example.appdecadastro.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appdecadastro.entities.Cliente;

import java.util.List;

public class ClienteDB {

    private DBHelper db;
    private SQLiteDatabase conexao;

    public ClienteDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Cliente cliente) {
        conexao = db.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", cliente.getNome());
        valores.put("cpf", cliente.getCPF());
        valores.put("telefone", cliente.getTelefone());
        valores.put("email", cliente.getEmail());

        conexao.insertOrThrow("clientes", null, valores);

        conexao.close();
    }

    public void remover(Integer id) {
        conexao = db.getWritableDatabase();

        conexao.delete("clientes", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Cliente> listaClientes) {
        listaClientes.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "nome", "cpf", "telefone", "email"};
        Cursor query = conexao.query("clientes", colunas, null, null, null, null, "nome");

        while (query.moveToNext()) {
            Cliente cliente = new Cliente();

            cliente.setId(query.getInt(0));
            cliente.setNome(query.getString(1));
            cliente.setCPF(query.getString(2));
            cliente.setTelefone(query.getString(3));
            cliente.setEmail(query.getString(4));

            listaClientes.add(cliente);
        }

        conexao.close();
    }
}
