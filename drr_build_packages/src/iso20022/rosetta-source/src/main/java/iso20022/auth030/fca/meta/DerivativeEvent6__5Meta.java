package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DerivativeEvent6__5;
import iso20022.auth030.fca.validation.DerivativeEvent6__5TypeFormatValidator;
import iso20022.auth030.fca.validation.DerivativeEvent6__5Validator;
import iso20022.auth030.fca.validation.exists.DerivativeEvent6__5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeEvent6__5.class)
public class DerivativeEvent6__5Meta implements RosettaMetaData<DerivativeEvent6__5> {

	@Override
	public List<Validator<? super DerivativeEvent6__5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeEvent6__5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeEvent6__5> validator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__5>create(DerivativeEvent6__5Validator.class);
	}

	@Override
	public Validator<? super DerivativeEvent6__5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__5>create(DerivativeEvent6__5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__5> validator() {
		return new DerivativeEvent6__5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__5> typeFormatValidator() {
		return new DerivativeEvent6__5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeEvent6__5, Set<String>> onlyExistsValidator() {
		return new DerivativeEvent6__5OnlyExistsValidator();
	}
}
