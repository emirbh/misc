package cdm.observable.asset.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.validation.ForeignExchangeRateIndexTypeFormatValidator;
import cdm.observable.asset.validation.ForeignExchangeRateIndexValidator;
import cdm.observable.asset.validation.datarule.ForeignExchangeRateIndexFXAssetClass;
import cdm.observable.asset.validation.exists.ForeignExchangeRateIndexOnlyExistsValidator;
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
@RosettaMeta(model=ForeignExchangeRateIndex.class)
public class ForeignExchangeRateIndexMeta implements RosettaMetaData<ForeignExchangeRateIndex> {

	@Override
	public List<Validator<? super ForeignExchangeRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetBase>create(AssetBaseExchangeListed.class),
			factory.<AssetBase>create(AssetBaseRelatedExchange.class),
			factory.<ForeignExchangeRateIndex>create(ForeignExchangeRateIndexFXAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super ForeignExchangeRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ForeignExchangeRateIndex> validator(ValidatorFactory factory) {
		return factory.<ForeignExchangeRateIndex>create(ForeignExchangeRateIndexValidator.class);
	}

	@Override
	public Validator<? super ForeignExchangeRateIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ForeignExchangeRateIndex>create(ForeignExchangeRateIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ForeignExchangeRateIndex> validator() {
		return new ForeignExchangeRateIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ForeignExchangeRateIndex> typeFormatValidator() {
		return new ForeignExchangeRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ForeignExchangeRateIndex, Set<String>> onlyExistsValidator() {
		return new ForeignExchangeRateIndexOnlyExistsValidator();
	}
}
