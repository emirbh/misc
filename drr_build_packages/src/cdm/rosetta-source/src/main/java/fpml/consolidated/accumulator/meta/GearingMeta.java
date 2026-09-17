package fpml.consolidated.accumulator.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.Gearing;
import fpml.consolidated.accumulator.validation.GearingTypeFormatValidator;
import fpml.consolidated.accumulator.validation.GearingValidator;
import fpml.consolidated.accumulator.validation.exists.GearingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Gearing.class)
public class GearingMeta implements RosettaMetaData<Gearing> {

	@Override
	public List<Validator<? super Gearing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Gearing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Gearing> validator(ValidatorFactory factory) {
		return factory.<Gearing>create(GearingValidator.class);
	}

	@Override
	public Validator<? super Gearing> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Gearing>create(GearingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Gearing> validator() {
		return new GearingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Gearing> typeFormatValidator() {
		return new GearingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Gearing, Set<String>> onlyExistsValidator() {
		return new GearingOnlyExistsValidator();
	}
}
