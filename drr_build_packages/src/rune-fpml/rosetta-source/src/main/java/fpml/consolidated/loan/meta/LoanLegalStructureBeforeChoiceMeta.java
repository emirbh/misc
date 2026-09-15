package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalStructureBeforeChoice;
import fpml.consolidated.loan.validation.LoanLegalStructureBeforeChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalStructureBeforeChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanLegalStructureBeforeChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalStructureBeforeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalStructureBeforeChoice.class)
public class LoanLegalStructureBeforeChoiceMeta implements RosettaMetaData<LoanLegalStructureBeforeChoice> {

	@Override
	public List<Validator<? super LoanLegalStructureBeforeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalStructureBeforeChoice>create(LoanLegalStructureBeforeChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalStructureBeforeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalStructureBeforeChoice> validator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureBeforeChoice>create(LoanLegalStructureBeforeChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanLegalStructureBeforeChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureBeforeChoice>create(LoanLegalStructureBeforeChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureBeforeChoice> validator() {
		return new LoanLegalStructureBeforeChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureBeforeChoice> typeFormatValidator() {
		return new LoanLegalStructureBeforeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalStructureBeforeChoice, Set<String>> onlyExistsValidator() {
		return new LoanLegalStructureBeforeChoiceOnlyExistsValidator();
	}
}
