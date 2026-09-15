package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFallbackReferencePrice;
import fpml.consolidated.fx.validation.FxFallbackReferencePriceTypeFormatValidator;
import fpml.consolidated.fx.validation.FxFallbackReferencePriceValidator;
import fpml.consolidated.fx.validation.exists.FxFallbackReferencePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFallbackReferencePrice.class)
public class FxFallbackReferencePriceMeta implements RosettaMetaData<FxFallbackReferencePrice> {

	@Override
	public List<Validator<? super FxFallbackReferencePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFallbackReferencePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFallbackReferencePrice> validator(ValidatorFactory factory) {
		return factory.<FxFallbackReferencePrice>create(FxFallbackReferencePriceValidator.class);
	}

	@Override
	public Validator<? super FxFallbackReferencePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFallbackReferencePrice>create(FxFallbackReferencePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFallbackReferencePrice> validator() {
		return new FxFallbackReferencePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFallbackReferencePrice> typeFormatValidator() {
		return new FxFallbackReferencePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFallbackReferencePrice, Set<String>> onlyExistsValidator() {
		return new FxFallbackReferencePriceOnlyExistsValidator();
	}
}
