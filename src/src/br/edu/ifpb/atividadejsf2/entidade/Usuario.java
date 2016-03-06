package src.br.edu.ifpb.atividadejsf2.entidade;

public class Usuario {
	
	private String nome;
	private String nascimento;
	private String matricula;
	
	public Usuario() {		
		this.nome = " ";
		this.nascimento = " ";
		this.matricula = " ";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	

}