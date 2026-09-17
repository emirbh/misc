package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetReference;
import fpml.consolidated.fx.targets.validation.FxTargetReferenceTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetReferenceValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetReference.class)
public class FxTargetReferenceMeta implements RosettaMetaData<FxTargetReference> {

	@Override
	public List<Validator<? super FxTargetReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetReference> validator(ValidatorFactory factory) {
		return factory.<FxTargetReference>create(FxTargetReferenceValidator.class);
	}

	@Override
	public Validator<? super FxTargetReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetReference>create(FxTargetReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetReference> validator() {
		return new FxTargetReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetReference> typeFormatValidator() {
		return new FxTargetReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetReference, Set<String>> onlyExistsValidator() {
		return new FxTargetReferenceOnlyExistsValidator();
	}
}
