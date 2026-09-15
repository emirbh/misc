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
import fpml.consolidated.loan.LoanAllocationIdentifier;
import fpml.consolidated.loan.validation.LoanAllocationIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationIdentifierValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationIdentifier.class)
public class LoanAllocationIdentifierMeta implements RosettaMetaData<LoanAllocationIdentifier> {

	@Override
	public List<Validator<? super LoanAllocationIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationIdentifier> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationIdentifier>create(LoanAllocationIdentifierValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationIdentifier>create(LoanAllocationIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationIdentifier> validator() {
		return new LoanAllocationIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationIdentifier> typeFormatValidator() {
		return new LoanAllocationIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationIdentifier, Set<String>> onlyExistsValidator() {
		return new LoanAllocationIdentifierOnlyExistsValidator();
	}
}
