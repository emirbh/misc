package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NotionalAmountReference;
import fpml.consolidated.shared.validation.NotionalAmountReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.NotionalAmountReferenceValidator;
import fpml.consolidated.shared.validation.exists.NotionalAmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotionalAmountReference.class)
public class NotionalAmountReferenceMeta implements RosettaMetaData<NotionalAmountReference> {

	@Override
	public List<Validator<? super NotionalAmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalAmountReference> validator(ValidatorFactory factory) {
		return factory.<NotionalAmountReference>create(NotionalAmountReferenceValidator.class);
	}

	@Override
	public Validator<? super NotionalAmountReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalAmountReference>create(NotionalAmountReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmountReference> validator() {
		return new NotionalAmountReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmountReference> typeFormatValidator() {
		return new NotionalAmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmountReference, Set<String>> onlyExistsValidator() {
		return new NotionalAmountReferenceOnlyExistsValidator();
	}
}
