package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPremium;
import fpml.consolidated.com.validation.CommodityPremiumTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPremiumValidator;
import fpml.consolidated.com.validation.exists.CommodityPremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPremium.class)
public class CommodityPremiumMeta implements RosettaMetaData<CommodityPremium> {

	@Override
	public List<Validator<? super CommodityPremium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPremium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPremium> validator(ValidatorFactory factory) {
		return factory.<CommodityPremium>create(CommodityPremiumValidator.class);
	}

	@Override
	public Validator<? super CommodityPremium> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPremium>create(CommodityPremiumTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPremium> validator() {
		return new CommodityPremiumValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPremium> typeFormatValidator() {
		return new CommodityPremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPremium, Set<String>> onlyExistsValidator() {
		return new CommodityPremiumOnlyExistsValidator();
	}
}
