package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.DualCurrencyFeature;
import fpml.consolidated.fx.validation.DualCurrencyFeatureTypeFormatValidator;
import fpml.consolidated.fx.validation.DualCurrencyFeatureValidator;
import fpml.consolidated.fx.validation.exists.DualCurrencyFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DualCurrencyFeature.class)
public class DualCurrencyFeatureMeta implements RosettaMetaData<DualCurrencyFeature> {

	@Override
	public List<Validator<? super DualCurrencyFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DualCurrencyFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DualCurrencyFeature> validator(ValidatorFactory factory) {
		return factory.<DualCurrencyFeature>create(DualCurrencyFeatureValidator.class);
	}

	@Override
	public Validator<? super DualCurrencyFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DualCurrencyFeature>create(DualCurrencyFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DualCurrencyFeature> validator() {
		return new DualCurrencyFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DualCurrencyFeature> typeFormatValidator() {
		return new DualCurrencyFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DualCurrencyFeature, Set<String>> onlyExistsValidator() {
		return new DualCurrencyFeatureOnlyExistsValidator();
	}
}
