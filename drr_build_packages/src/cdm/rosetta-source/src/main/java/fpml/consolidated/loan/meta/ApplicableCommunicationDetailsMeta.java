package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableCommunicationDetails;
import fpml.consolidated.loan.validation.ApplicableCommunicationDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.ApplicableCommunicationDetailsValidator;
import fpml.consolidated.loan.validation.exists.ApplicableCommunicationDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableCommunicationDetails.class)
public class ApplicableCommunicationDetailsMeta implements RosettaMetaData<ApplicableCommunicationDetails> {

	@Override
	public List<Validator<? super ApplicableCommunicationDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApplicableCommunicationDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableCommunicationDetails> validator(ValidatorFactory factory) {
		return factory.<ApplicableCommunicationDetails>create(ApplicableCommunicationDetailsValidator.class);
	}

	@Override
	public Validator<? super ApplicableCommunicationDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableCommunicationDetails>create(ApplicableCommunicationDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableCommunicationDetails> validator() {
		return new ApplicableCommunicationDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableCommunicationDetails> typeFormatValidator() {
		return new ApplicableCommunicationDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableCommunicationDetails, Set<String>> onlyExistsValidator() {
		return new ApplicableCommunicationDetailsOnlyExistsValidator();
	}
}
