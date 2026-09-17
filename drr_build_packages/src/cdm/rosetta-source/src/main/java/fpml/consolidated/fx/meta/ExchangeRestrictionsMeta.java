package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.ExchangeRestrictions;
import fpml.consolidated.fx.validation.ExchangeRestrictionsTypeFormatValidator;
import fpml.consolidated.fx.validation.ExchangeRestrictionsValidator;
import fpml.consolidated.fx.validation.exists.ExchangeRestrictionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExchangeRestrictions.class)
public class ExchangeRestrictionsMeta implements RosettaMetaData<ExchangeRestrictions> {

	@Override
	public List<Validator<? super ExchangeRestrictions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeRestrictions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExchangeRestrictions> validator(ValidatorFactory factory) {
		return factory.<ExchangeRestrictions>create(ExchangeRestrictionsValidator.class);
	}

	@Override
	public Validator<? super ExchangeRestrictions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExchangeRestrictions>create(ExchangeRestrictionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeRestrictions> validator() {
		return new ExchangeRestrictionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeRestrictions> typeFormatValidator() {
		return new ExchangeRestrictionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeRestrictions, Set<String>> onlyExistsValidator() {
		return new ExchangeRestrictionsOnlyExistsValidator();
	}
}
