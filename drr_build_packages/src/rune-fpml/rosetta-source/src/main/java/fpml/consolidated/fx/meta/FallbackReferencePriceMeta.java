package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FallbackReferencePrice;
import fpml.consolidated.fx.validation.FallbackReferencePriceTypeFormatValidator;
import fpml.consolidated.fx.validation.FallbackReferencePriceValidator;
import fpml.consolidated.fx.validation.exists.FallbackReferencePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FallbackReferencePrice.class)
public class FallbackReferencePriceMeta implements RosettaMetaData<FallbackReferencePrice> {

	@Override
	public List<Validator<? super FallbackReferencePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FallbackReferencePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FallbackReferencePrice> validator(ValidatorFactory factory) {
		return factory.<FallbackReferencePrice>create(FallbackReferencePriceValidator.class);
	}

	@Override
	public Validator<? super FallbackReferencePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FallbackReferencePrice>create(FallbackReferencePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FallbackReferencePrice> validator() {
		return new FallbackReferencePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FallbackReferencePrice> typeFormatValidator() {
		return new FallbackReferencePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FallbackReferencePrice, Set<String>> onlyExistsValidator() {
		return new FallbackReferencePriceOnlyExistsValidator();
	}
}
