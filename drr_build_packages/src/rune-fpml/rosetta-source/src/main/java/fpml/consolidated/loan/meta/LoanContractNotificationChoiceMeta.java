package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractNotificationChoice;
import fpml.consolidated.loan.validation.LoanContractNotificationChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractNotificationChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanContractNotificationChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanContractNotificationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractNotificationChoice.class)
public class LoanContractNotificationChoiceMeta implements RosettaMetaData<LoanContractNotificationChoice> {

	@Override
	public List<Validator<? super LoanContractNotificationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanContractNotificationChoice>create(LoanContractNotificationChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContractNotificationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractNotificationChoice> validator(ValidatorFactory factory) {
		return factory.<LoanContractNotificationChoice>create(LoanContractNotificationChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanContractNotificationChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractNotificationChoice>create(LoanContractNotificationChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractNotificationChoice> validator() {
		return new LoanContractNotificationChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractNotificationChoice> typeFormatValidator() {
		return new LoanContractNotificationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractNotificationChoice, Set<String>> onlyExistsValidator() {
		return new LoanContractNotificationChoiceOnlyExistsValidator();
	}
}
