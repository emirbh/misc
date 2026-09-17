package cdm.observable.asset.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.validation.FloatingRateIndexTypeFormatValidator;
import cdm.observable.asset.validation.FloatingRateIndexValidator;
import cdm.observable.asset.validation.datarule.FloatingRateIndexInterestRateAssetClass;
import cdm.observable.asset.validation.exists.FloatingRateIndexOnlyExistsValidator;
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
@RosettaMeta(model=FloatingRateIndex.class)
public class FloatingRateIndexMeta implements RosettaMetaData<FloatingRateIndex> {

	@Override
	public List<Validator<? super FloatingRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetBase>create(AssetBaseExchangeListed.class),
			factory.<AssetBase>create(AssetBaseRelatedExchange.class),
			factory.<FloatingRateIndex>create(FloatingRateIndexInterestRateAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndex> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndex>create(FloatingRateIndexValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndex>create(FloatingRateIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndex> validator() {
		return new FloatingRateIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndex> typeFormatValidator() {
		return new FloatingRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndex, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexOnlyExistsValidator();
	}
}
