package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeEvent;
import fpml.consolidated.loan.validation.LoanTradeEventTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeEventValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeEvent.class)
public class LoanTradeEventMeta implements RosettaMetaData<LoanTradeEvent> {

	@Override
	public List<Validator<? super LoanTradeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeEvent> validator(ValidatorFactory factory) {
		return factory.<LoanTradeEvent>create(LoanTradeEventValidator.class);
	}

	@Override
	public Validator<? super LoanTradeEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeEvent>create(LoanTradeEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeEvent> validator() {
		return new LoanTradeEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeEvent> typeFormatValidator() {
		return new LoanTradeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeEvent, Set<String>> onlyExistsValidator() {
		return new LoanTradeEventOnlyExistsValidator();
	}
}
