package cdm.product.common.settlement.meta;

import cdm.base.datetime.Offset;
import cdm.base.datetime.Period;
import cdm.base.datetime.validation.datarule.OffsetDayType;
import cdm.base.datetime.validation.datarule.PeriodDayPeriod;
import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.validation.FxFixingDateTypeFormatValidator;
import cdm.product.common.settlement.validation.FxFixingDateValidator;
import cdm.product.common.settlement.validation.datarule.FxFixingDateBusinessCentersChoice;
import cdm.product.common.settlement.validation.datarule.FxFixingDateDateChoice;
import cdm.product.common.settlement.validation.exists.FxFixingDateOnlyExistsValidator;
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
@RosettaMeta(model=FxFixingDate.class)
public class FxFixingDateMeta implements RosettaMetaData<FxFixingDate> {

	@Override
	public List<Validator<? super FxFixingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Period>create(PeriodDayPeriod.class),
			factory.<Offset>create(OffsetDayType.class),
			factory.<FxFixingDate>create(FxFixingDateBusinessCentersChoice.class),
			factory.<FxFixingDate>create(FxFixingDateDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFixingDate> validator(ValidatorFactory factory) {
		return factory.<FxFixingDate>create(FxFixingDateValidator.class);
	}

	@Override
	public Validator<? super FxFixingDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFixingDate>create(FxFixingDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingDate> validator() {
		return new FxFixingDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingDate> typeFormatValidator() {
		return new FxFixingDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingDate, Set<String>> onlyExistsValidator() {
		return new FxFixingDateOnlyExistsValidator();
	}
}
