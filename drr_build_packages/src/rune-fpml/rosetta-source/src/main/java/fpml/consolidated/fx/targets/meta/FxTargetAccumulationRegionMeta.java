package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetAccumulationRegion;
import fpml.consolidated.fx.targets.validation.FxTargetAccumulationRegionTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetAccumulationRegionValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetAccumulationRegionChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetAccumulationRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetAccumulationRegion.class)
public class FxTargetAccumulationRegionMeta implements RosettaMetaData<FxTargetAccumulationRegion> {

	@Override
	public List<Validator<? super FxTargetAccumulationRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetAccumulationRegion>create(FxTargetAccumulationRegionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetAccumulationRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetAccumulationRegion> validator(ValidatorFactory factory) {
		return factory.<FxTargetAccumulationRegion>create(FxTargetAccumulationRegionValidator.class);
	}

	@Override
	public Validator<? super FxTargetAccumulationRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetAccumulationRegion>create(FxTargetAccumulationRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetAccumulationRegion> validator() {
		return new FxTargetAccumulationRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetAccumulationRegion> typeFormatValidator() {
		return new FxTargetAccumulationRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetAccumulationRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetAccumulationRegionOnlyExistsValidator();
	}
}
