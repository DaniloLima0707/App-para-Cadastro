package com.example.appdecadastro.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appdecadastro.R;
import com.example.appdecadastro.fragments.CadastrarClientesFragment;
import com.example.appdecadastro.fragments.CadastrarFornecedoresFragment;
import com.example.appdecadastro.fragments.CadastrarProdutosFragment;
import com.example.appdecadastro.fragments.ListagemClientesFragment;
import com.example.appdecadastro.fragments.ListagemFornecedoresFragment;
import com.example.appdecadastro.fragments.ListagemProdutosFragment;

public class SecondActivity extends AppCompatActivity {

    Button botaoListagem;
    Button botaoCadastrar;
    Button botaoVoltar;

    Integer tipoOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tipoOperacao = getIntent().getIntExtra("operacao", -1);

        botaoListagem = findViewById(R.id.botaoListagem);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoVoltar = findViewById(R.id.botaoVoltar);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (tipoOperacao) {
            case -1: {
                onBackPressed();
                break;
            }

            case 0: {
                transaction.add(R.id.fragmentoPrincipal, new ListagemProdutosFragment());
                break;
            }

            case 1: {
                transaction.add(R.id.fragmentoPrincipal, new ListagemClientesFragment());
                break;
            }

            case 2: {
                transaction.add(R.id.fragmentoPrincipal, new ListagemFornecedoresFragment());
                break;
            }
        }

        transaction.commit();

        acoesComponentes();
    }

    private void acoesComponentes() {
        botaoListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (tipoOperacao) {
                    case 0: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoPrincipal, new ListagemProdutosFragment()).commit();

                        break;
                    }

                    case 1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoPrincipal, new ListagemClientesFragment()).commit();

                        break;
                    }

                    case 2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoPrincipal, new ListagemFornecedoresFragment()).commit();

                        break;
                    }
                }
            }
        });

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (tipoOperacao) {
                    case 0: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoPrincipal, new CadastrarProdutosFragment()).commit();

                        break;
                    }

                    case 1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoPrincipal, new CadastrarClientesFragment()).commit();

                        break;
                    }

                    case 2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoPrincipal, new CadastrarFornecedoresFragment()).commit();

                        break;
                    }
                }
            }
        });

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}