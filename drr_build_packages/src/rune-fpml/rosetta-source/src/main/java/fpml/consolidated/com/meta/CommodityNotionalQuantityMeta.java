package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.validation.CommodityNotionalQuantityTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityNotionalQuantityValidator;
import fpml.consolidated.com.validation.exists.CommodityNotionalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityNotionalQuantity.class)
public class CommodityNotionalQuantityMeta implements RosettaMetaData<CommodityNotionalQuantity> {

	@Override
	public List<Validator<? super CommodityNotionalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityNotionalQuantity> validator(ValidatorFactory factory) {
		return factory.<CommodityNotionalQuantity>create(CommodityNotionalQuantityValidator.class);
	}

	@Override
	public Validator<? super CommodityNotionalQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityNotionalQuantity>create(CommodityNotionalQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityNotionalQuantity> validator() {
		return new CommodityNotionalQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityNotionalQuantity> typeFormatValidator() {
		return new CommodityNotionalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalQuantity, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalQuantityOnlyExistsValidator();
	}
}
