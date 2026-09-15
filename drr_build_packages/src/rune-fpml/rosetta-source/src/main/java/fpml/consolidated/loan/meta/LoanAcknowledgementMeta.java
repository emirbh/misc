package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAcknowledgement;
import fpml.consolidated.loan.validation.LoanAcknowledgementTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAcknowledgementValidator;
import fpml.consolidated.loan.validation.exists.LoanAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAcknowledgement.class)
public class LoanAcknowledgementMeta implements RosettaMetaData<LoanAcknowledgement> {

	@Override
	public List<Validator<? super LoanAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<LoanAcknowledgement>create(LoanAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super LoanAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAcknowledgement>create(LoanAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAcknowledgement> validator() {
		return new LoanAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAcknowledgement> typeFormatValidator() {
		return new LoanAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAcknowledgement, Set<String>> onlyExistsValidator() {
		return new LoanAcknowledgementOnlyExistsValidator();
	}
}
