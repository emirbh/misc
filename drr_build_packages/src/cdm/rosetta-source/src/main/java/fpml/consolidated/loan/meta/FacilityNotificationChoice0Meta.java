package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityNotificationChoice0;
import fpml.consolidated.loan.validation.FacilityNotificationChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityNotificationChoice0Validator;
import fpml.consolidated.loan.validation.datarule.FacilityNotificationChoice0Choice;
import fpml.consolidated.loan.validation.exists.FacilityNotificationChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityNotificationChoice0.class)
public class FacilityNotificationChoice0Meta implements RosettaMetaData<FacilityNotificationChoice0> {

	@Override
	public List<Validator<? super FacilityNotificationChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityNotificationChoice0>create(FacilityNotificationChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityNotificationChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityNotificationChoice0> validator(ValidatorFactory factory) {
		return factory.<FacilityNotificationChoice0>create(FacilityNotificationChoice0Validator.class);
	}

	@Override
	public Validator<? super FacilityNotificationChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityNotificationChoice0>create(FacilityNotificationChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityNotificationChoice0> validator() {
		return new FacilityNotificationChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityNotificationChoice0> typeFormatValidator() {
		return new FacilityNotificationChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityNotificationChoice0, Set<String>> onlyExistsValidator() {
		return new FacilityNotificationChoice0OnlyExistsValidator();
	}
}
