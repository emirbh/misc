package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.validation.AmountReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.AmountReferenceValidator;
import fpml.consolidated.shared.validation.exists.AmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AmountReference.class)
public class AmountReferenceMeta implements RosettaMetaData<AmountReference> {

	@Override
	public List<Validator<? super AmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountReference> validator(ValidatorFactory factory) {
		return factory.<AmountReference>create(AmountReferenceValidator.class);
	}

	@Override
	public Validator<? super AmountReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountReference>create(AmountReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountReference> validator() {
		return new AmountReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountReference> typeFormatValidator() {
		return new AmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountReference, Set<String>> onlyExistsValidator() {
		return new AmountReferenceOnlyExistsValidator();
	}
}
