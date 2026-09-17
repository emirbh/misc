package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PrincipalExchanges;
import fpml.consolidated.shared.validation.PrincipalExchangesTypeFormatValidator;
import fpml.consolidated.shared.validation.PrincipalExchangesValidator;
import fpml.consolidated.shared.validation.exists.PrincipalExchangesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PrincipalExchanges.class)
public class PrincipalExchangesMeta implements RosettaMetaData<PrincipalExchanges> {

	@Override
	public List<Validator<? super PrincipalExchanges>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchanges, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrincipalExchanges> validator(ValidatorFactory factory) {
		return factory.<PrincipalExchanges>create(PrincipalExchangesValidator.class);
	}

	@Override
	public Validator<? super PrincipalExchanges> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrincipalExchanges>create(PrincipalExchangesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchanges> validator() {
		return new PrincipalExchangesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchanges> typeFormatValidator() {
		return new PrincipalExchangesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchanges, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangesOnlyExistsValidator();
	}
}
