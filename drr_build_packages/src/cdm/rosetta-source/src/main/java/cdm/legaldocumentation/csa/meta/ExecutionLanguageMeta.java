package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ExecutionLanguage;
import cdm.legaldocumentation.csa.validation.ExecutionLanguageTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ExecutionLanguageValidator;
import cdm.legaldocumentation.csa.validation.datarule.ExecutionLanguageNumberOfOriginals;
import cdm.legaldocumentation.csa.validation.datarule.ExecutionLanguageOtherLanguage;
import cdm.legaldocumentation.csa.validation.exists.ExecutionLanguageOnlyExistsValidator;
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
@RosettaMeta(model=ExecutionLanguage.class)
public class ExecutionLanguageMeta implements RosettaMetaData<ExecutionLanguage> {

	@Override
	public List<Validator<? super ExecutionLanguage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionLanguage>create(ExecutionLanguageNumberOfOriginals.class),
			factory.<ExecutionLanguage>create(ExecutionLanguageOtherLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionLanguage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionLanguage> validator(ValidatorFactory factory) {
		return factory.<ExecutionLanguage>create(ExecutionLanguageValidator.class);
	}

	@Override
	public Validator<? super ExecutionLanguage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionLanguage>create(ExecutionLanguageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionLanguage> validator() {
		return new ExecutionLanguageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionLanguage> typeFormatValidator() {
		return new ExecutionLanguageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionLanguage, Set<String>> onlyExistsValidator() {
		return new ExecutionLanguageOnlyExistsValidator();
	}
}
