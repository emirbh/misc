package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityTermination;
import fpml.consolidated.loan.validation.FacilityTerminationTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityTerminationValidator;
import fpml.consolidated.loan.validation.exists.FacilityTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityTermination.class)
public class FacilityTerminationMeta implements RosettaMetaData<FacilityTermination> {

	@Override
	public List<Validator<? super FacilityTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityTermination> validator(ValidatorFactory factory) {
		return factory.<FacilityTermination>create(FacilityTerminationValidator.class);
	}

	@Override
	public Validator<? super FacilityTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityTermination>create(FacilityTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityTermination> validator() {
		return new FacilityTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityTermination> typeFormatValidator() {
		return new FacilityTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityTermination, Set<String>> onlyExistsValidator() {
		return new FacilityTerminationOnlyExistsValidator();
	}
}
