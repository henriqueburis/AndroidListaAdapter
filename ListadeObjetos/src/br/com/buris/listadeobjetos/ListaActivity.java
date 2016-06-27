package br.com.buris.listadeobjetos;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ListaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);

		ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		listaPessoa = (ArrayList<Pessoa>) getPessoa();

		ListView listaDeCursos = (ListView) findViewById(R.id.listDadosCliente);

		ListaAdapter adapter = new ListaAdapter(this, R.layout.listar_model,
				listaPessoa) {

			@Override
			public void onEntrada(Object entrada, View view) {
				if (entrada != null) {
					TextView texto_superior_entrada = (TextView) view
							.findViewById(R.id.nome);
					if (texto_superior_entrada != null)
						texto_superior_entrada.setText(((Pessoa) entrada)
								.getNome());

					TextView texto_inferior_entrada = (TextView) view
							.findViewById(R.id.email);
					if (texto_inferior_entrada != null)
						texto_inferior_entrada.setText(((Pessoa) entrada)
								.getEmail());
				}
			}
		};

		listaDeCursos.setAdapter(adapter);
	}

	public List<Pessoa> getPessoa() {
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		Pessoa p = new Pessoa();
		p.setNome("Buris");
		p.setEmail("Henrique.buris@");
		lista.add(p);

		Pessoa p2 = new Pessoa();
		p2.setNome("Luiz");
		p2.setEmail("Luiz.buris@");
		lista.add(p2);
		return lista;
	}

}
