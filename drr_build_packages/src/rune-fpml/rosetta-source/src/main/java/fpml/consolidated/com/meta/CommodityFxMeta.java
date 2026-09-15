package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFx;
import fpml.consolidated.com.validation.CommodityFxTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityFxValidator;
import fpml.consolidated.com.validation.exists.CommodityFxOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityFx.class)
public class CommodityFxMeta implements RosettaMetaData<CommodityFx> {

	@Override
	public List<Validator<? super CommodityFx>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFx, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityFx> validator(ValidatorFactory factory) {
		return factory.<CommodityFx>create(CommodityFxValidator.class);
	}

	@Override
	public Validator<? super CommodityFx> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityFx>create(CommodityFxTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFx> validator() {
		return new CommodityFxValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFx> typeFormatValidator() {
		return new CommodityFxTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFx, Set<String>> onlyExistsValidator() {
		return new CommodityFxOnlyExistsValidator();
	}
}
