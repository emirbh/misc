package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.FxPriceSourceDisruption;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxPriceSourceDisruptionTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxPriceSourceDisruptionValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.FxPriceSourceDisruptionOnlyExistsValidator;
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
@RosettaMeta(model=FxPriceSourceDisruption.class)
public class FxPriceSourceDisruptionMeta implements RosettaMetaData<FxPriceSourceDisruption> {

	@Override
	public List<Validator<? super FxPriceSourceDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPriceSourceDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPriceSourceDisruption> validator(ValidatorFactory factory) {
		return factory.<FxPriceSourceDisruption>create(FxPriceSourceDisruptionValidator.class);
	}

	@Override
	public Validator<? super FxPriceSourceDisruption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPriceSourceDisruption>create(FxPriceSourceDisruptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPriceSourceDisruption> validator() {
		return new FxPriceSourceDisruptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPriceSourceDisruption> typeFormatValidator() {
		return new FxPriceSourceDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPriceSourceDisruption, Set<String>> onlyExistsValidator() {
		return new FxPriceSourceDisruptionOnlyExistsValidator();
	}
}
