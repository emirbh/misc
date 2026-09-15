package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanFloatingRateOption;
import fpml.consolidated.loan.validation.LoanFloatingRateOptionTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanFloatingRateOptionValidator;
import fpml.consolidated.loan.validation.exists.LoanFloatingRateOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanFloatingRateOption.class)
public class LoanFloatingRateOptionMeta implements RosettaMetaData<LoanFloatingRateOption> {

	@Override
	public List<Validator<? super LoanFloatingRateOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanFloatingRateOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanFloatingRateOption> validator(ValidatorFactory factory) {
		return factory.<LoanFloatingRateOption>create(LoanFloatingRateOptionValidator.class);
	}

	@Override
	public Validator<? super LoanFloatingRateOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanFloatingRateOption>create(LoanFloatingRateOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanFloatingRateOption> validator() {
		return new LoanFloatingRateOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanFloatingRateOption> typeFormatValidator() {
		return new LoanFloatingRateOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanFloatingRateOption, Set<String>> onlyExistsValidator() {
		return new LoanFloatingRateOptionOnlyExistsValidator();
	}
}
