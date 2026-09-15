package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimit;
import fpml.consolidated.business.events.validation.CreditLimitTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditLimitValidator;
import fpml.consolidated.business.events.validation.exists.CreditLimitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditLimit.class)
public class CreditLimitMeta implements RosettaMetaData<CreditLimit> {

	@Override
	public List<Validator<? super CreditLimit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditLimit> validator(ValidatorFactory factory) {
		return factory.<CreditLimit>create(CreditLimitValidator.class);
	}

	@Override
	public Validator<? super CreditLimit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditLimit>create(CreditLimitTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimit> validator() {
		return new CreditLimitValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimit> typeFormatValidator() {
		return new CreditLimitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimit, Set<String>> onlyExistsValidator() {
		return new CreditLimitOnlyExistsValidator();
	}
}
