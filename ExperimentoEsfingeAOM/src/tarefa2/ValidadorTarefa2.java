package tarefa2;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.esfinge.aom.api.model.IEntity;
import org.esfinge.aom.model.dynamic.factory.AdapterFactory;

public class ValidadorTarefa2 {
	
	public boolean validarEntidadeCobranca(IEntity cobranca) throws Exception {
		
		//Transformando para Java Bean
		AdapterFactory af = AdapterFactory.getInstance("AnnotationMapping.json");
		Object cobrancaJavaBean = af.generate(cobranca);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(cobrancaJavaBean);
		
		return constraintViolations.isEmpty();
	}

}
