package cdm.observable.asset.fro.meta;

import cdm.base.datetime.Period;
import cdm.base.datetime.validation.datarule.PeriodDayPeriod;
import cdm.observable.asset.fro.FloatingRateIndexFixingOffset;
import cdm.observable.asset.fro.validation.FloatingRateIndexFixingOffsetTypeFormatValidator;
import cdm.observable.asset.fro.validation.FloatingRateIndexFixingOffsetValidator;
import cdm.observable.asset.fro.validation.exists.FloatingRateIndexFixingOffsetOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=FloatingRateIndexFixingOffset.class)
public class FloatingRateIndexFixingOffsetMeta implements RosettaMetaData<FloatingRateIndexFixingOffset> {

	@Override
	public List<Validator<? super FloatingRateIndexFixingOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Period>create(PeriodDayPeriod.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexFixingOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndexFixingOffset> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexFixingOffset>create(FloatingRateIndexFixingOffsetValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndexFixingOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexFixingOffset>create(FloatingRateIndexFixingOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexFixingOffset> validator() {
		return new FloatingRateIndexFixingOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexFixingOffset> typeFormatValidator() {
		return new FloatingRateIndexFixingOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexFixingOffset, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexFixingOffsetOnlyExistsValidator();
	}
}
