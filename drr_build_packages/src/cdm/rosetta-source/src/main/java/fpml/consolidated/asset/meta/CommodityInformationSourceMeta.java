package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityInformationSource;
import fpml.consolidated.asset.validation.CommodityInformationSourceTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityInformationSourceValidator;
import fpml.consolidated.asset.validation.exists.CommodityInformationSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityInformationSource.class)
public class CommodityInformationSourceMeta implements RosettaMetaData<CommodityInformationSource> {

	@Override
	public List<Validator<? super CommodityInformationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityInformationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityInformationSource> validator(ValidatorFactory factory) {
		return factory.<CommodityInformationSource>create(CommodityInformationSourceValidator.class);
	}

	@Override
	public Validator<? super CommodityInformationSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityInformationSource>create(CommodityInformationSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityInformationSource> validator() {
		return new CommodityInformationSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityInformationSource> typeFormatValidator() {
		return new CommodityInformationSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityInformationSource, Set<String>> onlyExistsValidator() {
		return new CommodityInformationSourceOnlyExistsValidator();
	}
}
