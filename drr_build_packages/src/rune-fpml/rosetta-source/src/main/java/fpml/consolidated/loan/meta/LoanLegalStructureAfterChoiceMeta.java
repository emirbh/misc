package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalStructureAfterChoice;
import fpml.consolidated.loan.validation.LoanLegalStructureAfterChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalStructureAfterChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanLegalStructureAfterChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalStructureAfterChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalStructureAfterChoice.class)
public class LoanLegalStructureAfterChoiceMeta implements RosettaMetaData<LoanLegalStructureAfterChoice> {

	@Override
	public List<Validator<? super LoanLegalStructureAfterChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalStructureAfterChoice>create(LoanLegalStructureAfterChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalStructureAfterChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalStructureAfterChoice> validator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureAfterChoice>create(LoanLegalStructureAfterChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanLegalStructureAfterChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureAfterChoice>create(LoanLegalStructureAfterChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureAfterChoice> validator() {
		return new LoanLegalStructureAfterChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureAfterChoice> typeFormatValidator() {
		return new LoanLegalStructureAfterChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalStructureAfterChoice, Set<String>> onlyExistsValidator() {
		return new LoanLegalStructureAfterChoiceOnlyExistsValidator();
	}
}
