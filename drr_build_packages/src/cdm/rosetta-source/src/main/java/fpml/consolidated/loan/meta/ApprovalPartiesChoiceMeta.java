package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalPartiesChoice;
import fpml.consolidated.loan.validation.ApprovalPartiesChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.ApprovalPartiesChoiceValidator;
import fpml.consolidated.loan.validation.datarule.ApprovalPartiesChoiceChoice;
import fpml.consolidated.loan.validation.exists.ApprovalPartiesChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApprovalPartiesChoice.class)
public class ApprovalPartiesChoiceMeta implements RosettaMetaData<ApprovalPartiesChoice> {

	@Override
	public List<Validator<? super ApprovalPartiesChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApprovalPartiesChoice>create(ApprovalPartiesChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApprovalPartiesChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApprovalPartiesChoice> validator(ValidatorFactory factory) {
		return factory.<ApprovalPartiesChoice>create(ApprovalPartiesChoiceValidator.class);
	}

	@Override
	public Validator<? super ApprovalPartiesChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApprovalPartiesChoice>create(ApprovalPartiesChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalPartiesChoice> validator() {
		return new ApprovalPartiesChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalPartiesChoice> typeFormatValidator() {
		return new ApprovalPartiesChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalPartiesChoice, Set<String>> onlyExistsValidator() {
		return new ApprovalPartiesChoiceOnlyExistsValidator();
	}
}
