package Listeners;

import android.content.Intent;
import android.view.View;

import br.edu.ifpb.projeto_convites.Activities.Cadastro;
import br.edu.ifpb.projeto_convites.Activities.MainActivity;


/**
 * Created by gabri on 06/10/2016.
 */
public class OnClickListenerTelaCadastro implements View.OnClickListener {


    MainActivity mainActivity;

    public  OnClickListenerTelaCadastro(MainActivity mainActivity){

        this.mainActivity = mainActivity;

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this.mainActivity, Cadastro.class);
        this.mainActivity.startActivity(intent);


    }
}