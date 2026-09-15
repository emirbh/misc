package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityBase;
import fpml.consolidated.asset.validation.CommodityBaseTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityBaseValidator;
import fpml.consolidated.asset.validation.exists.CommodityBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBase.class)
public class CommodityBaseMeta implements RosettaMetaData<CommodityBase> {

	@Override
	public List<Validator<? super CommodityBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBase> validator(ValidatorFactory factory) {
		return factory.<CommodityBase>create(CommodityBaseValidator.class);
	}

	@Override
	public Validator<? super CommodityBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBase>create(CommodityBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBase> validator() {
		return new CommodityBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBase> typeFormatValidator() {
		return new CommodityBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBase, Set<String>> onlyExistsValidator() {
		return new CommodityBaseOnlyExistsValidator();
	}
}
