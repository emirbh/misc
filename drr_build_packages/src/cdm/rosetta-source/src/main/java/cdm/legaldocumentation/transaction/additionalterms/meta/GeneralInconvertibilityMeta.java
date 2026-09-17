package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.GeneralInconvertibility;
import cdm.legaldocumentation.transaction.additionalterms.validation.GeneralInconvertibilityTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.GeneralInconvertibilityValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.GeneralInconvertibilitySettlementPostponementExistence;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.GeneralInconvertibilitySubstituteTermsChoice;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.GeneralInconvertibilityOnlyExistsValidator;
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
@RosettaMeta(model=GeneralInconvertibility.class)
public class GeneralInconvertibilityMeta implements RosettaMetaData<GeneralInconvertibility> {

	@Override
	public List<Validator<? super GeneralInconvertibility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GeneralInconvertibility>create(GeneralInconvertibilitySettlementPostponementExistence.class),
			factory.<GeneralInconvertibility>create(GeneralInconvertibilitySubstituteTermsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GeneralInconvertibility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GeneralInconvertibility> validator(ValidatorFactory factory) {
		return factory.<GeneralInconvertibility>create(GeneralInconvertibilityValidator.class);
	}

	@Override
	public Validator<? super GeneralInconvertibility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GeneralInconvertibility>create(GeneralInconvertibilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GeneralInconvertibility> validator() {
		return new GeneralInconvertibilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GeneralInconvertibility> typeFormatValidator() {
		return new GeneralInconvertibilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralInconvertibility, Set<String>> onlyExistsValidator() {
		return new GeneralInconvertibilityOnlyExistsValidator();
	}
}
