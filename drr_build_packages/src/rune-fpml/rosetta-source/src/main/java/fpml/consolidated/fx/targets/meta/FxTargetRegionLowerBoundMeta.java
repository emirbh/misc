package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.validation.FxTargetRegionLowerBoundTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetRegionLowerBoundValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetRegionLowerBoundChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetRegionLowerBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetRegionLowerBound.class)
public class FxTargetRegionLowerBoundMeta implements RosettaMetaData<FxTargetRegionLowerBound> {

	@Override
	public List<Validator<? super FxTargetRegionLowerBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetRegionLowerBound>create(FxTargetRegionLowerBoundChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetRegionLowerBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetRegionLowerBound> validator(ValidatorFactory factory) {
		return factory.<FxTargetRegionLowerBound>create(FxTargetRegionLowerBoundValidator.class);
	}

	@Override
	public Validator<? super FxTargetRegionLowerBound> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetRegionLowerBound>create(FxTargetRegionLowerBoundTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetRegionLowerBound> validator() {
		return new FxTargetRegionLowerBoundValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetRegionLowerBound> typeFormatValidator() {
		return new FxTargetRegionLowerBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRegionLowerBound, Set<String>> onlyExistsValidator() {
		return new FxTargetRegionLowerBoundOnlyExistsValidator();
	}
}
