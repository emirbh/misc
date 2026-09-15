package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityReturnCalculation;
import fpml.consolidated.com.validation.CommodityReturnCalculationTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityReturnCalculationValidator;
import fpml.consolidated.com.validation.exists.CommodityReturnCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityReturnCalculation.class)
public class CommodityReturnCalculationMeta implements RosettaMetaData<CommodityReturnCalculation> {

	@Override
	public List<Validator<? super CommodityReturnCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityReturnCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityReturnCalculation> validator(ValidatorFactory factory) {
		return factory.<CommodityReturnCalculation>create(CommodityReturnCalculationValidator.class);
	}

	@Override
	public Validator<? super CommodityReturnCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityReturnCalculation>create(CommodityReturnCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityReturnCalculation> validator() {
		return new CommodityReturnCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityReturnCalculation> typeFormatValidator() {
		return new CommodityReturnCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityReturnCalculation, Set<String>> onlyExistsValidator() {
		return new CommodityReturnCalculationOnlyExistsValidator();
	}
}
