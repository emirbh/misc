package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.validation.FxFeatureTypeFormatValidator;
import fpml.consolidated.option.shared.validation.FxFeatureValidator;
import fpml.consolidated.option.shared.validation.datarule.FxFeatureChoice;
import fpml.consolidated.option.shared.validation.exists.FxFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFeature.class)
public class FxFeatureMeta implements RosettaMetaData<FxFeature> {

	@Override
	public List<Validator<? super FxFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxFeature>create(FxFeatureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFeature> validator(ValidatorFactory factory) {
		return factory.<FxFeature>create(FxFeatureValidator.class);
	}

	@Override
	public Validator<? super FxFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFeature>create(FxFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFeature> validator() {
		return new FxFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFeature> typeFormatValidator() {
		return new FxFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFeature, Set<String>> onlyExistsValidator() {
		return new FxFeatureOnlyExistsValidator();
	}
}
