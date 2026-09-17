package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationNotificationChoice2;
import fpml.consolidated.loan.validation.LoanAllocationNotificationChoice2TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationNotificationChoice2Validator;
import fpml.consolidated.loan.validation.datarule.LoanAllocationNotificationChoice2Choice;
import fpml.consolidated.loan.validation.exists.LoanAllocationNotificationChoice2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationNotificationChoice2.class)
public class LoanAllocationNotificationChoice2Meta implements RosettaMetaData<LoanAllocationNotificationChoice2> {

	@Override
	public List<Validator<? super LoanAllocationNotificationChoice2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanAllocationNotificationChoice2>create(LoanAllocationNotificationChoice2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNotificationChoice2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationNotificationChoice2> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotificationChoice2>create(LoanAllocationNotificationChoice2Validator.class);
	}

	@Override
	public Validator<? super LoanAllocationNotificationChoice2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotificationChoice2>create(LoanAllocationNotificationChoice2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotificationChoice2> validator() {
		return new LoanAllocationNotificationChoice2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotificationChoice2> typeFormatValidator() {
		return new LoanAllocationNotificationChoice2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNotificationChoice2, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNotificationChoice2OnlyExistsValidator();
	}
}
