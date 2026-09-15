package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import fpml.consolidated.fx.targets.validation.FxTargetLinearPayoffRegionTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetLinearPayoffRegionValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetLinearPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetLinearPayoffRegion.class)
public class FxTargetLinearPayoffRegionMeta implements RosettaMetaData<FxTargetLinearPayoffRegion> {

	@Override
	public List<Validator<? super FxTargetLinearPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetLinearPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetLinearPayoffRegion> validator(ValidatorFactory factory) {
		return factory.<FxTargetLinearPayoffRegion>create(FxTargetLinearPayoffRegionValidator.class);
	}

	@Override
	public Validator<? super FxTargetLinearPayoffRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetLinearPayoffRegion>create(FxTargetLinearPayoffRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetLinearPayoffRegion> validator() {
		return new FxTargetLinearPayoffRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetLinearPayoffRegion> typeFormatValidator() {
		return new FxTargetLinearPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetLinearPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetLinearPayoffRegionOnlyExistsValidator();
	}
}
