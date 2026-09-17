package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.InterestAdjustment;
import cdm.legaldocumentation.csa.validation.InterestAdjustmentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.InterestAdjustmentValidator;
import cdm.legaldocumentation.csa.validation.exists.InterestAdjustmentOnlyExistsValidator;
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
@RosettaMeta(model=InterestAdjustment.class)
public class InterestAdjustmentMeta implements RosettaMetaData<InterestAdjustment> {

	@Override
	public List<Validator<? super InterestAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAdjustment> validator(ValidatorFactory factory) {
		return factory.<InterestAdjustment>create(InterestAdjustmentValidator.class);
	}

	@Override
	public Validator<? super InterestAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestAdjustment>create(InterestAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestAdjustment> validator() {
		return new InterestAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestAdjustment> typeFormatValidator() {
		return new InterestAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAdjustment, Set<String>> onlyExistsValidator() {
		return new InterestAdjustmentOnlyExistsValidator();
	}
}
