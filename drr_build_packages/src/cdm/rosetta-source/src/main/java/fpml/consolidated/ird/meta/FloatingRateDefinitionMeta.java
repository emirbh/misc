package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FloatingRateDefinition;
import fpml.consolidated.ird.validation.FloatingRateDefinitionTypeFormatValidator;
import fpml.consolidated.ird.validation.FloatingRateDefinitionValidator;
import fpml.consolidated.ird.validation.exists.FloatingRateDefinitionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingRateDefinition.class)
public class FloatingRateDefinitionMeta implements RosettaMetaData<FloatingRateDefinition> {

	@Override
	public List<Validator<? super FloatingRateDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateDefinition> validator(ValidatorFactory factory) {
		return factory.<FloatingRateDefinition>create(FloatingRateDefinitionValidator.class);
	}

	@Override
	public Validator<? super FloatingRateDefinition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateDefinition>create(FloatingRateDefinitionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateDefinition> validator() {
		return new FloatingRateDefinitionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateDefinition> typeFormatValidator() {
		return new FloatingRateDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateDefinition, Set<String>> onlyExistsValidator() {
		return new FloatingRateDefinitionOnlyExistsValidator();
	}
}
