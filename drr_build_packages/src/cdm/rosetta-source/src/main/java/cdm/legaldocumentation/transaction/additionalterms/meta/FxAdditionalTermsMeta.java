package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.FxAdditionalTerms;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxAdditionalTermsTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxAdditionalTermsValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.FxAdditionalTermsNoFaultTerminationOrDisruptionTerms;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.FxAdditionalTermsSpecificDeterminationRetrictionsForFx;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.FxAdditionalTermsOnlyExistsValidator;
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
@RosettaMeta(model=FxAdditionalTerms.class)
public class FxAdditionalTermsMeta implements RosettaMetaData<FxAdditionalTerms> {

	@Override
	public List<Validator<? super FxAdditionalTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAdditionalTerms>create(FxAdditionalTermsSpecificDeterminationRetrictionsForFx.class),
			factory.<FxAdditionalTerms>create(FxAdditionalTermsNoFaultTerminationOrDisruptionTerms.class)
		);
	}
	
	@Override
	public List<Function<? super FxAdditionalTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAdditionalTerms> validator(ValidatorFactory factory) {
		return factory.<FxAdditionalTerms>create(FxAdditionalTermsValidator.class);
	}

	@Override
	public Validator<? super FxAdditionalTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAdditionalTerms>create(FxAdditionalTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAdditionalTerms> validator() {
		return new FxAdditionalTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAdditionalTerms> typeFormatValidator() {
		return new FxAdditionalTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAdditionalTerms, Set<String>> onlyExistsValidator() {
		return new FxAdditionalTermsOnlyExistsValidator();
	}
}
