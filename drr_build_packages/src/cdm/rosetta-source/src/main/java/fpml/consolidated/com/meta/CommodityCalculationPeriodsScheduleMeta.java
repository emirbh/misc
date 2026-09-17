package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.validation.CommodityCalculationPeriodsScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityCalculationPeriodsScheduleValidator;
import fpml.consolidated.com.validation.exists.CommodityCalculationPeriodsScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityCalculationPeriodsSchedule.class)
public class CommodityCalculationPeriodsScheduleMeta implements RosettaMetaData<CommodityCalculationPeriodsSchedule> {

	@Override
	public List<Validator<? super CommodityCalculationPeriodsSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityCalculationPeriodsSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityCalculationPeriodsSchedule> validator(ValidatorFactory factory) {
		return factory.<CommodityCalculationPeriodsSchedule>create(CommodityCalculationPeriodsScheduleValidator.class);
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityCalculationPeriodsSchedule>create(CommodityCalculationPeriodsScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityCalculationPeriodsSchedule> validator() {
		return new CommodityCalculationPeriodsScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityCalculationPeriodsSchedule> typeFormatValidator() {
		return new CommodityCalculationPeriodsScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCalculationPeriodsSchedule, Set<String>> onlyExistsValidator() {
		return new CommodityCalculationPeriodsScheduleOnlyExistsValidator();
	}
}
