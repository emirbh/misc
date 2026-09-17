package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.validation.datarule.TradeIdentifierChoice;
import fpml.consolidated.loan.LoanTradeType;
import fpml.consolidated.loan.validation.LoanTradeTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeType.class)
public class LoanTradeTypeMeta implements RosettaMetaData<LoanTradeType> {

	@Override
	public List<Validator<? super LoanTradeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeType> validator(ValidatorFactory factory) {
		return factory.<LoanTradeType>create(LoanTradeTypeValidator.class);
	}

	@Override
	public Validator<? super LoanTradeType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeType>create(LoanTradeTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeType> validator() {
		return new LoanTradeTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeType> typeFormatValidator() {
		return new LoanTradeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeType, Set<String>> onlyExistsValidator() {
		return new LoanTradeTypeOnlyExistsValidator();
	}
}
