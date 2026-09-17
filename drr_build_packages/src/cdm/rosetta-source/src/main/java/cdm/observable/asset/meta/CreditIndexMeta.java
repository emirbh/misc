package cdm.observable.asset.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.validation.CreditIndexTypeFormatValidator;
import cdm.observable.asset.validation.CreditIndexValidator;
import cdm.observable.asset.validation.datarule.CreditIndexCreditAssetClass;
import cdm.observable.asset.validation.datarule.CreditIndexIndexAnnexVersion;
import cdm.observable.asset.validation.datarule.CreditIndexIndexFactor;
import cdm.observable.asset.validation.datarule.CreditIndexIndexSeries;
import cdm.observable.asset.validation.exists.CreditIndexOnlyExistsValidator;
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
@RosettaMeta(model=CreditIndex.class)
public class CreditIndexMeta implements RosettaMetaData<CreditIndex> {

	@Override
	public List<Validator<? super CreditIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetBase>create(AssetBaseExchangeListed.class),
			factory.<AssetBase>create(AssetBaseRelatedExchange.class),
			factory.<CreditIndex>create(CreditIndexIndexSeries.class),
			factory.<CreditIndex>create(CreditIndexIndexAnnexVersion.class),
			factory.<CreditIndex>create(CreditIndexIndexFactor.class),
			factory.<CreditIndex>create(CreditIndexCreditAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super CreditIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditIndex> validator(ValidatorFactory factory) {
		return factory.<CreditIndex>create(CreditIndexValidator.class);
	}

	@Override
	public Validator<? super CreditIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditIndex>create(CreditIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditIndex> validator() {
		return new CreditIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditIndex> typeFormatValidator() {
		return new CreditIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditIndex, Set<String>> onlyExistsValidator() {
		return new CreditIndexOnlyExistsValidator();
	}
}
