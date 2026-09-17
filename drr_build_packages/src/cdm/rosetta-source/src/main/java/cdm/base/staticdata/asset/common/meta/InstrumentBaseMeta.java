package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.validation.InstrumentBaseTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.InstrumentBaseValidator;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed;
import cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange;
import cdm.base.staticdata.asset.common.validation.exists.InstrumentBaseOnlyExistsValidator;
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
@RosettaMeta(model=InstrumentBase.class)
public class InstrumentBaseMeta implements RosettaMetaData<InstrumentBase> {

	@Override
	public List<Validator<? super InstrumentBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetBase>create(AssetBaseExchangeListed.class),
			factory.<AssetBase>create(AssetBaseRelatedExchange.class)
		);
	}
	
	@Override
	public List<Function<? super InstrumentBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InstrumentBase> validator(ValidatorFactory factory) {
		return factory.<InstrumentBase>create(InstrumentBaseValidator.class);
	}

	@Override
	public Validator<? super InstrumentBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InstrumentBase>create(InstrumentBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentBase> validator() {
		return new InstrumentBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentBase> typeFormatValidator() {
		return new InstrumentBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentBase, Set<String>> onlyExistsValidator() {
		return new InstrumentBaseOnlyExistsValidator();
	}
}
