package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.com.validation.QuantityReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.QuantityReferenceValidator;
import fpml.consolidated.com.validation.exists.QuantityReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QuantityReference.class)
public class QuantityReferenceMeta implements RosettaMetaData<QuantityReference> {

	@Override
	public List<Validator<? super QuantityReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuantityReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantityReference> validator(ValidatorFactory factory) {
		return factory.<QuantityReference>create(QuantityReferenceValidator.class);
	}

	@Override
	public Validator<? super QuantityReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QuantityReference>create(QuantityReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QuantityReference> validator() {
		return new QuantityReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QuantityReference> typeFormatValidator() {
		return new QuantityReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityReference, Set<String>> onlyExistsValidator() {
		return new QuantityReferenceOnlyExistsValidator();
	}
}
