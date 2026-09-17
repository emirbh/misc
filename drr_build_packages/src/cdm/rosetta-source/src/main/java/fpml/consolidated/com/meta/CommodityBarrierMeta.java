package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBarrier;
import fpml.consolidated.com.validation.CommodityBarrierTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBarrierValidator;
import fpml.consolidated.com.validation.exists.CommodityBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBarrier.class)
public class CommodityBarrierMeta implements RosettaMetaData<CommodityBarrier> {

	@Override
	public List<Validator<? super CommodityBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBarrier> validator(ValidatorFactory factory) {
		return factory.<CommodityBarrier>create(CommodityBarrierValidator.class);
	}

	@Override
	public Validator<? super CommodityBarrier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBarrier>create(CommodityBarrierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBarrier> validator() {
		return new CommodityBarrierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBarrier> typeFormatValidator() {
		return new CommodityBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBarrier, Set<String>> onlyExistsValidator() {
		return new CommodityBarrierOnlyExistsValidator();
	}
}
