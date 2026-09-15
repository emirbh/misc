package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.PremiumQuote;
import fpml.consolidated.fx.validation.PremiumQuoteTypeFormatValidator;
import fpml.consolidated.fx.validation.PremiumQuoteValidator;
import fpml.consolidated.fx.validation.exists.PremiumQuoteOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PremiumQuote.class)
public class PremiumQuoteMeta implements RosettaMetaData<PremiumQuote> {

	@Override
	public List<Validator<? super PremiumQuote>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PremiumQuote, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PremiumQuote> validator(ValidatorFactory factory) {
		return factory.<PremiumQuote>create(PremiumQuoteValidator.class);
	}

	@Override
	public Validator<? super PremiumQuote> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PremiumQuote>create(PremiumQuoteTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PremiumQuote> validator() {
		return new PremiumQuoteValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PremiumQuote> typeFormatValidator() {
		return new PremiumQuoteTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PremiumQuote, Set<String>> onlyExistsValidator() {
		return new PremiumQuoteOnlyExistsValidator();
	}
}
