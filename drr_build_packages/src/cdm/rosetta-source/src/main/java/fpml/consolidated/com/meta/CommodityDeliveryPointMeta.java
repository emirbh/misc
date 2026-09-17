package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.validation.CommodityDeliveryPointTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityDeliveryPointValidator;
import fpml.consolidated.com.validation.exists.CommodityDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDeliveryPoint.class)
public class CommodityDeliveryPointMeta implements RosettaMetaData<CommodityDeliveryPoint> {

	@Override
	public List<Validator<? super CommodityDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDeliveryPoint> validator(ValidatorFactory factory) {
		return factory.<CommodityDeliveryPoint>create(CommodityDeliveryPointValidator.class);
	}

	@Override
	public Validator<? super CommodityDeliveryPoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDeliveryPoint>create(CommodityDeliveryPointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDeliveryPoint> validator() {
		return new CommodityDeliveryPointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDeliveryPoint> typeFormatValidator() {
		return new CommodityDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPointOnlyExistsValidator();
	}
}
