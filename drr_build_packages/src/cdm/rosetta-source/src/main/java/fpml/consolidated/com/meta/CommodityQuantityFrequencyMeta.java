package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.validation.CommodityQuantityFrequencyTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityQuantityFrequencyValidator;
import fpml.consolidated.com.validation.exists.CommodityQuantityFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityQuantityFrequency.class)
public class CommodityQuantityFrequencyMeta implements RosettaMetaData<CommodityQuantityFrequency> {

	@Override
	public List<Validator<? super CommodityQuantityFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityQuantityFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityQuantityFrequency> validator(ValidatorFactory factory) {
		return factory.<CommodityQuantityFrequency>create(CommodityQuantityFrequencyValidator.class);
	}

	@Override
	public Validator<? super CommodityQuantityFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityQuantityFrequency>create(CommodityQuantityFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityQuantityFrequency> validator() {
		return new CommodityQuantityFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityQuantityFrequency> typeFormatValidator() {
		return new CommodityQuantityFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityQuantityFrequency, Set<String>> onlyExistsValidator() {
		return new CommodityQuantityFrequencyOnlyExistsValidator();
	}
}
