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
import fpml.consolidated.loan.LoanAllocationType;
import fpml.consolidated.loan.validation.LoanAllocationTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationType.class)
public class LoanAllocationTypeMeta implements RosettaMetaData<LoanAllocationType> {

	@Override
	public List<Validator<? super LoanAllocationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationType> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationType>create(LoanAllocationTypeValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationType>create(LoanAllocationTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationType> validator() {
		return new LoanAllocationTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationType> typeFormatValidator() {
		return new LoanAllocationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationType, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTypeOnlyExistsValidator();
	}
}
