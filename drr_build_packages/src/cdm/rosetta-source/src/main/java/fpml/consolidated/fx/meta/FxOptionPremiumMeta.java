package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxOptionPremium;
import fpml.consolidated.fx.validation.FxOptionPremiumTypeFormatValidator;
import fpml.consolidated.fx.validation.FxOptionPremiumValidator;
import fpml.consolidated.fx.validation.exists.FxOptionPremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxOptionPremium.class)
public class FxOptionPremiumMeta implements RosettaMetaData<FxOptionPremium> {

	@Override
	public List<Validator<? super FxOptionPremium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOptionPremium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxOptionPremium> validator(ValidatorFactory factory) {
		return factory.<FxOptionPremium>create(FxOptionPremiumValidator.class);
	}

	@Override
	public Validator<? super FxOptionPremium> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxOptionPremium>create(FxOptionPremiumTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxOptionPremium> validator() {
		return new FxOptionPremiumValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxOptionPremium> typeFormatValidator() {
		return new FxOptionPremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionPremium, Set<String>> onlyExistsValidator() {
		return new FxOptionPremiumOnlyExistsValidator();
	}
}
