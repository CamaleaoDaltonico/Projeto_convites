package br.edu.ifpb.projeto_convites.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import br.edu.ifpb.exampleasynctaskjson.R;
import br.edu.ifpb.exampleasynctaskjson.listener.btTelaListarListener;
import br.edu.ifpb.exampleasynctaskjson.listener.btTelaCadastroListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity{



    @BindView(R.id.btMenuListar)Button btMenuListar;
    @BindView(R.id.btMenuCadastrar)Button btMenuCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        btMenuListar.setOnClickListener(new btTelaListarListener(this));
        btMenuCadastrar.setOnClickListener(new btTelaCadastroListener(this));

    }

}