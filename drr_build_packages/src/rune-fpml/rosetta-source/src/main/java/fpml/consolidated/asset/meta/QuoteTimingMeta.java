package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.QuoteTiming;
import fpml.consolidated.asset.validation.QuoteTimingTypeFormatValidator;
import fpml.consolidated.asset.validation.QuoteTimingValidator;
import fpml.consolidated.asset.validation.exists.QuoteTimingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QuoteTiming.class)
public class QuoteTimingMeta implements RosettaMetaData<QuoteTiming> {

	@Override
	public List<Validator<? super QuoteTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuoteTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuoteTiming> validator(ValidatorFactory factory) {
		return factory.<QuoteTiming>create(QuoteTimingValidator.class);
	}

	@Override
	public Validator<? super QuoteTiming> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QuoteTiming>create(QuoteTimingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QuoteTiming> validator() {
		return new QuoteTimingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QuoteTiming> typeFormatValidator() {
		return new QuoteTimingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuoteTiming, Set<String>> onlyExistsValidator() {
		return new QuoteTimingOnlyExistsValidator();
	}
}
