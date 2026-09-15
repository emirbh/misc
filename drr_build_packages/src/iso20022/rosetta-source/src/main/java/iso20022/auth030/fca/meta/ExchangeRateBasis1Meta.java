package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ExchangeRateBasis1;
import iso20022.auth030.fca.validation.ExchangeRateBasis1TypeFormatValidator;
import iso20022.auth030.fca.validation.ExchangeRateBasis1Validator;
import iso20022.auth030.fca.validation.exists.ExchangeRateBasis1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExchangeRateBasis1.class)
public class ExchangeRateBasis1Meta implements RosettaMetaData<ExchangeRateBasis1> {

	@Override
	public List<Validator<? super ExchangeRateBasis1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeRateBasis1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExchangeRateBasis1> validator(ValidatorFactory factory) {
		return factory.<ExchangeRateBasis1>create(ExchangeRateBasis1Validator.class);
	}

	@Override
	public Validator<? super ExchangeRateBasis1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExchangeRateBasis1>create(ExchangeRateBasis1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeRateBasis1> validator() {
		return new ExchangeRateBasis1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeRateBasis1> typeFormatValidator() {
		return new ExchangeRateBasis1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeRateBasis1, Set<String>> onlyExistsValidator() {
		return new ExchangeRateBasis1OnlyExistsValidator();
	}
}
