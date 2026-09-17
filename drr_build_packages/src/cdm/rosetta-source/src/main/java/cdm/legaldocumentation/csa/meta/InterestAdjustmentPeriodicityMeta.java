package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.InterestAdjustmentPeriodicity;
import cdm.legaldocumentation.csa.validation.InterestAdjustmentPeriodicityTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.InterestAdjustmentPeriodicityValidator;
import cdm.legaldocumentation.csa.validation.datarule.InterestAdjustmentPeriodicityOneOf0;
import cdm.legaldocumentation.csa.validation.exists.InterestAdjustmentPeriodicityOnlyExistsValidator;
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
@RosettaMeta(model=InterestAdjustmentPeriodicity.class)
public class InterestAdjustmentPeriodicityMeta implements RosettaMetaData<InterestAdjustmentPeriodicity> {

	@Override
	public List<Validator<? super InterestAdjustmentPeriodicity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestAdjustmentPeriodicity>create(InterestAdjustmentPeriodicityOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super InterestAdjustmentPeriodicity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAdjustmentPeriodicity> validator(ValidatorFactory factory) {
		return factory.<InterestAdjustmentPeriodicity>create(InterestAdjustmentPeriodicityValidator.class);
	}

	@Override
	public Validator<? super InterestAdjustmentPeriodicity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestAdjustmentPeriodicity>create(InterestAdjustmentPeriodicityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestAdjustmentPeriodicity> validator() {
		return new InterestAdjustmentPeriodicityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestAdjustmentPeriodicity> typeFormatValidator() {
		return new InterestAdjustmentPeriodicityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAdjustmentPeriodicity, Set<String>> onlyExistsValidator() {
		return new InterestAdjustmentPeriodicityOnlyExistsValidator();
	}
}
