package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationSettlementDateAvailability;
import fpml.consolidated.loan.validation.LoanAllocationSettlementDateAvailabilityTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationSettlementDateAvailabilityValidator;
import fpml.consolidated.loan.validation.datarule.LoanAllocationSettlementDateAvailabilityChoice;
import fpml.consolidated.loan.validation.exists.LoanAllocationSettlementDateAvailabilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationSettlementDateAvailability.class)
public class LoanAllocationSettlementDateAvailabilityMeta implements RosettaMetaData<LoanAllocationSettlementDateAvailability> {

	@Override
	public List<Validator<? super LoanAllocationSettlementDateAvailability>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanAllocationSettlementDateAvailability>create(LoanAllocationSettlementDateAvailabilityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementDateAvailability, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationSettlementDateAvailability> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlementDateAvailability>create(LoanAllocationSettlementDateAvailabilityValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationSettlementDateAvailability> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlementDateAvailability>create(LoanAllocationSettlementDateAvailabilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlementDateAvailability> validator() {
		return new LoanAllocationSettlementDateAvailabilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlementDateAvailability> typeFormatValidator() {
		return new LoanAllocationSettlementDateAvailabilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementDateAvailability, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementDateAvailabilityOnlyExistsValidator();
	}
}
