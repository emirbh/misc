package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
import cdm.product.common.schedule.validation.FinalCalculationPeriodDateAdjustmentTypeFormatValidator;
import cdm.product.common.schedule.validation.FinalCalculationPeriodDateAdjustmentValidator;
import cdm.product.common.schedule.validation.datarule.FinalCalculationPeriodDateAdjustmentIsInterestRatePayout;
import cdm.product.common.schedule.validation.exists.FinalCalculationPeriodDateAdjustmentOnlyExistsValidator;
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
@RosettaMeta(model=FinalCalculationPeriodDateAdjustment.class)
public class FinalCalculationPeriodDateAdjustmentMeta implements RosettaMetaData<FinalCalculationPeriodDateAdjustment> {

	@Override
	public List<Validator<? super FinalCalculationPeriodDateAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FinalCalculationPeriodDateAdjustment>create(FinalCalculationPeriodDateAdjustmentIsInterestRatePayout.class)
		);
	}
	
	@Override
	public List<Function<? super FinalCalculationPeriodDateAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinalCalculationPeriodDateAdjustment> validator(ValidatorFactory factory) {
		return factory.<FinalCalculationPeriodDateAdjustment>create(FinalCalculationPeriodDateAdjustmentValidator.class);
	}

	@Override
	public Validator<? super FinalCalculationPeriodDateAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinalCalculationPeriodDateAdjustment>create(FinalCalculationPeriodDateAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinalCalculationPeriodDateAdjustment> validator() {
		return new FinalCalculationPeriodDateAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinalCalculationPeriodDateAdjustment> typeFormatValidator() {
		return new FinalCalculationPeriodDateAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinalCalculationPeriodDateAdjustment, Set<String>> onlyExistsValidator() {
		return new FinalCalculationPeriodDateAdjustmentOnlyExistsValidator();
	}
}
