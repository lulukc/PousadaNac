package aplication;

import aplication.config.JpaConfig;
import aplication.config.Seed;

public class Main {

	public static void main(String[] args) {

		Seed.criarQuarto();
		Interface.iniciar();
		JpaConfig.fecharConexão();
	}

}
