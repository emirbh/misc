package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportObligations;
import cdm.legaldocumentation.csa.validation.CreditSupportObligationsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportObligationsValidator;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportObligationsOnlyExistsValidator;
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
@RosettaMeta(model=CreditSupportObligations.class)
public class CreditSupportObligationsMeta implements RosettaMetaData<CreditSupportObligations> {

	@Override
	public List<Validator<? super CreditSupportObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportObligations> validator(ValidatorFactory factory) {
		return factory.<CreditSupportObligations>create(CreditSupportObligationsValidator.class);
	}

	@Override
	public Validator<? super CreditSupportObligations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportObligations>create(CreditSupportObligationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportObligations> validator() {
		return new CreditSupportObligationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportObligations> typeFormatValidator() {
		return new CreditSupportObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportObligations, Set<String>> onlyExistsValidator() {
		return new CreditSupportObligationsOnlyExistsValidator();
	}
}
