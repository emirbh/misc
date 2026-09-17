package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyDefinition;
import cdm.legaldocumentation.csa.validation.LegacyDefinitionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyDefinitionValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyDefinitionApplicableLanguage;
import cdm.legaldocumentation.csa.validation.exists.LegacyDefinitionOnlyExistsValidator;
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
@RosettaMeta(model=LegacyDefinition.class)
public class LegacyDefinitionMeta implements RosettaMetaData<LegacyDefinition> {

	@Override
	public List<Validator<? super LegacyDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyDefinition>create(LegacyDefinitionApplicableLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyDefinition> validator(ValidatorFactory factory) {
		return factory.<LegacyDefinition>create(LegacyDefinitionValidator.class);
	}

	@Override
	public Validator<? super LegacyDefinition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyDefinition>create(LegacyDefinitionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyDefinition> validator() {
		return new LegacyDefinitionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyDefinition> typeFormatValidator() {
		return new LegacyDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyDefinition, Set<String>> onlyExistsValidator() {
		return new LegacyDefinitionOnlyExistsValidator();
	}
}
