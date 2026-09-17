package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ThresholdRatingsBased;
import cdm.legaldocumentation.csa.validation.ThresholdRatingsBasedTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ThresholdRatingsBasedValidator;
import cdm.legaldocumentation.csa.validation.exists.ThresholdRatingsBasedOnlyExistsValidator;
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
@RosettaMeta(model=ThresholdRatingsBased.class)
public class ThresholdRatingsBasedMeta implements RosettaMetaData<ThresholdRatingsBased> {

	@Override
	public List<Validator<? super ThresholdRatingsBased>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ThresholdRatingsBased, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ThresholdRatingsBased> validator(ValidatorFactory factory) {
		return factory.<ThresholdRatingsBased>create(ThresholdRatingsBasedValidator.class);
	}

	@Override
	public Validator<? super ThresholdRatingsBased> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ThresholdRatingsBased>create(ThresholdRatingsBasedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ThresholdRatingsBased> validator() {
		return new ThresholdRatingsBasedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ThresholdRatingsBased> typeFormatValidator() {
		return new ThresholdRatingsBasedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ThresholdRatingsBased, Set<String>> onlyExistsValidator() {
		return new ThresholdRatingsBasedOnlyExistsValidator();
	}
}
