package cdm.legaldocumentation.common.meta;

import cdm.legaldocumentation.common.Agreement;
import cdm.legaldocumentation.common.validation.AgreementTypeFormatValidator;
import cdm.legaldocumentation.common.validation.AgreementValidator;
import cdm.legaldocumentation.common.validation.datarule.AgreementOneOf0;
import cdm.legaldocumentation.common.validation.exists.AgreementOnlyExistsValidator;
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
@RosettaMeta(model=Agreement.class)
public class AgreementMeta implements RosettaMetaData<Agreement> {

	@Override
	public List<Validator<? super Agreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Agreement>create(AgreementOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super Agreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Agreement> validator(ValidatorFactory factory) {
		return factory.<Agreement>create(AgreementValidator.class);
	}

	@Override
	public Validator<? super Agreement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Agreement>create(AgreementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Agreement> validator() {
		return new AgreementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Agreement> typeFormatValidator() {
		return new AgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Agreement, Set<String>> onlyExistsValidator() {
		return new AgreementOnlyExistsValidator();
	}
}
