package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPerformanceSwapLeg;
import fpml.consolidated.com.validation.CommodityPerformanceSwapLegTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPerformanceSwapLegValidator;
import fpml.consolidated.com.validation.exists.CommodityPerformanceSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPerformanceSwapLeg.class)
public class CommodityPerformanceSwapLegMeta implements RosettaMetaData<CommodityPerformanceSwapLeg> {

	@Override
	public List<Validator<? super CommodityPerformanceSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPerformanceSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPerformanceSwapLeg> validator(ValidatorFactory factory) {
		return factory.<CommodityPerformanceSwapLeg>create(CommodityPerformanceSwapLegValidator.class);
	}

	@Override
	public Validator<? super CommodityPerformanceSwapLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPerformanceSwapLeg>create(CommodityPerformanceSwapLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPerformanceSwapLeg> validator() {
		return new CommodityPerformanceSwapLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPerformanceSwapLeg> typeFormatValidator() {
		return new CommodityPerformanceSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPerformanceSwapLeg, Set<String>> onlyExistsValidator() {
		return new CommodityPerformanceSwapLegOnlyExistsValidator();
	}
}
