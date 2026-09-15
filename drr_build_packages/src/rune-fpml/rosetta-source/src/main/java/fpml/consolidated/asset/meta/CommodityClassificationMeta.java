package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.asset.validation.CommodityClassificationTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityClassificationValidator;
import fpml.consolidated.asset.validation.exists.CommodityClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityClassification.class)
public class CommodityClassificationMeta implements RosettaMetaData<CommodityClassification> {

	@Override
	public List<Validator<? super CommodityClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityClassification> validator(ValidatorFactory factory) {
		return factory.<CommodityClassification>create(CommodityClassificationValidator.class);
	}

	@Override
	public Validator<? super CommodityClassification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityClassification>create(CommodityClassificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityClassification> validator() {
		return new CommodityClassificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityClassification> typeFormatValidator() {
		return new CommodityClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityClassification, Set<String>> onlyExistsValidator() {
		return new CommodityClassificationOnlyExistsValidator();
	}
}
