package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractAdjustment;
import fpml.consolidated.loan.validation.LoanContractAdjustmentTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractAdjustmentValidator;
import fpml.consolidated.loan.validation.exists.LoanContractAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractAdjustment.class)
public class LoanContractAdjustmentMeta implements RosettaMetaData<LoanContractAdjustment> {

	@Override
	public List<Validator<? super LoanContractAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractAdjustment> validator(ValidatorFactory factory) {
		return factory.<LoanContractAdjustment>create(LoanContractAdjustmentValidator.class);
	}

	@Override
	public Validator<? super LoanContractAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractAdjustment>create(LoanContractAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractAdjustment> validator() {
		return new LoanContractAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractAdjustment> typeFormatValidator() {
		return new LoanContractAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractAdjustment, Set<String>> onlyExistsValidator() {
		return new LoanContractAdjustmentOnlyExistsValidator();
	}
}
