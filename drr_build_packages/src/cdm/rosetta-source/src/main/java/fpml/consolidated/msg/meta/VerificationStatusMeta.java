package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.VerificationStatus;
import fpml.consolidated.msg.validation.VerificationStatusTypeFormatValidator;
import fpml.consolidated.msg.validation.VerificationStatusValidator;
import fpml.consolidated.msg.validation.exists.VerificationStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VerificationStatus.class)
public class VerificationStatusMeta implements RosettaMetaData<VerificationStatus> {

	@Override
	public List<Validator<? super VerificationStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VerificationStatus> validator(ValidatorFactory factory) {
		return factory.<VerificationStatus>create(VerificationStatusValidator.class);
	}

	@Override
	public Validator<? super VerificationStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VerificationStatus>create(VerificationStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VerificationStatus> validator() {
		return new VerificationStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VerificationStatus> typeFormatValidator() {
		return new VerificationStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationStatus, Set<String>> onlyExistsValidator() {
		return new VerificationStatusOnlyExistsValidator();
	}
}
