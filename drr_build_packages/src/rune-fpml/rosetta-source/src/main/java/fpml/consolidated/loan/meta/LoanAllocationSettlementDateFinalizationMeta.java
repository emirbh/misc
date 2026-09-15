package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationSettlementDateFinalization;
import fpml.consolidated.loan.validation.LoanAllocationSettlementDateFinalizationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationSettlementDateFinalizationValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationSettlementDateFinalizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationSettlementDateFinalization.class)
public class LoanAllocationSettlementDateFinalizationMeta implements RosettaMetaData<LoanAllocationSettlementDateFinalization> {

	@Override
	public List<Validator<? super LoanAllocationSettlementDateFinalization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementDateFinalization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationSettlementDateFinalization> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlementDateFinalization>create(LoanAllocationSettlementDateFinalizationValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationSettlementDateFinalization> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlementDateFinalization>create(LoanAllocationSettlementDateFinalizationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlementDateFinalization> validator() {
		return new LoanAllocationSettlementDateFinalizationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlementDateFinalization> typeFormatValidator() {
		return new LoanAllocationSettlementDateFinalizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementDateFinalization, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementDateFinalizationOnlyExistsValidator();
	}
}
