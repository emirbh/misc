package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.TimeDimension;
import fpml.consolidated.riskdef.validation.TimeDimensionTypeFormatValidator;
import fpml.consolidated.riskdef.validation.TimeDimensionValidator;
import fpml.consolidated.riskdef.validation.exists.TimeDimensionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TimeDimension.class)
public class TimeDimensionMeta implements RosettaMetaData<TimeDimension> {

	@Override
	public List<Validator<? super TimeDimension>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimeDimension, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TimeDimension> validator(ValidatorFactory factory) {
		return factory.<TimeDimension>create(TimeDimensionValidator.class);
	}

	@Override
	public Validator<? super TimeDimension> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TimeDimension>create(TimeDimensionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TimeDimension> validator() {
		return new TimeDimensionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TimeDimension> typeFormatValidator() {
		return new TimeDimensionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimeDimension, Set<String>> onlyExistsValidator() {
		return new TimeDimensionOnlyExistsValidator();
	}
}
