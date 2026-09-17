package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.EquityAdditionalTerms;
import cdm.legaldocumentation.transaction.validation.EquityAdditionalTermsTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.EquityAdditionalTermsValidator;
import cdm.legaldocumentation.transaction.validation.exists.EquityAdditionalTermsOnlyExistsValidator;
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
@RosettaMeta(model=EquityAdditionalTerms.class)
public class EquityAdditionalTermsMeta implements RosettaMetaData<EquityAdditionalTerms> {

	@Override
	public List<Validator<? super EquityAdditionalTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityAdditionalTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityAdditionalTerms> validator(ValidatorFactory factory) {
		return factory.<EquityAdditionalTerms>create(EquityAdditionalTermsValidator.class);
	}

	@Override
	public Validator<? super EquityAdditionalTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityAdditionalTerms>create(EquityAdditionalTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityAdditionalTerms> validator() {
		return new EquityAdditionalTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityAdditionalTerms> typeFormatValidator() {
		return new EquityAdditionalTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityAdditionalTerms, Set<String>> onlyExistsValidator() {
		return new EquityAdditionalTermsOnlyExistsValidator();
	}
}
