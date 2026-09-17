package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFixedInterestCalculation;
import fpml.consolidated.com.validation.CommodityFixedInterestCalculationTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityFixedInterestCalculationValidator;
import fpml.consolidated.com.validation.exists.CommodityFixedInterestCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityFixedInterestCalculation.class)
public class CommodityFixedInterestCalculationMeta implements RosettaMetaData<CommodityFixedInterestCalculation> {

	@Override
	public List<Validator<? super CommodityFixedInterestCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedInterestCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityFixedInterestCalculation> validator(ValidatorFactory factory) {
		return factory.<CommodityFixedInterestCalculation>create(CommodityFixedInterestCalculationValidator.class);
	}

	@Override
	public Validator<? super CommodityFixedInterestCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityFixedInterestCalculation>create(CommodityFixedInterestCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFixedInterestCalculation> validator() {
		return new CommodityFixedInterestCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFixedInterestCalculation> typeFormatValidator() {
		return new CommodityFixedInterestCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedInterestCalculation, Set<String>> onlyExistsValidator() {
		return new CommodityFixedInterestCalculationOnlyExistsValidator();
	}
}
