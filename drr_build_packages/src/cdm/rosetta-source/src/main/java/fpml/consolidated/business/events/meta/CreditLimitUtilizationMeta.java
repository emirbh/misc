package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimitUtilization;
import fpml.consolidated.business.events.validation.CreditLimitUtilizationTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditLimitUtilizationValidator;
import fpml.consolidated.business.events.validation.exists.CreditLimitUtilizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditLimitUtilization.class)
public class CreditLimitUtilizationMeta implements RosettaMetaData<CreditLimitUtilization> {

	@Override
	public List<Validator<? super CreditLimitUtilization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimitUtilization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditLimitUtilization> validator(ValidatorFactory factory) {
		return factory.<CreditLimitUtilization>create(CreditLimitUtilizationValidator.class);
	}

	@Override
	public Validator<? super CreditLimitUtilization> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditLimitUtilization>create(CreditLimitUtilizationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitUtilization> validator() {
		return new CreditLimitUtilizationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitUtilization> typeFormatValidator() {
		return new CreditLimitUtilizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitUtilization, Set<String>> onlyExistsValidator() {
		return new CreditLimitUtilizationOnlyExistsValidator();
	}
}
