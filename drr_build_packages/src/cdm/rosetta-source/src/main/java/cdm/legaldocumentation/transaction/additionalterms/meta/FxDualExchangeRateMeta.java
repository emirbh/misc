package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.FxDualExchangeRate;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxDualExchangeRateTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxDualExchangeRateValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.FxDualExchangeRateOnlyExistsValidator;
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
@RosettaMeta(model=FxDualExchangeRate.class)
public class FxDualExchangeRateMeta implements RosettaMetaData<FxDualExchangeRate> {

	@Override
	public List<Validator<? super FxDualExchangeRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDualExchangeRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDualExchangeRate> validator(ValidatorFactory factory) {
		return factory.<FxDualExchangeRate>create(FxDualExchangeRateValidator.class);
	}

	@Override
	public Validator<? super FxDualExchangeRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDualExchangeRate>create(FxDualExchangeRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDualExchangeRate> validator() {
		return new FxDualExchangeRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDualExchangeRate> typeFormatValidator() {
		return new FxDualExchangeRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDualExchangeRate, Set<String>> onlyExistsValidator() {
		return new FxDualExchangeRateOnlyExistsValidator();
	}
}
