package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTrade;
import fpml.consolidated.loan.validation.LoanTradeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTrade.class)
public class LoanTradeMeta implements RosettaMetaData<LoanTrade> {

	@Override
	public List<Validator<? super LoanTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTrade> validator(ValidatorFactory factory) {
		return factory.<LoanTrade>create(LoanTradeValidator.class);
	}

	@Override
	public Validator<? super LoanTrade> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTrade>create(LoanTradeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTrade> validator() {
		return new LoanTradeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTrade> typeFormatValidator() {
		return new LoanTradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTrade, Set<String>> onlyExistsValidator() {
		return new LoanTradeOnlyExistsValidator();
	}
}
