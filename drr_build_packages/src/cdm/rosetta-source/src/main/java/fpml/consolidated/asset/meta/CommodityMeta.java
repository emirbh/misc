package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.validation.CommodityTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityValidator;
import fpml.consolidated.asset.validation.datarule.CommodityChoice0;
import fpml.consolidated.asset.validation.datarule.CommodityChoice1;
import fpml.consolidated.asset.validation.datarule.CommodityChoice2;
import fpml.consolidated.asset.validation.exists.CommodityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Commodity.class)
public class CommodityMeta implements RosettaMetaData<Commodity> {

	@Override
	public List<Validator<? super Commodity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Commodity>create(CommodityChoice0.class),
			factory.<Commodity>create(CommodityChoice1.class),
			factory.<Commodity>create(CommodityChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super Commodity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Commodity> validator(ValidatorFactory factory) {
		return factory.<Commodity>create(CommodityValidator.class);
	}

	@Override
	public Validator<? super Commodity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Commodity>create(CommodityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Commodity> validator() {
		return new CommodityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Commodity> typeFormatValidator() {
		return new CommodityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Commodity, Set<String>> onlyExistsValidator() {
		return new CommodityOnlyExistsValidator();
	}
}
