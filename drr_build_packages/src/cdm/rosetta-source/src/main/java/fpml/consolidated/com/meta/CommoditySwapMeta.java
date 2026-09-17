package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.com.validation.CommoditySwapTypeFormatValidator;
import fpml.consolidated.com.validation.CommoditySwapValidator;
import fpml.consolidated.com.validation.datarule.CommoditySwapChoice;
import fpml.consolidated.com.validation.exists.CommoditySwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommoditySwap.class)
public class CommoditySwapMeta implements RosettaMetaData<CommoditySwap> {

	@Override
	public List<Validator<? super CommoditySwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommoditySwap>create(CommoditySwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommoditySwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommoditySwap> validator(ValidatorFactory factory) {
		return factory.<CommoditySwap>create(CommoditySwapValidator.class);
	}

	@Override
	public Validator<? super CommoditySwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommoditySwap>create(CommoditySwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySwap> validator() {
		return new CommoditySwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySwap> typeFormatValidator() {
		return new CommoditySwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwap, Set<String>> onlyExistsValidator() {
		return new CommoditySwapOnlyExistsValidator();
	}
}
