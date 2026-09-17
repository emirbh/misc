package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.IneligibleCreditSupport;
import cdm.legaldocumentation.csa.validation.IneligibleCreditSupportTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.IneligibleCreditSupportValidator;
import cdm.legaldocumentation.csa.validation.exists.IneligibleCreditSupportOnlyExistsValidator;
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
@RosettaMeta(model=IneligibleCreditSupport.class)
public class IneligibleCreditSupportMeta implements RosettaMetaData<IneligibleCreditSupport> {

	@Override
	public List<Validator<? super IneligibleCreditSupport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IneligibleCreditSupport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IneligibleCreditSupport> validator(ValidatorFactory factory) {
		return factory.<IneligibleCreditSupport>create(IneligibleCreditSupportValidator.class);
	}

	@Override
	public Validator<? super IneligibleCreditSupport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IneligibleCreditSupport>create(IneligibleCreditSupportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IneligibleCreditSupport> validator() {
		return new IneligibleCreditSupportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IneligibleCreditSupport> typeFormatValidator() {
		return new IneligibleCreditSupportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IneligibleCreditSupport, Set<String>> onlyExistsValidator() {
		return new IneligibleCreditSupportOnlyExistsValidator();
	}
}
