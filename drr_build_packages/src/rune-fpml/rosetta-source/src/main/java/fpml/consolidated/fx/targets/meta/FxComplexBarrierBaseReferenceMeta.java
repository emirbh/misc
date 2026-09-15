package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxComplexBarrierBaseReference;
import fpml.consolidated.fx.targets.validation.FxComplexBarrierBaseReferenceTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxComplexBarrierBaseReferenceValidator;
import fpml.consolidated.fx.targets.validation.exists.FxComplexBarrierBaseReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxComplexBarrierBaseReference.class)
public class FxComplexBarrierBaseReferenceMeta implements RosettaMetaData<FxComplexBarrierBaseReference> {

	@Override
	public List<Validator<? super FxComplexBarrierBaseReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxComplexBarrierBaseReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxComplexBarrierBaseReference> validator(ValidatorFactory factory) {
		return factory.<FxComplexBarrierBaseReference>create(FxComplexBarrierBaseReferenceValidator.class);
	}

	@Override
	public Validator<? super FxComplexBarrierBaseReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxComplexBarrierBaseReference>create(FxComplexBarrierBaseReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxComplexBarrierBaseReference> validator() {
		return new FxComplexBarrierBaseReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxComplexBarrierBaseReference> typeFormatValidator() {
		return new FxComplexBarrierBaseReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxComplexBarrierBaseReference, Set<String>> onlyExistsValidator() {
		return new FxComplexBarrierBaseReferenceOnlyExistsValidator();
	}
}
