package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ExtendibleProvisionAdjustedDates;
import fpml.consolidated.ird.validation.ExtendibleProvisionAdjustedDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.ExtendibleProvisionAdjustedDatesValidator;
import fpml.consolidated.ird.validation.exists.ExtendibleProvisionAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExtendibleProvisionAdjustedDates.class)
public class ExtendibleProvisionAdjustedDatesMeta implements RosettaMetaData<ExtendibleProvisionAdjustedDates> {

	@Override
	public List<Validator<? super ExtendibleProvisionAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExtendibleProvisionAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExtendibleProvisionAdjustedDates> validator(ValidatorFactory factory) {
		return factory.<ExtendibleProvisionAdjustedDates>create(ExtendibleProvisionAdjustedDatesValidator.class);
	}

	@Override
	public Validator<? super ExtendibleProvisionAdjustedDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExtendibleProvisionAdjustedDates>create(ExtendibleProvisionAdjustedDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExtendibleProvisionAdjustedDates> validator() {
		return new ExtendibleProvisionAdjustedDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExtendibleProvisionAdjustedDates> typeFormatValidator() {
		return new ExtendibleProvisionAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtendibleProvisionAdjustedDates, Set<String>> onlyExistsValidator() {
		return new ExtendibleProvisionAdjustedDatesOnlyExistsValidator();
	}
}
