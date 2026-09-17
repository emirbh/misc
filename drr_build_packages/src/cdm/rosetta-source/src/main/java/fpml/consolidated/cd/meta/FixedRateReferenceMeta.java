package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FixedRateReference;
import fpml.consolidated.cd.validation.FixedRateReferenceTypeFormatValidator;
import fpml.consolidated.cd.validation.FixedRateReferenceValidator;
import fpml.consolidated.cd.validation.exists.FixedRateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FixedRateReference.class)
public class FixedRateReferenceMeta implements RosettaMetaData<FixedRateReference> {

	@Override
	public List<Validator<? super FixedRateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedRateReference> validator(ValidatorFactory factory) {
		return factory.<FixedRateReference>create(FixedRateReferenceValidator.class);
	}

	@Override
	public Validator<? super FixedRateReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedRateReference>create(FixedRateReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedRateReference> validator() {
		return new FixedRateReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedRateReference> typeFormatValidator() {
		return new FixedRateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateReference, Set<String>> onlyExistsValidator() {
		return new FixedRateReferenceOnlyExistsValidator();
	}
}
