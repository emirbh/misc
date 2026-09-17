package cdm.base.datetime.meta;

import cdm.base.datetime.Offset;
import cdm.base.datetime.Period;
import cdm.base.datetime.RelativeDates;
import cdm.base.datetime.validation.RelativeDatesTypeFormatValidator;
import cdm.base.datetime.validation.RelativeDatesValidator;
import cdm.base.datetime.validation.datarule.OffsetDayType;
import cdm.base.datetime.validation.datarule.PeriodDayPeriod;
import cdm.base.datetime.validation.datarule.RelativeDatesPeriodSkipGreaterThanOne;
import cdm.base.datetime.validation.exists.RelativeDatesOnlyExistsValidator;
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
@RosettaMeta(model=RelativeDates.class)
public class RelativeDatesMeta implements RosettaMetaData<RelativeDates> {

	@Override
	public List<Validator<? super RelativeDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Period>create(PeriodDayPeriod.class),
			factory.<Offset>create(OffsetDayType.class),
			factory.<RelativeDates>create(RelativeDatesPeriodSkipGreaterThanOne.class)
		);
	}
	
	@Override
	public List<Function<? super RelativeDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativeDates> validator(ValidatorFactory factory) {
		return factory.<RelativeDates>create(RelativeDatesValidator.class);
	}

	@Override
	public Validator<? super RelativeDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelativeDates>create(RelativeDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDates> validator() {
		return new RelativeDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDates> typeFormatValidator() {
		return new RelativeDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDates, Set<String>> onlyExistsValidator() {
		return new RelativeDatesOnlyExistsValidator();
	}
}
