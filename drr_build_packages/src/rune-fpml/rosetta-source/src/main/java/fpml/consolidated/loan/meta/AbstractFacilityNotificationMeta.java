package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacilityNotification;
import fpml.consolidated.loan.validation.AbstractFacilityNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractFacilityNotificationValidator;
import fpml.consolidated.loan.validation.exists.AbstractFacilityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractFacilityNotification.class)
public class AbstractFacilityNotificationMeta implements RosettaMetaData<AbstractFacilityNotification> {

	@Override
	public List<Validator<? super AbstractFacilityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacilityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractFacilityNotification> validator(ValidatorFactory factory) {
		return factory.<AbstractFacilityNotification>create(AbstractFacilityNotificationValidator.class);
	}

	@Override
	public Validator<? super AbstractFacilityNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractFacilityNotification>create(AbstractFacilityNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityNotification> validator() {
		return new AbstractFacilityNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityNotification> typeFormatValidator() {
		return new AbstractFacilityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacilityNotification, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityNotificationOnlyExistsValidator();
	}
}
