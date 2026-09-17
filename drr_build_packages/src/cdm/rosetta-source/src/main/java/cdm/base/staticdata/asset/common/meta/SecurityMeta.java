package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.validation.SecurityTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.SecurityValidator;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange;
import cdm.base.staticdata.asset.common.validation.datarule.SecurityDebtSubType;
import cdm.base.staticdata.asset.common.validation.datarule.SecurityEquitySubType;
import cdm.base.staticdata.asset.common.validation.datarule.SecurityFundSubType;
import cdm.base.staticdata.asset.common.validation.exists.SecurityOnlyExistsValidator;
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
@RosettaMeta(model=Security.class)
public class SecurityMeta implements RosettaMetaData<Security> {

	@Override
	public List<Validator<? super Security>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetBase>create(AssetBaseExchangeListed.class),
			factory.<AssetBase>create(AssetBaseRelatedExchange.class),
			factory.<Security>create(SecurityDebtSubType.class),
			factory.<Security>create(SecurityEquitySubType.class),
			factory.<Security>create(SecurityFundSubType.class)
		);
	}
	
	@Override
	public List<Function<? super Security, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Security> validator(ValidatorFactory factory) {
		return factory.<Security>create(SecurityValidator.class);
	}

	@Override
	public Validator<? super Security> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Security>create(SecurityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Security> validator() {
		return new SecurityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Security> typeFormatValidator() {
		return new SecurityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Security, Set<String>> onlyExistsValidator() {
		return new SecurityOnlyExistsValidator();
	}
}
