package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportAmount;
import cdm.legaldocumentation.csa.validation.CreditSupportAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportAmountValidator;
import cdm.legaldocumentation.csa.validation.datarule.CreditSupportAmountAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportAmountOnlyExistsValidator;
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
@RosettaMeta(model=CreditSupportAmount.class)
public class CreditSupportAmountMeta implements RosettaMetaData<CreditSupportAmount> {

	@Override
	public List<Validator<? super CreditSupportAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditSupportAmount>create(CreditSupportAmountAdditionalLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super CreditSupportAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportAmount> validator(ValidatorFactory factory) {
		return factory.<CreditSupportAmount>create(CreditSupportAmountValidator.class);
	}

	@Override
	public Validator<? super CreditSupportAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportAmount>create(CreditSupportAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportAmount> validator() {
		return new CreditSupportAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportAmount> typeFormatValidator() {
		return new CreditSupportAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportAmount, Set<String>> onlyExistsValidator() {
		return new CreditSupportAmountOnlyExistsValidator();
	}
}
