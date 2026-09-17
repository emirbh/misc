package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportObligationsVariationMargin;
import cdm.legaldocumentation.csa.validation.CreditSupportObligationsVariationMarginTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportObligationsVariationMarginValidator;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportObligationsVariationMarginOnlyExistsValidator;
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
@RosettaMeta(model=CreditSupportObligationsVariationMargin.class)
public class CreditSupportObligationsVariationMarginMeta implements RosettaMetaData<CreditSupportObligationsVariationMargin> {

	@Override
	public List<Validator<? super CreditSupportObligationsVariationMargin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportObligationsVariationMargin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportObligationsVariationMargin> validator(ValidatorFactory factory) {
		return factory.<CreditSupportObligationsVariationMargin>create(CreditSupportObligationsVariationMarginValidator.class);
	}

	@Override
	public Validator<? super CreditSupportObligationsVariationMargin> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportObligationsVariationMargin>create(CreditSupportObligationsVariationMarginTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportObligationsVariationMargin> validator() {
		return new CreditSupportObligationsVariationMarginValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportObligationsVariationMargin> typeFormatValidator() {
		return new CreditSupportObligationsVariationMarginTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportObligationsVariationMargin, Set<String>> onlyExistsValidator() {
		return new CreditSupportObligationsVariationMarginOnlyExistsValidator();
	}
}
