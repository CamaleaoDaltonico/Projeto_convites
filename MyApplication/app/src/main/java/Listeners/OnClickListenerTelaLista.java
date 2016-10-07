package Listeners;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


import br.edu.ifpb.projeto_convites.Activities.ListarActivity;
import br.edu.ifpb.projeto_convites.Activities.MainActivity;
import butterknife.ButterKnife;
/**
 * Created by gabri on 06/10/2016.
 */
public class OnClickListenerTelaLista  implements View.OnClickListener {


    MainActivity mainActivity;

    public OnClickListenerTelaLista(MainActivity mainActivity){

        this.mainActivity = mainActivity;

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this.mainActivity,ListarActivity.class);
        this.mainActivity.startActivity(intent);


    }
}
