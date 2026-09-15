package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.SensitivityDefinitionChoice;
import fpml.consolidated.riskdef.validation.SensitivityDefinitionChoiceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.SensitivityDefinitionChoiceValidator;
import fpml.consolidated.riskdef.validation.datarule.SensitivityDefinitionChoiceChoice;
import fpml.consolidated.riskdef.validation.exists.SensitivityDefinitionChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SensitivityDefinitionChoice.class)
public class SensitivityDefinitionChoiceMeta implements RosettaMetaData<SensitivityDefinitionChoice> {

	@Override
	public List<Validator<? super SensitivityDefinitionChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SensitivityDefinitionChoice>create(SensitivityDefinitionChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SensitivityDefinitionChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivityDefinitionChoice> validator(ValidatorFactory factory) {
		return factory.<SensitivityDefinitionChoice>create(SensitivityDefinitionChoiceValidator.class);
	}

	@Override
	public Validator<? super SensitivityDefinitionChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SensitivityDefinitionChoice>create(SensitivityDefinitionChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityDefinitionChoice> validator() {
		return new SensitivityDefinitionChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityDefinitionChoice> typeFormatValidator() {
		return new SensitivityDefinitionChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityDefinitionChoice, Set<String>> onlyExistsValidator() {
		return new SensitivityDefinitionChoiceOnlyExistsValidator();
	}
}
