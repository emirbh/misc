package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.OptionFeature;
import fpml.consolidated.option.shared.validation.OptionFeatureTypeFormatValidator;
import fpml.consolidated.option.shared.validation.OptionFeatureValidator;
import fpml.consolidated.option.shared.validation.exists.OptionFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionFeature.class)
public class OptionFeatureMeta implements RosettaMetaData<OptionFeature> {

	@Override
	public List<Validator<? super OptionFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionFeature> validator(ValidatorFactory factory) {
		return factory.<OptionFeature>create(OptionFeatureValidator.class);
	}

	@Override
	public Validator<? super OptionFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionFeature>create(OptionFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionFeature> validator() {
		return new OptionFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionFeature> typeFormatValidator() {
		return new OptionFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionFeature, Set<String>> onlyExistsValidator() {
		return new OptionFeatureOnlyExistsValidator();
	}
}
