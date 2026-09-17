package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.StrikePriceBasketReference;
import fpml.consolidated.com.validation.StrikePriceBasketReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.StrikePriceBasketReferenceValidator;
import fpml.consolidated.com.validation.exists.StrikePriceBasketReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StrikePriceBasketReference.class)
public class StrikePriceBasketReferenceMeta implements RosettaMetaData<StrikePriceBasketReference> {

	@Override
	public List<Validator<? super StrikePriceBasketReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrikePriceBasketReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StrikePriceBasketReference> validator(ValidatorFactory factory) {
		return factory.<StrikePriceBasketReference>create(StrikePriceBasketReferenceValidator.class);
	}

	@Override
	public Validator<? super StrikePriceBasketReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StrikePriceBasketReference>create(StrikePriceBasketReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StrikePriceBasketReference> validator() {
		return new StrikePriceBasketReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StrikePriceBasketReference> typeFormatValidator() {
		return new StrikePriceBasketReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrikePriceBasketReference, Set<String>> onlyExistsValidator() {
		return new StrikePriceBasketReferenceOnlyExistsValidator();
	}
}
