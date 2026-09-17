package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalObligations;
import cdm.legaldocumentation.csa.validation.AdditionalObligationsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalObligationsValidator;
import cdm.legaldocumentation.csa.validation.exists.AdditionalObligationsOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalObligations.class)
public class AdditionalObligationsMeta implements RosettaMetaData<AdditionalObligations> {

	@Override
	public List<Validator<? super AdditionalObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalObligations> validator(ValidatorFactory factory) {
		return factory.<AdditionalObligations>create(AdditionalObligationsValidator.class);
	}

	@Override
	public Validator<? super AdditionalObligations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalObligations>create(AdditionalObligationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalObligations> validator() {
		return new AdditionalObligationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalObligations> typeFormatValidator() {
		return new AdditionalObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalObligations, Set<String>> onlyExistsValidator() {
		return new AdditionalObligationsOnlyExistsValidator();
	}
}
