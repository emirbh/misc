package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxScheduleReference;
import fpml.consolidated.fx.targets.validation.FxScheduleReferenceTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxScheduleReferenceValidator;
import fpml.consolidated.fx.targets.validation.exists.FxScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxScheduleReference.class)
public class FxScheduleReferenceMeta implements RosettaMetaData<FxScheduleReference> {

	@Override
	public List<Validator<? super FxScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxScheduleReference> validator(ValidatorFactory factory) {
		return factory.<FxScheduleReference>create(FxScheduleReferenceValidator.class);
	}

	@Override
	public Validator<? super FxScheduleReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxScheduleReference>create(FxScheduleReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxScheduleReference> validator() {
		return new FxScheduleReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxScheduleReference> typeFormatValidator() {
		return new FxScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxScheduleReference, Set<String>> onlyExistsValidator() {
		return new FxScheduleReferenceOnlyExistsValidator();
	}
}
