package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetConstantPayoffRegion;
import fpml.consolidated.fx.targets.validation.FxTargetConstantPayoffRegionTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetConstantPayoffRegionValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetConstantPayoffRegionChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetConstantPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetConstantPayoffRegion.class)
public class FxTargetConstantPayoffRegionMeta implements RosettaMetaData<FxTargetConstantPayoffRegion> {

	@Override
	public List<Validator<? super FxTargetConstantPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetConstantPayoffRegion>create(FxTargetConstantPayoffRegionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetConstantPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetConstantPayoffRegion> validator(ValidatorFactory factory) {
		return factory.<FxTargetConstantPayoffRegion>create(FxTargetConstantPayoffRegionValidator.class);
	}

	@Override
	public Validator<? super FxTargetConstantPayoffRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetConstantPayoffRegion>create(FxTargetConstantPayoffRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetConstantPayoffRegion> validator() {
		return new FxTargetConstantPayoffRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetConstantPayoffRegion> typeFormatValidator() {
		return new FxTargetConstantPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetConstantPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetConstantPayoffRegionOnlyExistsValidator();
	}
}
