package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalParties;
import fpml.consolidated.loan.validation.ApprovalPartiesTypeFormatValidator;
import fpml.consolidated.loan.validation.ApprovalPartiesValidator;
import fpml.consolidated.loan.validation.exists.ApprovalPartiesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApprovalParties.class)
public class ApprovalPartiesMeta implements RosettaMetaData<ApprovalParties> {

	@Override
	public List<Validator<? super ApprovalParties>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApprovalParties, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApprovalParties> validator(ValidatorFactory factory) {
		return factory.<ApprovalParties>create(ApprovalPartiesValidator.class);
	}

	@Override
	public Validator<? super ApprovalParties> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApprovalParties>create(ApprovalPartiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalParties> validator() {
		return new ApprovalPartiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalParties> typeFormatValidator() {
		return new ApprovalPartiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalParties, Set<String>> onlyExistsValidator() {
		return new ApprovalPartiesOnlyExistsValidator();
	}
}
