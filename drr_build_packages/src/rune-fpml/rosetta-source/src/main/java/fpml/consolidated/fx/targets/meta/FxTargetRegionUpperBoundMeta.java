package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import fpml.consolidated.fx.targets.validation.FxTargetRegionUpperBoundTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetRegionUpperBoundValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetRegionUpperBoundChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetRegionUpperBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetRegionUpperBound.class)
public class FxTargetRegionUpperBoundMeta implements RosettaMetaData<FxTargetRegionUpperBound> {

	@Override
	public List<Validator<? super FxTargetRegionUpperBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetRegionUpperBound>create(FxTargetRegionUpperBoundChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetRegionUpperBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetRegionUpperBound> validator(ValidatorFactory factory) {
		return factory.<FxTargetRegionUpperBound>create(FxTargetRegionUpperBoundValidator.class);
	}

	@Override
	public Validator<? super FxTargetRegionUpperBound> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetRegionUpperBound>create(FxTargetRegionUpperBoundTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetRegionUpperBound> validator() {
		return new FxTargetRegionUpperBoundValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetRegionUpperBound> typeFormatValidator() {
		return new FxTargetRegionUpperBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRegionUpperBound, Set<String>> onlyExistsValidator() {
		return new FxTargetRegionUpperBoundOnlyExistsValidator();
	}
}
