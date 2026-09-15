package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPipeline;
import fpml.consolidated.com.validation.CommodityPipelineTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPipelineValidator;
import fpml.consolidated.com.validation.exists.CommodityPipelineOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPipeline.class)
public class CommodityPipelineMeta implements RosettaMetaData<CommodityPipeline> {

	@Override
	public List<Validator<? super CommodityPipeline>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPipeline, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPipeline> validator(ValidatorFactory factory) {
		return factory.<CommodityPipeline>create(CommodityPipelineValidator.class);
	}

	@Override
	public Validator<? super CommodityPipeline> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPipeline>create(CommodityPipelineTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPipeline> validator() {
		return new CommodityPipelineValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPipeline> typeFormatValidator() {
		return new CommodityPipelineTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPipeline, Set<String>> onlyExistsValidator() {
		return new CommodityPipelineOnlyExistsValidator();
	}
}
