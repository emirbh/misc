package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.validation.NotionalReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.NotionalReferenceValidator;
import fpml.consolidated.shared.validation.exists.NotionalReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotionalReference.class)
public class NotionalReferenceMeta implements RosettaMetaData<NotionalReference> {

	@Override
	public List<Validator<? super NotionalReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalReference> validator(ValidatorFactory factory) {
		return factory.<NotionalReference>create(NotionalReferenceValidator.class);
	}

	@Override
	public Validator<? super NotionalReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalReference>create(NotionalReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalReference> validator() {
		return new NotionalReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalReference> typeFormatValidator() {
		return new NotionalReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalReference, Set<String>> onlyExistsValidator() {
		return new NotionalReferenceOnlyExistsValidator();
	}
}
