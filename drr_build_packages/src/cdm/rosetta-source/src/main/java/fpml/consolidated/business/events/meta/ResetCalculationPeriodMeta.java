package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ResetCalculationPeriod;
import fpml.consolidated.business.events.validation.ResetCalculationPeriodTypeFormatValidator;
import fpml.consolidated.business.events.validation.ResetCalculationPeriodValidator;
import fpml.consolidated.business.events.validation.exists.ResetCalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResetCalculationPeriod.class)
public class ResetCalculationPeriodMeta implements RosettaMetaData<ResetCalculationPeriod> {

	@Override
	public List<Validator<? super ResetCalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetCalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetCalculationPeriod> validator(ValidatorFactory factory) {
		return factory.<ResetCalculationPeriod>create(ResetCalculationPeriodValidator.class);
	}

	@Override
	public Validator<? super ResetCalculationPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetCalculationPeriod>create(ResetCalculationPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetCalculationPeriod> validator() {
		return new ResetCalculationPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetCalculationPeriod> typeFormatValidator() {
		return new ResetCalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetCalculationPeriod, Set<String>> onlyExistsValidator() {
		return new ResetCalculationPeriodOnlyExistsValidator();
	}
}
