package com.example.appdecadastro.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appdecadastro.entities.Produto;

import java.util.List;

public class ProdutoDB {

    private DBHelper db;
    private SQLiteDatabase conexao;

    public ProdutoDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Produto produto) {
        conexao = db.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome());
        valores.put("marca", produto.getMarca());
        valores.put("quantidade", produto.getQuantidade());
        valores.put("dataValidade", produto.getDataValidade());
        valores.put("preco", produto.getPreco());

        conexao.insertOrThrow("produtos", null, valores);

        conexao.close();
    }

    public void remover(Integer id) {
        conexao = db.getWritableDatabase();

        conexao.delete("produtos", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Produto> listaProdutos) {
        listaProdutos.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "nome", "marca", "quantidade", "dataValidade", "preco"};
        Cursor query = conexao.query("produtos", colunas, null, null, null, null, "nome");

        while (query.moveToNext()) {
            Produto produto = new Produto();

            produto.setId(query.getInt(0));
            produto.setNome(query.getString(1));
            produto.setMarca(query.getString(2));
            produto.setQuantidade(query.getInt(3));
            produto.setDataValidade(query.getString(4));
            produto.setPreco(query.getFloat(5));

            listaProdutos.add(produto);
        }

        conexao.close();
    }
}
