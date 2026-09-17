package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.SensitivitySetDefinition;
import fpml.consolidated.riskdef.validation.SensitivitySetDefinitionTypeFormatValidator;
import fpml.consolidated.riskdef.validation.SensitivitySetDefinitionValidator;
import fpml.consolidated.riskdef.validation.exists.SensitivitySetDefinitionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SensitivitySetDefinition.class)
public class SensitivitySetDefinitionMeta implements RosettaMetaData<SensitivitySetDefinition> {

	@Override
	public List<Validator<? super SensitivitySetDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SensitivitySetDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivitySetDefinition> validator(ValidatorFactory factory) {
		return factory.<SensitivitySetDefinition>create(SensitivitySetDefinitionValidator.class);
	}

	@Override
	public Validator<? super SensitivitySetDefinition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SensitivitySetDefinition>create(SensitivitySetDefinitionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SensitivitySetDefinition> validator() {
		return new SensitivitySetDefinitionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SensitivitySetDefinition> typeFormatValidator() {
		return new SensitivitySetDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivitySetDefinition, Set<String>> onlyExistsValidator() {
		return new SensitivitySetDefinitionOnlyExistsValidator();
	}
}
