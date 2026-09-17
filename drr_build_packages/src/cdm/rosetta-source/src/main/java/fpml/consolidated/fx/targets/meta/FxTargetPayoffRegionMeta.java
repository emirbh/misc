package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetPayoffRegion;
import fpml.consolidated.fx.targets.validation.FxTargetPayoffRegionTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetPayoffRegionValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetPayoffRegion.class)
public class FxTargetPayoffRegionMeta implements RosettaMetaData<FxTargetPayoffRegion> {

	@Override
	public List<Validator<? super FxTargetPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetPayoffRegion> validator(ValidatorFactory factory) {
		return factory.<FxTargetPayoffRegion>create(FxTargetPayoffRegionValidator.class);
	}

	@Override
	public Validator<? super FxTargetPayoffRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetPayoffRegion>create(FxTargetPayoffRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetPayoffRegion> validator() {
		return new FxTargetPayoffRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetPayoffRegion> typeFormatValidator() {
		return new FxTargetPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetPayoffRegionOnlyExistsValidator();
	}
}
