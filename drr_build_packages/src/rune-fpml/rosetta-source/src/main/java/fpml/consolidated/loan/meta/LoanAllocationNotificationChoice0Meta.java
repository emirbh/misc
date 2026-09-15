package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.validation.LoanAllocationNotificationChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationNotificationChoice0Validator;
import fpml.consolidated.loan.validation.datarule.LoanAllocationNotificationChoice0Choice;
import fpml.consolidated.loan.validation.exists.LoanAllocationNotificationChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationNotificationChoice0.class)
public class LoanAllocationNotificationChoice0Meta implements RosettaMetaData<LoanAllocationNotificationChoice0> {

	@Override
	public List<Validator<? super LoanAllocationNotificationChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanAllocationNotificationChoice0>create(LoanAllocationNotificationChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNotificationChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationNotificationChoice0> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotificationChoice0>create(LoanAllocationNotificationChoice0Validator.class);
	}

	@Override
	public Validator<? super LoanAllocationNotificationChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotificationChoice0>create(LoanAllocationNotificationChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotificationChoice0> validator() {
		return new LoanAllocationNotificationChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotificationChoice0> typeFormatValidator() {
		return new LoanAllocationNotificationChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNotificationChoice0, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNotificationChoice0OnlyExistsValidator();
	}
}
