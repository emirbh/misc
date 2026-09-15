package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.PrincipalExchangeAmount;
import fpml.consolidated.eq.shared.validation.PrincipalExchangeAmountTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.PrincipalExchangeAmountValidator;
import fpml.consolidated.eq.shared.validation.datarule.PrincipalExchangeAmountChoice;
import fpml.consolidated.eq.shared.validation.exists.PrincipalExchangeAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PrincipalExchangeAmount.class)
public class PrincipalExchangeAmountMeta implements RosettaMetaData<PrincipalExchangeAmount> {

	@Override
	public List<Validator<? super PrincipalExchangeAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PrincipalExchangeAmount>create(PrincipalExchangeAmountChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchangeAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrincipalExchangeAmount> validator(ValidatorFactory factory) {
		return factory.<PrincipalExchangeAmount>create(PrincipalExchangeAmountValidator.class);
	}

	@Override
	public Validator<? super PrincipalExchangeAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrincipalExchangeAmount>create(PrincipalExchangeAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchangeAmount> validator() {
		return new PrincipalExchangeAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalExchangeAmount> typeFormatValidator() {
		return new PrincipalExchangeAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchangeAmount, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeAmountOnlyExistsValidator();
	}
}
