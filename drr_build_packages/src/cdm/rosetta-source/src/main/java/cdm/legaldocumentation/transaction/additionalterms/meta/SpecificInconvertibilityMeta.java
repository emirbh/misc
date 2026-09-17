package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.SpecificInconvertibility;
import cdm.legaldocumentation.transaction.additionalterms.validation.SpecificInconvertibilityTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.SpecificInconvertibilityValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.SpecificInconvertibilitySettlementPostponementExistence;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.SpecificInconvertibilitySubstituteTermsChoice;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.SpecificInconvertibilityOnlyExistsValidator;
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
@RosettaMeta(model=SpecificInconvertibility.class)
public class SpecificInconvertibilityMeta implements RosettaMetaData<SpecificInconvertibility> {

	@Override
	public List<Validator<? super SpecificInconvertibility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SpecificInconvertibility>create(SpecificInconvertibilitySettlementPostponementExistence.class),
			factory.<SpecificInconvertibility>create(SpecificInconvertibilitySubstituteTermsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SpecificInconvertibility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecificInconvertibility> validator(ValidatorFactory factory) {
		return factory.<SpecificInconvertibility>create(SpecificInconvertibilityValidator.class);
	}

	@Override
	public Validator<? super SpecificInconvertibility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpecificInconvertibility>create(SpecificInconvertibilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpecificInconvertibility> validator() {
		return new SpecificInconvertibilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpecificInconvertibility> typeFormatValidator() {
		return new SpecificInconvertibilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecificInconvertibility, Set<String>> onlyExistsValidator() {
		return new SpecificInconvertibilityOnlyExistsValidator();
	}
}
