package cdm.margin.schedule.meta;

import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.margin.schedule.validation.StandardizedScheduleTradeInfoTypeFormatValidator;
import cdm.margin.schedule.validation.StandardizedScheduleTradeInfoValidator;
import cdm.margin.schedule.validation.datarule.StandardizedScheduleTradeInfoPositiveGrossInitialMargin;
import cdm.margin.schedule.validation.datarule.StandardizedScheduleTradeInfoSameCurrencies;
import cdm.margin.schedule.validation.exists.StandardizedScheduleTradeInfoOnlyExistsValidator;
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
@RosettaMeta(model=StandardizedScheduleTradeInfo.class)
public class StandardizedScheduleTradeInfoMeta implements RosettaMetaData<StandardizedScheduleTradeInfo> {

	@Override
	public List<Validator<? super StandardizedScheduleTradeInfo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<StandardizedScheduleTradeInfo>create(StandardizedScheduleTradeInfoPositiveGrossInitialMargin.class),
			factory.<StandardizedScheduleTradeInfo>create(StandardizedScheduleTradeInfoSameCurrencies.class)
		);
	}
	
	@Override
	public List<Function<? super StandardizedScheduleTradeInfo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StandardizedScheduleTradeInfo> validator(ValidatorFactory factory) {
		return factory.<StandardizedScheduleTradeInfo>create(StandardizedScheduleTradeInfoValidator.class);
	}

	@Override
	public Validator<? super StandardizedScheduleTradeInfo> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StandardizedScheduleTradeInfo>create(StandardizedScheduleTradeInfoTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StandardizedScheduleTradeInfo> validator() {
		return new StandardizedScheduleTradeInfoValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StandardizedScheduleTradeInfo> typeFormatValidator() {
		return new StandardizedScheduleTradeInfoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StandardizedScheduleTradeInfo, Set<String>> onlyExistsValidator() {
		return new StandardizedScheduleTradeInfoOnlyExistsValidator();
	}
}
