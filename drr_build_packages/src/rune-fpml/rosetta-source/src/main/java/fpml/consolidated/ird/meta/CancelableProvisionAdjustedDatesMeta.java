package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CancelableProvisionAdjustedDates;
import fpml.consolidated.ird.validation.CancelableProvisionAdjustedDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.CancelableProvisionAdjustedDatesValidator;
import fpml.consolidated.ird.validation.exists.CancelableProvisionAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CancelableProvisionAdjustedDates.class)
public class CancelableProvisionAdjustedDatesMeta implements RosettaMetaData<CancelableProvisionAdjustedDates> {

	@Override
	public List<Validator<? super CancelableProvisionAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CancelableProvisionAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CancelableProvisionAdjustedDates> validator(ValidatorFactory factory) {
		return factory.<CancelableProvisionAdjustedDates>create(CancelableProvisionAdjustedDatesValidator.class);
	}

	@Override
	public Validator<? super CancelableProvisionAdjustedDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CancelableProvisionAdjustedDates>create(CancelableProvisionAdjustedDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CancelableProvisionAdjustedDates> validator() {
		return new CancelableProvisionAdjustedDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CancelableProvisionAdjustedDates> typeFormatValidator() {
		return new CancelableProvisionAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CancelableProvisionAdjustedDates, Set<String>> onlyExistsValidator() {
		return new CancelableProvisionAdjustedDatesOnlyExistsValidator();
	}
}
