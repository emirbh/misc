package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CalculationAndTiming;
import cdm.legaldocumentation.csa.validation.CalculationAndTimingTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CalculationAndTimingValidator;
import cdm.legaldocumentation.csa.validation.exists.CalculationAndTimingOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CalculationAndTiming.class)
public class CalculationAndTimingMeta implements RosettaMetaData<CalculationAndTiming> {

	@Override
	public List<Validator<? super CalculationAndTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationAndTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAndTiming> validator(ValidatorFactory factory) {
		return factory.<CalculationAndTiming>create(CalculationAndTimingValidator.class);
	}

	@Override
	public Validator<? super CalculationAndTiming> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationAndTiming>create(CalculationAndTimingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAndTiming> validator() {
		return new CalculationAndTimingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAndTiming> typeFormatValidator() {
		return new CalculationAndTimingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAndTiming, Set<String>> onlyExistsValidator() {
		return new CalculationAndTimingOnlyExistsValidator();
	}
}
