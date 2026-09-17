package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.InterestRateStreamReference;
import fpml.consolidated.ird.validation.InterestRateStreamReferenceTypeFormatValidator;
import fpml.consolidated.ird.validation.InterestRateStreamReferenceValidator;
import fpml.consolidated.ird.validation.exists.InterestRateStreamReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestRateStreamReference.class)
public class InterestRateStreamReferenceMeta implements RosettaMetaData<InterestRateStreamReference> {

	@Override
	public List<Validator<? super InterestRateStreamReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateStreamReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateStreamReference> validator(ValidatorFactory factory) {
		return factory.<InterestRateStreamReference>create(InterestRateStreamReferenceValidator.class);
	}

	@Override
	public Validator<? super InterestRateStreamReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateStreamReference>create(InterestRateStreamReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateStreamReference> validator() {
		return new InterestRateStreamReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateStreamReference> typeFormatValidator() {
		return new InterestRateStreamReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateStreamReference, Set<String>> onlyExistsValidator() {
		return new InterestRateStreamReferenceOnlyExistsValidator();
	}
}
