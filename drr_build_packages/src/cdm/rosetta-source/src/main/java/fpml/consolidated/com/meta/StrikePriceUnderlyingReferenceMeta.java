package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.StrikePriceUnderlyingReference;
import fpml.consolidated.com.validation.StrikePriceUnderlyingReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.StrikePriceUnderlyingReferenceValidator;
import fpml.consolidated.com.validation.exists.StrikePriceUnderlyingReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StrikePriceUnderlyingReference.class)
public class StrikePriceUnderlyingReferenceMeta implements RosettaMetaData<StrikePriceUnderlyingReference> {

	@Override
	public List<Validator<? super StrikePriceUnderlyingReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrikePriceUnderlyingReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StrikePriceUnderlyingReference> validator(ValidatorFactory factory) {
		return factory.<StrikePriceUnderlyingReference>create(StrikePriceUnderlyingReferenceValidator.class);
	}

	@Override
	public Validator<? super StrikePriceUnderlyingReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StrikePriceUnderlyingReference>create(StrikePriceUnderlyingReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StrikePriceUnderlyingReference> validator() {
		return new StrikePriceUnderlyingReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StrikePriceUnderlyingReference> typeFormatValidator() {
		return new StrikePriceUnderlyingReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrikePriceUnderlyingReference, Set<String>> onlyExistsValidator() {
		return new StrikePriceUnderlyingReferenceOnlyExistsValidator();
	}
}
