package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMetalProducer;
import fpml.consolidated.com.validation.CommodityMetalProducerTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityMetalProducerValidator;
import fpml.consolidated.com.validation.exists.CommodityMetalProducerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityMetalProducer.class)
public class CommodityMetalProducerMeta implements RosettaMetaData<CommodityMetalProducer> {

	@Override
	public List<Validator<? super CommodityMetalProducer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalProducer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityMetalProducer> validator(ValidatorFactory factory) {
		return factory.<CommodityMetalProducer>create(CommodityMetalProducerValidator.class);
	}

	@Override
	public Validator<? super CommodityMetalProducer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityMetalProducer>create(CommodityMetalProducerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalProducer> validator() {
		return new CommodityMetalProducerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalProducer> typeFormatValidator() {
		return new CommodityMetalProducerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalProducer, Set<String>> onlyExistsValidator() {
		return new CommodityMetalProducerOnlyExistsValidator();
	}
}
