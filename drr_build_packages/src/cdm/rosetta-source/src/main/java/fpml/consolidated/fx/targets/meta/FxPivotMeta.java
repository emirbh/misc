package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxPivot;
import fpml.consolidated.fx.targets.validation.FxPivotTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxPivotValidator;
import fpml.consolidated.fx.targets.validation.exists.FxPivotOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxPivot.class)
public class FxPivotMeta implements RosettaMetaData<FxPivot> {

	@Override
	public List<Validator<? super FxPivot>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPivot, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPivot> validator(ValidatorFactory factory) {
		return factory.<FxPivot>create(FxPivotValidator.class);
	}

	@Override
	public Validator<? super FxPivot> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPivot>create(FxPivotTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPivot> validator() {
		return new FxPivotValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPivot> typeFormatValidator() {
		return new FxPivotTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPivot, Set<String>> onlyExistsValidator() {
		return new FxPivotOnlyExistsValidator();
	}
}
