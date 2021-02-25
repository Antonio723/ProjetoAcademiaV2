package br.semai.sp.Jandira.model;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
	private String nome;
	private double peso;
	private double altura;
	private LocalDate dataNascimento;
	private char sexo;
	private String nivelAtividadeFisica;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		LocalDate hoje = LocalDate.now();
		Period intervaloDataNascimento = Period.between(this.dataNascimento, hoje);
		return intervaloDataNascimento.getYears();
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public void setNivelAtividadeFisica(String nivelAtividadeFisica) {
		this.nivelAtividadeFisica = nivelAtividadeFisica;
	}
	
	public String getNivelAtividadeFisica() {
		return this.nivelAtividadeFisica;
	}
	
	public double getImc() {
		return peso/Math.pow(altura, 2);
	}
	public String getNivelImc() {
		String imc = "";
		if(getImc() < 0) {
			imc = "Erro os valores de Peso e Altura podem estar incorretos";
		}else if(getImc() < 18.5) {
			imc = "Seu imc é " + getImc() + " você está abaixo do pesso";
		}else if(getImc() >= 18.6 && getImc() <= 24.9){
			imc="Seu imc é " + getImc() + " você com o peso ideal (PARABÉNS)";
		}else if(getImc() >= 25 && getImc() <= 29.9) {
			imc = "Seu imc é " + getImc() + " Você está levemente a cima do peso";
		}else if(getImc() >= 30 && getImc() <= 34.9) {
			imc = "Seu imc é " + getImc() + "Você está com obsidade grau I";
		}else if(getImc() >= 35 && getImc() <= 39.9) {
			imc = "Seu imc é " +getImc() + " você está com obsidade grau II";
		}else if(getImc()>40) {
			imc = "Seu imc é de " + getImc() + " você está com obsidade grau III";
		}
		
		return imc;
	}
	
//	Homens
//	• Entre 18 a 30 anos — 15,3 x peso + 679;
//	• Entre 31 a 60 anos — 11,6 x peso + 879;
//	• Acima de 60 anos — 13,5 x peso + 487.
//	Mulheres
//	• Entre 18 a 30 anos — 14,7 x peso + 496
//	• Entre 31 a 60 anos — 8,7 x peso + 829;
//	• Acima de 60 anos — 10,5 x peso + 596.
	
	/*definindo o gasto calorico diario sem considerar as atividades fisicas */
	
	public double getGastoCaloricoDiario() {
		double necessidadeCaloricaDia = 0;
		if(this.sexo == 'm') {						//Masculino
			if(getIdade()<18) {
				necessidadeCaloricaDia = 0;
			}else if(getIdade() >= 18 && getIdade()<=30) {
				necessidadeCaloricaDia = 15.3 * getPeso()+679;
			}else if(getIdade()>=31 && getIdade()<=60) {
				necessidadeCaloricaDia = 11.6*getPeso()+879;
			}else if(getIdade()>60) {
				necessidadeCaloricaDia = 13.5*getPeso()+487;
			}
		}else {
			if(this.sexo == 'f') {                
				if(getIdade()<18) {					//Feminino
					necessidadeCaloricaDia = 0;
				}else if(getIdade()>=18 && getIdade()<=30) {
					necessidadeCaloricaDia = 14.7*getPeso()+829;
				}else if(getIdade()>=31 && getIdade()<=60) {
					necessidadeCaloricaDia = 8.7*getPeso()+829;
				}else if(getIdade() > 60) {
					necessidadeCaloricaDia = 10.5 * getPeso() + 596;
				}
			}
		}
		return necessidadeCaloricaDia;
	}
	
	/*Define a necessidade calorica diaria de um praicante de atividades fisicas*/
	
	public double getNcd() {
		double ncd = 0.01;
		if(this.sexo == 'm') {
			if(getNivelAtividadeFisica().equalsIgnoreCase("leve")) {
				ncd = getGastoCaloricoDiario()*1.5;
			}else if(getNivelAtividadeFisica().equalsIgnoreCase("moderado")) {
				ncd = getGastoCaloricoDiario()*1.8;
			}else if (getNivelAtividadeFisica().equalsIgnoreCase("intenso")) {
				ncd = getGastoCaloricoDiario()*2.1;
			}
		}
		
		else {
			if(this.sexo == 'f') {
				if(getNivelAtividadeFisica().equalsIgnoreCase("leve")) {
					ncd = getGastoCaloricoDiario()*1.6;
				}else if (getNivelAtividadeFisica().equalsIgnoreCase("moderado")) {
					ncd = getGastoCaloricoDiario()*1.6;
				}else if(getNivelAtividadeFisica().equalsIgnoreCase("intenso")) {
					ncd = getGastoCaloricoDiario()*1.8;
				}
			}
		}
		return ncd;
	}
}
