package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxAsianFeature;
import fpml.consolidated.fx.validation.FxAsianFeatureTypeFormatValidator;
import fpml.consolidated.fx.validation.FxAsianFeatureValidator;
import fpml.consolidated.fx.validation.exists.FxAsianFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAsianFeature.class)
public class FxAsianFeatureMeta implements RosettaMetaData<FxAsianFeature> {

	@Override
	public List<Validator<? super FxAsianFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAsianFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAsianFeature> validator(ValidatorFactory factory) {
		return factory.<FxAsianFeature>create(FxAsianFeatureValidator.class);
	}

	@Override
	public Validator<? super FxAsianFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAsianFeature>create(FxAsianFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAsianFeature> validator() {
		return new FxAsianFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAsianFeature> typeFormatValidator() {
		return new FxAsianFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAsianFeature, Set<String>> onlyExistsValidator() {
		return new FxAsianFeatureOnlyExistsValidator();
	}
}
