package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CSAThreshold;
import cdm.legaldocumentation.csa.validation.CSAThresholdTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CSAThresholdValidator;
import cdm.legaldocumentation.csa.validation.exists.CSAThresholdOnlyExistsValidator;
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
@RosettaMeta(model=CSAThreshold.class)
public class CSAThresholdMeta implements RosettaMetaData<CSAThreshold> {

	@Override
	public List<Validator<? super CSAThreshold>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CSAThreshold, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAThreshold> validator(ValidatorFactory factory) {
		return factory.<CSAThreshold>create(CSAThresholdValidator.class);
	}

	@Override
	public Validator<? super CSAThreshold> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAThreshold>create(CSAThresholdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAThreshold> validator() {
		return new CSAThresholdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAThreshold> typeFormatValidator() {
		return new CSAThresholdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAThreshold, Set<String>> onlyExistsValidator() {
		return new CSAThresholdOnlyExistsValidator();
	}
}
