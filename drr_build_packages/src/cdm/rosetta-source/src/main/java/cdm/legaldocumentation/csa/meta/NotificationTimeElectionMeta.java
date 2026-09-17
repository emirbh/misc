package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.NotificationTimeElection;
import cdm.legaldocumentation.csa.validation.NotificationTimeElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.NotificationTimeElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.NotificationTimeElectionNotificationTimeElectionChoice;
import cdm.legaldocumentation.csa.validation.exists.NotificationTimeElectionOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=NotificationTimeElection.class)
public class NotificationTimeElectionMeta implements RosettaMetaData<NotificationTimeElection> {

	@Override
	public List<Validator<? super NotificationTimeElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NotificationTimeElection>create(NotificationTimeElectionNotificationTimeElectionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NotificationTimeElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotificationTimeElection> validator(ValidatorFactory factory) {
		return factory.<NotificationTimeElection>create(NotificationTimeElectionValidator.class);
	}

	@Override
	public Validator<? super NotificationTimeElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotificationTimeElection>create(NotificationTimeElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotificationTimeElection> validator() {
		return new NotificationTimeElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotificationTimeElection> typeFormatValidator() {
		return new NotificationTimeElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotificationTimeElection, Set<String>> onlyExistsValidator() {
		return new NotificationTimeElectionOnlyExistsValidator();
	}
}
