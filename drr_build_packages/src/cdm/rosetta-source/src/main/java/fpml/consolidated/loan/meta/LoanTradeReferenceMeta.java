package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.loan.validation.LoanTradeReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeReferenceValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeReference.class)
public class LoanTradeReferenceMeta implements RosettaMetaData<LoanTradeReference> {

	@Override
	public List<Validator<? super LoanTradeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeReference> validator(ValidatorFactory factory) {
		return factory.<LoanTradeReference>create(LoanTradeReferenceValidator.class);
	}

	@Override
	public Validator<? super LoanTradeReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeReference>create(LoanTradeReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeReference> validator() {
		return new LoanTradeReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeReference> typeFormatValidator() {
		return new LoanTradeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeReference, Set<String>> onlyExistsValidator() {
		return new LoanTradeReferenceOnlyExistsValidator();
	}
}
