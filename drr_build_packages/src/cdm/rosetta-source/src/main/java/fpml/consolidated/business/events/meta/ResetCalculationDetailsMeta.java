package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ResetCalculationDetails;
import fpml.consolidated.business.events.validation.ResetCalculationDetailsTypeFormatValidator;
import fpml.consolidated.business.events.validation.ResetCalculationDetailsValidator;
import fpml.consolidated.business.events.validation.exists.ResetCalculationDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResetCalculationDetails.class)
public class ResetCalculationDetailsMeta implements RosettaMetaData<ResetCalculationDetails> {

	@Override
	public List<Validator<? super ResetCalculationDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetCalculationDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetCalculationDetails> validator(ValidatorFactory factory) {
		return factory.<ResetCalculationDetails>create(ResetCalculationDetailsValidator.class);
	}

	@Override
	public Validator<? super ResetCalculationDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetCalculationDetails>create(ResetCalculationDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetCalculationDetails> validator() {
		return new ResetCalculationDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetCalculationDetails> typeFormatValidator() {
		return new ResetCalculationDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetCalculationDetails, Set<String>> onlyExistsValidator() {
		return new ResetCalculationDetailsOnlyExistsValidator();
	}
}
