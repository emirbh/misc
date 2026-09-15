package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalQuantity;
import fpml.consolidated.com.validation.CommodityPhysicalQuantityTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPhysicalQuantityValidator;
import fpml.consolidated.com.validation.datarule.CommodityPhysicalQuantityChoice;
import fpml.consolidated.com.validation.exists.CommodityPhysicalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPhysicalQuantity.class)
public class CommodityPhysicalQuantityMeta implements RosettaMetaData<CommodityPhysicalQuantity> {

	@Override
	public List<Validator<? super CommodityPhysicalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPhysicalQuantity>create(CommodityPhysicalQuantityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPhysicalQuantity> validator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalQuantity>create(CommodityPhysicalQuantityValidator.class);
	}

	@Override
	public Validator<? super CommodityPhysicalQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalQuantity>create(CommodityPhysicalQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalQuantity> validator() {
		return new CommodityPhysicalQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalQuantity> typeFormatValidator() {
		return new CommodityPhysicalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalQuantity, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalQuantityOnlyExistsValidator();
	}
}
