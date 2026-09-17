package cdm.observable.asset.fro.meta;

import cdm.base.datetime.Period;
import cdm.base.datetime.validation.datarule.PeriodDayPeriod;
import cdm.observable.asset.fro.BusinessDayOffset;
import cdm.observable.asset.fro.validation.BusinessDayOffsetTypeFormatValidator;
import cdm.observable.asset.fro.validation.BusinessDayOffsetValidator;
import cdm.observable.asset.fro.validation.exists.BusinessDayOffsetOnlyExistsValidator;
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
@RosettaMeta(model=BusinessDayOffset.class)
public class BusinessDayOffsetMeta implements RosettaMetaData<BusinessDayOffset> {

	@Override
	public List<Validator<? super BusinessDayOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Period>create(PeriodDayPeriod.class)
		);
	}
	
	@Override
	public List<Function<? super BusinessDayOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessDayOffset> validator(ValidatorFactory factory) {
		return factory.<BusinessDayOffset>create(BusinessDayOffsetValidator.class);
	}

	@Override
	public Validator<? super BusinessDayOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessDayOffset>create(BusinessDayOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDayOffset> validator() {
		return new BusinessDayOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDayOffset> typeFormatValidator() {
		return new BusinessDayOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDayOffset, Set<String>> onlyExistsValidator() {
		return new BusinessDayOffsetOnlyExistsValidator();
	}
}
