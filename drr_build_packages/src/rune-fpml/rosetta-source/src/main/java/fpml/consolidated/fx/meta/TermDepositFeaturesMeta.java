package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.TermDepositFeatures;
import fpml.consolidated.fx.validation.TermDepositFeaturesTypeFormatValidator;
import fpml.consolidated.fx.validation.TermDepositFeaturesValidator;
import fpml.consolidated.fx.validation.exists.TermDepositFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TermDepositFeatures.class)
public class TermDepositFeaturesMeta implements RosettaMetaData<TermDepositFeatures> {

	@Override
	public List<Validator<? super TermDepositFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermDepositFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TermDepositFeatures> validator(ValidatorFactory factory) {
		return factory.<TermDepositFeatures>create(TermDepositFeaturesValidator.class);
	}

	@Override
	public Validator<? super TermDepositFeatures> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TermDepositFeatures>create(TermDepositFeaturesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TermDepositFeatures> validator() {
		return new TermDepositFeaturesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TermDepositFeatures> typeFormatValidator() {
		return new TermDepositFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermDepositFeatures, Set<String>> onlyExistsValidator() {
		return new TermDepositFeaturesOnlyExistsValidator();
	}
}
