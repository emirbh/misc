package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.validation.CommodityPhysicalQuantityScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPhysicalQuantityScheduleValidator;
import fpml.consolidated.com.validation.datarule.CommodityPhysicalQuantityScheduleChoice;
import fpml.consolidated.com.validation.exists.CommodityPhysicalQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPhysicalQuantitySchedule.class)
public class CommodityPhysicalQuantityScheduleMeta implements RosettaMetaData<CommodityPhysicalQuantitySchedule> {

	@Override
	public List<Validator<? super CommodityPhysicalQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPhysicalQuantitySchedule>create(CommodityPhysicalQuantityScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPhysicalQuantitySchedule> validator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalQuantitySchedule>create(CommodityPhysicalQuantityScheduleValidator.class);
	}

	@Override
	public Validator<? super CommodityPhysicalQuantitySchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalQuantitySchedule>create(CommodityPhysicalQuantityScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalQuantitySchedule> validator() {
		return new CommodityPhysicalQuantityScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalQuantitySchedule> typeFormatValidator() {
		return new CommodityPhysicalQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalQuantityScheduleOnlyExistsValidator();
	}
}
