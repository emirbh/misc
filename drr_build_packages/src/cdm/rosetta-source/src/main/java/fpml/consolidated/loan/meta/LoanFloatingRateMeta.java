package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.loan.validation.LoanFloatingRateTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanFloatingRateValidator;
import fpml.consolidated.loan.validation.exists.LoanFloatingRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanFloatingRate.class)
public class LoanFloatingRateMeta implements RosettaMetaData<LoanFloatingRate> {

	@Override
	public List<Validator<? super LoanFloatingRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanFloatingRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanFloatingRate> validator(ValidatorFactory factory) {
		return factory.<LoanFloatingRate>create(LoanFloatingRateValidator.class);
	}

	@Override
	public Validator<? super LoanFloatingRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanFloatingRate>create(LoanFloatingRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanFloatingRate> validator() {
		return new LoanFloatingRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanFloatingRate> typeFormatValidator() {
		return new LoanFloatingRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanFloatingRate, Set<String>> onlyExistsValidator() {
		return new LoanFloatingRateOnlyExistsValidator();
	}
}
