package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CalculationAgentTerms;
import cdm.legaldocumentation.csa.validation.CalculationAgentTermsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CalculationAgentTermsValidator;
import cdm.legaldocumentation.csa.validation.datarule.CalculationAgentTermsOneOf0;
import cdm.legaldocumentation.csa.validation.exists.CalculationAgentTermsOnlyExistsValidator;
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
@RosettaMeta(model=CalculationAgentTerms.class)
public class CalculationAgentTermsMeta implements RosettaMetaData<CalculationAgentTerms> {

	@Override
	public List<Validator<? super CalculationAgentTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationAgentTerms>create(CalculationAgentTermsOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationAgentTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAgentTerms> validator(ValidatorFactory factory) {
		return factory.<CalculationAgentTerms>create(CalculationAgentTermsValidator.class);
	}

	@Override
	public Validator<? super CalculationAgentTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationAgentTerms>create(CalculationAgentTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAgentTerms> validator() {
		return new CalculationAgentTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAgentTerms> typeFormatValidator() {
		return new CalculationAgentTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgentTerms, Set<String>> onlyExistsValidator() {
		return new CalculationAgentTermsOnlyExistsValidator();
	}
}
