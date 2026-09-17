package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPerformanceSwapEarlyTermination;
import fpml.consolidated.com.validation.CommodityPerformanceSwapEarlyTerminationTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPerformanceSwapEarlyTerminationValidator;
import fpml.consolidated.com.validation.exists.CommodityPerformanceSwapEarlyTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPerformanceSwapEarlyTermination.class)
public class CommodityPerformanceSwapEarlyTerminationMeta implements RosettaMetaData<CommodityPerformanceSwapEarlyTermination> {

	@Override
	public List<Validator<? super CommodityPerformanceSwapEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPerformanceSwapEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPerformanceSwapEarlyTermination> validator(ValidatorFactory factory) {
		return factory.<CommodityPerformanceSwapEarlyTermination>create(CommodityPerformanceSwapEarlyTerminationValidator.class);
	}

	@Override
	public Validator<? super CommodityPerformanceSwapEarlyTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPerformanceSwapEarlyTermination>create(CommodityPerformanceSwapEarlyTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPerformanceSwapEarlyTermination> validator() {
		return new CommodityPerformanceSwapEarlyTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPerformanceSwapEarlyTermination> typeFormatValidator() {
		return new CommodityPerformanceSwapEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPerformanceSwapEarlyTermination, Set<String>> onlyExistsValidator() {
		return new CommodityPerformanceSwapEarlyTerminationOnlyExistsValidator();
	}
}
