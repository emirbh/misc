package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.validation.CashTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.CashValidator;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange;
import cdm.base.staticdata.asset.common.validation.datarule.CashCurrencyExists;
import cdm.base.staticdata.asset.common.validation.datarule.CashNoExchange;
import cdm.base.staticdata.asset.common.validation.datarule.CashNoTaxonomy;
import cdm.base.staticdata.asset.common.validation.exists.CashOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Cash.class)
public class CashMeta implements RosettaMetaData<Cash> {

	@Override
	public List<Validator<? super Cash>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetBase>create(AssetBaseExchangeListed.class),
			factory.<AssetBase>create(AssetBaseRelatedExchange.class),
			factory.<Cash>create(CashCurrencyExists.class),
			factory.<Cash>create(CashNoTaxonomy.class),
			factory.<Cash>create(CashNoExchange.class)
		);
	}
	
	@Override
	public List<Function<? super Cash, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Cash> validator(ValidatorFactory factory) {
		return factory.<Cash>create(CashValidator.class);
	}

	@Override
	public Validator<? super Cash> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Cash>create(CashTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Cash> validator() {
		return new CashValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Cash> typeFormatValidator() {
		return new CashTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Cash, Set<String>> onlyExistsValidator() {
		return new CashOnlyExistsValidator();
	}
}
