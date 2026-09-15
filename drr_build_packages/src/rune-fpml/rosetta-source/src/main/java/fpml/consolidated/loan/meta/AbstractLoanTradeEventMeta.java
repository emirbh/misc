package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanTradeEvent;
import fpml.consolidated.loan.validation.AbstractLoanTradeEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanTradeEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanTradeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanTradeEvent.class)
public class AbstractLoanTradeEventMeta implements RosettaMetaData<AbstractLoanTradeEvent> {

	@Override
	public List<Validator<? super AbstractLoanTradeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTradeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanTradeEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanTradeEvent>create(AbstractLoanTradeEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanTradeEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanTradeEvent>create(AbstractLoanTradeEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanTradeEvent> validator() {
		return new AbstractLoanTradeEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanTradeEvent> typeFormatValidator() {
		return new AbstractLoanTradeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTradeEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradeEventOnlyExistsValidator();
	}
}
