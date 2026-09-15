package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.DerivativeEvent6__6;
import iso20022.auth030.hkma.tr.validation.DerivativeEvent6__6TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.DerivativeEvent6__6Validator;
import iso20022.auth030.hkma.tr.validation.exists.DerivativeEvent6__6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeEvent6__6.class)
public class DerivativeEvent6__6Meta implements RosettaMetaData<DerivativeEvent6__6> {

	@Override
	public List<Validator<? super DerivativeEvent6__6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeEvent6__6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeEvent6__6> validator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__6>create(DerivativeEvent6__6Validator.class);
	}

	@Override
	public Validator<? super DerivativeEvent6__6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__6>create(DerivativeEvent6__6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__6> validator() {
		return new DerivativeEvent6__6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__6> typeFormatValidator() {
		return new DerivativeEvent6__6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeEvent6__6, Set<String>> onlyExistsValidator() {
		return new DerivativeEvent6__6OnlyExistsValidator();
	}
}
