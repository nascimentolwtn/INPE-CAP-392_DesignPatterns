package tarefa1;

import java.util.Date;
import java.util.regex.Pattern;

import org.esfinge.aom.api.model.IEntity;

public class ValidadorTarefa1 {
	
	private Pattern pattternCpf = Pattern.compile("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");

	// Tempo total: 44min 12s
	public boolean validarEntidadePessoa(IEntity pessoa) throws Exception{
		boolean validade = true;
		
		String nome = (String) pessoa.getProperty("nome").getValue();
		validade = validade && isNomeValido(nome);
		
		Integer altura = (Integer) pessoa.getProperty("altura").getValue();
		validade = validade && isAlturaValida(altura);
		
		String cpf = (String) pessoa.getProperty("cpf").getValue();
		validade = validade && isCpfValido(cpf);
		
		String email = (String) pessoa.getProperty("email").getValue();
		validade = validade && isEmailValido(email);
		
		String profissao = (String) pessoa.getProperty("profissao").getValue();
		validade = validade && isProfissaoValida(profissao);
		
		Date nascimento = (Date) pessoa.getProperty("nascimento").getValue();
		validade = validade && isDataNascimentoValida(nascimento);
		
		String login = (String) pessoa.getProperty("login").getValue();
		validade = validade && isLoginValido(login);
		
		return validade;
	}

	private boolean isNomeValido(String nome) {
		return nome.length() > 5 && nome.length() < 50;
	}

	private boolean isAlturaValida(Integer altura) {
		return altura > 0 && altura < 215;
	}

	private boolean isCpfValido(String cpf) {
		boolean patternCpfMatches = pattternCpf.matcher(cpf).matches();
		return patternCpfMatches & isDigitoCpfValido(cpf);
	}

	private boolean isEmailValido(String email) {
		return email.contains("@");
	}
	
	private boolean isProfissaoValida(String profissao) {
		return profissao != null && !"".equals(profissao);
	}
	
	private boolean isDataNascimentoValida(Date nascimento) {
		Date dataAtual = new Date();
		return nascimento.before(dataAtual);
	}

	private boolean isLoginValido(String login) {
		return login.length() > 7;
	}

	private boolean isDigitoCpfValido(String cpf) {
		cpf = cpf.replace(".", "").replace("-", "");
		
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
			// e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro
			// digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}

		// Primeiro resto da divisão por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
		// menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divisão por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
		// menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que está sendo validado.
		String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo
		// resto.
		return nDigVerific.equals(nDigResult);
	}

}

