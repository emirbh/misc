package cdm.base.datetime.meta;

import cdm.base.datetime.Offset;
import cdm.base.datetime.Period;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.validation.RelativeDateOffsetTypeFormatValidator;
import cdm.base.datetime.validation.RelativeDateOffsetValidator;
import cdm.base.datetime.validation.datarule.OffsetDayType;
import cdm.base.datetime.validation.datarule.PeriodDayPeriod;
import cdm.base.datetime.validation.exists.RelativeDateOffsetOnlyExistsValidator;
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
@RosettaMeta(model=RelativeDateOffset.class)
public class RelativeDateOffsetMeta implements RosettaMetaData<RelativeDateOffset> {

	@Override
	public List<Validator<? super RelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Period>create(PeriodDayPeriod.class),
			factory.<Offset>create(OffsetDayType.class)
		);
	}
	
	@Override
	public List<Function<? super RelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativeDateOffset> validator(ValidatorFactory factory) {
		return factory.<RelativeDateOffset>create(RelativeDateOffsetValidator.class);
	}

	@Override
	public Validator<? super RelativeDateOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelativeDateOffset>create(RelativeDateOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDateOffset> validator() {
		return new RelativeDateOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDateOffset> typeFormatValidator() {
		return new RelativeDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new RelativeDateOffsetOnlyExistsValidator();
	}
}
