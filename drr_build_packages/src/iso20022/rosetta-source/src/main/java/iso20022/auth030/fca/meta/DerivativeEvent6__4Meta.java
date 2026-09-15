package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DerivativeEvent6__4;
import iso20022.auth030.fca.validation.DerivativeEvent6__4TypeFormatValidator;
import iso20022.auth030.fca.validation.DerivativeEvent6__4Validator;
import iso20022.auth030.fca.validation.exists.DerivativeEvent6__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeEvent6__4.class)
public class DerivativeEvent6__4Meta implements RosettaMetaData<DerivativeEvent6__4> {

	@Override
	public List<Validator<? super DerivativeEvent6__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeEvent6__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeEvent6__4> validator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__4>create(DerivativeEvent6__4Validator.class);
	}

	@Override
	public Validator<? super DerivativeEvent6__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__4>create(DerivativeEvent6__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__4> validator() {
		return new DerivativeEvent6__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__4> typeFormatValidator() {
		return new DerivativeEvent6__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeEvent6__4, Set<String>> onlyExistsValidator() {
		return new DerivativeEvent6__4OnlyExistsValidator();
	}
}
