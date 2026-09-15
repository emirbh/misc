package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.DerivativeEvent6__2;
import iso20022.auth030.asic.validation.DerivativeEvent6__2TypeFormatValidator;
import iso20022.auth030.asic.validation.DerivativeEvent6__2Validator;
import iso20022.auth030.asic.validation.exists.DerivativeEvent6__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeEvent6__2.class)
public class DerivativeEvent6__2Meta implements RosettaMetaData<DerivativeEvent6__2> {

	@Override
	public List<Validator<? super DerivativeEvent6__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeEvent6__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeEvent6__2> validator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__2>create(DerivativeEvent6__2Validator.class);
	}

	@Override
	public Validator<? super DerivativeEvent6__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__2>create(DerivativeEvent6__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__2> validator() {
		return new DerivativeEvent6__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__2> typeFormatValidator() {
		return new DerivativeEvent6__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeEvent6__2, Set<String>> onlyExistsValidator() {
		return new DerivativeEvent6__2OnlyExistsValidator();
	}
}
