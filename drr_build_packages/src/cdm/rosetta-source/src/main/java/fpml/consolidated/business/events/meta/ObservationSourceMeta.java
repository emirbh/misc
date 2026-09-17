package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ObservationSource;
import fpml.consolidated.business.events.validation.ObservationSourceTypeFormatValidator;
import fpml.consolidated.business.events.validation.ObservationSourceValidator;
import fpml.consolidated.business.events.validation.exists.ObservationSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservationSource.class)
public class ObservationSourceMeta implements RosettaMetaData<ObservationSource> {

	@Override
	public List<Validator<? super ObservationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationSource> validator(ValidatorFactory factory) {
		return factory.<ObservationSource>create(ObservationSourceValidator.class);
	}

	@Override
	public Validator<? super ObservationSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservationSource>create(ObservationSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservationSource> validator() {
		return new ObservationSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservationSource> typeFormatValidator() {
		return new ObservationSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationSource, Set<String>> onlyExistsValidator() {
		return new ObservationSourceOnlyExistsValidator();
	}
}
