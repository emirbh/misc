package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradingEventSummary;
import fpml.consolidated.business.events.validation.TradingEventSummaryTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradingEventSummaryValidator;
import fpml.consolidated.business.events.validation.datarule.TradingEventSummaryChoice;
import fpml.consolidated.business.events.validation.exists.TradingEventSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradingEventSummary.class)
public class TradingEventSummaryMeta implements RosettaMetaData<TradingEventSummary> {

	@Override
	public List<Validator<? super TradingEventSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradingEventSummary>create(TradingEventSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradingEventSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradingEventSummary> validator(ValidatorFactory factory) {
		return factory.<TradingEventSummary>create(TradingEventSummaryValidator.class);
	}

	@Override
	public Validator<? super TradingEventSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradingEventSummary>create(TradingEventSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradingEventSummary> validator() {
		return new TradingEventSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradingEventSummary> typeFormatValidator() {
		return new TradingEventSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingEventSummary, Set<String>> onlyExistsValidator() {
		return new TradingEventSummaryOnlyExistsValidator();
	}
}
