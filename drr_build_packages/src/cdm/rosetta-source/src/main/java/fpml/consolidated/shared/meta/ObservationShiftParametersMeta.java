package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ObservationShiftParameters;
import fpml.consolidated.shared.validation.ObservationShiftParametersTypeFormatValidator;
import fpml.consolidated.shared.validation.ObservationShiftParametersValidator;
import fpml.consolidated.shared.validation.exists.ObservationShiftParametersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservationShiftParameters.class)
public class ObservationShiftParametersMeta implements RosettaMetaData<ObservationShiftParameters> {

	@Override
	public List<Validator<? super ObservationShiftParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationShiftParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationShiftParameters> validator(ValidatorFactory factory) {
		return factory.<ObservationShiftParameters>create(ObservationShiftParametersValidator.class);
	}

	@Override
	public Validator<? super ObservationShiftParameters> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservationShiftParameters>create(ObservationShiftParametersTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservationShiftParameters> validator() {
		return new ObservationShiftParametersValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservationShiftParameters> typeFormatValidator() {
		return new ObservationShiftParametersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationShiftParameters, Set<String>> onlyExistsValidator() {
		return new ObservationShiftParametersOnlyExistsValidator();
	}
}
