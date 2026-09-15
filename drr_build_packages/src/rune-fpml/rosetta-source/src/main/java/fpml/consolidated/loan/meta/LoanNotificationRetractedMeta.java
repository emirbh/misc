package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanNotificationRetracted;
import fpml.consolidated.loan.validation.LoanNotificationRetractedTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanNotificationRetractedValidator;
import fpml.consolidated.loan.validation.datarule.LoanNotificationRetractedChoice;
import fpml.consolidated.loan.validation.exists.LoanNotificationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanNotificationRetracted.class)
public class LoanNotificationRetractedMeta implements RosettaMetaData<LoanNotificationRetracted> {

	@Override
	public List<Validator<? super LoanNotificationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanNotificationRetracted>create(LoanNotificationRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanNotificationRetracted> validator(ValidatorFactory factory) {
		return factory.<LoanNotificationRetracted>create(LoanNotificationRetractedValidator.class);
	}

	@Override
	public Validator<? super LoanNotificationRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanNotificationRetracted>create(LoanNotificationRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanNotificationRetracted> validator() {
		return new LoanNotificationRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanNotificationRetracted> typeFormatValidator() {
		return new LoanNotificationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationRetracted, Set<String>> onlyExistsValidator() {
		return new LoanNotificationRetractedOnlyExistsValidator();
	}
}
