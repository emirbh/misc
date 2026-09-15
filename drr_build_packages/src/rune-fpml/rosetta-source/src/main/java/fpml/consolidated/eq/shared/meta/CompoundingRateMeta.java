package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.CompoundingRate;
import fpml.consolidated.eq.shared.validation.CompoundingRateTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.CompoundingRateValidator;
import fpml.consolidated.eq.shared.validation.datarule.CompoundingRateChoice;
import fpml.consolidated.eq.shared.validation.exists.CompoundingRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CompoundingRate.class)
public class CompoundingRateMeta implements RosettaMetaData<CompoundingRate> {

	@Override
	public List<Validator<? super CompoundingRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CompoundingRate>create(CompoundingRateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CompoundingRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CompoundingRate> validator(ValidatorFactory factory) {
		return factory.<CompoundingRate>create(CompoundingRateValidator.class);
	}

	@Override
	public Validator<? super CompoundingRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CompoundingRate>create(CompoundingRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CompoundingRate> validator() {
		return new CompoundingRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CompoundingRate> typeFormatValidator() {
		return new CompoundingRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompoundingRate, Set<String>> onlyExistsValidator() {
		return new CompoundingRateOnlyExistsValidator();
	}
}
