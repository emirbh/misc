package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.option.shared.validation.StrategyFeatureTypeFormatValidator;
import fpml.consolidated.option.shared.validation.StrategyFeatureValidator;
import fpml.consolidated.option.shared.validation.datarule.StrategyFeatureChoice;
import fpml.consolidated.option.shared.validation.exists.StrategyFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StrategyFeature.class)
public class StrategyFeatureMeta implements RosettaMetaData<StrategyFeature> {

	@Override
	public List<Validator<? super StrategyFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<StrategyFeature>create(StrategyFeatureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StrategyFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StrategyFeature> validator(ValidatorFactory factory) {
		return factory.<StrategyFeature>create(StrategyFeatureValidator.class);
	}

	@Override
	public Validator<? super StrategyFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StrategyFeature>create(StrategyFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StrategyFeature> validator() {
		return new StrategyFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StrategyFeature> typeFormatValidator() {
		return new StrategyFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrategyFeature, Set<String>> onlyExistsValidator() {
		return new StrategyFeatureOnlyExistsValidator();
	}
}
