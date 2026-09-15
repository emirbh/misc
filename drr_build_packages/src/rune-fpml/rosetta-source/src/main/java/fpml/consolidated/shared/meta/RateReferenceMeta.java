package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RateReference;
import fpml.consolidated.shared.validation.RateReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.RateReferenceValidator;
import fpml.consolidated.shared.validation.exists.RateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RateReference.class)
public class RateReferenceMeta implements RosettaMetaData<RateReference> {

	@Override
	public List<Validator<? super RateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RateReference> validator(ValidatorFactory factory) {
		return factory.<RateReference>create(RateReferenceValidator.class);
	}

	@Override
	public Validator<? super RateReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RateReference>create(RateReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RateReference> validator() {
		return new RateReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RateReference> typeFormatValidator() {
		return new RateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateReference, Set<String>> onlyExistsValidator() {
		return new RateReferenceOnlyExistsValidator();
	}
}
