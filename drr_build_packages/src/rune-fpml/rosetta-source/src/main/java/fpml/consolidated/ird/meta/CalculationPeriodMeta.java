package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CalculationPeriod;
import fpml.consolidated.ird.validation.CalculationPeriodTypeFormatValidator;
import fpml.consolidated.ird.validation.CalculationPeriodValidator;
import fpml.consolidated.ird.validation.datarule.CalculationPeriodChoice0;
import fpml.consolidated.ird.validation.datarule.CalculationPeriodChoice1;
import fpml.consolidated.ird.validation.exists.CalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationPeriod.class)
public class CalculationPeriodMeta implements RosettaMetaData<CalculationPeriod> {

	@Override
	public List<Validator<? super CalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationPeriod>create(CalculationPeriodChoice0.class),
			factory.<CalculationPeriod>create(CalculationPeriodChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriod> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriod>create(CalculationPeriodValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriod>create(CalculationPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriod> validator() {
		return new CalculationPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriod> typeFormatValidator() {
		return new CalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriod, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodOnlyExistsValidator();
	}
}
