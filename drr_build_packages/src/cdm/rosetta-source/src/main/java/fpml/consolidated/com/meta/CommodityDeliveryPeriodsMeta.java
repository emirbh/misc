package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.com.validation.CommodityDeliveryPeriodsTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityDeliveryPeriodsValidator;
import fpml.consolidated.com.validation.datarule.CommodityDeliveryPeriodsChoice;
import fpml.consolidated.com.validation.exists.CommodityDeliveryPeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDeliveryPeriods.class)
public class CommodityDeliveryPeriodsMeta implements RosettaMetaData<CommodityDeliveryPeriods> {

	@Override
	public List<Validator<? super CommodityDeliveryPeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityDeliveryPeriods>create(CommodityDeliveryPeriodsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDeliveryPeriods> validator(ValidatorFactory factory) {
		return factory.<CommodityDeliveryPeriods>create(CommodityDeliveryPeriodsValidator.class);
	}

	@Override
	public Validator<? super CommodityDeliveryPeriods> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDeliveryPeriods>create(CommodityDeliveryPeriodsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDeliveryPeriods> validator() {
		return new CommodityDeliveryPeriodsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDeliveryPeriods> typeFormatValidator() {
		return new CommodityDeliveryPeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPeriods, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPeriodsOnlyExistsValidator();
	}
}
