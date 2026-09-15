package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalStructureAfter;
import fpml.consolidated.loan.validation.LoanLegalStructureAfterTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalStructureAfterValidator;
import fpml.consolidated.loan.validation.datarule.LoanLegalStructureAfterChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalStructureAfterOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalStructureAfter.class)
public class LoanLegalStructureAfterMeta implements RosettaMetaData<LoanLegalStructureAfter> {

	@Override
	public List<Validator<? super LoanLegalStructureAfter>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalStructureAfter>create(LoanLegalStructureAfterChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalStructureAfter, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalStructureAfter> validator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureAfter>create(LoanLegalStructureAfterValidator.class);
	}

	@Override
	public Validator<? super LoanLegalStructureAfter> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureAfter>create(LoanLegalStructureAfterTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureAfter> validator() {
		return new LoanLegalStructureAfterValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureAfter> typeFormatValidator() {
		return new LoanLegalStructureAfterTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalStructureAfter, Set<String>> onlyExistsValidator() {
		return new LoanLegalStructureAfterOnlyExistsValidator();
	}
}
