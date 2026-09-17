package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ExecutionTerms;
import cdm.legaldocumentation.csa.validation.ExecutionTermsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ExecutionTermsValidator;
import cdm.legaldocumentation.csa.validation.exists.ExecutionTermsOnlyExistsValidator;
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
@RosettaMeta(model=ExecutionTerms.class)
public class ExecutionTermsMeta implements RosettaMetaData<ExecutionTerms> {

	@Override
	public List<Validator<? super ExecutionTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionTerms> validator(ValidatorFactory factory) {
		return factory.<ExecutionTerms>create(ExecutionTermsValidator.class);
	}

	@Override
	public Validator<? super ExecutionTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionTerms>create(ExecutionTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionTerms> validator() {
		return new ExecutionTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionTerms> typeFormatValidator() {
		return new ExecutionTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionTerms, Set<String>> onlyExistsValidator() {
		return new ExecutionTermsOnlyExistsValidator();
	}
}
