package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.PrincipalExchangeFeatures;
import fpml.consolidated.eq.shared.validation.PrincipalExchangeFeaturesTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.PrincipalExchangeFeaturesValidator;
import fpml.consolidated.eq.shared.validation.exists.PrincipalExchangeFeaturesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PrincipalExchangeFeatures.class)
public class PrincipalExchangeFeaturesMeta implements RosettaMetaData<PrincipalExchangeFeatures> {

	@Override
	public List<Validator<? super PrincipalExchangeFeatures>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchangeFeatures, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrincipalExchangeFeatures> validator(ValidatorFactory factory) {
		return factory.<PrincipalExchangeFeatures>create(PrincipalExchangeFeaturesValidator.class);
	}

	@Override
	public Validator<? super PrincipalExchangeFeatures> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrincipalExchangeFeatures>create(PrincipalExchangeFeaturesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchangeFeatures> validator() {
		return new PrincipalExchangeFeaturesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchangeFeatures> typeFormatValidator() {
		return new PrincipalExchangeFeaturesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchangeFeatures, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeFeaturesOnlyExistsValidator();
	}
}
