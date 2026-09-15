package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.SensitivityDefinition;
import fpml.consolidated.riskdef.validation.SensitivityDefinitionTypeFormatValidator;
import fpml.consolidated.riskdef.validation.SensitivityDefinitionValidator;
import fpml.consolidated.riskdef.validation.datarule.SensitivityDefinitionChoice;
import fpml.consolidated.riskdef.validation.exists.SensitivityDefinitionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SensitivityDefinition.class)
public class SensitivityDefinitionMeta implements RosettaMetaData<SensitivityDefinition> {

	@Override
	public List<Validator<? super SensitivityDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SensitivityDefinition>create(SensitivityDefinitionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SensitivityDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivityDefinition> validator(ValidatorFactory factory) {
		return factory.<SensitivityDefinition>create(SensitivityDefinitionValidator.class);
	}

	@Override
	public Validator<? super SensitivityDefinition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SensitivityDefinition>create(SensitivityDefinitionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityDefinition> validator() {
		return new SensitivityDefinitionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityDefinition> typeFormatValidator() {
		return new SensitivityDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityDefinition, Set<String>> onlyExistsValidator() {
		return new SensitivityDefinitionOnlyExistsValidator();
	}
}
