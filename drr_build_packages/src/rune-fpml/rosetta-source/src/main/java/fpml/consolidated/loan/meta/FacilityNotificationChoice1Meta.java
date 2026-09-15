package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityNotificationChoice1;
import fpml.consolidated.loan.validation.FacilityNotificationChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityNotificationChoice1Validator;
import fpml.consolidated.loan.validation.datarule.FacilityNotificationChoice1Choice;
import fpml.consolidated.loan.validation.exists.FacilityNotificationChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityNotificationChoice1.class)
public class FacilityNotificationChoice1Meta implements RosettaMetaData<FacilityNotificationChoice1> {

	@Override
	public List<Validator<? super FacilityNotificationChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityNotificationChoice1>create(FacilityNotificationChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityNotificationChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityNotificationChoice1> validator(ValidatorFactory factory) {
		return factory.<FacilityNotificationChoice1>create(FacilityNotificationChoice1Validator.class);
	}

	@Override
	public Validator<? super FacilityNotificationChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityNotificationChoice1>create(FacilityNotificationChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityNotificationChoice1> validator() {
		return new FacilityNotificationChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityNotificationChoice1> typeFormatValidator() {
		return new FacilityNotificationChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityNotificationChoice1, Set<String>> onlyExistsValidator() {
		return new FacilityNotificationChoice1OnlyExistsValidator();
	}
}
