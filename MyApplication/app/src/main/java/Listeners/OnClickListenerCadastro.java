package Listeners;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.edu.ifpb.exampleasynctaskjson.activity.CadastrarActivity;
import br.edu.ifpb.exampleasynctaskjson.activity.MainActivity;
import br.edu.ifpb.exampleasynctaskjson.asynctask.CadastrarPessoaAsyncTask;
import br.edu.ifpb.exampleasynctaskjson.entity.Pessoa;
import br.edu.ifpb.projeto_convites.Activities.Cadastro;

/**
 * Created by gabri on 06/10/2016.
 */
public class OnClickListenerCadastro  implements View.OnClickListener {

    Cadastro cadastro;


    public btCadastrarListener(Cadastro cadastro){

        this.cadastro = cadastro;

    }


    @Override
    public void onClick(View v) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(cadastrarActivity.getEtNome().getText().toString());
        pessoa.setEndereco(cadastrarActivity.getEtEndereco().getText().toString());
        pessoa.setEmail(cadastrarActivity.getEtEmail().getText().toString());
        pessoa.setCpf(cadastrarActivity.getEtCpf().getText().toString());

        CadastrarPessoaAsyncTask cadastrarPessoaAsyncTask = new CadastrarPessoaAsyncTask();

        try {

            String message = cadastrarPessoaAsyncTask.execute(pessoa).get();

            //exibe mensagem dependendo do código retornado no asynctTask
            Toast toast = Toast.makeText(this.cadastrarActivity,message,Toast.LENGTH_SHORT);
            toast.show();

            cadastro.getEtNome().setText("");
            cadastro.getEtEndereco().setText("");
            cadastro.getEtEmail().setText("");
            cadastro.getEtCpf().setText("");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}