package AsyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.edu.ifpb.exampleasynctaskjson.activity.CadastrarActivity;
import br.edu.ifpb.exampleasynctaskjson.entity.Pessoa;
/**
 * Created by gabri on 06/10/2016.
 */
public class AsyncTaskCadastro extends AsyncTask<Pessoa, Void, String>{


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Pessoa... pessoas) {

        String mensagemResposta = "";

        try {

            // Converte a  Pessoa para objeto Json
            Gson gson = new Gson();
            String pessoaJson = gson.toJson(pessoas[0]);


            // Seta o metodo e a requisição e conecta ao servidor
            URL url = new URL("http://ladoss.info:8773/Convite_SERVICE/convidado/cadastrar");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();


            DataOutputStream wr = new DataOutputStream(
                    urlConnection.getOutputStream());

            // Escreve a Saída do outputstream na string
            wr.writeBytes(pessoaJson);
            wr.close();

            Log.i("ExampleAsyncTaskJson","Resposta: "+urlConnection.getResponseCode());


            if(urlConnection.getResponseCode() == 200){
                mensagemResposta= "O usuário foi cadastrado com sucesso";
            }else{
                mensagemResposta = "Problemas técnicos,por favor contate o admnistrador!";
            }

            urlConnection.disconnect();


        } catch (IOException e) {

            Log.e("Erro ", e.getMessage());
        }

        return mensagemResposta;
    }





    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }
}
