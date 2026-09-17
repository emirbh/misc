package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxRateObservableReference;
import fpml.consolidated.fx.accruals.validation.FxRateObservableReferenceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxRateObservableReferenceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxRateObservableReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxRateObservableReference.class)
public class FxRateObservableReferenceMeta implements RosettaMetaData<FxRateObservableReference> {

	@Override
	public List<Validator<? super FxRateObservableReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRateObservableReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxRateObservableReference> validator(ValidatorFactory factory) {
		return factory.<FxRateObservableReference>create(FxRateObservableReferenceValidator.class);
	}

	@Override
	public Validator<? super FxRateObservableReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxRateObservableReference>create(FxRateObservableReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxRateObservableReference> validator() {
		return new FxRateObservableReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxRateObservableReference> typeFormatValidator() {
		return new FxRateObservableReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateObservableReference, Set<String>> onlyExistsValidator() {
		return new FxRateObservableReferenceOnlyExistsValidator();
	}
}
