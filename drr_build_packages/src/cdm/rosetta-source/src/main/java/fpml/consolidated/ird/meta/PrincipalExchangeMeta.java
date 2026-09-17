package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.ird.validation.PrincipalExchangeTypeFormatValidator;
import fpml.consolidated.ird.validation.PrincipalExchangeValidator;
import fpml.consolidated.ird.validation.exists.PrincipalExchangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PrincipalExchange.class)
public class PrincipalExchangeMeta implements RosettaMetaData<PrincipalExchange> {

	@Override
	public List<Validator<? super PrincipalExchange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrincipalExchange> validator(ValidatorFactory factory) {
		return factory.<PrincipalExchange>create(PrincipalExchangeValidator.class);
	}

	@Override
	public Validator<? super PrincipalExchange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrincipalExchange>create(PrincipalExchangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchange> validator() {
		return new PrincipalExchangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchange> typeFormatValidator() {
		return new PrincipalExchangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchange, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeOnlyExistsValidator();
	}
}
