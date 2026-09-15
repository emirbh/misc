package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.CreditEventNotificationRetracted;
import fpml.consolidated.credit.event.notification.validation.CreditEventNotificationRetractedTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.CreditEventNotificationRetractedValidator;
import fpml.consolidated.credit.event.notification.validation.exists.CreditEventNotificationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEventNotificationRetracted.class)
public class CreditEventNotificationRetractedMeta implements RosettaMetaData<CreditEventNotificationRetracted> {

	@Override
	public List<Validator<? super CreditEventNotificationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventNotificationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEventNotificationRetracted> validator(ValidatorFactory factory) {
		return factory.<CreditEventNotificationRetracted>create(CreditEventNotificationRetractedValidator.class);
	}

	@Override
	public Validator<? super CreditEventNotificationRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEventNotificationRetracted>create(CreditEventNotificationRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNotificationRetracted> validator() {
		return new CreditEventNotificationRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNotificationRetracted> typeFormatValidator() {
		return new CreditEventNotificationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventNotificationRetracted, Set<String>> onlyExistsValidator() {
		return new CreditEventNotificationRetractedOnlyExistsValidator();
	}
}
