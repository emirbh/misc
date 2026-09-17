package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SwapStreamReference;
import fpml.consolidated.shared.validation.SwapStreamReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.SwapStreamReferenceValidator;
import fpml.consolidated.shared.validation.exists.SwapStreamReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SwapStreamReference.class)
public class SwapStreamReferenceMeta implements RosettaMetaData<SwapStreamReference> {

	@Override
	public List<Validator<? super SwapStreamReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwapStreamReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SwapStreamReference> validator(ValidatorFactory factory) {
		return factory.<SwapStreamReference>create(SwapStreamReferenceValidator.class);
	}

	@Override
	public Validator<? super SwapStreamReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SwapStreamReference>create(SwapStreamReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SwapStreamReference> validator() {
		return new SwapStreamReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SwapStreamReference> typeFormatValidator() {
		return new SwapStreamReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwapStreamReference, Set<String>> onlyExistsValidator() {
		return new SwapStreamReferenceOnlyExistsValidator();
	}
}
