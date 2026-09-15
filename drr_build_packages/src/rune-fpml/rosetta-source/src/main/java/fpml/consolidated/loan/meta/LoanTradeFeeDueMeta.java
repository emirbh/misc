package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeFeeDue;
import fpml.consolidated.loan.validation.LoanTradeFeeDueTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeFeeDueValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeFeeDueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeFeeDue.class)
public class LoanTradeFeeDueMeta implements RosettaMetaData<LoanTradeFeeDue> {

	@Override
	public List<Validator<? super LoanTradeFeeDue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeFeeDue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeFeeDue> validator(ValidatorFactory factory) {
		return factory.<LoanTradeFeeDue>create(LoanTradeFeeDueValidator.class);
	}

	@Override
	public Validator<? super LoanTradeFeeDue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeFeeDue>create(LoanTradeFeeDueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeFeeDue> validator() {
		return new LoanTradeFeeDueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeFeeDue> typeFormatValidator() {
		return new LoanTradeFeeDueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeFeeDue, Set<String>> onlyExistsValidator() {
		return new LoanTradeFeeDueOnlyExistsValidator();
	}
}
