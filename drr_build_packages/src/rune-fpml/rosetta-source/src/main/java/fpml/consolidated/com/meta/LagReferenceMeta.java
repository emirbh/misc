package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.LagReference;
import fpml.consolidated.com.validation.LagReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.LagReferenceValidator;
import fpml.consolidated.com.validation.exists.LagReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LagReference.class)
public class LagReferenceMeta implements RosettaMetaData<LagReference> {

	@Override
	public List<Validator<? super LagReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LagReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LagReference> validator(ValidatorFactory factory) {
		return factory.<LagReference>create(LagReferenceValidator.class);
	}

	@Override
	public Validator<? super LagReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LagReference>create(LagReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LagReference> validator() {
		return new LagReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LagReference> typeFormatValidator() {
		return new LagReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LagReference, Set<String>> onlyExistsValidator() {
		return new LagReferenceOnlyExistsValidator();
	}
}
