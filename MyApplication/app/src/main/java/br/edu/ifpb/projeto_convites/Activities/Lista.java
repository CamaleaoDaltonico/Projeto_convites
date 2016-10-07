package br.edu.ifpb.projeto_convites.Activities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

import br.edu.ifpb.exampleasynctaskjson.R;
import br.edu.ifpb.exampleasynctaskjson.asynctask.ListarPessoaAsyncTask;
import br.edu.ifpb.exampleasynctaskjson.entity.Pessoa;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListarActivity extends Activity {


    @BindView(R.id.lvPessoas) ListView lvPessoas;
    ArrayAdapter<Pessoa> adapter;
    List<Pessoa> pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ButterKnife.bind(this);
        listagem();

    }



    public void listagem(){

        ListarPessoaAsyncTask listPessoa = new ListarPessoaAsyncTask();

        try {
            pessoas = listPessoa.execute("http://ladoss.info:8773/Convite_SERVICE/convidado/listar").get();
            adapter= new ArrayAdapter<Pessoa>(this,
                    android.R.layout.simple_list_item_1, pessoas);
            lvPessoas.setAdapter(adapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



    public ListView getLvPessoas() {
        return lvPessoas;
    }

    public void setLvPessoas(ListView lvPessoas) {
        this.lvPessoas = lvPessoas;
    }

    public ArrayAdapter<Pessoa> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<Pessoa> adapter) {
        this.adapter = adapter;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}