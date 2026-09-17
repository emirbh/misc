package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalQuantityBase;
import fpml.consolidated.com.validation.CommodityPhysicalQuantityBaseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPhysicalQuantityBaseValidator;
import fpml.consolidated.com.validation.exists.CommodityPhysicalQuantityBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPhysicalQuantityBase.class)
public class CommodityPhysicalQuantityBaseMeta implements RosettaMetaData<CommodityPhysicalQuantityBase> {

	@Override
	public List<Validator<? super CommodityPhysicalQuantityBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalQuantityBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPhysicalQuantityBase> validator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalQuantityBase>create(CommodityPhysicalQuantityBaseValidator.class);
	}

	@Override
	public Validator<? super CommodityPhysicalQuantityBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalQuantityBase>create(CommodityPhysicalQuantityBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalQuantityBase> validator() {
		return new CommodityPhysicalQuantityBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalQuantityBase> typeFormatValidator() {
		return new CommodityPhysicalQuantityBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalQuantityBase, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalQuantityBaseOnlyExistsValidator();
	}
}
