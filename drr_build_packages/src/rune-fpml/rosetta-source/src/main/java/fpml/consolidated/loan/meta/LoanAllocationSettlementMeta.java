package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationSettlement;
import fpml.consolidated.loan.validation.LoanAllocationSettlementTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationSettlementValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationSettlement.class)
public class LoanAllocationSettlementMeta implements RosettaMetaData<LoanAllocationSettlement> {

	@Override
	public List<Validator<? super LoanAllocationSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationSettlement> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlement>create(LoanAllocationSettlementValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlement>create(LoanAllocationSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlement> validator() {
		return new LoanAllocationSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlement> typeFormatValidator() {
		return new LoanAllocationSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlement, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementOnlyExistsValidator();
	}
}
