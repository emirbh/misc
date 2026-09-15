package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationHybridDetails;
import fpml.consolidated.loan.validation.LoanCovenantObligationHybridDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationHybridDetailsValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationHybridDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationHybridDetails.class)
public class LoanCovenantObligationHybridDetailsMeta implements RosettaMetaData<LoanCovenantObligationHybridDetails> {

	@Override
	public List<Validator<? super LoanCovenantObligationHybridDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationHybridDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationHybridDetails> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationHybridDetails>create(LoanCovenantObligationHybridDetailsValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationHybridDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationHybridDetails>create(LoanCovenantObligationHybridDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationHybridDetails> validator() {
		return new LoanCovenantObligationHybridDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationHybridDetails> typeFormatValidator() {
		return new LoanCovenantObligationHybridDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationHybridDetails, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationHybridDetailsOnlyExistsValidator();
	}
}
