package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxPivotReference;
import fpml.consolidated.fx.targets.validation.FxPivotReferenceTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxPivotReferenceValidator;
import fpml.consolidated.fx.targets.validation.exists.FxPivotReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxPivotReference.class)
public class FxPivotReferenceMeta implements RosettaMetaData<FxPivotReference> {

	@Override
	public List<Validator<? super FxPivotReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPivotReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPivotReference> validator(ValidatorFactory factory) {
		return factory.<FxPivotReference>create(FxPivotReferenceValidator.class);
	}

	@Override
	public Validator<? super FxPivotReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPivotReference>create(FxPivotReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPivotReference> validator() {
		return new FxPivotReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPivotReference> typeFormatValidator() {
		return new FxPivotReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPivotReference, Set<String>> onlyExistsValidator() {
		return new FxPivotReferenceOnlyExistsValidator();
	}
}
