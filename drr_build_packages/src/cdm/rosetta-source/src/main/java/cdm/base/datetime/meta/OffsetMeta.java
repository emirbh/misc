package cdm.base.datetime.meta;

import cdm.base.datetime.Offset;
import cdm.base.datetime.Period;
import cdm.base.datetime.validation.OffsetTypeFormatValidator;
import cdm.base.datetime.validation.OffsetValidator;
import cdm.base.datetime.validation.datarule.OffsetDayType;
import cdm.base.datetime.validation.datarule.PeriodDayPeriod;
import cdm.base.datetime.validation.exists.OffsetOnlyExistsValidator;
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
@RosettaMeta(model=Offset.class)
public class OffsetMeta implements RosettaMetaData<Offset> {

	@Override
	public List<Validator<? super Offset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Period>create(PeriodDayPeriod.class),
			factory.<Offset>create(OffsetDayType.class)
		);
	}
	
	@Override
	public List<Function<? super Offset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Offset> validator(ValidatorFactory factory) {
		return factory.<Offset>create(OffsetValidator.class);
	}

	@Override
	public Validator<? super Offset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Offset>create(OffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Offset> validator() {
		return new OffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Offset> typeFormatValidator() {
		return new OffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Offset, Set<String>> onlyExistsValidator() {
		return new OffsetOnlyExistsValidator();
	}
}
