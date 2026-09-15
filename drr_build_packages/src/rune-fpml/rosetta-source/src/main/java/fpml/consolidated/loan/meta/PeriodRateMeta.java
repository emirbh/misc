package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PeriodRate;
import fpml.consolidated.loan.validation.PeriodRateTypeFormatValidator;
import fpml.consolidated.loan.validation.PeriodRateValidator;
import fpml.consolidated.loan.validation.exists.PeriodRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PeriodRate.class)
public class PeriodRateMeta implements RosettaMetaData<PeriodRate> {

	@Override
	public List<Validator<? super PeriodRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PeriodRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PeriodRate> validator(ValidatorFactory factory) {
		return factory.<PeriodRate>create(PeriodRateValidator.class);
	}

	@Override
	public Validator<? super PeriodRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PeriodRate>create(PeriodRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PeriodRate> validator() {
		return new PeriodRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PeriodRate> typeFormatValidator() {
		return new PeriodRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodRate, Set<String>> onlyExistsValidator() {
		return new PeriodRateOnlyExistsValidator();
	}
}
