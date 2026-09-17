package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.GovernmentalAuthorityDefault;
import cdm.legaldocumentation.transaction.additionalterms.validation.GovernmentalAuthorityDefaultTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.GovernmentalAuthorityDefaultValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.GovernmentalAuthorityDefaultOnlyExistsValidator;
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
@RosettaMeta(model=GovernmentalAuthorityDefault.class)
public class GovernmentalAuthorityDefaultMeta implements RosettaMetaData<GovernmentalAuthorityDefault> {

	@Override
	public List<Validator<? super GovernmentalAuthorityDefault>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GovernmentalAuthorityDefault, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GovernmentalAuthorityDefault> validator(ValidatorFactory factory) {
		return factory.<GovernmentalAuthorityDefault>create(GovernmentalAuthorityDefaultValidator.class);
	}

	@Override
	public Validator<? super GovernmentalAuthorityDefault> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GovernmentalAuthorityDefault>create(GovernmentalAuthorityDefaultTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GovernmentalAuthorityDefault> validator() {
		return new GovernmentalAuthorityDefaultValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GovernmentalAuthorityDefault> typeFormatValidator() {
		return new GovernmentalAuthorityDefaultTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GovernmentalAuthorityDefault, Set<String>> onlyExistsValidator() {
		return new GovernmentalAuthorityDefaultOnlyExistsValidator();
	}
}
