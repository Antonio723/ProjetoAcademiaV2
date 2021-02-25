package br.semai.sp.Jandira;

import java.time.LocalDate;

import br.semai.sp.Jandira.model.Aluno;

public class Aplication {

	public static void main(String[] args) {
		Aluno Joao = new Aluno();
		Joao.setNome("Joao Batista e Silva");
		Joao.setPeso(65.8);
		Joao.setAltura(1.75);
		Joao.setDataNascimento(LocalDate.of(2002, 04, 20));
		Joao.setSexo('m');
		Joao.setNivelAtividadeFisica("LevE");
		
		System.out.println(Joao.getNome());
		System.out.println(Joao.getPeso());
		System.out.println(Joao.getAltura());
		System.out.println(Joao.getIdade());
		System.out.println(Joao.getSexo());
		System.out.println(Joao.getNivelAtividadeFisica());
		System.out.println(Joao.getNivelImc());
		System.out.println(Joao.getNcd());
	}

}
