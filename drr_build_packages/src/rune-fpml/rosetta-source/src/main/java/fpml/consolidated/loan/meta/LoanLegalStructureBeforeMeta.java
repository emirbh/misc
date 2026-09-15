package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalStructureBefore;
import fpml.consolidated.loan.validation.LoanLegalStructureBeforeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalStructureBeforeValidator;
import fpml.consolidated.loan.validation.datarule.LoanLegalStructureBeforeChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalStructureBeforeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalStructureBefore.class)
public class LoanLegalStructureBeforeMeta implements RosettaMetaData<LoanLegalStructureBefore> {

	@Override
	public List<Validator<? super LoanLegalStructureBefore>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalStructureBefore>create(LoanLegalStructureBeforeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalStructureBefore, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalStructureBefore> validator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureBefore>create(LoanLegalStructureBeforeValidator.class);
	}

	@Override
	public Validator<? super LoanLegalStructureBefore> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalStructureBefore>create(LoanLegalStructureBeforeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureBefore> validator() {
		return new LoanLegalStructureBeforeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalStructureBefore> typeFormatValidator() {
		return new LoanLegalStructureBeforeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalStructureBefore, Set<String>> onlyExistsValidator() {
		return new LoanLegalStructureBeforeOnlyExistsValidator();
	}
}
