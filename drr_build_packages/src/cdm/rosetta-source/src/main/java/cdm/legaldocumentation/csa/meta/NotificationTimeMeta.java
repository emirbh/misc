package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.NotificationTime;
import cdm.legaldocumentation.csa.validation.NotificationTimeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.NotificationTimeValidator;
import cdm.legaldocumentation.csa.validation.exists.NotificationTimeOnlyExistsValidator;
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
@RosettaMeta(model=NotificationTime.class)
public class NotificationTimeMeta implements RosettaMetaData<NotificationTime> {

	@Override
	public List<Validator<? super NotificationTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotificationTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotificationTime> validator(ValidatorFactory factory) {
		return factory.<NotificationTime>create(NotificationTimeValidator.class);
	}

	@Override
	public Validator<? super NotificationTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotificationTime>create(NotificationTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotificationTime> validator() {
		return new NotificationTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotificationTime> typeFormatValidator() {
		return new NotificationTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotificationTime, Set<String>> onlyExistsValidator() {
		return new NotificationTimeOnlyExistsValidator();
	}
}
