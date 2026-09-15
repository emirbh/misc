package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.VerificationStatusAcknowledgement;
import fpml.consolidated.msg.validation.VerificationStatusAcknowledgementTypeFormatValidator;
import fpml.consolidated.msg.validation.VerificationStatusAcknowledgementValidator;
import fpml.consolidated.msg.validation.exists.VerificationStatusAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VerificationStatusAcknowledgement.class)
public class VerificationStatusAcknowledgementMeta implements RosettaMetaData<VerificationStatusAcknowledgement> {

	@Override
	public List<Validator<? super VerificationStatusAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationStatusAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VerificationStatusAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<VerificationStatusAcknowledgement>create(VerificationStatusAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super VerificationStatusAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VerificationStatusAcknowledgement>create(VerificationStatusAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VerificationStatusAcknowledgement> validator() {
		return new VerificationStatusAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VerificationStatusAcknowledgement> typeFormatValidator() {
		return new VerificationStatusAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationStatusAcknowledgement, Set<String>> onlyExistsValidator() {
		return new VerificationStatusAcknowledgementOnlyExistsValidator();
	}
}
