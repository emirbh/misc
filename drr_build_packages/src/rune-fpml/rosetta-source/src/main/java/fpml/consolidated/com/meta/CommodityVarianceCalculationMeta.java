package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityVarianceCalculation;
import fpml.consolidated.com.validation.CommodityVarianceCalculationTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityVarianceCalculationValidator;
import fpml.consolidated.com.validation.exists.CommodityVarianceCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityVarianceCalculation.class)
public class CommodityVarianceCalculationMeta implements RosettaMetaData<CommodityVarianceCalculation> {

	@Override
	public List<Validator<? super CommodityVarianceCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityVarianceCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityVarianceCalculation> validator(ValidatorFactory factory) {
		return factory.<CommodityVarianceCalculation>create(CommodityVarianceCalculationValidator.class);
	}

	@Override
	public Validator<? super CommodityVarianceCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityVarianceCalculation>create(CommodityVarianceCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityVarianceCalculation> validator() {
		return new CommodityVarianceCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityVarianceCalculation> typeFormatValidator() {
		return new CommodityVarianceCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityVarianceCalculation, Set<String>> onlyExistsValidator() {
		return new CommodityVarianceCalculationOnlyExistsValidator();
	}
}
