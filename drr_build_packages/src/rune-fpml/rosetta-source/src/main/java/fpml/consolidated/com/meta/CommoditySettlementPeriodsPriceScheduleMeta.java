package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommoditySettlementPeriodsPriceSchedule;
import fpml.consolidated.com.validation.CommoditySettlementPeriodsPriceScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommoditySettlementPeriodsPriceScheduleValidator;
import fpml.consolidated.com.validation.exists.CommoditySettlementPeriodsPriceScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommoditySettlementPeriodsPriceSchedule.class)
public class CommoditySettlementPeriodsPriceScheduleMeta implements RosettaMetaData<CommoditySettlementPeriodsPriceSchedule> {

	@Override
	public List<Validator<? super CommoditySettlementPeriodsPriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySettlementPeriodsPriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommoditySettlementPeriodsPriceSchedule> validator(ValidatorFactory factory) {
		return factory.<CommoditySettlementPeriodsPriceSchedule>create(CommoditySettlementPeriodsPriceScheduleValidator.class);
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsPriceSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommoditySettlementPeriodsPriceSchedule>create(CommoditySettlementPeriodsPriceScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySettlementPeriodsPriceSchedule> validator() {
		return new CommoditySettlementPeriodsPriceScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySettlementPeriodsPriceSchedule> typeFormatValidator() {
		return new CommoditySettlementPeriodsPriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySettlementPeriodsPriceSchedule, Set<String>> onlyExistsValidator() {
		return new CommoditySettlementPeriodsPriceScheduleOnlyExistsValidator();
	}
}
