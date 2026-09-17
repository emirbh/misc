package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ObservationFrequency;
import fpml.consolidated.shared.validation.ObservationFrequencyTypeFormatValidator;
import fpml.consolidated.shared.validation.ObservationFrequencyValidator;
import fpml.consolidated.shared.validation.exists.ObservationFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservationFrequency.class)
public class ObservationFrequencyMeta implements RosettaMetaData<ObservationFrequency> {

	@Override
	public List<Validator<? super ObservationFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationFrequency> validator(ValidatorFactory factory) {
		return factory.<ObservationFrequency>create(ObservationFrequencyValidator.class);
	}

	@Override
	public Validator<? super ObservationFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservationFrequency>create(ObservationFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservationFrequency> validator() {
		return new ObservationFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservationFrequency> typeFormatValidator() {
		return new ObservationFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationFrequency, Set<String>> onlyExistsValidator() {
		return new ObservationFrequencyOnlyExistsValidator();
	}
}
