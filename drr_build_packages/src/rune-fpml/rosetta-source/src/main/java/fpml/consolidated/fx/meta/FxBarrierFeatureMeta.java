package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxBarrierFeature;
import fpml.consolidated.fx.validation.FxBarrierFeatureTypeFormatValidator;
import fpml.consolidated.fx.validation.FxBarrierFeatureValidator;
import fpml.consolidated.fx.validation.datarule.FxBarrierFeatureChoice;
import fpml.consolidated.fx.validation.exists.FxBarrierFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxBarrierFeature.class)
public class FxBarrierFeatureMeta implements RosettaMetaData<FxBarrierFeature> {

	@Override
	public List<Validator<? super FxBarrierFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxBarrierFeature>create(FxBarrierFeatureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxBarrierFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxBarrierFeature> validator(ValidatorFactory factory) {
		return factory.<FxBarrierFeature>create(FxBarrierFeatureValidator.class);
	}

	@Override
	public Validator<? super FxBarrierFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxBarrierFeature>create(FxBarrierFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxBarrierFeature> validator() {
		return new FxBarrierFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxBarrierFeature> typeFormatValidator() {
		return new FxBarrierFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBarrierFeature, Set<String>> onlyExistsValidator() {
		return new FxBarrierFeatureOnlyExistsValidator();
	}
}
