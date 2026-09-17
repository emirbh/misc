package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.validation.LoanAllocationNotificationChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationNotificationChoice1Validator;
import fpml.consolidated.loan.validation.datarule.LoanAllocationNotificationChoice1Choice;
import fpml.consolidated.loan.validation.exists.LoanAllocationNotificationChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationNotificationChoice1.class)
public class LoanAllocationNotificationChoice1Meta implements RosettaMetaData<LoanAllocationNotificationChoice1> {

	@Override
	public List<Validator<? super LoanAllocationNotificationChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanAllocationNotificationChoice1>create(LoanAllocationNotificationChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNotificationChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationNotificationChoice1> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotificationChoice1>create(LoanAllocationNotificationChoice1Validator.class);
	}

	@Override
	public Validator<? super LoanAllocationNotificationChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotificationChoice1>create(LoanAllocationNotificationChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotificationChoice1> validator() {
		return new LoanAllocationNotificationChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotificationChoice1> typeFormatValidator() {
		return new LoanAllocationNotificationChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNotificationChoice1, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNotificationChoice1OnlyExistsValidator();
	}
}
