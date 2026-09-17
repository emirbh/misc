package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableCommunicationDetailsChoice;
import fpml.consolidated.loan.validation.ApplicableCommunicationDetailsChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.ApplicableCommunicationDetailsChoiceValidator;
import fpml.consolidated.loan.validation.datarule.ApplicableCommunicationDetailsChoiceChoice;
import fpml.consolidated.loan.validation.exists.ApplicableCommunicationDetailsChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableCommunicationDetailsChoice.class)
public class ApplicableCommunicationDetailsChoiceMeta implements RosettaMetaData<ApplicableCommunicationDetailsChoice> {

	@Override
	public List<Validator<? super ApplicableCommunicationDetailsChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApplicableCommunicationDetailsChoice>create(ApplicableCommunicationDetailsChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApplicableCommunicationDetailsChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableCommunicationDetailsChoice> validator(ValidatorFactory factory) {
		return factory.<ApplicableCommunicationDetailsChoice>create(ApplicableCommunicationDetailsChoiceValidator.class);
	}

	@Override
	public Validator<? super ApplicableCommunicationDetailsChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableCommunicationDetailsChoice>create(ApplicableCommunicationDetailsChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableCommunicationDetailsChoice> validator() {
		return new ApplicableCommunicationDetailsChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableCommunicationDetailsChoice> typeFormatValidator() {
		return new ApplicableCommunicationDetailsChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableCommunicationDetailsChoice, Set<String>> onlyExistsValidator() {
		return new ApplicableCommunicationDetailsChoiceOnlyExistsValidator();
	}
}
