package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ThresholdFixedAmount;
import cdm.legaldocumentation.csa.validation.ThresholdFixedAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ThresholdFixedAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.ThresholdFixedAmountOnlyExistsValidator;
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
@RosettaMeta(model=ThresholdFixedAmount.class)
public class ThresholdFixedAmountMeta implements RosettaMetaData<ThresholdFixedAmount> {

	@Override
	public List<Validator<? super ThresholdFixedAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ThresholdFixedAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ThresholdFixedAmount> validator(ValidatorFactory factory) {
		return factory.<ThresholdFixedAmount>create(ThresholdFixedAmountValidator.class);
	}

	@Override
	public Validator<? super ThresholdFixedAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ThresholdFixedAmount>create(ThresholdFixedAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ThresholdFixedAmount> validator() {
		return new ThresholdFixedAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ThresholdFixedAmount> typeFormatValidator() {
		return new ThresholdFixedAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ThresholdFixedAmount, Set<String>> onlyExistsValidator() {
		return new ThresholdFixedAmountOnlyExistsValidator();
	}
}
