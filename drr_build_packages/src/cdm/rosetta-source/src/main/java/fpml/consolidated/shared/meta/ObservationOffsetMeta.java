package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ObservationOffset;
import fpml.consolidated.shared.validation.ObservationOffsetTypeFormatValidator;
import fpml.consolidated.shared.validation.ObservationOffsetValidator;
import fpml.consolidated.shared.validation.exists.ObservationOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservationOffset.class)
public class ObservationOffsetMeta implements RosettaMetaData<ObservationOffset> {

	@Override
	public List<Validator<? super ObservationOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationOffset> validator(ValidatorFactory factory) {
		return factory.<ObservationOffset>create(ObservationOffsetValidator.class);
	}

	@Override
	public Validator<? super ObservationOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservationOffset>create(ObservationOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservationOffset> validator() {
		return new ObservationOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservationOffset> typeFormatValidator() {
		return new ObservationOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationOffset, Set<String>> onlyExistsValidator() {
		return new ObservationOffsetOnlyExistsValidator();
	}
}
