package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityInformationProvider;
import fpml.consolidated.asset.validation.CommodityInformationProviderTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityInformationProviderValidator;
import fpml.consolidated.asset.validation.exists.CommodityInformationProviderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityInformationProvider.class)
public class CommodityInformationProviderMeta implements RosettaMetaData<CommodityInformationProvider> {

	@Override
	public List<Validator<? super CommodityInformationProvider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityInformationProvider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityInformationProvider> validator(ValidatorFactory factory) {
		return factory.<CommodityInformationProvider>create(CommodityInformationProviderValidator.class);
	}

	@Override
	public Validator<? super CommodityInformationProvider> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityInformationProvider>create(CommodityInformationProviderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityInformationProvider> validator() {
		return new CommodityInformationProviderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityInformationProvider> typeFormatValidator() {
		return new CommodityInformationProviderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityInformationProvider, Set<String>> onlyExistsValidator() {
		return new CommodityInformationProviderOnlyExistsValidator();
	}
}
