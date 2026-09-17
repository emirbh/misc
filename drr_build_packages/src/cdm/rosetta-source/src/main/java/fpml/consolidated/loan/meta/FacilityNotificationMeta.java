package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityNotification;
import fpml.consolidated.loan.validation.FacilityNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityNotificationValidator;
import fpml.consolidated.loan.validation.datarule.FacilityNotificationChoice0;
import fpml.consolidated.loan.validation.datarule.FacilityNotificationChoice1;
import fpml.consolidated.loan.validation.exists.FacilityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityNotification.class)
public class FacilityNotificationMeta implements RosettaMetaData<FacilityNotification> {

	@Override
	public List<Validator<? super FacilityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityNotification>create(FacilityNotificationChoice0.class),
			factory.<FacilityNotification>create(FacilityNotificationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityNotification> validator(ValidatorFactory factory) {
		return factory.<FacilityNotification>create(FacilityNotificationValidator.class);
	}

	@Override
	public Validator<? super FacilityNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityNotification>create(FacilityNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityNotification> validator() {
		return new FacilityNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityNotification> typeFormatValidator() {
		return new FacilityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityNotification, Set<String>> onlyExistsValidator() {
		return new FacilityNotificationOnlyExistsValidator();
	}
}
