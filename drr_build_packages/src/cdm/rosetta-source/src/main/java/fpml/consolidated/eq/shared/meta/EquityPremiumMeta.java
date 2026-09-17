package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eq.shared.validation.EquityPremiumTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.EquityPremiumValidator;
import fpml.consolidated.eq.shared.validation.exists.EquityPremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityPremium.class)
public class EquityPremiumMeta implements RosettaMetaData<EquityPremium> {

	@Override
	public List<Validator<? super EquityPremium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityPremium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityPremium> validator(ValidatorFactory factory) {
		return factory.<EquityPremium>create(EquityPremiumValidator.class);
	}

	@Override
	public Validator<? super EquityPremium> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityPremium>create(EquityPremiumTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityPremium> validator() {
		return new EquityPremiumValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityPremium> typeFormatValidator() {
		return new EquityPremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityPremium, Set<String>> onlyExistsValidator() {
		return new EquityPremiumOnlyExistsValidator();
	}
}
