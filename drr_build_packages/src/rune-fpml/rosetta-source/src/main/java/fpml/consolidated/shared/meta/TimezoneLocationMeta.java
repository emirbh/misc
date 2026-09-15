package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.TimezoneLocation;
import fpml.consolidated.shared.validation.TimezoneLocationTypeFormatValidator;
import fpml.consolidated.shared.validation.TimezoneLocationValidator;
import fpml.consolidated.shared.validation.exists.TimezoneLocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TimezoneLocation.class)
public class TimezoneLocationMeta implements RosettaMetaData<TimezoneLocation> {

	@Override
	public List<Validator<? super TimezoneLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimezoneLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TimezoneLocation> validator(ValidatorFactory factory) {
		return factory.<TimezoneLocation>create(TimezoneLocationValidator.class);
	}

	@Override
	public Validator<? super TimezoneLocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TimezoneLocation>create(TimezoneLocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TimezoneLocation> validator() {
		return new TimezoneLocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TimezoneLocation> typeFormatValidator() {
		return new TimezoneLocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimezoneLocation, Set<String>> onlyExistsValidator() {
		return new TimezoneLocationOnlyExistsValidator();
	}
}
