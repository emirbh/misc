package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.Threshold;
import cdm.legaldocumentation.csa.validation.ThresholdTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ThresholdValidator;
import cdm.legaldocumentation.csa.validation.exists.ThresholdOnlyExistsValidator;
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
@RosettaMeta(model=Threshold.class)
public class ThresholdMeta implements RosettaMetaData<Threshold> {

	@Override
	public List<Validator<? super Threshold>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Threshold, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Threshold> validator(ValidatorFactory factory) {
		return factory.<Threshold>create(ThresholdValidator.class);
	}

	@Override
	public Validator<? super Threshold> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Threshold>create(ThresholdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Threshold> validator() {
		return new ThresholdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Threshold> typeFormatValidator() {
		return new ThresholdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Threshold, Set<String>> onlyExistsValidator() {
		return new ThresholdOnlyExistsValidator();
	}
}
