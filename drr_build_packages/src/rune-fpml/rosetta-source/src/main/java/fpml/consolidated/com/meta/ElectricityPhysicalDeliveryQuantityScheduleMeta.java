package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.consolidated.com.validation.ElectricityPhysicalDeliveryQuantityScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityPhysicalDeliveryQuantityScheduleValidator;
import fpml.consolidated.com.validation.datarule.CommodityPhysicalQuantityScheduleChoice;
import fpml.consolidated.com.validation.exists.ElectricityPhysicalDeliveryQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityPhysicalDeliveryQuantitySchedule.class)
public class ElectricityPhysicalDeliveryQuantityScheduleMeta implements RosettaMetaData<ElectricityPhysicalDeliveryQuantitySchedule> {

	@Override
	public List<Validator<? super ElectricityPhysicalDeliveryQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPhysicalQuantitySchedule>create(CommodityPhysicalQuantityScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalDeliveryQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantitySchedule> validator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalDeliveryQuantitySchedule>create(ElectricityPhysicalDeliveryQuantityScheduleValidator.class);
	}

	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantitySchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalDeliveryQuantitySchedule>create(ElectricityPhysicalDeliveryQuantityScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantitySchedule> validator() {
		return new ElectricityPhysicalDeliveryQuantityScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantitySchedule> typeFormatValidator() {
		return new ElectricityPhysicalDeliveryQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalDeliveryQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalDeliveryQuantityScheduleOnlyExistsValidator();
	}
}
