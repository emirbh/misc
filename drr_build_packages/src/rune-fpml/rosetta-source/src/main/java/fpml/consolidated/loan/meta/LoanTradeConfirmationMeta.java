package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeConfirmation;
import fpml.consolidated.loan.validation.LoanTradeConfirmationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeConfirmationValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeConfirmationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeConfirmation.class)
public class LoanTradeConfirmationMeta implements RosettaMetaData<LoanTradeConfirmation> {

	@Override
	public List<Validator<? super LoanTradeConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeConfirmation> validator(ValidatorFactory factory) {
		return factory.<LoanTradeConfirmation>create(LoanTradeConfirmationValidator.class);
	}

	@Override
	public Validator<? super LoanTradeConfirmation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeConfirmation>create(LoanTradeConfirmationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeConfirmation> validator() {
		return new LoanTradeConfirmationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeConfirmation> typeFormatValidator() {
		return new LoanTradeConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeConfirmation, Set<String>> onlyExistsValidator() {
		return new LoanTradeConfirmationOnlyExistsValidator();
	}
}
