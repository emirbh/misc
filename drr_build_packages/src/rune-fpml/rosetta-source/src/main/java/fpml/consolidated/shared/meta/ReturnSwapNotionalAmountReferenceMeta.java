package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ReturnSwapNotionalAmountReference;
import fpml.consolidated.shared.validation.ReturnSwapNotionalAmountReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.ReturnSwapNotionalAmountReferenceValidator;
import fpml.consolidated.shared.validation.exists.ReturnSwapNotionalAmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapNotionalAmountReference.class)
public class ReturnSwapNotionalAmountReferenceMeta implements RosettaMetaData<ReturnSwapNotionalAmountReference> {

	@Override
	public List<Validator<? super ReturnSwapNotionalAmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapNotionalAmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapNotionalAmountReference> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapNotionalAmountReference>create(ReturnSwapNotionalAmountReferenceValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapNotionalAmountReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapNotionalAmountReference>create(ReturnSwapNotionalAmountReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapNotionalAmountReference> validator() {
		return new ReturnSwapNotionalAmountReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapNotionalAmountReference> typeFormatValidator() {
		return new ReturnSwapNotionalAmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapNotionalAmountReference, Set<String>> onlyExistsValidator() {
		return new ReturnSwapNotionalAmountReferenceOnlyExistsValidator();
	}
}
