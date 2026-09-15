package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualTriggerReference;
import fpml.consolidated.fx.accruals.validation.FxAccrualTriggerReferenceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualTriggerReferenceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualTriggerReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualTriggerReference.class)
public class FxAccrualTriggerReferenceMeta implements RosettaMetaData<FxAccrualTriggerReference> {

	@Override
	public List<Validator<? super FxAccrualTriggerReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualTriggerReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualTriggerReference> validator(ValidatorFactory factory) {
		return factory.<FxAccrualTriggerReference>create(FxAccrualTriggerReferenceValidator.class);
	}

	@Override
	public Validator<? super FxAccrualTriggerReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualTriggerReference>create(FxAccrualTriggerReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualTriggerReference> validator() {
		return new FxAccrualTriggerReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualTriggerReference> typeFormatValidator() {
		return new FxAccrualTriggerReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualTriggerReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualTriggerReferenceOnlyExistsValidator();
	}
}
