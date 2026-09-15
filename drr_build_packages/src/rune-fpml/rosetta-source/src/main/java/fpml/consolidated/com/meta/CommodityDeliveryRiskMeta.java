package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryRisk;
import fpml.consolidated.com.validation.CommodityDeliveryRiskTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityDeliveryRiskValidator;
import fpml.consolidated.com.validation.exists.CommodityDeliveryRiskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDeliveryRisk.class)
public class CommodityDeliveryRiskMeta implements RosettaMetaData<CommodityDeliveryRisk> {

	@Override
	public List<Validator<? super CommodityDeliveryRisk>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryRisk, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDeliveryRisk> validator(ValidatorFactory factory) {
		return factory.<CommodityDeliveryRisk>create(CommodityDeliveryRiskValidator.class);
	}

	@Override
	public Validator<? super CommodityDeliveryRisk> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDeliveryRisk>create(CommodityDeliveryRiskTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDeliveryRisk> validator() {
		return new CommodityDeliveryRiskValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDeliveryRisk> typeFormatValidator() {
		return new CommodityDeliveryRiskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryRisk, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryRiskOnlyExistsValidator();
	}
}
