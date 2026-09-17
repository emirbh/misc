package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.MarginApproach;
import cdm.legaldocumentation.csa.validation.MarginApproachTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.MarginApproachValidator;
import cdm.legaldocumentation.csa.validation.exists.MarginApproachOnlyExistsValidator;
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
@RosettaMeta(model=MarginApproach.class)
public class MarginApproachMeta implements RosettaMetaData<MarginApproach> {

	@Override
	public List<Validator<? super MarginApproach>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginApproach, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginApproach> validator(ValidatorFactory factory) {
		return factory.<MarginApproach>create(MarginApproachValidator.class);
	}

	@Override
	public Validator<? super MarginApproach> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginApproach>create(MarginApproachTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginApproach> validator() {
		return new MarginApproachValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginApproach> typeFormatValidator() {
		return new MarginApproachTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginApproach, Set<String>> onlyExistsValidator() {
		return new MarginApproachOnlyExistsValidator();
	}
}
