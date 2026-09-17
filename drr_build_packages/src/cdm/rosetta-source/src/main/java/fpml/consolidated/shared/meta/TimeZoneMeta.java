package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.TimeZone;
import fpml.consolidated.shared.validation.TimeZoneTypeFormatValidator;
import fpml.consolidated.shared.validation.TimeZoneValidator;
import fpml.consolidated.shared.validation.exists.TimeZoneOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TimeZone.class)
public class TimeZoneMeta implements RosettaMetaData<TimeZone> {

	@Override
	public List<Validator<? super TimeZone>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimeZone, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TimeZone> validator(ValidatorFactory factory) {
		return factory.<TimeZone>create(TimeZoneValidator.class);
	}

	@Override
	public Validator<? super TimeZone> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TimeZone>create(TimeZoneTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TimeZone> validator() {
		return new TimeZoneValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TimeZone> typeFormatValidator() {
		return new TimeZoneTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimeZone, Set<String>> onlyExistsValidator() {
		return new TimeZoneOnlyExistsValidator();
	}
}
