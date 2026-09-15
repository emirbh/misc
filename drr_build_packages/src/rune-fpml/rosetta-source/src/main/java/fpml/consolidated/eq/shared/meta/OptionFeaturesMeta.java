package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eq.shared.validation.OptionFeaturesTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.OptionFeaturesValidator;
import fpml.consolidated.eq.shared.validation.exists.OptionFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionFeatures.class)
public class OptionFeaturesMeta implements RosettaMetaData<OptionFeatures> {

	@Override
	public List<Validator<? super OptionFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionFeatures> validator(ValidatorFactory factory) {
		return factory.<OptionFeatures>create(OptionFeaturesValidator.class);
	}

	@Override
	public Validator<? super OptionFeatures> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionFeatures>create(OptionFeaturesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionFeatures> validator() {
		return new OptionFeaturesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionFeatures> typeFormatValidator() {
		return new OptionFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionFeatures, Set<String>> onlyExistsValidator() {
		return new OptionFeaturesOnlyExistsValidator();
	}
}
