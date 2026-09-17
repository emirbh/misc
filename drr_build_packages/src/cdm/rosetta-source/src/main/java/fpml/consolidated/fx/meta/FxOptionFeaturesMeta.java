package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxOptionFeatures;
import fpml.consolidated.fx.validation.FxOptionFeaturesTypeFormatValidator;
import fpml.consolidated.fx.validation.FxOptionFeaturesValidator;
import fpml.consolidated.fx.validation.datarule.FxOptionFeaturesChoice;
import fpml.consolidated.fx.validation.exists.FxOptionFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxOptionFeatures.class)
public class FxOptionFeaturesMeta implements RosettaMetaData<FxOptionFeatures> {

	@Override
	public List<Validator<? super FxOptionFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxOptionFeatures>create(FxOptionFeaturesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxOptionFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxOptionFeatures> validator(ValidatorFactory factory) {
		return factory.<FxOptionFeatures>create(FxOptionFeaturesValidator.class);
	}

	@Override
	public Validator<? super FxOptionFeatures> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxOptionFeatures>create(FxOptionFeaturesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxOptionFeatures> validator() {
		return new FxOptionFeaturesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxOptionFeatures> typeFormatValidator() {
		return new FxOptionFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionFeatures, Set<String>> onlyExistsValidator() {
		return new FxOptionFeaturesOnlyExistsValidator();
	}
}
